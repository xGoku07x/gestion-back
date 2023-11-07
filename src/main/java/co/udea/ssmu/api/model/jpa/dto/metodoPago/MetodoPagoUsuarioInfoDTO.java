package co.udea.ssmu.api.model.jpa.dto.metodoPago;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class MetodoPagoUsuarioInfoDTO {

    private long idMetodoPagoUsuario;
    private String nombreMetodoPago;
    private String nombreBanco;
    private String nombreTarjeta;
    private String numeroTarjeta;
}
