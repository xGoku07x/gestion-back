package co.udea.ssmu.api.model.jpa.dto;

import co.udea.ssmu.api.model.jpa.model.Usuario;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LugarFavoritoDTO {

    private long idLugarFavorito;
    private Usuario usuario;
    private long ubicacion; //TODO: Cambiar por objeto Ubicacion
    private String nombre;

}
