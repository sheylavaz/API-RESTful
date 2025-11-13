package dio.santander.api.handler;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Injete o MessageSource
	@Autowired
	private MessageSource messageSource;
	
    private ResponseError responseError(String message, HttpStatus statusCode) {
    	ResponseError responseError = new ResponseError();
    	responseError.setError(message);
    	responseError.setStatus("error");
    	responseError.setStatusCode(statusCode.value());
    	responseError.setTimestamp(LocalDateTime.now());
    	return responseError;
    }
	
    // Tratamento genérico para outras exceções
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
    	
    	if(e.getClass().isAssignableFrom(UndeclaredThrowableException.class)) {
    		UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
    		return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
    	} else {
    		String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
    		ResponseError error = responseError(message, HttpStatus.INTERNAL_SERVER_ERROR);
    		return handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    	}
    }	

    // Tratamento para BusinessException
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request) {
    	ResponseError error = responseError(e.getMessage(), HttpStatus.CONFLICT);
        return (ResponseEntity<Object>) handleExceptionInternal(e, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }


}