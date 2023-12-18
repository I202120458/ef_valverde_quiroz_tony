package ef.valverde_quiroz_tony_samir.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "tb_departamento")
@Entity
@Getter
@Setter
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @OneToMany(mappedBy = "departamento")  // Corregir el nombre del atributo
    private List<Empleado> empleados;

    // Otros campos y métodos, si los hay
}