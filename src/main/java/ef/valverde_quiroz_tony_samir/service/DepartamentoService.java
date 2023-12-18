package ef.valverde_quiroz_tony_samir.service;
import ef.valverde_quiroz_tony_samir.model.Departamento;

import java.util.List;

public interface DepartamentoService {
    Departamento guardarDepartamento(Departamento departamento);

    Departamento actualizarDepartamento(Departamento departamento);

    void eliminarDepartamento(Long id);

    Departamento obtenerDepartamento(Long id);

    List<Departamento> listarTodosLosDepartamentos();
}
