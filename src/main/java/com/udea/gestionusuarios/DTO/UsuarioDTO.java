package com.udea.gestionusuarios.DTO;

import com.udea.gestionusuarios.model.Grupo;
import com.udea.gestionusuarios.model.TipoUsuario;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioDTO {
    private long id;
    private Grupo grupo;
    private TipoUsuario tipoUsuario;
    private String nombre;
    private String apellido;
    private String celular;
    private String email;
    private String password;
    private String nroDocumento;
    private String rol;
    private String nroServicios;
}
