package com.udea.gestionusuarios.model;

import java.sql.Date;

public class MetodoPagoUsuario {
    
    private long id;
    private long idUsuario;
    private long idMetodoPago;
    private String nombreBanco;
    private String nombreTarjeta;
    private String numeroTarjeta;
    private Date expiracionTarjeta;
    private String codigoSeguridadTarjeta;

}
