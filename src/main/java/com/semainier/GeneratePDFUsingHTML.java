package com.semainier;

import java.io.*;
import com.itextpdf.html2pdf.HtmlConverter;

public class GeneratePDFUsingHTML {
    public static void main(String[] args) throws IOException {
        HtmlConverter.convertToPdf(new File("/Users/lucas/Documents/GitHub/semainier/src/main/resources/templates/report.html"),new File("demo-html.pdf"));
    }
}
