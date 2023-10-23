package co.udea.ssmu.api.model.jpa.dto;

import java.sql.Date;

import co.udea.ssmu.api.model.jpa.model.MetodoPago;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MetodoPagoUsuarioDTO {

    private Usuario idUsuario;
    private MetodoPago idMetodoPago;
    private String nombreBanco;
    private String nombreTarjeta;
    private String numeroTarjeta;
    private Date expiracionTarjeta;
    private String codigoSeguridadTarjeta;
    
}
