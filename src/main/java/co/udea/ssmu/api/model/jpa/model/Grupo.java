package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "m3_grupo")
public class Grupo {

    @Id
    @Column(name = "id_grupo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_grupo_generator")
    @SequenceGenerator(name="seq_grupo_generator", sequenceName = "SEQ_grupo", allocationSize=1)
    private long idGrupo;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_usuario_dueno")
    private Usuario usuarioJefe;

    @Column(name = "descripcion")
    private String descripcion;
}
