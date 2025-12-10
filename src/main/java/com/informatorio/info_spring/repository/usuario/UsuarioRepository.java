package com.informatorio.info_spring.repository.usuario;

import com.informatorio.info_spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID>, JpaSpecificationExecutor<Usuario> {
                                            //<Entidad, tipo de dato del id>
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);

    //Esto para filtrar por nombre o email, hecho en el service
    List <Usuario> findAllByNombreEqualsIgnoreCase(String nombre);
    List <Usuario> findAllByEmailContainsIgnoreCase(String email); //por ser email unico
    List <Usuario> findAllByNombreEqualsIgnoreCaseAndEmailContainsIgnoreCase(String nombre, String email);
}
