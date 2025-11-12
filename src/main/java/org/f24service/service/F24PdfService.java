package org.f24service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.f24.dto.form.F24Simplified;
import org.f24.service.pdf.PDFCreator;
import org.f24.service.pdf.PDFCreatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.f24.service.validator.ValidatorFactory;
import org.springframework.stereotype.Service;

@Service
public class F24PdfService {

    private final ObjectMapper mapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(F24PdfService.class);

    public byte[] generatePdf(String jsonString) throws Exception {
        try {
            F24Simplified f24Simplified = mapper.readValue(jsonString, F24Simplified.class);
            org.f24.service.validator.Validator validator = ValidatorFactory.createValidator(f24Simplified);
            validator.validate();
            PDFCreator creator = PDFCreatorFactory.createPDFCreator(f24Simplified);
            byte[] pdfBytes = creator.createPDF();

            if (pdfBytes == null || pdfBytes.length == 0) {
                logger.warn("La generazione del PDF ha prodotto un risultato nullo o vuoto.");
                throw new Exception("La generazione del PDF ha prodotto un risultato nullo o vuoto.");
            }
            return pdfBytes;
        } catch (Exception e) {
            logger.error("Errore durante la generazione del PDF F24", e);
            throw e; // Rilancia l'eccezione originale per mantenere la stack trace completa
        }
    }
}
