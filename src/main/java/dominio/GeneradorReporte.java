package dominio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeneradorReporte {
    private static GeneradorReporte instancia = null;

    private GeneradorReporte() {}

    public static GeneradorReporte getInstancia() {
      //Para que sea un Singleton de forma reducida
      return (instancia == null)? new GeneradorReporte() : instancia;
    }

    public void generar(List<Persona> personas, String nombreArchivo, String titulo) {
      try {
        System.out.println("empiezo de generar");
        // Carga y compila el archivo JRXML
        JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/PersonReport.jrxml");

        // Llenar el reporte con datos
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(personas);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("tituloReport", titulo);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Exportar a PDF
        JasperExportManager.exportReportToPdfFile(jasperPrint, nombreArchivo);
      } catch (JRException e) {
        e.printStackTrace();
      }
    }
}
