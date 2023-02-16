package com.aat.stock.management.transaction.pdf;

import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import com.aat.stock.management.matierePremiere.MatierePremiereRepository;
import com.aat.stock.management.matierePremiere.service.MatierePremiereServiceInterface;
import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiereDto;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FactureSortiePDFExport {



    private List<ReceptionnaireMatiereDto> receptionnaireMatiereDtos;

    public FactureSortiePDFExport(List<ReceptionnaireMatiereDto> receptionnaireMatiereDtos) {
        this.receptionnaireMatiereDtos = receptionnaireMatiereDtos;
    }

    public void export(HttpServletResponse response)throws DocumentException, IOException {
        
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Image png = Image.getInstance("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRAveoPJJpqLAUYrGG6sLnyYNZO8NZlaVL0XeGu1Zdew4ATILNXIGJOBZNhDSMe9KggR0c&usqp=CAU");
        png.scaleAbsolute(  70,80);
         png.setAbsolutePosition(260,750);
        document.add(png);
        Font font = FontFactory.getFont(FontFactory.TIMES_BOLD);
        font.setSize(14);
        font.setColor(Color.BLACK);
        Paragraph TT = new Paragraph("BON DE SORTIE MAGASIN",font);
        TT.setAlignment(Paragraph.ALIGN_CENTER);
        TT.setSpacingBefore(20);
        Paragraph T2 = new Paragraph("Urgence      ",font);
        T2.setAlignment(Paragraph.ALIGN_RIGHT);
        T2.setSpacingBefore(10);
        //dssdsd
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.5f,6f,1f,1f});
        table.setSpacingBefore(10);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);
        cell.setPhrase(new Phrase("Code", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("DESIGNATION", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("UTE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("QTE", font));
        table.addCell(cell);
        for(ReceptionnaireMatiereDto r: receptionnaireMatiereDtos){
        table.addCell(r.getArticleCode());
        table.addCell(r.getArticleDesignation());
        table.addCell(r.getUnite());
        table.addCell(""+r.getQuantiteLivre());
        }
        PdfPTable table1 = new PdfPTable(2);
        table1.setWidthPercentage(30f);
        table1.setWidths(new float[] {2.5f,2.5f});
        table1.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table1.setSpacingBefore(3);
        PdfPCell cell1 = new PdfPCell();
        cell1.setBackgroundColor(Color.LIGHT_GRAY);
        cell1.setPhrase(new Phrase("OUI", font));
        table1.addCell(cell1);
        cell1.setPhrase(new Phrase("NON", font));
        table1.addCell(cell1);
        table1.addCell("...............");
        table1.addCell("...............");
        PdfPTable table2 = new PdfPTable(1);
        table2.setWidthPercentage(100f);
        table2.setSpacingBefore(0);
        table2.addCell("Imputation : \n");
        PdfPTable table3 = new PdfPTable(2);
        table3.setWidthPercentage(100f);
        table3.setWidths(new float[] {2.5f,2.5f});
        table3.setSpacingBefore(20);
        table3.addCell("             Nom et visa du Réceptionnaire\n\n\n");
        table3.addCell("     Chef du service Logistique et Gestion de la\n                       production à l'AAT\n\n\n ");
        table3.addCell("    Chef de la Division chargée de la Formation\n                 et de la Recherche à l'AAT\n\n\n\n");
        table3.addCell("             Chef de la Division des Affaires\n         Administratives et Financiere à l'AAT\n\n\n\n");
        PdfPTable table4 = new PdfPTable(1);
        table4.setWidthPercentage(100f);
        table4.setSpacingBefore(0);
        table4.addCell("                                 Le Directeur DE l'Académie des Arts Traditionnels\n\n\n\n\n");
        //get la date d'aujourdhui
        Font F1 = FontFactory.getFont(FontFactory.TIMES);
        font.setSize(12);
        font.setColor(Color.BLACK);
        SimpleDateFormat formater = null;
        Date aujourdhui = new Date();
        formater = new SimpleDateFormat(" dd/MM/yyyy ");
        Paragraph T3= new Paragraph("Casablanca, le"+formater.format(aujourdhui), F1);
        T3.setAlignment(Paragraph.ALIGN_RIGHT);
        T3.setSpacingBefore(50);
        SimpleDateFormat formater1 = null;
        formater1 = new SimpleDateFormat(" MM-yyyy ");
        Paragraph T4= new Paragraph("N°"+formater1.format(aujourdhui), F1);
        T4.setAlignment(Paragraph.ALIGN_CENTER);
        T4.setSpacingBefore(5);
        document.add(T3);
        document.add(TT);
        document.add(T4);
        document.add(T2);
        document.add(table1);
        document.add(table);
        document.add(table2);
        document.add(table3);
        document.add(table4);
        document.close();

    }
}
