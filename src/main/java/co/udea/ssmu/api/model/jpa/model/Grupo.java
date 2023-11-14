package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @Column(name = "id_grupo")
    private long idGrupo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_usuario_dueno")
    private Usuario usuarioJefe;

    @Column(name = "descripcion")
    private String descripcion;
}
