package com.udea.gestionusuarios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @Column(name = "id_usuario")
    private long idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name="celular", nullable = false)
    private String celular;

    @Column(name="email", nullable = false)
    private String email;
    
    @Column(name="contrasena", nullable = false)
    private String password;

    @Column(name="cedula", nullable = false)
    private String cedula;

    @Column(name="rol", nullable = false)
    private String rol;

    @Column(name="nro_servicios", nullable = false)
    private String nroServicios;

}
