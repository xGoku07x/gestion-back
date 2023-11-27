package co.udea.ssmu.api.mapper;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import co.udea.ssmu.api.model.jpa.model.MetodoPago;
import co.udea.ssmu.api.model.jpa.model.MetodoPagoUsuario;
import co.udea.ssmu.api.model.jpa.model.Usuario;

public class MetodoPagoUsuarioMapperTest {

    @Test
    void testConvertirDTO() {

        MetodoPago metodoPago = MetodoPago.builder().idMetodoPago(1).nombre("Tarjeta de crédito")
                .descripcion("Tarjeta de crédito").build();
        Usuario usuario = Usuario.builder().nombre("Juan").apellido("Lopera").celular("1233333")
                .email("correo@udea.edu.co").nroDocumento("1234444").build();
        MetodoPagoUsuario metodoPagoUsuario = MetodoPagoUsuario.builder()
        .idMetodoPago(metodoPago).idUsuario(usuario)                
        .nombreBanco("Bancolombia")
        .nombreTarjeta("Juan Fernando Lopera")
        .numeroTarjeta("112222")
        .codigoSeguridadTarjeta("123")
        .build();

    }

    @Test
    void testConvertirEntidad() {

    }
}
