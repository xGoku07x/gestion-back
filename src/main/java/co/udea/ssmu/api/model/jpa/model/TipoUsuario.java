package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {

    @Id
    @Column(name = "id_tipo_usuario")
    private long idTipoUsuario;

    @Column(name = "nombre", nullable=false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
    
}
