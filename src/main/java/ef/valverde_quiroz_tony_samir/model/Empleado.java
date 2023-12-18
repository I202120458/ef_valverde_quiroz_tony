package ef.valverde_quiroz_tony_samir.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "tbl_empleado")
@Entity
@Getter
@Setter

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(precision = 10, scale = 2)
    private BigDecimal salario;

    @Column(columnDefinition = "DATE") // Esto indica que la columna será de tipo DATE en la base de datos

    private LocalDate fecha_ingreso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;}
