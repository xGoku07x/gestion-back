package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "metodo_pago_usuario")
public class MetodoPagoUsuario {

    @Id
    @Column(name="id_metodo_pago_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_metodo_pago_usuario_generator")
    @SequenceGenerator(name="seq_metodo_pago_usuario_generator", sequenceName = "SEQ_METODO_PAGO_USUARIO", allocationSize=1)
    private long idMetodoPagoUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago idMetodoPago;

    @Column(name = "nombre_banco")
    private String nombreBanco;

    @Column(name = "nombre_tarjeta")
    private String nombreTarjeta;

    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;

    @Column(name = "expiracion_tarjeta")
    private Date expiracionTarjeta;

    @Column(name = "codigo_seguridad_tarjeta")
    private String codigoSeguridadTarjeta;
}
