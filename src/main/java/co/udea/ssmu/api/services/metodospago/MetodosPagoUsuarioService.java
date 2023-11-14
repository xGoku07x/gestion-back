package co.udea.ssmu.api.services.metodospago;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.metodopago.MetodoPagoUsuarioDTO;
import co.udea.ssmu.api.model.jpa.dto.metodopago.MetodoPagoUsuarioInfoDTO;
import co.udea.ssmu.api.model.jpa.model.MetodoPago;
import co.udea.ssmu.api.model.jpa.model.MetodoPagoUsuario;
import co.udea.ssmu.api.model.jpa.model.Usuario;
import co.udea.ssmu.api.model.jpa.repository.MetodoPagoUsuarioRepository;
import co.udea.ssmu.api.services.usuario.UsuarioFacade;
import co.udea.ssmu.api.model.jpa.mapper.MetodoPagoUsuarioMapper;

@Service
public class MetodosPagoUsuarioService {

    private MetodoPagoUsuarioRepository metodoPagoUsuarioRepository;
    private UsuarioFacade usuarioFacade;
    private MetodoPagoFacade metodoPagoFacade;

    public MetodosPagoUsuarioService(
            MetodoPagoUsuarioRepository metodoPagoUsuarioRepository,
            UsuarioFacade usuarioFacade,
            MetodoPagoFacade metodoPagoFacade) {
        this.metodoPagoUsuarioRepository = metodoPagoUsuarioRepository;
        this.usuarioFacade = usuarioFacade;
        this.metodoPagoFacade = metodoPagoFacade;
    }

    public void crearMetodoPagoUsuario(MetodoPagoUsuarioDTO metodoPagoUsuarioDTO) {
        Usuario usuario = this.usuarioFacade.obtenerUsuarioPorCedula(metodoPagoUsuarioDTO.getCedula());
        MetodoPago metodoPago = this.metodoPagoFacade.obtenerMetodoPago(metodoPagoUsuarioDTO.getIdMetodoPago());
        MetodoPagoUsuario metodoPagoUsuario = MetodoPagoUsuarioMapper.convertirEntidad(metodoPagoUsuarioDTO, usuario,
                metodoPago);
                System.out.println(metodoPagoUsuario);
        this.metodoPagoUsuarioRepository.save(metodoPagoUsuario);
    }

    public List<MetodoPagoUsuarioInfoDTO> obtenerMetodoPagosUsuario(String cedula) {
        Usuario usuario = this.usuarioFacade.obtenerUsuarioPorCedula(cedula);
        Long idUsuario = usuario.getIdUsuario();

        List<MetodoPagoUsuario> metodosPagoUsuario = this.metodoPagoUsuarioRepository
                .findAllByIdUsuario_IdUsuario(idUsuario);
        List<MetodoPagoUsuarioInfoDTO> metodosPagoUsuarioDTO = new ArrayList<>();

        for (MetodoPagoUsuario metodoPagoUsuario : metodosPagoUsuario) {
            MetodoPago metodoPago = metodoPagoUsuario.getIdMetodoPago();
            metodosPagoUsuarioDTO.add(MetodoPagoUsuarioMapper.convertirDTO(metodoPagoUsuario, metodoPago));
        }

        return metodosPagoUsuarioDTO;
    }
}
