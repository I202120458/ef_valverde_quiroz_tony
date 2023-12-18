package ef.valverde_quiroz_tony_samir;

import ef.valverde_quiroz_tony_samir.model.Empleado;
import ef.valverde_quiroz_tony_samir.model.Departamento;
import ef.valverde_quiroz_tony_samir.repository.EmpleadoRepository;
import ef.valverde_quiroz_tony_samir.repository.DepartamentoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate; // Importa la clase LocalDate
import java.util.Date;

@SpringBootTest
class ValverdeQuirozTonySamirApplicationTests {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Test
	void insertarEmpleado() {
		// Primero, asegúrate de tener un departamento válido en tu base de datos
		Departamento departamento = new Departamento();
		departamento.setDescripcion("Ventas");
		departamentoRepository.save(departamento);

		// Crea un nuevo Empleado
		Empleado empleado = new Empleado();
		empleado.setNombre("Alex gamarra");
		empleado.setSalario(new BigDecimal("1800.00"));

		// Establece la fecha actual
		empleado.setFechaIngreso(LocalDate.now());

		// Asocia el empleado con el departamento
		empleado.setDepartamento(departamento);

		// Guarda el empleado en la base de datos
		empleadoRepository.save(empleado);
	}
}
