/**
 *
 * Projeto: santander-api
 * Autor: Sheyla Vaz
 * Data de criação: 22/10/2025
 *
 */


package dio.santander.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.santander.api.model.Usuario;

/**
 * 
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{



}
