package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.utils.hasher.PasswordHash;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario convertirEntidad(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .idUsuario(usuarioDTO.getIdUsuario())
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .celular(usuarioDTO.getCelular())
                .email(usuarioDTO.getEmail())
                .nroDocumento(usuarioDTO.getNroDocumento())
                .rol(usuarioDTO.getRol())
                .nroServicios(usuarioDTO.getNroServicios())
                .build();
    }

    public static Usuario crearUsuarioEntidad(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .celular(usuarioDTO.getCelular())
                .email(usuarioDTO.getEmail())
                .password(encodePassword(usuarioDTO.getPassword()))
                .nroDocumento(usuarioDTO.getNroDocumento())
                .rol("Usuario")
                .nroServicios("0")
                .build();
    }

    public static UsuarioDTO convertirDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .idUsuario(usuario.getIdUsuario())
                .tipoUsuario(usuario.getTipoUsuario().getIdTipoUsuario())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .celular(usuario.getCelular())
                .email(usuario.getEmail())
                .nroDocumento(usuario.getNroDocumento())
                .rol(usuario.getRol())
                .nroServicios(usuario.getNroServicios())
                .build();
    }

    public static String encodePassword(String password) {
        PasswordHash passwordHash = new PasswordHash();
        return passwordHash.encriptarPassword(password);
    }
}
