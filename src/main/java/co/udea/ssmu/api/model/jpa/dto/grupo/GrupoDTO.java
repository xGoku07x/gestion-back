package co.udea.ssmu.api.model.jpa.dto.grupo;

import co.udea.ssmu.api.model.jpa.model.Usuario;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GrupoDTO {
    
    private long idGrupo;
    private String nombre;
    private Usuario usuarioJefe;
    private String descripcion;
}
