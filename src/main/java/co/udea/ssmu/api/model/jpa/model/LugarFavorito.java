package co.udea.ssmu.api.model.jpa.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "lugar_favorito")
public class LugarFavorito {

    @Id
    @Column(name = "id_lugar_favorito")
    private long idLugarFavorito;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "id_ubicacion")
    private long ubicacion; //Cambiar por objeto Ubicacion
    
    @Column(name = "nombre")    
    private String nombre;

}
