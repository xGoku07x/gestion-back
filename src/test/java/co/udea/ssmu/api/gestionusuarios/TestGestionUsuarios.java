package co.udea.ssmu.api.gestionusuarios;

import co.udea.ssmu.api.controller.UsuarioController;
import co.udea.ssmu.api.model.jpa.dto.UsuarioDTO;
import co.udea.ssmu.api.services.UsuarioFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestGestionUsuarios {


    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioFacade usuarioFacade;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void crearUsuario_UsuarioCreadoExitosamente_DebeRetornarOk() {
        // Simulamos el comportamiento exitoso de usuarioFacade.crearUsuario
        Mockito.doNothing().when(usuarioFacade).crearUsuario(Mockito.any(UsuarioDTO.class));

        UsuarioDTO usuarioDTO = new UsuarioDTO();
        ResponseEntity<String> response = usuarioController.crearUsuario(usuarioDTO);

        assertEquals(200, response.getStatusCodeValue()); // Verifica si la respuesta es OK (código de estado 200)
        assertEquals("El usuario ha sido creado correctamente.", response.getBody()); // Verifica el cuerpo de la respuesta
    }
}

