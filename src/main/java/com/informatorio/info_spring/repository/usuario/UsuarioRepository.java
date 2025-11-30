package com.informatorio.info_spring.repository.usuario;

import com.informatorio.info_spring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID> {
                                            //<Entidad, tipo de dato del id>
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}
