package com.informatorio.info_spring.repository.specification;

import com.informatorio.info_spring.model.Usuario;
import org.springframework.data.jpa.domain.Specification;

public final class UsuarioSpecifications {

    private UsuarioSpecifications() {}

    public static Specification<Usuario> byNombre(final String nombre) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")),"%" + nombre.toLowerCase() + "%"
                ));

    }

    public static Specification<Usuario> byEmail(final String email) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("email")),"%" + email.toLowerCase() + "%"
                ));
    }

    public static Specification<Usuario> byColorFavorito(final String colorFavorito){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        criteriaBuilder.lower(
                                root.join("perfil").get("colorFavorito")
                        ),
                        colorFavorito.toLowerCase()
                ));
    }
}
