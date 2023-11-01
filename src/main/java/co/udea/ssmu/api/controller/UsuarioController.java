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
    public ResponseEntity<Object> obtenerInformacionUsuario(@PathVariable(name="nro_documento") String nroDocumento) {
        
            UsuarioDTO usuario = usuarioFacade.obtenerInformacionUsuario(nroDocumento);
            return ResponseEntity.ok(usuario);
        
    }

    @PostMapping("/")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        
            this.usuarioFacade.crearUsuario(usuarioDTO);
            return ResponseEntity.ok("El usuario ha sido creado correctamente.");
        
    }

    @PatchMapping("/")
    public ResponseEntity<String> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        
            this.usuarioFacade.actualizarUsuario(usuarioDTO);
            return ResponseEntity.ok("El usuario ha sido actualizado correctamente.");
        
    }
}
