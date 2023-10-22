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
    @Column(name = "id")
    private long id;

    @Column(name = "grupo")
    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @Column(name = "tipo_usuario")
    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name="celular", nullable = false)
    private String celular;

    @Column(name="email", nullable = false)
    private String email;
    
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="nroDocumento", nullable = false)
    private String nroDocumento;

    @Column(name="rol", nullable = false)
    private String rol;

    @Column(name="nroServicios", nullable = false)
    private String nroServicios;

}
