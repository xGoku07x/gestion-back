package co.udea.ssmu.api.services.metodospago;

import java.util.List;

import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.model.MetodoPago;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoPagoFacade {
    
    private MetodoPagoService metodoPagoService;

    public MetodoPagoFacade(MetodoPagoService metodoPagoService){
        this.metodoPagoService = metodoPagoService;
    }

    public List<MetodoPago> obtenerMetodoPagos(){
        return metodoPagoService.obtenerMetodosPago();
    }

    public MetodoPago obtenerMetodoPago(Long id){
        return metodoPagoService.obtenerMetodoPago(id);
    }

}
