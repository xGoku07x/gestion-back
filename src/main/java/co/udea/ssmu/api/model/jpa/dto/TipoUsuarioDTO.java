package co.udea.ssmu.api.model.jpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoUsuarioDTO {
    private long idTipoUsuario;
    private String nombre;
    private String descripcion;
    private float descuento;
}
