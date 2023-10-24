package co.udea.ssmu.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.services.UsuarioFacade;

public class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioFacade usuarioFacade;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testActualizarUsuario() {
        
    }

    @Test
    void testCrearUsuario() {

    }

    @Test
    void testObtenerInformacionUsuario() {
        // Datos de prueba
        UsuarioDTO usuarioMock = new UsuarioDTO();
        String nroDocumento = "1001416";

        // Simular el comportamiento del objeto Mock (usuarioFacade)
        Mockito.when(usuarioFacade.obtenerInformacionUsuario(nroDocumento)).thenReturn(usuarioMock);

        // Simular la respuesta del controller
        ResponseEntity<Object> response = usuarioController.obtenerInformacionUsuario(nroDocumento);

        // Verificar que se llame al método del usuarioFacade
        Mockito.verify(usuarioFacade).obtenerInformacionUsuario(nroDocumento);

        // Verificar que la respuesta sea un ResponseEntity con el código de estado OK
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Verificar que el cuerpo de la respuesta sea el usuarioMock
        assertEquals(usuarioMock, response.getBody());
    }

    @Test
    void testObtenerInformacionUsuarioError() {
        
    }
}
