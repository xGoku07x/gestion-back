package co.udea.ssmu.api.model.jpa.dto.metodopago;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class MetodoPagoUsuarioDTO {

    private String cedula;
    private long idMetodoPago;
    private String nombreBanco;
    private String nombreTarjeta;
    private String numeroTarjeta;
    private Date expiracionTarjeta;
    private String codigoSeguridadTarjeta;
    
}
