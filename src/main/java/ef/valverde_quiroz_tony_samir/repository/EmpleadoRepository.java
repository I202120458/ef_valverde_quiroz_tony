package ef.valverde_quiroz_tony_samir.repository;

import ef.valverde_quiroz_tony_samir.model.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

    List<Empleado> findByNombre(String nombre);

    List<Empleado> findByNombreContaining(String cadena);

    List<Empleado> findByNombreStartingWith(String cadena);

    List<Empleado> findById(BigDecimal id);

}