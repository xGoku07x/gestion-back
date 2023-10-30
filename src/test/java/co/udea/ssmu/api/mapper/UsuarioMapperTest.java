package co.udea.ssmu.api.mapper;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.mapper.UsuarioMapper;
import co.udea.ssmu.api.model.jpa.model.TipoUsuario;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.utils.hasher.PasswordHash;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UsuarioMapperTest {

    @Test
    public void convertirEntidadExitosoTest() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setIdUsuario(1L);
        usuarioDTO.setNombre("John");
        usuarioDTO.setApellido("Doe");
        usuarioDTO.setCelular("123456789");
        usuarioDTO.setEmail("john@example.com");
        usuarioDTO.setNroDocumento("123ABC");
        usuarioDTO.setRol("usuario");
        usuarioDTO.setNroServicios("5");

        Usuario usuario = UsuarioMapper.convertirEntidad(usuarioDTO);

        assertEquals(usuarioDTO.getIdUsuario(), usuario.getIdUsuario());
        assertEquals(usuarioDTO.getNombre(), usuario.getNombre());
        assertEquals(usuarioDTO.getApellido(), usuario.getApellido());
        assertEquals(usuarioDTO.getCelular(), usuario.getCelular());
        assertEquals(usuarioDTO.getEmail(), usuario.getEmail());
        assertEquals(usuarioDTO.getNroDocumento(), usuario.getNroDocumento());
        assertEquals(usuarioDTO.getRol(), usuario.getRol());
        assertEquals(usuarioDTO.getNroServicios(), usuario.getNroServicios());
    }


    @Test
    public void convertirDTOExitosoTest() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setCelular("123456789");
        usuario.setEmail("john@example.com");
        usuario.setNroDocumento("123ABC");
        usuario.setRol("Usuario");
        usuario.setNroServicios("0");

        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(1L);
        usuario.setTipoUsuario(tipoUsuario);

        UsuarioDTO usuarioDTO = UsuarioMapper.convertirDTO(usuario);

        assertEquals(usuario.getIdUsuario(), usuarioDTO.getIdUsuario());
        assertEquals(usuario.getTipoUsuario().getIdTipoUsuario(), usuarioDTO.getTipoUsuario());
        assertEquals(usuario.getNombre(), usuarioDTO.getNombre());
        assertEquals(usuario.getApellido(), usuarioDTO.getApellido());
        assertEquals(usuario.getCelular(), usuarioDTO.getCelular());
        assertEquals(usuario.getEmail(), usuarioDTO.getEmail());
        assertEquals(usuario.getNroDocumento(), usuarioDTO.getNroDocumento());
        assertEquals(usuario.getRol(), usuarioDTO.getRol());
        assertEquals(usuario.getNroServicios(), usuarioDTO.getNroServicios());
    }

}
