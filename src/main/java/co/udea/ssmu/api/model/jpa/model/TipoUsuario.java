package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name = "m3_tipo_usuarios")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoUsuario {

    @Id
    @Column(name = "id_tipo_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tipo_usuario_generator")
    @SequenceGenerator(name="seq_tipo_usuario_generator", sequenceName = "SEQ_TIPO_USUARIO", allocationSize=1)
    private long idTipoUsuario;

    @Column(name = "nombre", nullable=false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
    
}
