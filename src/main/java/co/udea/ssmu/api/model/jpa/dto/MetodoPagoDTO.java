package co.udea.ssmu.api.model.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetodoPagoDTO {
    private long idMetodoPago;
    private String nombre;
    private String descripcion;
}
