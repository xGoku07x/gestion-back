package co.udea.ssmu.api.model.jpa.dto;

import co.udea.ssmu.api.model.jpa.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrupoDTO {
    
    private long idGrupo;
    private String nombre;
    private Usuario usuarioJefe;
    private String descripcion;
}
