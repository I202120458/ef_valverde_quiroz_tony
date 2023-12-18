package ef.valverde_quiroz_tony_samir.service.Impl;
import ef.valverde_quiroz_tony_samir.model.Empleado;
import ef.valverde_quiroz_tony_samir.repository.EmpleadoRepository;
import ef.valverde_quiroz_tony_samir.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        validarEmpleado(empleado);
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        validarEmpleado(empleado);
        if (!empleadoRepository.existsById(empleado.getId())) {
            throw new IllegalArgumentException("El empleado con el ID especificado no existe.");
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new IllegalArgumentException("El empleado con el ID especificado no existe.");
        }
        empleadoRepository.deleteById(id);
    }

    @Override
    public Empleado obtenerEmpleado(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        if (empleado.isEmpty()) {
            throw new IllegalArgumentException("El empleado con el ID especificado no existe.");
        }
        return empleado.get();
    }

    @Override
    public List<Empleado> listarTodosLosEmpleados() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    private void validarEmpleado(Empleado empleado) {
        if (empleado.getNombre() == null || empleado.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del empleado no puede estar vacío.");
        }

        // Puedes agregar más validaciones según tus requerimientos.
    }
}
