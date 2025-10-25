/**
 *
 * Projeto: santander-api
 * Autor: Sheyla Vaz
 * Data de criação: 25/10/2025
 *
 */


package dio.santander.api.DTO;

import dio.santander.api.model.Usuario;

/**
 * 
 */
public class UsuarioDTO {

	private Integer id;
	private String login;
	private String password;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.login = usuario.getLogin();
		this.password = usuario.getPassword();
	}

	public UsuarioDTO(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
