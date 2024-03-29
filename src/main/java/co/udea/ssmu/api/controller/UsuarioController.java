package co.udea.ssmu.api.controller;

import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioInfoDTO;
import co.udea.ssmu.api.model.jpa.dto.usuario.UsuarioDTO;
import co.udea.ssmu.api.services.usuario.UsuarioFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Usuario", description = "El API de Usuario permite realizar operaciones CRUD sobre los usuarios del sistema.")
@RestController
@RequestMapping("/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    
    private final UsuarioFacade usuarioFacade;

    @Operation(summary = "Obtener información de un usuario", description = "Obtiene la información de un usuario dado su número de documento.")
    @GetMapping("/{nro_documento}")
    public ResponseEntity<Object> obtenerInformacionUsuario(@PathVariable(name="nro_documento") String nroDocumento) {
        try {
            UsuarioInfoDTO usuario = usuarioFacade.obtenerInformacionUsuario(nroDocumento);
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Crear un usuario", description = "Crea un usuario en el sistema.")    
    @PostMapping("/")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            this.usuarioFacade.crearUsuario(usuarioDTO);
            return ResponseEntity.ok("El usuario ha sido creado correctamente.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @Operation(summary = "Actualizar un usuario", description = "Actualiza la información de un usuario en el sistema.")    
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
