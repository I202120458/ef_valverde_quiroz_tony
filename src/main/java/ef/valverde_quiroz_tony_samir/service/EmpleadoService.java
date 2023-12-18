package ef.valverde_quiroz_tony_samir.service;

import ef.valverde_quiroz_tony_samir.model.Empleado;

import java.util.List;

public interface EmpleadoService {
    Empleado guardarEmpleado(Empleado empleado);

    Empleado actualizarEmpleado(Empleado empleado);

    void eliminarEmpleado(Long id);

    Empleado obtenerEmpleado(Long id);

    List<Empleado> listarTodosLosEmpleados();

}
