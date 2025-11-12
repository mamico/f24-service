package org.f24service.controller;

import org.f24service.service.F24PdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/f24")
public class F24Controller {

    private final F24PdfService pdfService;

    public F24Controller(F24PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @PostMapping(
        value = "/pdf",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_PDF_VALUE
    )
    public ResponseEntity<byte[]> createPdf(@RequestBody String jsonBody) throws Exception {
        byte[] pdfBytes = pdfService.generatePdf(jsonBody);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=f24.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
