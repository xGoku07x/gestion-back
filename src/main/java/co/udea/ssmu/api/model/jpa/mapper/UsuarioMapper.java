package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.utils.hasher.PasswordHash;

public class UsuarioMapper {

    public static Usuario convertirEntidad(UsuarioDTO usuarioDTO) {
        /*
         * Usuario usuario = new Usuario();
         * usuario.setNombre(usuarioDTO.getNombre());
         * usuario.setApellido(usuarioDTO.getApellido());
         * usuario.setCelular(usuarioDTO.getCelular());
         * usuario.setEmail(usuarioDTO.getEmail());
         * usuario.setPassword(encodePassword(usuarioDTO.getPassword()));
         * usuario.setNroDocumento(usuarioDTO.getNroDocumento());
         * usuario.setRol(usuarioDTO.getRol());
         * usuario.setNroServicios(usuarioDTO.getNroServicios());
         * return usuario;
         */
        Usuario usuario = Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .celular(usuarioDTO.getCelular())
                .email(usuarioDTO.getEmail())
                .password(encodePassword(usuarioDTO.getPassword()))
                .nroDocumento(usuarioDTO.getNroDocumento())
                .rol(usuarioDTO.getRol())
                .nroServicios(usuarioDTO.getNroServicios())
                .build();
        return usuario;
    }

    public static UsuarioDTO convertirDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = UsuarioDTO.builder()
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .celular(usuario.getCelular())
                .email(usuario.getEmail())
                .nroDocumento(usuario.getNroDocumento())
                .rol(usuario.getRol())
                .nroServicios(usuario.getNroServicios())
                .build();
        // UsuarioDTO usuarioDTO = new UsuarioDTO();
        // usuarioDTO.setNombre(usuario.getNombre());
        // usuarioDTO.setApellido(usuario.getApellido());
        // usuarioDTO.setCelular(usuario.getCelular());
        // usuarioDTO.setEmail(usuario.getEmail());
        // usuarioDTO.setNroDocumento(usuario.getNroDocumento());
        // usuarioDTO.setRol(usuario.getRol());
        // usuarioDTO.setNroServicios(usuario.getNroServicios());
        return usuarioDTO;
    }

    public static String encodePassword(String password) {
        PasswordHash passwordHash = new PasswordHash();
        return passwordHash.encriptarPassword(password);
    }
}
