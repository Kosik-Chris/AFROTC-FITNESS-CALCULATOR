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
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import static org.apache.poi.sl.draw.binding.STRectAlignment.CTR;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;
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
    private String date, topFailedExercise;
    
    WordDocGenerator(int fails,int pass, double avgScore,double avgPScore,
     double avgSScore, double avgRScore, double avgWScore, double stdDevScore,
     double stdDevPScore, double stdDevSScore, double stdDevRScore,double stdDevWScore,
     double avg100Score, double avg200Score, double avg250Score, double avg300Score,
     double avg400Score, double avg450Score, double avg700Score, double avg800Score,
     ArrayList<Cadet> cadets,String topFailedExercise){
        this.numFails = fails;
        this.numPass = pass;
        this.avgScore = Math.round(avgScore*100.0)/100.0;
        this.avgPScore = Math.round(avgPScore*100.0)/100.0;
        this.avgSScore = Math.round(avgSScore*100.0)/100.0;
        this.avgRScore = Math.round(avgRScore*100.0)/100.0;
        this.avgWScore = Math.round(avgWScore*100.0)/100.0;
        this.stdDevScore = Math.round(stdDevScore*100.0)/100.0;
        this.stdDevPScore = Math.round(stdDevPScore*100.0)/100.0;
        this.stdDevSScore = Math.round(stdDevSScore*100.0)/100.0;
        this.stdDevRScore = Math.round(stdDevRScore*100.0)/100.0;
        this.stdDevWScore = Math.round(stdDevWScore*100.0)/100.0;
        this.avg100Score = Math.round(avg100Score*100.0)/100.0;
        this.avg200Score = Math.round(avg200Score*100.0)/100.0;
        this.avg250Score = Math.round(avg250Score*100.0)/100.0;
        this.avg300Score = Math.round(avg300Score*100.0)/100.0;
        this.avg400Score = Math.round(avg400Score*100.0)/100.0;
        this.avg450Score = Math.round(avg450Score*100.0)/100.0;
        this.avg700Score = Math.round(avg700Score*100.0)/100.0;
        this.avg800Score = Math.round(avg800Score*100.0)/100.0;
        this.cadets = cadets;
        this.topFailedExercise = topFailedExercise;
    }
    
    public void getDate(){
        date = JOptionPane.showInputDialog("Please enter the date of the Fitness Assesment");
    }

    public void createWord(List<String> lines) throws IOException, InvalidFormatException {
        getDate();
        createCharts();
        for (String line : lines) {
            //Blank Document
            MainMenu main = new MainMenu();
        //main.failVsPassChart();
        File file = new File("AFROTC FA Statistics.docx");
            XWPFDocument document = new XWPFDocument();
            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
            XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document,
                    sectPr);
            //Write the Document in file system
            FileOutputStream out = new FileOutputStream(file);
            //Header
            CTP ctpHeader = CTP.Factory.newInstance();
	        CTR ctrHeader = ctpHeader.addNewR();
		CTText ctHeader = ctrHeader.addNewT();
		String headerText = "AFROTC FA Statistics for Date: "+date;
		ctHeader.setStringValue(headerText);	
		XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
	        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
	        parsHeader[0] = headerParagraph;
	        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
            //Footer
            CTP ctpFooter = CTP.Factory.newInstance();
                CTR ctrFooter = ctpFooter.addNewR();
                CTText ctFooter = ctrFooter.addNewT();
                LocalDate date = java.time.LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
                String footText =  date.format(formatter);
                ctFooter.setStringValue("Date report generated on: "+footText);
                XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter,document);
                XWPFParagraph[] parsFooter = new XWPFParagraph[1];
                parsFooter[0] = footerParagraph;
                policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT,parsFooter);
            
            //Main body
            XWPFParagraph paragraph = document.createParagraph();
            paragraph.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun run = paragraph.createRun();
            run.setFontSize(24);
            run.setBold(true);
            run.setText("AFROTC FA Statistics report");
            XWPFParagraph paragraph2 = document.createParagraph();
            paragraph2.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun run2 = paragraph2.createRun();
            run2.setFontSize(12);
            run2.setText("Average FA score: "+avgScore);
            run2.addBreak();
            run2.setText("Number of failing scores: "+numFails);
            run2.addBreak();
            run2.setText("Number of passing scores: "+numPass);
            run2.addBreak();
            run2.setText(topFailedExercise);
            XWPFParagraph paragraph3 = document.createParagraph();
            XWPFRun run3 = paragraph3.createRun();
            InputStream pic1 = new FileInputStream("Pass vs. Fail chart.jpeg");
            InputStream pic2 = new FileInputStream("Average score by AS Year.jpeg");
            InputStream pic3 = new FileInputStream("Average score by school.jpeg");
            run3.addPicture(pic1, XWPFDocument.PICTURE_TYPE_JPEG,
                    "Pass vs. Fail chart.jpeg",Units.toEMU(300),Units.toEMU(250));
            run3.addPicture(pic2,XWPFDocument.PICTURE_TYPE_JPEG,
                    "Average score by AS Year.jpeg",Units.toEMU(300),Units.toEMU(250));
            run3.addPicture(pic3,XWPFDocument.PICTURE_TYPE_JPEG,
                    "Average score by school.jpeg",Units.toEMU(300),Units.toEMU(250));
            document.write(out);
            out.close();
            if(Desktop.isDesktopSupported() == true){
                Desktop.getDesktop().print(file);
                }
            else{
            JOptionPane.showMessageDialog(null,"Output not supported by your"
                    + " Desktop.\n"
                    + "Check security settings.");
                }
            System.out.println("\nDOCX CREATED");
        }
    }
    
    public void createCharts() throws IOException{
            failVsPassChart();
            avgScoreByYearChart();
            avgScoreBySchoolChart();
    }
    
    public void failVsPassChart() throws FileNotFoundException, IOException{
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Passing cadets", numPass);
        pieDataset.setValue("Failing cadets", numFails);
        JFreeChart chart = ChartFactory.createPieChart("Pass vs. Fail chart.jpeg",
                pieDataset, true, true, true);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
        String home = System.getProperty("user.home");
        try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File chart1 = new File("Pass vs. Fail chart.jpeg");
           ChartUtilities.saveChartAsPNG(chart1, chart, 600, 400, info);
        }
        catch(Exception e){
            
        }
    
}
    
    public void avgScoreByYearChart() throws FileNotFoundException, IOException{
        
        DefaultCategoryDataset barData = new DefaultCategoryDataset();
        barData.addValue(avg100Score, "100", "GMC Score");
        barData.addValue(avg200Score, "200", "GMC Score");
        barData.addValue(avg250Score,"250","GMC Score");
        barData.addValue(avg300Score,"300","POC Score");
        barData.addValue(avg400Score,"400","POC Score");
        barData.addValue(avg450Score,"450","POC Score");
        barData.addValue(avg700Score,"700","POC Score");
        barData.addValue(avg800Score,"800","POC Score");
        JFreeChart barChart = ChartFactory.createBarChart(
         "Average score by AS Year", "AS Year", "Average Score",barData);
        BarRenderer render = new BarRenderer();
        render.setPositiveItemLabelPositionFallback(new ItemLabelPosition(
        ItemLabelAnchor.CENTER,TextAnchor.CENTER));
         try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File chart1 = new File("Average score by AS Year.jpeg");
           ChartUtilities.saveChartAsPNG(chart1, barChart, 600, 400, info);
        }
        catch(Exception e){
            
        }
        
    }
    
    public void avgScoreBySchoolChart() throws FileNotFoundException, IOException{
        Calculation calc = new Calculation(cadets);
        DefaultCategoryDataset barData = new DefaultCategoryDataset();
        barData.addValue(calc.avgScoreBySchool("MSU"), "MSU", "MSU Score");
        barData.addValue(calc.avgScoreBySchool("WMU"), "WMU", "WMU Score");
        barData.addValue(calc.avgScoreBySchool("CMU"),"CMU","CMU Score");
        barData.addValue(calc.avgScoreBySchool("LCC"),"LCC","LCC Score");
        JFreeChart barChart = ChartFactory.createBarChart(
         "Average score by School", "School", "Average Score",barData);
        BarRenderer render = new BarRenderer();
        render.setPositiveItemLabelPositionFallback(new ItemLabelPosition(
        ItemLabelAnchor.CENTER,TextAnchor.CENTER));
         try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           File chart1 = new File("Average score by school.jpeg");
           ChartUtilities.saveChartAsPNG(chart1, barChart, 600, 400, info);
        }
        catch(Exception e){
            
        }
    }
    
    
}