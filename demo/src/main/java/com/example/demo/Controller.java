package com.example.demo;



import com.almasb.fxgl.entity.action.Action;
import com.example.demo.benchmark.BenchmarkRunner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import oshi.*;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Display;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class Controller implements Initializable {



    @FXML
    private Button ABOUT;

    @FXML
    private Button Bench;

    @FXML
    private Button CINFO;

    @FXML
    private Button HSTR;

    @FXML
    private CheckBox btnDhry;

    @FXML
    private CheckBox btnPi;

    @FXML
    private CheckBox btnThr;

    @FXML
    private Pane finB;

    @FXML
    private Label lblStat;

    @FXML
    private Pane panel1;

    @FXML
    private Text textFin;

    @FXML
    private Text textStat;

    @FXML
    private Button useBTN;

    @FXML
    private void handleClicks(ActionEvent event){

        if(event.getSource()==Bench){
            lblStat.setText("Benchmarking !");
            textStat.setText("To get started, please select the benchmarking options you would like to run from the list below. You can choose to run all available benchmarks or select specific ones based on your needs.\n" +
                    "\n" );
            useBTN.setVisible(true);
            btnPi.setVisible(true);
            btnThr.setVisible(true);
            btnDhry.setVisible(true);
            useBTN.setText("Being Benchmarking !");
            finB.setVisible(false);

        }
        else if(event.getSource()==HSTR){
            useBTN.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);
            btnDhry.setVisible(false);
            finB.setVisible(false);
            lblStat.setText("History ");
            textStat.setText("History of tests done");


        }
        else if(event.getSource()==CINFO){
            // Get processor name

            useBTN.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);
            btnDhry.setVisible(false);
            finB.setVisible(false);
            SystemInfo systemInfo = new SystemInfo();
            HardwareAbstractionLayer hardware = systemInfo.getHardware();
            OperatingSystem os = systemInfo.getOperatingSystem();
            CentralProcessor processor = hardware.getProcessor();
            String cpuModel = processor.getProcessorIdentifier().getName();
            int numCores = processor.getPhysicalProcessorCount();
            long totalMemory = hardware.getMemory().getTotal();
            long availableMemory = hardware.getMemory().getAvailable();
            String osName = os.getManufacturer() + " " + os.getVersionInfo().getVersion();
            Display[] displays = hardware.getDisplays().toArray(new Display[0]);
            lblStat.setText("Computer Information");
            textStat.setText("Operating System : \t" + os + "\n"+
                            "RAM: Total :\t " + totalMemory + " bytes, Available : \t" + availableMemory + " bytes" +"\n" +
                    "CPU: \t " + cpuModel + " (" + numCores + " cores)");

        }
        else if(event.getSource()==ABOUT){
            useBTN.setVisible(false);

            btnPi.setVisible(false);
            btnThr.setVisible(false);
            btnDhry.setVisible(false);

            finB.setVisible(false);

            lblStat.setText("About the Bomb Benchmark ");
            textStat.setText("Welcome to the Bomb Benchmark, where we explode the limits of computer performance. Our project was developed by a group of university students with a passion for computer science and programming. Our team consists of four dedicated students who share a common goal of improving their programming skills and expanding their knowledge of computer architecture.\n" +
                    "\n" +
                    "We believe that benchmarking tools play a crucial role in assessing the performance of computer systems and optimizing their efficiency. Therefore, we developed the Bomb Benchmark to provide a reliable and user-friendly tool for measuring the performance of CPUs and GPUs.");
            useBTN.setVisible(false);

        }
    }
    boolean dhry=false,pi=false,thr=false;
    @FXML
    private void handleSelection(ActionEvent event){
        if(event.getSource()==btnDhry){
            dhry=!dhry; // toggle the value of dhry
        }
        else if(event.getSource()==btnPi){
            pi=!pi; // toggle the value of pi
        }
        else if(event.getSource()==btnThr){
            thr=!thr; // toggle the value of thr
        }

    }
    @FXML
    private void beginBenchmarking(ActionEvent event) throws InterruptedException {
        if(event.getSource()==useBTN){
            BenchmarkRunner Bench = new BenchmarkRunner();
            Bench.runBenchmarks(pi,thr,dhry);
            double score = Bench.getTotalScore();
            useBTN.setVisible(false);
            finB.setVisible(true);
            textFin.setText("Congratulations ! You scored " + score + " points out of 10 ! \n");


        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        finB.setVisible(false);
        lblStat.setText("About the Bomb Benchmark ");
        textStat.setText("Welcome to the Bomb Benchmark, where we explode the limits of computer performance. Our project was developed by a group of university students with a passion for computer science and programming. Our team consists of four dedicated students who share a common goal of improving their programming skills and expanding their knowledge of computer architecture.\n" +
                "\n" +
                "We believe that benchmarking tools play a crucial role in assessing the performance of computer systems and optimizing their efficiency. Therefore, we developed the Bomb Benchmark to provide a reliable and user-friendly tool for measuring the performance of CPUs and GPUs.");

    }
}
