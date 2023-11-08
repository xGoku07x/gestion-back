package co.udea.ssmu.api.services.metodospago;

import java.util.List;

import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.dto.metodopago.MetodoPagoUsuarioDTO;
import co.udea.ssmu.api.model.jpa.dto.metodopago.MetodoPagoUsuarioInfoDTO;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodosPagoUsuarioFacade {

    private MetodosPagoUsuarioService metodosPagoUsuarioService;

    public MetodosPagoUsuarioFacade(MetodosPagoUsuarioService metodosPagoUsuarioService){
        this.metodosPagoUsuarioService = metodosPagoUsuarioService;
    }

    public void crearMetodoPagoUsuario(MetodoPagoUsuarioDTO metodoPagoUsuarioDTO){
        this.metodosPagoUsuarioService.crearMetodoPagoUsuario(metodoPagoUsuarioDTO);
    }

    public List<MetodoPagoUsuarioInfoDTO> obtenerMetodoPagosUsuario(String cedula){
        return metodosPagoUsuarioService.obtenerMetodoPagosUsuario(cedula);
    }
}
