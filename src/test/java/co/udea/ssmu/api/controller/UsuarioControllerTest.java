package co.udea.ssmu.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.services.usuario.UsuarioFacade;

class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioFacade usuarioFacade;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testActualizarUsuario() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Mockito.doNothing().when(usuarioFacade).actualizarUsuario(usuarioDTO);
        ResponseEntity<String> response = usuarioController.actualizarUsuario(usuarioDTO);
        Mockito.verify(usuarioFacade).actualizarUsuario(usuarioDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("El usuario ha sido actualizado correctamente.", response.getBody());
    }

    @Test
    public void testActualizarUsuarioError() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Mockito.doThrow(new RuntimeException("El usuario no existe")).when(usuarioFacade).actualizarUsuario(usuarioDTO);
        ResponseEntity<String> response = usuarioController.actualizarUsuario(usuarioDTO);
        Mockito.verify(usuarioFacade).actualizarUsuario(usuarioDTO);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("El usuario no existe", response.getBody());
    }

    @Test
    void testCrearUsuario() {
        Mockito.doNothing().when(usuarioFacade).crearUsuario(Mockito.any(UsuarioDTO.class));
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        ResponseEntity<String> response = usuarioController.crearUsuario(usuarioDTO);
        assertEquals(200, response.getStatusCode().value()); 
        assertEquals("El usuario ha sido creado correctamente.", response.getBody()); 
    }

    @Test
    public void testCrearUsuarioError() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Mockito.doThrow(new RuntimeException("Ya existe un usuario con este email o número de cédula usuario  existe")).when(usuarioFacade).crearUsuario(Mockito.any(UsuarioDTO.class));
        ResponseEntity<String> response = usuarioController.crearUsuario(usuarioDTO);
        Mockito.verify(usuarioFacade).crearUsuario(usuarioDTO);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Ya existe un usuario con este email o número de cédula usuario  existe", response.getBody());
    }

    @Test
    void testObtenerInformacionUsuario() {
        UsuarioDTO usuarioMock = new UsuarioDTO();
        String nroDocumento = "1001416";
        Mockito.when(usuarioFacade.obtenerInformacionUsuario(nroDocumento)).thenReturn(usuarioMock);
        ResponseEntity<Object> response = usuarioController.obtenerInformacionUsuario(nroDocumento);
        Mockito.verify(usuarioFacade).obtenerInformacionUsuario(nroDocumento);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usuarioMock, response.getBody());
    }

    @Test
    void testObtenerInformacionUsuarioError() {
        String nroDocumento = "1001416"; 
        RuntimeException errorMock = new RuntimeException("El usuario no existe");
        Mockito.when(usuarioFacade.obtenerInformacionUsuario(nroDocumento)).thenThrow(errorMock);
        ResponseEntity<Object> response = usuarioController.obtenerInformacionUsuario(nroDocumento);
        Mockito.verify(usuarioFacade).obtenerInformacionUsuario(nroDocumento);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("El usuario no existe", response.getBody());
    }
}
