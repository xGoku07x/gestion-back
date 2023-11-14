package co.udea.ssmu.api.model.jpa.mapper;

import co.udea.ssmu.api.model.jpa.dto.metodopago.MetodoPagoUsuarioDTO;
import co.udea.ssmu.api.model.jpa.dto.metodopago.MetodoPagoUsuarioInfoDTO;
import co.udea.ssmu.api.model.jpa.model.MetodoPago;
import co.udea.ssmu.api.model.jpa.model.MetodoPagoUsuario;
import co.udea.ssmu.api.model.jpa.model.Usuario;

import org.apache.commons.lang3.StringUtils;

public class MetodoPagoUsuarioMapper {

    private MetodoPagoUsuarioMapper() {
    }
    public static MetodoPagoUsuario convertirEntidad(MetodoPagoUsuarioDTO metodoPagoUsuarioDTO, Usuario usuario, MetodoPago metodoPago){

        return MetodoPagoUsuario.builder()
                .idUsuario(usuario)
                .idMetodoPago(metodoPago)
                .nombreBanco(metodoPagoUsuarioDTO.getNombreBanco())
                .nombreTarjeta(metodoPagoUsuarioDTO.getNombreTarjeta())
                .numeroTarjeta(metodoPagoUsuarioDTO.getNumeroTarjeta())
                .expiracionTarjeta(metodoPagoUsuarioDTO.getExpiracionTarjeta())
                .codigoSeguridadTarjeta(metodoPagoUsuarioDTO.getCodigoSeguridadTarjeta())
                .build();
    }


    public static MetodoPagoUsuarioInfoDTO convertirDTO(MetodoPagoUsuario metodoPagoUsuario, MetodoPago metodoPago){
        return MetodoPagoUsuarioInfoDTO.builder()
                .idMetodoPagoUsuario(metodoPagoUsuario.getIdMetodoPagoUsuario())
                .nombreMetodoPago(metodoPago.getNombre())
                .nombreBanco(metodoPagoUsuario.getNombreBanco())
                .nombreTarjeta(metodoPagoUsuario.getNombreTarjeta())
                .numeroTarjeta(StringUtils.right(metodoPagoUsuario.getNumeroTarjeta(),4))
                .build();
    }

}
