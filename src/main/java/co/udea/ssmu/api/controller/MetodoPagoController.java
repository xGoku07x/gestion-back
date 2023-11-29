package co.udea.ssmu.api.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.ssmu.api.model.jpa.model.MetodoPago;
import co.udea.ssmu.api.services.metodospago.MetodoPagoFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Metodos de pago", description = "El API de MetodoPago permite realizar operaciones CRUD sobre los metodos de pago del sistema.")
@RestController
@RequestMapping("/v1/metodos-pago")
@RequiredArgsConstructor
public class MetodoPagoController {
    
    private final MetodoPagoFacade metodoPagoFacade;

    @Operation(summary = "Obtener metodos de pago", description = "Obtiene los metodos de pago del sistema.")   
    @GetMapping("/lista")
    public ResponseEntity<List<MetodoPago>> obtenerMetodosPago(){
        List<MetodoPago> metodos = metodoPagoFacade.obtenerMetodoPagos();
        return ResponseEntity.ok(metodos);

    }
}
