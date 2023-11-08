package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioInfoDTO;
import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioDTO;
import co.udea.ssmu.api.services.usuario.UsuarioFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {

    private final UsuarioFacade usuarioFacade;

    public UsuarioController (UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    @GetMapping("/{nro_documento}")
    public ResponseEntity<Object> obtenerInformacionUsuario(@PathVariable(name="nro_documento") String nroDocumento) {
        try {
            UsuarioInfoDTO usuario = usuarioFacade.obtenerInformacionUsuario(nroDocumento);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            this.usuarioFacade.crearUsuario(usuarioDTO);
            return ResponseEntity.ok("El usuario ha sido creado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/")
    public ResponseEntity<String> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            this.usuarioFacade.actualizarUsuario(usuarioDTO);
            return ResponseEntity.ok("El usuario ha sido actualizado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
