/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Christopher
 */
public class WordDocGenerator {
    
    public void createWord(List<String> lines) throws IOException {
        for (String line : lines) {
            //Blank Document
            XWPFDocument document = new XWPFDocument();
            //Write the Document in file system
            FileOutputStream out = new FileOutputStream(
                    new File("AFROTC FA Statistics.docx"));
 
            //create Paragraph
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("VK Number (Parameter): " + line + " here you type your text...\n");
            document.write(out);
           
            //Close document
            out.close();
            System.out.println("createdWord" + "_" + line + ".docx" + " written successfully");
        }
    }
    
}
