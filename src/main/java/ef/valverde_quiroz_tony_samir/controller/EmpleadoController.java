package ef.valverde_quiroz_tony_samir.controller;
import ef.valverde_quiroz_tony_samir.model.Empleado;
import ef.valverde_quiroz_tony_samir.service.EmpleadoService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> listarTodosLosEmpleados() {
        return empleadoService.listarTodosLosEmpleados();
    }

    @PostMapping
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.guardarEmpleado(empleado);
    }

    @GetMapping("/reporte01")
    public ResponseEntity<byte[]> descargarReporte01() throws JRException {
        JasperReport report = JasperCompileManager.compileReport("src/main/resources/reportes/ReportEmp.jrxml");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(empleadoService.listarTodosLosEmpleados());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("titulo", "Reporte de Empleados");
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);

        byte[] reporte = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("empleados.pdf").build());

        return ResponseEntity.ok()
                .headers(headers)
                .body(reporte);
    }

}