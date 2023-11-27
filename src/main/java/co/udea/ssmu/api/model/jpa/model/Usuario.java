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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "m3_usuario", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "nro_documento")
})
public class Usuario {
    
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios_generator")
    @SequenceGenerator(name="seq_usuarios_generator", sequenceName = "SEQ_USUARIO", allocationSize=1)
    private long idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    @NotNull(message = "El tipo de usuario es obligatorio")
    private TipoUsuario tipoUsuario;

    @Column(name = "nombre", nullable = false)
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @Column(name = "apellido", nullable = false)
    @Size(min = 3, max = 50, message = "El apellido debe tener entre 3 y 50 caracteres")
    private String apellido;

    @Column(name="celular", nullable = false)
    @Size(min = 10, max = 10, message = "El número de celular debe tener 10 caracteres")
    private String celular;

    @Column(name="email", nullable = false)
    @Email()
    private String email;
    
    @Column(name="password", nullable = false)
    @Size(min = 8, message = "La contraseña debe tener mínimo 8 caracteres")
    private String password;

    @Column(name="nro_documento", nullable = false)
    @Size(min = 8, max = 10, message = "El número de documento debe tener entre 8 y 10 caracteres")
    private String nroDocumento;

    @Column(name="rol", nullable = true, columnDefinition = "VARCHAR2(10) DEFAULT 'usuario'")
    private String rol;

    @Column(name="nro_servicios", nullable = true, columnDefinition = "VARCHAR2(10) DEFAULT '0'")
    private String nroServicios;

}
