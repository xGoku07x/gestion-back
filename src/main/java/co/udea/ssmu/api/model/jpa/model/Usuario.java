package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "nro_documento")
})
public class Usuario {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario_generator")
    @SequenceGenerator(name="seq_usuario_generator", sequenceName = "SEQ_USUARIO", allocationSize=1)
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
    @Email
    private String email;
    
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="nro_documento", nullable = false)
    private String nroDocumento;

    @Column(name="rol", nullable = true, columnDefinition = "VARCHAR2(10) DEFAULT 'usuario'")
    private String rol;

    @Column(name="nro_servicios", nullable = true, columnDefinition = "VARCHAR2(10) DEFAULT '0'")
    private String nroServicios;

}
