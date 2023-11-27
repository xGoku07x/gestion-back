package co.udea.ssmu.api.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import co.udea.ssmu.api.model.jpa.dto.metodopago.MetodoPagoUsuarioDTO;
import co.udea.ssmu.api.model.jpa.dto.metodopago.MetodoPagoUsuarioInfoDTO;
import co.udea.ssmu.api.services.metodospago.MetodosPagoUsuarioFacade;
import co.udea.ssmu.api.utils.exception.GeneralRuntimeException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "MetodoPagoUsuario", description = "El API de MetodoPagoUsuario permite realizar operaciones CRUD sobre los metodos de pago de los usuarios del sistema.") 
@RestController
@RequestMapping("/metodos-pagos-usuario")
@RequiredArgsConstructor

public class MetodoPagoUsuarioController {

    private final MetodosPagoUsuarioFacade metodoPagoUsuarioFacade;

    @Operation(summary = "Crear un metodo de pago de un usuario", description = "Crea un metodo de pago de un usuario en el sistema.")
    @PostMapping("/")
    public ResponseEntity<String> crearMetodoPagoUsuario(@RequestBody MetodoPagoUsuarioDTO metodoPagoUsuarioDTO){
        try{
            this.metodoPagoUsuarioFacade.crearMetodoPagoUsuario(metodoPagoUsuarioDTO);
            return ResponseEntity.ok("Se agregó el método de pago correctamente.");
        } catch (GeneralRuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Obtener metodos de pago de un usuario", description = "Obtiene los metodos de pago de un usuario dado su numero de documento.")
    @GetMapping("/{cedula}")
    public ResponseEntity<List<MetodoPagoUsuarioInfoDTO>> obtenerMetodosPagoUsuario(
            @PathVariable(name = "cedula") String cedula) {
        List<MetodoPagoUsuarioInfoDTO> metodos = this.metodoPagoUsuarioFacade.obtenerMetodoPagosUsuario(cedula);
        return ResponseEntity.ok(metodos);
    }
}
