/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadet.Spartan.Warrior.holder;

import Cadet.Spartan.Warrior.holder.CadetClasses.*;
import Cadet.Spartan.Warrior.holder.CadetClasses.HostStats;
import Cadet.Spartan.Warrior.holder.CadetClasses.FemalesStats;
import Cadet.Spartan.Warrior.holder.CadetClasses.CrosstownStats;
import Cadet.Spartan.Warrior.holder.CadetClasses.MalesStats;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author Christopher
 */
public class ChartGeneration {
    
    DecimalFormat df = new DecimalFormat("#.##");
    
    private JTable avgScoresTable;
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
            averageScoresTable();
            totalAverageScoresTable();
            averageScoresPerComponentTableF();
            averageScoresPerComponentTableM();
            averageRepsAndTimeTable();
            situpsTableM();
            situpsTableF();
            pushupsTableM();
            pushupsTableF();
            runTableF();
            runTableM();
            situpsChart();
            pushupsChart();
            runChart();
    }
    
    private void averageScoresTable() throws IOException{
        BaseCalc calc = new BaseCalc(cadets);
    try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
            System.out.println("Defaults used");
        }
        AS100Stats as100 = new AS100Stats(cadets);
        AS200Stats as200 = new AS200Stats(cadets);
        AS250Stats as250 = new AS250Stats(cadets);
        AS300Stats as300 = new AS300Stats(cadets);
        AS400Stats as400 = new AS400Stats(cadets);
        AS450Stats as450 = new AS450Stats(cadets);
        AS700Stats as700 = new AS700Stats(cadets);
        AS800Stats as800 = new AS800Stats(cadets);
        MalesStats male = new MalesStats(cadets);
        FemalesStats female = new FemalesStats(cadets);
        HostStats host = new HostStats(cadets);
        CrosstownStats cross = new CrosstownStats(cadets);
        
        as100.number100s();
        as200.number200s();
        as250.number250s();
        as300.number300s();
        as400.number400s();
        as450.number450s();
        as700.number700s();
        as800.number800s();
        male.numberMaless();
        female.numberFemaless();
        host.numberHosts();
        cross.numberCross();
        
        Object[][] data = {
            {"AS100",Math.round(as100.averageSitupScore()*100.0)/100.0,
                as100.averagePushupScore(),
                Math.round(as100.averageRunScore()*100.0)/100.0,
                Math.round(as100.averageAbScore()*100.0)/100.0},
            {"AS200", Math.round(as200.averageSitupScore()*100.0)/100.0,
                Math.round(as200.averagePushupScore()*100.0)/100.0,
                Math.round(as200.averageRunScore()*100.0)/100.0,
                Math.round(as200.averageAbScore()*100.0)/100.0},
            {"AS250", Math.round(as250.averageSitupScore()*100.0)/100.0,
                Math.round(as250.averagePushupScore()*100.0)/100.0,
                Math.round(as250.averageRunScore()*100.0)/100.0,
                Math.round(as250.averageAbScore()*100.0)/100.0},
            {"AS300", Math.round(as300.averageSitupScore()*100.0)/100.0,
                Math.round(as300.averagePushupScore()*100.0)/100.0,
                Math.round(as300.averageRunScore()*100.0)/100.0,
                Math.round(as300.averageAbScore()*100.0)/100.0},
            {"AS400", Math.round(as400.averageSitupScore()*100.0)/100.0,
                Math.round(as400.averagePushupScore()*100.0)/100.0,
                Math.round(as400.averageRunScore()*100.0)/100.0,
                Math.round(as400.averageAbScore()*100.0)/100.0},
            {"AS450", Math.round(as450.averageSitupScore()*100.0)/100.0,
                Math.round(as450.averagePushupScore()*100.0)/100.0,
                Math.round(as450.averageRunScore()*100.0)/100.0,
                Math.round(as450.averageAbScore()*100.0)/100.0},
            {"AS700", Math.round(as700.averageSitupScore()*100.0)/100.0,
                Math.round(as700.averagePushupScore()*100.0)/100.0,
                Math.round(as700.averageRunScore()*100.0)/100.0,
                Math.round(as700.averageAbScore()*100.0)/100.0},
            {"AS800",Math.round(as800.averageSitupScore()*100.0)/100.0,
                Math.round(as800.averagePushupScore()*100.0)/100.0,
                Math.round(as800.averageRunScore()*100.0)/100.0,
                Math.round(as800.averageAbScore()*100.0)/100.0},
            {"GMC", Math.round(calc.gmcSitupAverageScore()*100.0)/100.0,
                Math.round(calc.gmcPushupAverageScore()*100.0)/100.0,
                Math.round(calc.gmcRunAverageScore()*100.0)/100.0,
                Math.round(calc.gmcAbAverageScore()*100.0)/100.0},
            {"POC", Math.round(calc.pocSitupAverageScore()*100.0)/100.0,
                Math.round(calc.pocPushupAverageScore()*100.0)/100.0,
                Math.round(calc.pocRunAverageScore()*100.0)/100.0,
                Math.round(calc.pocAbAverageScore()*100.0)/100.0},
            {"Males",Math.round(male.averageSitupScore()*100.0)/100.0,
                Math.round(male.averagePushupScore()*100.0)/100.0,
                Math.round(male.averageRunScore()*100.0)/100.0,
                Math.round(male.averageAbScore()*100.0)/100.0},
            {"Females",Math.round(female.averageSitupScore()*100.0)/100.0,
                Math.round(female.averagePushupScore()*100.0)/100.0,
                Math.round(female.averageRunScore()*100.0)/100.0,
                Math.round(female.averageAbScore()*100.0)/100.0},
            {"Host",Math.round(host.averageSitScore()*100.0)/100.0,
                Math.round(host.averagePushupScore()*100.0)/100.0,
                Math.round(host.averageRunScore()*100.0)/100.0,
            Math.round(host.averageAbScore()*100.0)/100.0},
            {"Crosstown",Math.round(cross.averageSitScore()*100.0)/100.0,
                Math.round(cross.averagePushupScore()*100.0)/100.0,
                Math.round(cross.averageRunScore()*100.0)/100.0,
            Math.round(cross.averageAbScore()*100.0)/100.0},
            {"All", Math.round(calc.averageSScore()*100.0)/100.0,
                Math.round(calc.averagePScore()*100.0)/100.0,
                Math.round(calc.averageRScore()*100.0)/100.0,
                Math.round(calc.averageWScore()*100.0)/100.0},
        };
        String[] columns = {"Category", "Sit-Up", "Push-Up", "Run","Ab"};

        JPanel p = new JPanel();
            p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Average Scores",
                TitledBorder.CENTER,
                TitledBorder.TOP));
            
        JTable table = new JTable(data, columns);
            
        p.add(new JScrollPane(table));

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.add(p);
        f.pack();
        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );
        Graphics g = bi.createGraphics();

        h.paint(g);

        g.translate(0,h.getHeight());

        table.paint(g);

        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop"
                + "\\Special Programs\\AFROTC Fitness Calculator\\src\\"
                + "resources\\tables\\Average Scores Table.jpeg"));
    }
    
    private void totalAverageScoresTable() throws IOException{
       try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }
        BaseCalc calc = new BaseCalc(cadets);
        HostStats host = new HostStats(cadets);
        CrosstownStats cross = new CrosstownStats(cadets);
        host.numberHosts();
        cross.numberCross();
        Object[][] data = {
            {"AS100", Math.round(avg100Score*100.0)/100.0},
            {"AS200", Math.round(avg200Score*100.0)/100.0},
            {"AS250", Math.round(avg250Score*100.0)/100.0},
            {"AS300", Math.round(avg300Score*100.0)/100.0},
            {"AS400", Math.round(avg400Score*100.0)/100.0},
            {"AS450", Math.round(avg450Score*100.0)/100.0},
            {"AS700", Math.round(avg700Score*100.0)/100.0},
            {"AS800", Math.round(avg800Score*100.0)/100.0},
            {"GMC", Math.round(calc.gmcTotAverageScore()*100.0)/100.0},
            {"POC", Math.round(calc.pocTotAverageScore()*100.0)/100.0},
            {"Males", Math.round(calc.avgScoreBySexM()*100.0)/100.0},
            {"Females", Math.round(calc.avgScoreBySexF()*100.0)/100.0},
            {"Host", Math.round(host.averageScore()*100.0)/100.0},
            {"Crosstown", Math.round(cross.averageScore()*100.0)/100.0},
            {"All", Math.round(calc.averageScore()*100.0)/100.0},
        };
        String[] columns = {"Category","Total Averages"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources\\"
                + "tables\\Total Average Scores Table.jpeg"));
    }
    
    private void averageScoresPerComponentTableF() throws IOException{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }
        
        FemalesStats female = new FemalesStats(cadets);
        POCFemales pfemale = new POCFemales(cadets);
        GMCFemales gfemale = new GMCFemales(cadets);
        HostFemales hfemale = new HostFemales(cadets);
        CrossFemales cfemale = new CrossFemales(cadets);
        
        female.numberFemaless();
        pfemale.numberPOCFemales();
        gfemale.numberGMCFemales();
        hfemale.numberHostFemales();
        cfemale.numberCrossFemales();
        
        Object[][] data = {
            {"Females", Math.round(female.averageSitupScore()*100.0)/100.0,
                Math.round(female.averagePushupScore()*100.0)/100.0,
                Math.round(female.averageRunScore()*100.0)/100.0,
                Math.round(female.averageAbScore()*100.0)/100.0,
                Math.round(female.averageScore()*100.0)/100.0,
                female.getNumF()},
            {"POC Females",Math.round(pfemale.averageSitupScore()*100.0)/100.0,
                Math.round(pfemale.averagePushupScore()*100.0)/100.0,
                Math.round(pfemale.averageRunScore()*100.0)/100.0,
                Math.round(pfemale.averageAbScore()*100.0)/100.0,
                Math.round(pfemale.averageScore()*100.0)/100.0,
                Math.round(pfemale.getNumPFemales())},
            {"GMC Females",Math.round(gfemale.averageSitupScore()*100.0)/100.0,
                Math.round(gfemale.averagePushupScore()*100.0)/100.0,
                Math.round(gfemale.averageRunScore()*100.0)/100.0,
                Math.round(gfemale.averageAbScore()*100.0)/100.0,
                Math.round(gfemale.averageScore()*100.0)/100.0,
                Math.round(gfemale.getNumGMCF())},
            {"MSU Females", Math.round(hfemale.averageSitupScore()*100.0)/100.0,
                Math.round(hfemale.averagePushupScore()*100.0)/100.0,
                Math.round(hfemale.averageRunScore()*100.0)/100.0,
                Math.round(hfemale.averageAbScore()*100.0)/100.0,
                Math.round(hfemale.averageScore()*100.0)/100.0,
                Math.round(hfemale.getNumHostF())},
            {"Crosstown Females",Math.round(cfemale.averageSitupScore()*100.0)/100.0,
                Math.round(cfemale.averagePushupScore()*100.0)/100.0,
                Math.round(cfemale.averageRunScore()*100.0)/100.0,
                Math.round(cfemale.averageAbScore()*100.0)/100.0,
                Math.round(cfemale.averageScore()*100.0)/100.0,
                Math.round(cfemale.getNumCrossF())}
        };

        String[] columns = {"Category","Sit-Up","Push-Up","Run","Ab",
            "Total Averages","# of Cadets"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
                p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Average Scores Per Component Females",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame fr = new JFrame("Never shown");
        fr.setContentPane(scroll);
        fr.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources\\"
                + "tables\\Average Scores per Component Females"
                + " table.jpeg"));
    }
    
    private void averageScoresPerComponentTableM() throws IOException{
                try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }
        
        MalesStats male = new MalesStats(cadets);
        POCMales pmale = new POCMales(cadets);
        GMCMales gmale = new GMCMales(cadets);
        HostMales hmale = new HostMales(cadets);
        CrossMales cmale = new CrossMales(cadets);
        
        male.numberMaless();
        pmale.numberPOCMales();
        gmale.numberGMCMales();
        hmale.numberHostMales();
        cmale.numberCrossMales();
                
        Object[][] data = {
            {"Males",Math.round(male.averageSitupScore()*100.0)/100.0,
                Math.round(male.averagePushupScore()*100.0)/100.0,
                Math.round(male.averageRunScore()*100.0)/100.0,
                Math.round(male.averageAbScore()*100.0)/100.0,
                Math.round(male.averageScore()*100.0)/100.0,
                male.getNumMale()},
            {"POC Males",Math.round(pmale.averageSitupScore()*100.0)/100.0,
                Math.round(pmale.averagePushupScore()*100.0)/100.0,
                Math.round(pmale.averageRunScore()*100.0)/100.0,
                Math.round(pmale.averageAbScore()*100.0)/100.0,
                Math.round(pmale.averageScore()*100.0)/100.0,
                pmale.getNumPOCM()},
            {"GMC Males",Math.round(gmale.averageSitupScore()*100.0)/100.0,
                Math.round(gmale.averagePushupScore()*100.0)/100.0,
                Math.round(gmale.averageRunScore()*100.0)/100.0,
                Math.round(gmale.averageAbScore()*100.0)/100.0,
                Math.round(gmale.averageScore()*100.0)/100.0,
                gmale.getNumGMCM()},
            {"MSU Males",Math.round(hmale.averageSitupScore()*100.0)/100.0,
                Math.round(hmale.averagePushupScore()*100.0)/100.0,
                Math.round(hmale.averageRunScore()*100.0)/100.0,
                Math.round(hmale.averageAbScore()*100.0)/100.0,
                Math.round(hmale.averageScore()*100.0)/100.0,
                hmale.getNumHostM()},
            {"Crosstown Males",Math.round(cmale.averageSitupScore()*100.0)/100.0,
                Math.round(cmale.averagePushupScore()*100.0)/100.0,
                Math.round(cmale.averageRunScore()*100.0)/100.0,
                Math.round(cmale.averageAbScore()*100.0)/100.0,
                Math.round(cmale.averageScore()*100.0)/100.0,
                Math.round(cmale.getNumCrossM())}
        };

        String[] columns = {"Category","Sit-Up","Push-Up","Run","Ab",
            "Total Averages","# of Cadets"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
                p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Average Points Per Component Males",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources\\"
                + "tables\\Average Scores per Component "
                + "Males table.jpeg"));
    }
    
    private void averageRepsAndTimeTable() throws IOException{
     try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }
        
     MalesStats male = new MalesStats(cadets);
     FemalesStats female = new FemalesStats(cadets);
     HostMales hmale = new HostMales(cadets);
     HostFemales hfemale = new HostFemales(cadets);
     
     male.numberMaless();
     female.numberFemaless();
     hmale.numberHostMales();
     

        Object[][] data = {
            {"Males",male.averageSitRep(),male.averagePushRep(),male.averageRunTime(),
            male.averageAbSize(),male.getNumMale()},
            {"Females",female.averageSitRep(),female.averagePushRep(),female.averageRunTime(),
            female.averageAbSize(),female.getNumF()},
            {"Host Males",hmale.averageSitRep(),hmale.averagePushRep(),hmale.averageRunTime(),
            hmale.averageAbSize(),hmale.getNumHostM()},
            {"Host Females", new Integer(22), new Double(84.81), new Boolean(true),
            new Integer(23),new Integer(23)},
            {"Crosstown Males", new Integer(22), new Double(84.81), new Boolean(true),
            new Integer(23),new Integer(23)},
            {"Crosstown Females", new Integer(22), new Double(84.81), new Boolean(true),
            new Integer(23),new Integer(23)},
            {"POC Males", new Integer(22), new Double(84.81), new Boolean(true),
            new Integer(23),new Integer(23)},
            {"GMC Males", new Integer(22), new Double(84.81), new Boolean(true),
            new Integer(23),new Integer(23)},
            {"POC Females", new Integer(22), new Double(84.81), new Boolean(true),
            new Integer(23),new Integer(23)},
            {"GMC Females", new Integer(22), new Double(84.81), new Boolean(true),
            new Integer(23),new Integer(23)}
        };

        String[] columns = {"Category", "Sit-Up", "Push-Up", "Run","Ab",
            "# of Cadets"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
                p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Average Repetitions/Time",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources"
                + "\\tables\\Average Repetitions and Time table.jpeg"));   
    }
    
    private void situpsChart(){
        double[] numSitups = new double[cadets.size()];
        for(int i = 0; i< cadets.size(); i++){
            numSitups[i] = cadets.get(i).getNumSitUps();
        }
        
        HistogramDataset sitData = new HistogramDataset();
        sitData.setType(HistogramType.FREQUENCY);
        
        sitData.addSeries("Sit ups Histogram", numSitups, cadets.size());
        
        JFreeChart sitChart = ChartFactory.createHistogram("Sit ups Histogram"
                , "Repetitions", "Frequency", sitData, PlotOrientation.VERTICAL,
                true, true, true);
        try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File chart1 = new File("C:\\Users\\Christopher\\Desktop\\"
                   + "Special Programs\\AFROTC Fitness Calculator\\src\\"
                   + "resources\\charts\\situp frequency chart.jpeg");
           ChartUtilities.saveChartAsPNG(chart1, sitChart, 600, 400, info);
        }
        catch(Exception e){
            
        }
    }
    
    private void situpsTableM() throws IOException{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }

        Object[][] data = {
            {"Median", new Integer(23)},
            {"Mean", new Integer(23)},
            {"Max", new Integer(22)},
            {"Min", new Integer(22)}
        };

        String[] columns = {"Statistics","Times"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Male Sit Up",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources\\"
                + "tables\\Situps table Male.jpeg")); 
    }
    
    private void situpsTableF() throws IOException{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }
        
        Object[][] data = {
            {"Median", new Integer(23)},
            {"Mean", new Integer(23)},
            {"Max", new Integer(22)},
            {"Min", new Integer(22)}
        };

        String[] columns = {"Statistics","Times"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Female Sit Up",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources"
                + "\\tables\\Situps table Female.jpeg"));
    }
    
    private void pushupsChart(){
        double[] numPushups = new double[cadets.size()];
        for(int i = 0; i< cadets.size(); i++){
            numPushups[i] = cadets.get(i).getNumPushUps();
        }
        
        HistogramDataset pushData = new HistogramDataset();
            pushData.setType(HistogramType.FREQUENCY);
            pushData.addSeries("Push ups Histogram", numPushups, cadets.size());
        
        JFreeChart pushChart = ChartFactory.createHistogram("Push ups Histogram"
                , "Repetitions", "Frequency", pushData, PlotOrientation.VERTICAL,
                true, true, true);
        try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File chart1 = new File("C:\\Users\\Christopher\\Desktop\\"
                   + "Special Programs\\AFROTC Fitness Calculator\\src\\"
                   + "resources\\charts\\pushup frequency chart.jpeg");
           ChartUtilities.saveChartAsPNG(chart1, pushChart, 600, 400, info);
        }
        catch(Exception e){

        }
    }
    
    private void pushupsTableF() throws IOException{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }

        Object[][] data = {
            {"Median", new Integer(23)},
            {"Mean", new Integer(23)},
            {"Max", new Integer(22)},
            {"Min", new Integer(22)}
        };

        String[] columns = {"Statistics","Times"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Female Push Up",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources"
                + "\\tables\\Pushups table Female.jpeg"));
    }
    
    private void pushupsTableM() throws IOException{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }

        Object[][] data = {
            {"Median", new Integer(23)},
            {"Mean", new Integer(23)},
            {"Max", new Integer(22)},
            {"Min", new Integer(22)}
        };

        String[] columns = {"Statistics","Times"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Male Push Up",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources"
                + "\\tables\\Pushups table Male.jpeg"));
    }
    
    private void runChart(){
      //WIll require extra work to display times in format
      //No easy way to accomplish so will switch statement into
      // multiple counters for each category?
      double eightThirty = 0;
      double eightFifty = 0;
      double nineTen = 0;
      double nineThirty = 0;
      double nineFifty = 0;
      double tenTen = 0;
      double tenThirty = 0;
      double tenFifty = 0;
      double elevenTen = 0;
      double elevenThirty = 0;
      double elevenFifty = 0;
      double twelveTen = 0;
      double twelveThirty = 0;
      double twelveFifty = 0;
      double thirteenTen = 0;
      double thirteenThirty = 0;
      double thirteenFifty = 0;
      double fourteenTen = 0;
      double fourteenThirty = 0;
      double fourteenFifty = 0;
      double fifteenTen = 0;
      double fifteenThirty = 0;
      double fifteenFifty = 0;
      double sixteenTen = 0;
      double sixteenThirty = 0;
      double sixteenFifty = 0;
      double seventeenTen = 0;
      double seventeenThirty = 0;
      
      for(int i =0; i < cadets.size(); i++){
          int runLength = cadets.get(i).getNumRunTime();
              if(runLength <= 510){
                  eightThirty++;
              }
              if(runLength> 510 & runLength <= 530){
                  eightFifty++;
              }
              if(runLength >530 & runLength <= 550){
                  nineTen++;
              }
              if(runLength >550 & runLength <= 570){
                  nineThirty++;
              }
              if(runLength >570 & runLength <=590){
                  nineFifty++;
              }
              if(runLength >590 & runLength <=610){
                  tenTen++;
              }
              if(runLength >610 & runLength <=630){
                  tenThirty++;
              }
              if(runLength >630 & runLength <=650){
                  tenFifty++;
              }
              if(runLength >650 & runLength <=670){
                  elevenTen++;
              }
              if(runLength >670 & runLength <=690){
                  elevenThirty++;
              }
              if(runLength >690 & runLength <=710){
                  elevenFifty++;
              }
              if(runLength >710 & runLength <=730){
                  twelveTen++;
              }
              if(runLength >730 & runLength <=750){
                  twelveThirty++;
              }
              if(runLength >750 & runLength <=770){
                  twelveFifty++;
              }
              if(runLength >770 & runLength <= 790){
                  thirteenTen++;
              }
              if(runLength >790 & runLength <=810){
                  thirteenThirty++;
              }
              if(runLength >810 & runLength <=830){
                  thirteenFifty++;
              }
              if(runLength >830 & runLength <=850){
                  fourteenTen++;
              }
              if(runLength >850 & runLength <= 870){
                  fourteenThirty++;
              }
              if(runLength >870 & runLength <=890){
                  fourteenFifty++;
              }
              if(runLength >890 & runLength <=910){
                  fifteenTen++;
              }
              if(runLength >910 & runLength <= 930){
                  fifteenThirty++;
              }
              if(runLength >930 & runLength <= 950){
                  fifteenFifty++;
              }
              if(runLength >950 & runLength <= 970){
                  sixteenTen++;
              }
              if(runLength >970 & runLength <=990){
                  sixteenThirty++;
              }
              if(runLength >990 & runLength <=1010){
                  sixteenFifty++;
              }
              if(runLength >1010 & runLength <=1030){
                  seventeenTen++;
              }
              if(runLength >1030 & runLength <= 1050){
                  seventeenThirty++;
              }
      }
      
      double[] runTimes = new double[28];
      runTimes[0] = eightThirty;
      runTimes[1] = eightFifty;
      runTimes[2] = nineTen;
      runTimes[3] = nineThirty;
      runTimes[4] = nineFifty;
      runTimes[5] = tenTen;
      runTimes[6] = tenThirty;
      runTimes[7] = tenFifty;
      runTimes[8] = elevenTen;
      runTimes[9] = elevenThirty;
      runTimes[10] = elevenFifty;
      runTimes[11] = twelveTen;
      runTimes[12] = twelveThirty;
      runTimes[13] = twelveFifty;
      runTimes[14] = thirteenTen;
      runTimes[15] = thirteenThirty;
      runTimes[16] = thirteenFifty;
      runTimes[17] = fourteenTen;
      runTimes[18] = fourteenThirty;
      runTimes[19] = fourteenFifty;
      runTimes[20] = fifteenTen;
      runTimes[21] = fifteenThirty;
      runTimes[22] = fifteenFifty;
      runTimes[23] = sixteenTen;
      runTimes[24] = sixteenThirty;
      runTimes[25] = sixteenFifty;
      runTimes[26] = seventeenTen;
      runTimes[27] = seventeenThirty;
//      double[] runTimes = {eightThirty,eightFifty,nineTen,
//      nineThirty,nineFifty,tenTen,tenThirty,tenFifty,elevenTen,elevenThirty,
//      elevenFifty,twelveTen,twelveThirty,twelveFifty,thirteenTen,thirteenThirty,
//      thirteenFifty,fourteenTen,fourteenThirty,fourteenFifty,fifteenTen,
//      fifteenthirty,fifteenTen,fifteenThirty,fifteenFifty,sixteenTen,
//      sixteenThirty,sixteenFifty,seventeenTen,seventeenThirty};
      
      
      for(int i = 0; i <runTimes.length;i++){
          System.out.println(runTimes[i]);
      }
      HistogramDataset runData = new HistogramDataset();
        runData.setType(HistogramType.FREQUENCY);               
        runData.addSeries("", runTimes, cadets.size()+1);
        
    JFreeChart runChart = ChartFactory.createHistogram("Run times Histogram"
                , "Run times", "Frequency", runData, PlotOrientation.VERTICAL,
                true, true, true);
        try{
           final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
           final File chart1 = new File("C:\\Users\\Christopher\\Desktop\\Special Programs\\"
                   + "AFROTC Fitness Calculator\\src\\"
                   + "charts\\runtime frequency chart.jpeg");
           ChartUtilities.saveChartAsPNG(chart1, runChart, 600, 400, info);
        }
        catch(Exception e){
            
        }    
    }
    
    private void runTableF() throws IOException{
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }

        Object[][] data = {
            {"Median", new Integer(23)},
            {"Mean", new Integer(23)},
            {"Max", new Integer(22)},
            {"Min", new Integer(22)}
        };

        String[] columns = {"Statistics","Times"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Female Run",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources"
                + "\\tables\\Run table Female.jpeg"));
    }
    
    private void runTableM() throws IOException{
              try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception useDefault) {
        }

        Object[][] data = {
            {"Median", new Integer(23)},
            {"Mean", new Integer(23)},
            {"Max", new Integer(22)},
            {"Min", new Integer(22)}
        };

        String[] columns = {"Statistics","Times"};

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);

        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "Male Run",
                TitledBorder.CENTER,
                TitledBorder.TOP));
        p.add(scroll,BorderLayout.CENTER);

        // JTable must have been added to a TLC in order to render
        // correctly - go figure.
        JFrame f = new JFrame("Never shown");
        f.setContentPane(scroll);
        f.pack();

        JTableHeader h = table.getTableHeader();
        Dimension dH = h.getSize();
        Dimension dT = table.getSize();
        int x = (int)dH.getWidth();
        int y = (int)dH.getHeight() + (int)dT.getHeight();

        scroll.setDoubleBuffered(false);

        BufferedImage bi = new BufferedImage(
            (int)x,
            (int)y,
            BufferedImage.TYPE_INT_RGB
            );

        Graphics g = bi.createGraphics();
        h.paint(g);
        g.translate(0,h.getHeight());
        table.paint(g);
        g.dispose();

        ImageIO.write(bi,"jpeg",new File("C:\\Users\\Christopher\\Desktop\\"
                + "Special Programs\\AFROTC Fitness Calculator\\src\\resources"
                + "\\tables\\Run table Male.jpeg"));  
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
           final File chart1 = new File("C:\\Users\\Christopher\\Desktop\\"
                   + "Special Programs\\AFROTC Fitness Calculator\\src\\"
                   + "resources\\charts\\Pass vs. Fail chart.jpeg");
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
           final File chart1 = new File("C:\\Users\\Christopher\\Desktop\\"
                   + "Special Programs\\AFROTC Fitness Calculator\\src\\"
                   + "resources\\charts\\Average score by AS Year.jpeg");
           ChartUtilities.saveChartAsPNG(chart1, barChart, 600, 400, info);
        }
        catch(Exception e){
            
        }
        
    }
    
    private void avgScoreBySchoolChart() throws FileNotFoundException, IOException{
        BaseCalc calc = new BaseCalc(cadets);
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
           File chart1 = new File("C:\\Users\\Christopher\\Desktop\\"
                   + "Special Programs\\AFROTC Fitness Calculator\\src\\"
                   + "resources\\charts\\Average score by school.jpeg");
           ChartUtilities.saveChartAsPNG(chart1, barChart, 600, 400, info);
        }
        catch(Exception e){
            
        }
    }
}
