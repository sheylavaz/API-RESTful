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
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dio.santander.api.handler.BusinessException;
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
	
	public List<Usuario> findAll(){
		System.out.println("Listando os usuario do sistema"); 
		List<Usuario> usuariosLista = new ArrayList<>(); 
		usuariosLista = usuarioRepository.findAll();
		return usuariosLista; 
	}
	
	public void save(Usuario usuario) { 
		if(usuario.getLogin()==null) {
			//throw new BusinessException("O campo nome não foi preenchido! Por favor reveja as informações");
		}
		if(usuario.getId()==null){
			 usuarioRepository.save(usuario);
			 System.out.println("SAVE - recebendo o usuario na camada de repositorio"); 
		} else {
			 Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getId());
			 if(!usuarioExistente.isEmpty()) {
				 usuarioRepository.save(usuario);
			 } else {
				  throw new NoSuchElementException("Usuario com ID " + usuario.getId() + "não encontrado! Revise as informações e tente novamente!");
			}
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
