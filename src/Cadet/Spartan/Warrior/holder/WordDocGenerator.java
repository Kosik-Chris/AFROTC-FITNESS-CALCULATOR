/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;
import java.io.DataInputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import static org.apache.poi.sl.draw.binding.STRectAlignment.CTR;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import static org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment.CTR;
import static org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
/**
 *
 * @author Christopher
 */
public class WordDocGenerator {
    private int numFails, numPass;
    private double avgScore,avgPScore,avgSScore,avgRScore,avgWScore;
    private double stdDevScore,stdDevPScore,stdDevSScore,stdDevRScore,stdDevWScore;
    
    WordDocGenerator(int fails,int pass, double avgScore,double avgPScore,
     double avgSScore, double avgRScore, double avgWScore, double stdDevScore,
     double stdDevPScore, double stdDevSScore, double stdDevRScore,double stdDevWScore){
        this.numFails = fails;
        this.numPass = pass;
        this.avgScore = avgScore;
        this.avgPScore = avgPScore;
        this.avgSScore = avgSScore;
        this.avgRScore = avgRScore;
        this.avgWScore = avgWScore;
        this.stdDevScore = stdDevScore;
        this.stdDevPScore = stdDevPScore;
        this.stdDevSScore = stdDevSScore;
        this.stdDevRScore = stdDevRScore;
        this.stdDevWScore = stdDevWScore;
    }

    public void createWord(List<String> lines) throws IOException, InvalidFormatException {
        for (String line : lines) {
            //Blank Document
            MainMenu main = new MainMenu();
        File f = new File("\"C:\\Users\\Christopher\\Desktop\\Special Programs"
                        + "\\AFROTC Fitness Calculator\\src\\resources"
                        + "\\charts\"");
        DataInputStream chart1 = new DataInputStream(new FileInputStream(f));
        main.failVsPassChart();
            XWPFDocument document = new XWPFDocument();
            document.addPictureData(chart1,document.PICTURE_TYPE_JPEG);
            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document,
                    sectPr);
            //Write the Document in file system
            FileOutputStream out = new FileOutputStream(
                    new File("AFROTC FA Statistics.docx"));
            //Header
            CTP ctpHeader = CTP.Factory.newInstance();
	        CTR ctrHeader = ctpHeader.addNewR();
		CTText ctHeader = ctrHeader.addNewT();
		String headerText = "AFROTC FA Statistics for Date: XXX";
		ctHeader.setStringValue(headerText);	
		XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
	        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
	        parsHeader[0] = headerParagraph;
	        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
            //Main body
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Statistics!" + line + " I sure hope?\r\n"
                    + "Number Fails are: "+numFails+"\r\n"
                    + "Number passes are: "+numPass+"\r\n"
                    + "Average Score was: "+avgScore+" with a"
                            + "standard deviation of: "+stdDevScore+
                      "\r\n"
                    + "Average Push up Score was: "+avgPScore+" with"
                            + " a standard deviation of: "+stdDevPScore+
                    "\r\n"
                    + "Average Sit up Score was: "+avgSScore+" with "
                            + "a standard deviation of: "+ stdDevSScore+
                    "\r\n"
                    + "Average Run Score was: "+avgRScore+" with "
                            + "a standard deviation of: "+stdDevRScore+
                    "\r\n"
                    + "Average Waist Score was: "+avgWScore+" with "
                            + "a standard deviation of: "+stdDevWScore);
            XWPFParagraph paragraph2 = document.createParagraph();
            XWPFRun run2 = paragraph2.createRun();
            run2.setBold(true);
            run2.setText("hello?");
            document.write(out);
           
            //Close document
            out.close();
        }
    }
    
}
