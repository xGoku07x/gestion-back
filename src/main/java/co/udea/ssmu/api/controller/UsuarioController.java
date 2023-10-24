package co.udea.ssmu.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.services.UsuarioFacade;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioFacade usuarioFacade;

    public UsuarioController(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @GetMapping("/{nro_documento}")
    public ResponseEntity<Object> obtenerInformacionUsuario(@PathVariable String nroDocumento) {
        return executeAndReturnResponse(() -> usuarioFacade.obtenerInformacionUsuario(nroDocumento));
    }

    @PostMapping("/")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return executeAndReturnMessage(() -> {
            usuarioFacade.crearUsuario(usuarioDTO);
            return "El usuario ha sido creado correctamente.";
        });
    }

    @PatchMapping("/")
    public ResponseEntity<String> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return executeAndReturnMessage(() -> {
            usuarioFacade.actualizarUsuario(usuarioDTO);
            return "El usuario ha sido actualizado correctamente.";
        });
    }

    private ResponseEntity<Object> executeAndReturnResponse(Supplier<UsuarioDTO> action) {
        try {
            UsuarioDTO usuario = action.get();
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    private ResponseEntity<String> executeAndReturnMessage(Supplier<String> action) {
        try {
            String message = action.get();
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
