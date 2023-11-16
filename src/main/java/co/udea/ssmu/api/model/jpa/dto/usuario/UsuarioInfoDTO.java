package co.udea.ssmu.api.model.jpa.dto.usuario;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UsuarioInfoDTO {
    private String nombre;
    private String apellido;
    private long idGrupo;
    private String grupo;
    private String tipoUsuario;
    private String celular;
    private String email;
    private String nroDocumento;
    private String nroServicios;
    private String rol;
}
