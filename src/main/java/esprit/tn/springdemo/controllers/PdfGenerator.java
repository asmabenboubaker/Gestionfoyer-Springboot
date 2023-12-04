package esprit.tn.springdemo.controllers;


import com.lowagie.text.DocumentException;
import esprit.tn.springdemo.services.PDFGeneratorService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

@RequestMapping("")
public class PdfGenerator {
    private final PDFGeneratorService pdfGeneratorService;
    public PdfGenerator(PDFGeneratorService pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }
    @GetMapping("/export/pdf")
    public void exportToPDF(HttpServletResponse response) {
        try {
            response.setContentType("application/pdf");
            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
            String currentDateTime = dateFormatter.format(new Date());

            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=blocs" + currentDateTime + ".pdf";
            response.setHeader(headerKey, headerValue);

            this.pdfGeneratorService.export(response);
        } catch (IOException | DocumentException e) {
            e.printStackTrace(); // Log the exception or handle it appropriately
        }
    }

}
