package com.aat.stock.management.transaction.pdf;

import com.aat.stock.management.transaction.fournisseurMatiere.FournisseurMatiereDto;
import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiereDto;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FactureReceptionPDFExport {

    private List<FournisseurMatiereDto> fournisseurMatiereDtos;

    public FactureReceptionPDFExport(List<FournisseurMatiereDto> fournisseurMatiereDtos) {
        this.fournisseurMatiereDtos = fournisseurMatiereDtos;
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
        Font F1 = FontFactory.getFont(FontFactory.TIMES);
        font.setSize(12);
        font.setColor(Color.BLACK);
        Paragraph TT = new Paragraph("BON DE RECEPTION ET D'AFFECTATION",font);
        TT.setAlignment(Paragraph.ALIGN_CENTER);
        TT.setSpacingBefore(50);
        SimpleDateFormat formater1 = null;
        Date aujourdhui = new Date();
        formater1 = new SimpleDateFormat(" MM-yyyy ");
        Paragraph T1= new Paragraph("N°"+formater1.format(aujourdhui), F1);
        T1.setAlignment(Paragraph.ALIGN_CENTER);
        T1.setSpacingBefore(5);
        // le premiere  table
        PdfPTable table2 = new PdfPTable(5);
        table2.setWidthPercentage(100f);
        table2.setWidths(new float[] {5f,3f,3f,3f,3f});
        table2.setSpacingBefore(10);
        PdfPTable table3 = new PdfPTable(2);
        table3.setWidthPercentage(100f);
        table3.setWidths(new float[] {3.5f,3.5f});
        table3.setSpacingBefore(0);
        PdfPCell cell1 = new PdfPCell();
        cell1.setPhrase(new Phrase("DATE", font));
        table3.addCell(cell1);
        cell1.setPhrase(new Phrase("NUMERO", font));
        table3.addCell(cell1);
        table3.addCell("...............");
        table3.addCell("...............");
        cell1.setBackgroundColor(Color.WHITE);
        cell1.setPadding(5);
        FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);
        cell1.setPhrase(new Phrase("Marché/BC", font));
        table2.addCell(cell1);
        cell1.setPhrase(new Phrase("NOM DU FOURNISSEUR", font));
        table2.addCell(cell1);
        cell1.setPhrase(new Phrase("N° BON DE LIVRAISON", font));
        table2.addCell(cell1);
        cell1.setPhrase(new Phrase("N° FACTURE", font));
        table2.addCell(cell1);
        cell1.setPhrase(new Phrase("DATE DE RECEPTION ", font));
        table2.addCell(cell1);
        table2.addCell(table3);
        table2.addCell(fournisseurMatiereDtos.get(0).getFournisseurIce());
        table2.addCell("----------------");
        table2.addCell("...............");
        table2.addCell(""+formater1.format(aujourdhui));
        //table des transaction
        PdfPTable table = new PdfPTable(6);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.5f,3f,6f,3f,3f,3f});
        table.setSpacingBefore(10);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);
        FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);
        cell.setPhrase(new Phrase("Code", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("N°", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("DESIGNATION", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("U", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("QUANTITE LIVRE", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("PU/HT", font));
        table.addCell(cell);
        int i =1;
        for(FournisseurMatiereDto f : fournisseurMatiereDtos){

            table.addCell(f.getArticleCode());
            table.addCell(""+i);
            table.addCell(f.getArticleDesignation());
            table.addCell(f.getUnite());
            table.addCell(""+f.getQuantiteLivre());
            table.addCell(""+f.getPuHt());
            i++;
        }
        PdfPTable table1 = new PdfPTable(1);
        table1.setWidthPercentage(100f);
        table1.setSpacingBefore(0);
        table1.addCell("Lieu d'affectation : "+fournisseurMatiereDtos.get(0).getLieuAffectation());
        //le derniere table
        PdfPTable table4 = new PdfPTable(2);
        table4.setWidthPercentage(100f);
        table4.setWidths(new float[] {2f,6f});
        table4.setSpacingBefore(10);
        PdfPTable table5 = new PdfPTable(2);
        table5.setWidthPercentage(100f);
        table5.setWidths(new float[] {3f,3f});
        table5.setSpacingBefore(0);
        PdfPCell cell2 = new PdfPCell();
        cell2.setPhrase(new Phrase("RECEPTION QUANTITE", font));
        table5.addCell(cell2);
        cell2.setPhrase(new Phrase("RECEPTION QUALITE", font));
        table5.addCell(cell2);
        table5.addCell("....................");
        table5.addCell("....................");
        table5.addCell("SERRAY");
        table5.addCell("KHALFAOUI");
        table5.addCell("....................");
        table5.addCell("....................");
        table3.addCell(cell1);
        table4.addCell("\n            VISAS    \n\n");
        table4.addCell(table5);
        document.add(TT);
        document.add(T1);
        document.add(table2);
        document.add(table);
        document.add(table1);
        document.add(table4);
        document.close();
    }
}
