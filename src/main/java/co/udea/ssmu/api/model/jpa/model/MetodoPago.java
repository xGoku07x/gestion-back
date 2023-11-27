package co.udea.ssmu.api.model.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "m3_metodo_pago")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MetodoPago {

    @Id
    @Column(name = "id_metodo_pago")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_metodo_pago_generator")
    @SequenceGenerator(name="seq_metodo_pago_generator", sequenceName = "SEQ_METODO_PAGO", allocationSize=1)
    private long idMetodoPago;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;
}
