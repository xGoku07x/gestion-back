package co.udea.ssmu.api.mapper;

import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioInfoDTO;
import co.udea.ssmu.api.model.jpa.mapper.UsuarioMapper;
import co.udea.ssmu.api.model.jpa.model.TipoUsuario;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioMapperTest {


    @Test
    public void convertirEntidadExitosoTest() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("John");
        usuarioDTO.setApellido("Doe");
        usuarioDTO.setCelular("123456789");
        usuarioDTO.setEmail("john@example.com");
        usuarioDTO.setNroDocumento("123ABC");
        usuarioDTO.setNroServicios("5");

        Usuario usuario = UsuarioMapper.convertirEntidad(usuarioDTO);

        assertEquals(usuarioDTO.getNombre(), usuario.getNombre());
        assertEquals(usuarioDTO.getApellido(), usuario.getApellido());
        assertEquals(usuarioDTO.getCelular(), usuario.getCelular());
        assertEquals(usuarioDTO.getEmail(), usuario.getEmail());
        assertEquals(usuarioDTO.getNroDocumento(), usuario.getNroDocumento());
        assertEquals(usuarioDTO.getNroServicios(), usuario.getNroServicios());
    }


    @Test
    public void crearUsuarioEntidadExitosoTest() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("John");
        usuarioDTO.setApellido("Doe");
        usuarioDTO.setCelular("123456789");
        usuarioDTO.setEmail("john@example.com");
        usuarioDTO.setPassword("1234567");
        usuarioDTO.setNroDocumento("123ABC");

        Usuario usuario = UsuarioMapper.crearUsuarioEntidad(usuarioDTO);

        assertEquals(usuarioDTO.getNombre(), usuario.getNombre());
        assertEquals(usuarioDTO.getApellido(), usuario.getApellido());
        assertEquals(usuarioDTO.getCelular(), usuario.getCelular());
        assertEquals(usuarioDTO.getEmail(), usuario.getEmail());
        assertEquals(usuarioDTO.getNroDocumento(), usuario.getNroDocumento());
        assertEquals("USUARIO", usuario.getRol());
        assertEquals("0", usuario.getNroServicios());
    }


    @Test
    public void convertirDTOExitosoTest() {
        Usuario usuario = new Usuario();
        TipoUsuario tipoUsuario = TipoUsuario.builder().idTipoUsuario(1).nombre("Usuario nuevo").descripcion("nuevo").build();

        usuario.setNombre("John");
        usuario.setApellido("Doe");
        usuario.setTipoUsuario(tipoUsuario);
        usuario.setCelular("123456789");
        usuario.setEmail("john@example.com");
        usuario.setNroDocumento("123ABC");
        usuario.setRol("Usuario");
        usuario.setNroServicios("0");

        UsuarioInfoDTO usuarioInfoDTO = UsuarioMapper.convertirDTO(usuario);

        assertEquals(usuario.getTipoUsuario().getNombre(), usuarioInfoDTO.getTipoUsuario());
        assertEquals(usuario.getNombre(), usuarioInfoDTO.getNombre());
        assertEquals(usuario.getApellido(), usuarioInfoDTO.getApellido());
        assertEquals(usuario.getCelular(), usuarioInfoDTO.getCelular());
        assertEquals(usuario.getEmail(), usuarioInfoDTO.getEmail());
        assertEquals(usuario.getNroDocumento(), usuarioInfoDTO.getNroDocumento());
        assertEquals(usuario.getRol(), usuarioInfoDTO.getRol());
        assertEquals(usuario.getNroServicios(), usuarioInfoDTO.getNroServicios());
    }

}
