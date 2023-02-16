package com.aat.stock.management.transaction.pdf;

import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import com.aat.stock.management.transaction.fournisseurMatiere.FournisseurMatiereDto;
import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiereDto;
import com.lowagie.text.DocumentException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pdf")
@CrossOrigin("*")
public class FacturePDFController {
    @PostMapping("/facturesortie")
    public void exportFactureSortieToPDF(HttpServletResponse response , @RequestBody List<ReceptionnaireMatiereDto>  receptionnaireMatiereDtos) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=facture_de_sortie" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        FactureSortiePDFExport exporter = new FactureSortiePDFExport(receptionnaireMatiereDtos);
        exporter.export(response);

    }
    @PostMapping("/facturereception")
    public void exportFactureReceptionToPDF(HttpServletResponse response , @RequestBody List<FournisseurMatiereDto> fournisseurMatiereDtos) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=facture_de_reception " + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        FactureReceptionPDFExport exporter = new FactureReceptionPDFExport(fournisseurMatiereDtos);
        exporter.export(response);

    }
}
