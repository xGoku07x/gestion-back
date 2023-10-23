package co.udea.ssmu.api.model.jpa.dto;

import co.udea.ssmu.api.model.jpa.model.Grupo;
import co.udea.ssmu.api.model.jpa.model.TipoUsuario;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private long id;
    private String nombre;
    private String apellido;
    private Grupo grupo;
    private TipoUsuario tipoUsuario; 
    private String celular;
    private String email;
    private String password;
    private String nroDocumento;
    private String rol;
    private String nroServicios;
}
