package dio.santander.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dio.santander.api.DTO.UsuarioDTO;
import dio.santander.api.model.Usuario;
import dio.santander.api.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;


/**
 * 
 */
@Tag(name="Usuários", description = "Endpoint para gerenciamento de usuários")
@RestController
@RequestMapping("/users")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping()
	public List<UsuarioDTO> getUsers(){
		return usuarioService.findAll();
	}
	
	@GetMapping("/{username}")
	public Usuario getOne(@PathVariable("username") String username) {
		return usuarioService.findByUsername(username);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {usuarioService.deleteById(id);}
	
	@PostMapping()
	public void postUser(@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
	}
	
}
