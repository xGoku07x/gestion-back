package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioInfoDTO;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.utils.hasher.PasswordHash;

public class UsuarioMapper {

    private UsuarioMapper() {
    }

    public static Usuario convertirEntidad(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .celular(usuarioDTO.getCelular())
                .email(usuarioDTO.getEmail())
                .nroDocumento(usuarioDTO.getNroDocumento())
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
                .rol("USUARIO")
                .nroServicios("0")
                .build();
    }

    public static UsuarioInfoDTO convertirDTO(Usuario usuario) {
        UsuarioInfoDTO.UsuarioInfoDTOBuilder usuarioInfoDTOBuilder =  UsuarioInfoDTO.builder()
                .tipoUsuario(usuario.getTipoUsuario().getNombre())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .celular(usuario.getCelular())
                .email(usuario.getEmail())
                .nroDocumento(usuario.getNroDocumento())
                .nroServicios(usuario.getNroServicios())
                .rol(usuario.getRol());

        cargarGrupo(usuario, usuarioInfoDTOBuilder);
        return usuarioInfoDTOBuilder.build();

    }

    public static void cargarGrupo(Usuario usuario, UsuarioInfoDTO.UsuarioInfoDTOBuilder builder){
        if (usuario.getGrupo() != null){
            builder.grupo(usuario.getGrupo().getNombre()).idGrupo(usuario.getGrupo().getIdGrupo());
        } else {
            builder.idGrupo(-1);
        }
    }

    public static String encodePassword(String password) {
        PasswordHash passwordHash = new PasswordHash();
        return passwordHash.encriptarPassword(password);
    }
}
