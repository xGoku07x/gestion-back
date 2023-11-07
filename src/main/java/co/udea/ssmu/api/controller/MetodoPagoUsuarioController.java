package co.udea.ssmu.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import co.udea.ssmu.api.model.jpa.dto.metodoPago.MetodoPagoUsuarioDTO;
import co.udea.ssmu.api.model.jpa.dto.metodoPago.MetodoPagoUsuarioInfoDTO;
import co.udea.ssmu.api.services.metodosPago.MetodosPagoUsuarioFacade;
import co.udea.ssmu.api.utils.exception.GeneralRuntimeException;

@RestController
@RequestMapping("/metodos-pagos-usuario")
public class MetodoPagoUsuarioController {
    private MetodosPagoUsuarioFacade metodoPagoUsuarioFacade;

    public MetodoPagoUsuarioController(MetodosPagoUsuarioFacade metodoPagoUsuarioFacade) {
        this.metodoPagoUsuarioFacade = metodoPagoUsuarioFacade;
    }

    @PostMapping("/")
    public ResponseEntity<String> crearMetodoPagoUsuario(@RequestBody MetodoPagoUsuarioDTO metodoPagoUsuarioDTO){
        try{
            this.metodoPagoUsuarioFacade.crearMetodoPagoUsuario(metodoPagoUsuarioDTO);
            return ResponseEntity.ok("No vale mondá la vida");
        } catch (GeneralRuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
            
        }
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<List<MetodoPagoUsuarioInfoDTO>> obtenerMetodosPagoUsuario(
            @PathVariable(name = "cedula") String cedula) {
        List<MetodoPagoUsuarioInfoDTO> metodos = this.metodoPagoUsuarioFacade.obtenerMetodoPagosUsuario(cedula);
        return ResponseEntity.ok(metodos);
    }
}
