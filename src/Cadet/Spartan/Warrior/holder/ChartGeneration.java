/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Christopher
 */
public class ChartGeneration {
    private final int numFails, numPass;
    private final double avgScore,avgPScore,avgSScore,avgRScore,avgWScore;
    private final double stdDevScore,stdDevPScore,stdDevSScore,stdDevRScore,stdDevWScore;
    private final double avg100Score,avg200Score,avg250Score,avg300Score,avg400Score,
            avg450Score,avg700Score,avg800Score;
    private final ArrayList<Cadet> cadets;
    private String date;
    private final String topFailedExercise;
    ChartGeneration(int fails,int pass, double avgScore,double avgPScore,
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
    /**
     * Method called to generate all graphs and tables into JPEG file type.
     * @throws IOException 
     */
    public void createCharts() throws IOException{
            failVsPassChart();
            avgScoreByYearChart();
            avgScoreBySchoolChart();
    }
    
    private void averageScoresTable(){
        
    }
    
    private void totalAverageScoresTable(){
        
    }
    
    private void averageScoresPerComponentTable(){
        
    }
    
    private void averageRepsAndTimeTable(){
        
    }
    
    private void situpsGraph(){
        
    }
    
    private void situpsTable(){
        
    }
    
    private void pushupsGraph(){
        
    }
    
    private void pushupsTable(){
        
    }
    
    private void runGraph(){
        
    }
    
    private void runTable(){
        
    }
    
    private void failVsPassChart() throws FileNotFoundException, IOException{
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Passing cadets", numPass);
        pieDataset.setValue("Failing cadets", numFails);
        JFreeChart chart = ChartFactory.createPieChart("Pass vs. Fail chart",
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
    
    private void avgScoreByYearChart() throws FileNotFoundException, IOException{
        
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
    
    private void avgScoreBySchoolChart() throws FileNotFoundException, IOException{
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
