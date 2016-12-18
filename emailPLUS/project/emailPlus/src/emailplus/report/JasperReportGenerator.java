/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emailplus.report;

import emailplus.operations.DBConnection;
import java.sql.Connection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Vishal
 */
public class JasperReportGenerator {

    String designFilePath;

    public JasperReportGenerator(String designFilePath) {
        this.designFilePath = designFilePath;
        generateReport();
    }

    void generateReport() {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(designFilePath);
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            Connection con = DBConnection.getConnection();

            ////String un="admin";

           // Map parameters = new HashMap();

           //parameters.put("un", un);




            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println("Exception in generationg report, generateReport() of JasperReportGenerator: "+e);
        }

    }
}
