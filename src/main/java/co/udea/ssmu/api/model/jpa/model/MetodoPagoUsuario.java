package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@Entity
@Table(name = "metodo_pago_usuario")
public class MetodoPagoUsuario {

    @Id
    @Column(name="id_metodo_pago_usuario")
    private long idMetodoPagoUsuario;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_metodo_pago")
    private MetodoPago idMetodoPago;
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
