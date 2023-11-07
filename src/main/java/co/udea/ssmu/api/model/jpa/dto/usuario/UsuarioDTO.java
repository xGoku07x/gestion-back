package co.udea.ssmu.api.model.jpa.dto.usuario;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    
    private String nombre;
    private String apellido;
    private long grupo;
    private long tipoUsuario; 
    private String celular;
    private String email;
    private String password;
    private String nroDocumento;
    private String nroServicios;
}
