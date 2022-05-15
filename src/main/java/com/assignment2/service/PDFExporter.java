package com.assignment2.service;

import com.assignment2.dtos.FoodDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * The type Pdf exporter.
 */
@Log4j2
@Service
public class PDFExporter {
    /**
     * Export menu pdf.
     *
     * @param restaurantName the restaurant name
     * @param adminName      the admin name
     * @param menu           the menu
     */
    public void exportMenuPDF(String restaurantName, String adminName, List<FoodDTO> menu) {
        Document document = new Document();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        try {
            PdfWriter.getInstance(document, new FileOutputStream("reports/report" + restaurantName + ".pdf"));
            document.open();
            document.add(new Paragraph(restaurantName+"\n",font));
            document.add(new Paragraph(adminName+"\n",font));
            document.add(makeTable(menu));
        } catch (DocumentException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            document.close();
        }
        log.info("Menu PDF "+restaurantName+".pdf written in reports directory.");
    }

    private PdfPTable makeTable(List<FoodDTO> menu) {
        PdfPTable table = new PdfPTable(4);
        List<String> tableHeaders = Arrays.stream(FoodDTO.class.getFields()).map(Field::getName).toList();
        setHeaders(tableHeaders, table);
        addFoodRows(table, menu);
        return table;
    }

    private void setHeaders(List<String> headers, PdfPTable table) {
        headers.forEach(h -> {
            PdfPCell header = new PdfPCell();
            header.setPhrase(new Phrase(h));
            table.addCell(header);
        });
    }

    private void addFoodRows(PdfPTable table, List<FoodDTO> menu) {
        menu.forEach(item -> {
            table.addCell(item.getName());
            table.addCell(item.getCategory().getLabel());
            table.addCell(item.getDescription());
            table.addCell((String.valueOf(item.getPrice())));
        });
    }
}
