package co.udea.ssmu.api.services.metodosPago;

import java.util.List;

import org.springframework.stereotype.Service;

import co.udea.ssmu.api.model.jpa.model.MetodoPago;
import co.udea.ssmu.api.model.jpa.repository.MetodoPagoRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class MetodoPagoService {
    
    private MetodoPagoRepository metodoPagoRepository;


    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    public List<MetodoPago> obtenerMetodosPago(){
        return metodoPagoRepository.findAll();
    }

    public MetodoPago obtenerMetodoPago(Long id){
        return metodoPagoRepository.findById(id).orElse(null);
    }
}
