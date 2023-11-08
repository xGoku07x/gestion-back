package co.udea.ssmu.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.ssmu.api.model.jpa.model.MetodoPago;
import co.udea.ssmu.api.services.metodospago.MetodoPagoFacade;

@RestController
@RequestMapping("/metodos-pago")
public class MetodoPagoController {
    
    private MetodoPagoFacade metodoPagoFacade;

    public MetodoPagoController(MetodoPagoFacade metodoPagoFacade) {
        this.metodoPagoFacade = metodoPagoFacade;
    }

    @GetMapping("/lista")
    public ResponseEntity<List<MetodoPago>> obtenerMetodosPago(){
        List<MetodoPago> metodos = metodoPagoFacade.obtenerMetodoPagos();
        return ResponseEntity.ok(metodos);

    }
}
