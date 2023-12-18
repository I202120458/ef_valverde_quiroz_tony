package ef.valverde_quiroz_tony_samir.repository;
import ef.valverde_quiroz_tony_samir.model.Departamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DepartamentoRepository extends CrudRepository<Departamento, Long> {

    List<Departamento> findById(BigDecimal id);

    List<Departamento> findByDescripcion(String descripcion);

    List<Departamento> findByDescripcionContaining(String cadena);

    List<Departamento> findByDescripcionStartingWith(String cadena);
}