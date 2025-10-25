/**
 *
 * Projeto: santander-api
 * Autor: Sheyla Vaz
 * Data de criação: 25/10/2025
 *
 */


package dio.santander.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.santander.api.DTO.UsuarioDTO;
import dio.santander.api.model.Usuario;
import dio.santander.api.repository.UsuarioRepository;

/**
 * 
 */
@Service
public class UsuarioService {

	/**
	 * 
	 */
	@Autowired
	private final UsuarioRepository usuarioRepository;
	
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public List<UsuarioDTO> findAll(){
		System.out.println("Listando os usuario do sistema"); 
		List<UsuarioDTO> usuarios = new ArrayList<>(); 
		usuarios.add(new UsuarioDTO("svaz", "ss123"));
		usuarios.add(new UsuarioDTO("smattos", "mm1234")); 
		return usuarios; 
	}
	
	public void save(Usuario usuario) { 
		  //save(usuario); 
		  if(usuario.getId()==null){ 
			  save(usuario);
			  System.out.println("SAVE - recebendo o usuario na camada de repositorio"); }
		  else {
			  System.out.println("UPDATE - Recebendo o usuario na camada de repositorio");
		  } 
		  System.out.println(usuario); 
	}
	 	
	 public void deleteById(Integer id) {
		 System.out.println(String.format("DELETE/id - Recebendo id: %d para ", id));
		 System.out.println(id); 
	 }
	 

	  
	  public Usuario findById(Integer id) { 
		  System.out.println(String.format("FIND/ID - Recebendo o id: %d para localizar um usuario", id)); 
		  return new Usuario("svaz","ss123"); 
	  }
	  
	  public Usuario findByUsername(String username) { 
		  System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuario", username)); 
		  return new Usuario("svaz","ss123"); 
	  }
}
