package co.udea.ssmu.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.mapper.UsuarioMapper;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioFacade {
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioFacade(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public void crearUsuario(UsuarioDTO usuarioDTO){
        UsuarioMapper.convertirDTO(usuarioService.crearUsuario(usuarioDTO));
    }

    public UsuarioDTO actualizarUsuario(UsuarioDTO usuarioDTO){
        return UsuarioMapper.convertirDTO(usuarioService.actualizarUsuario(usuarioDTO));
    }

    public UsuarioDTO obtenerInformacionUsuario(String nroDocumento){
        return UsuarioMapper.convertirDTO(usuarioService.obtenerInformacionUsuario(nroDocumento));
    }
}
