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
import java.util.ResourceBundle;

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
    private Label lblStat;

    @FXML
    private Pane panel1;
    @FXML
    private Button useBTN;


    @FXML
    private Text textStat;
    @FXML
    private CheckBox btnDhry;

    @FXML
    private CheckBox btnPi;

    @FXML
    private CheckBox btnThr;
    @FXML


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

        }
        else if(event.getSource()==HSTR){
            useBTN.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);
            btnDhry.setVisible(false);

            lblStat.setText("History ");
            textStat.setText("History of tests done");


        }
        else if(event.getSource()==CINFO){
            // Get processor name

            useBTN.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);
            btnDhry.setVisible(false);

            lblStat.setText("Computer Information");
            textStat.setText("Get COmp INFO");

        }
        else if(event.getSource()==ABOUT){
            useBTN.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);
            btnDhry.setVisible(false);


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
    private void beginBenchmarking(ActionEvent event){
        if(event.getSource()==useBTN){
            BenchmarkRunner Bench = new BenchmarkRunner();
            Bench.runBenchmarks(pi,thr,dhry);
            proggresB.setVisible(true);



        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblStat.setText("About the Bomb Benchmark ");
        textStat.setText("Welcome to the Bomb Benchmark, where we explode the limits of computer performance. Our project was developed by a group of university students with a passion for computer science and programming. Our team consists of four dedicated students who share a common goal of improving their programming skills and expanding their knowledge of computer architecture.\n" +
                "\n" +
                "We believe that benchmarking tools play a crucial role in assessing the performance of computer systems and optimizing their efficiency. Therefore, we developed the Bomb Benchmark to provide a reliable and user-friendly tool for measuring the performance of CPUs and GPUs.");


    }
}
