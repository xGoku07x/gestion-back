package co.udea.ssmu.api.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.model.jpa.mapper.UsuarioMapper;
import co.udea.ssmu.api.model.jpa.model.TipoUsuario;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.model.jpa.repository.TipoUsuarioRepository;
import co.udea.ssmu.api.model.jpa.repository.UsuarioRepository;
import co.udea.ssmu.api.utils.exception.DataDuplicatedException;
import co.udea.ssmu.api.utils.exception.DataNotFoundException;

@Service
@Transactional
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private TipoUsuarioRepository tipoUsuarioRepository;

    private static final String USUARIO_NO_EXISTE = "El usuario no existe";
    private static final String USUARIO_YA_EXISTE = "Ya existe un usuario con este email o número de cédula usuario  existe";
    
    public UsuarioService(UsuarioRepository usuarioRepository, TipoUsuarioRepository tipoUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    public Usuario obtenerInformacionUsuario(String nroDocumento) {
        Usuario usuario = usuarioRepository.findByNroDocumento(nroDocumento);
        if (usuario == null) {
            throw new DataNotFoundException(USUARIO_NO_EXISTE);
        }
        return usuario;
    }

    public Usuario crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = UsuarioMapper.crearUsuarioEntidad(usuarioDTO);
        if (this.existeUsuario(usuario)) {
            throw new DataDuplicatedException(USUARIO_YA_EXISTE);
        }
        this.asignarTipoUsuario(usuario, 1L);
        return this.usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
        if (usuario == null) {
            throw new DataNotFoundException(USUARIO_NO_EXISTE);
        }
        this.actualizarUsuario(usuario, usuarioDTO);
        return this.usuarioRepository.save(usuario);
    }


    private void actualizarUsuario(Usuario usuario, UsuarioDTO usuarioDTO) {
        Map<Function<UsuarioDTO, ?>, Consumer<Object>> mapeoCampos = new HashMap<>();
        mapeoCampos.put(UsuarioDTO::getNombre, usuario::setNombre);
        mapeoCampos.put(UsuarioDTO::getApellido, usuario::setApellido);
        mapeoCampos.put(UsuarioDTO::getCelular, usuario::setCelular);

        if (usuarioDTO.getPassword() != null) {
            String password = UsuarioMapper.encodePassword(usuarioDTO.getPassword());
            usuario.setPassword(password);
        }

        mapeoCampos.forEach((getter, setter) -> {
            Object valor = getter.apply(usuarioDTO);
            if (valor != null) {
                setter.accept(valor);
            }
        });
}

    private void asignarTipoUsuario(Usuario usuario, long idTipoUsuario) {
        TipoUsuario tipoNuevoUsuario = tipoUsuarioRepository.findById(idTipoUsuario).orElse(null);
        
        usuario.setTipoUsuario(tipoNuevoUsuario);
    }

    private boolean existeUsuario(Usuario usuario) {
        return this.usuarioRepository.existsByEmailOrNroDocumento(usuario.getEmail(), usuario.getNroDocumento());
    }
}
