/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;
import java.awt.Desktop;
import java.io.DataInputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
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
    private double avg100Score,avg200Score,avg250Score,avg300Score,avg400Score,
            avg450Score,avg700Score,avg800Score;
    private ArrayList<Cadet> cadets;
    
    WordDocGenerator(int fails,int pass, double avgScore,double avgPScore,
     double avgSScore, double avgRScore, double avgWScore, double stdDevScore,
     double stdDevPScore, double stdDevSScore, double stdDevRScore,double stdDevWScore,
     double avg100Score, double avg200Score, double avg250Score, double avg300Score,
     double avg400Score, double avg450Score, double avg700Score, double avg800Score,
     ArrayList<Cadet> cadets){
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
        this.avg100Score = avg100Score;
        this.avg200Score = avg200Score;
        this.avg250Score = avg250Score;
        this.avg300Score = avg300Score;
        this.avg400Score = avg400Score;
        this.avg450Score = avg450Score;
        this.avg700Score = avg700Score;
        this.avg800Score = avg800Score;
        this.cadets = cadets;
    }

    public void createWord(List<String> lines) throws IOException, InvalidFormatException {
        for (String line : lines) {
            //Blank Document
            MainMenu main = new MainMenu();
        //main.failVsPassChart();
            XWPFDocument document = new XWPFDocument();
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
            XWPFParagraph paragraph3 = document.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            failVsPassChart();
            avgScoreByYearChart();
            avgScoreBySchoolChart();
            //Add picture that is created and stored from the chart methods
            //run3.addPicture(pictureData, numFails, line, numPass, numPass)
            //Close document
            out.close();
            System.out.println("\nDOCX CREATED");
        }
    }
    
    public void failVsPassChart() throws FileNotFoundException, IOException{
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Passing cadets", numPass);
        pieDataset.setValue("Failing cadets", numFails);
        JFreeChart chart = ChartFactory.createPieChart("Cadets passing vs. failing",
                pieDataset, true, true, true);
        PiePlot plot = (PiePlot) chart.getPlot();
        try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File chart1 = new File("Pass vs. Fail chart.png");
           ChartUtilities.saveChartAsPNG(chart1, chart, 600, 400, info);
        }
        catch(Exception e){
            
        }
    
}
    
    public void avgScoreByYearChart() throws FileNotFoundException, IOException{
        
        DefaultCategoryDataset barData = new DefaultCategoryDataset();
        barData.addValue(avg100Score, "100", "score");
        barData.addValue(avg200Score, "200", "score");
        barData.addValue(avg250Score,"250","score");
        barData.addValue(avg300Score,"300","score");
        barData.addValue(avg400Score,"400","score");
        barData.addValue(avg450Score,"450","score");
        barData.addValue(avg700Score,"700","score");
        barData.addValue(avg800Score,"800","score");
        JFreeChart barChart = ChartFactory.createBarChart(
         "Average score by AS Year", "AS Year", "Average Score",barData);          
         try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File chart1 = new File("Average score by AS Year.png");
           ChartUtilities.saveChartAsPNG(chart1, barChart, 600, 400, info);
        }
        catch(Exception e){
            
        }
        
    }
    
    public void avgScoreBySchoolChart() throws FileNotFoundException, IOException{
        Calculation calc = new Calculation(cadets);
        DefaultCategoryDataset barData = new DefaultCategoryDataset();
        barData.addValue(calc.avgScoreBySchool("MSU"), "MSU", "score");
        barData.addValue(calc.avgScoreBySchool("WMU"), "WMU", "score");
        barData.addValue(calc.avgScoreBySchool("CMU"),"CMU","score");
        barData.addValue(calc.avgScoreBySchool("LCC"),"LCC","score");
        JFreeChart barChart = ChartFactory.createBarChart(
         "Average score by School", "School", "Average Score",barData);          
         try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File chart1 = new File("Average score by school.png");
           ChartUtilities.saveChartAsPNG(chart1, barChart, 600, 400, info);
        }
        catch(Exception e){
            
        }
    }
    
    
}