package co.udea.ssmu.api.services.usuario;

import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioInfoDTO;
import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.mapper.UsuarioMapper;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioFacade {
    private UsuarioService usuarioService;

    public UsuarioFacade(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public void crearUsuario(UsuarioDTO usuarioDTO){
        this.usuarioService.crearUsuario(usuarioDTO);
    }

    public void actualizarUsuario(UsuarioDTO usuarioDTO){
        this.usuarioService.actualizarUsuario(usuarioDTO);
    }

    public UsuarioInfoDTO obtenerInformacionUsuario(String nroDocumento){
        return UsuarioMapper.convertirDTO(usuarioService.obtenerInformacionUsuario(nroDocumento));
    }

    public Usuario obtenerUsuarioPorCedula(String cedula){
        return this.usuarioService.obtenerUsuarioPorCedula(cedula);
    }
}
