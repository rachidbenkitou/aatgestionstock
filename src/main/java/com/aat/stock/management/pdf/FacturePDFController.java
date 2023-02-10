package com.aat.stock.management.pdf;

import com.lowagie.text.DocumentException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/pdf")
public class FacturePDFController {
    @GetMapping("/facturesortie")
    public void exportFactureSortieToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=facture_de_sortie" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        FactureSortiePDFExport exporter = new FactureSortiePDFExport();
        exporter.export(response);

    }
    @GetMapping("/facturereception")
    public void exportFactureReceptionToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=facture_de_reception " + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        FactureReceptionPDFExport exporter = new FactureReceptionPDFExport();
        exporter.export(response);

    }
}
