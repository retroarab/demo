package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
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
    private void handleClicks(ActionEvent event){
        //System.out.println((event.getSource() instanceof Button && ((Button)event.getSource()).getId().equals("Bench")));

        if(event.getSource()==Bench){ // The right way to test since event.getSrouce().equals(Bench) doesn't work
            lblStat.setText("Benchmarking !");
            textStat.setText("To get started, please select the benchmarking options you would like to run from the list below. You can choose to run all available benchmarks or select specific ones based on your needs.\n" +
                    "\n" );
            useBTN.setVisible(true);
            btnDhry.setVisible(true);
            btnPi.setVisible(true);
            btnThr.setVisible(true);
            useBTN.setText("Being Benchmarking !");
            //panel1.setBackground(new Background(new BackgroundFill(Color.rgb(63,43,99), CornerRadii.EMPTY, Insets.EMPTY)));

        }
        else if(event.getSource()==HSTR){

            btnDhry.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);
            lblStat.setText("History ");
            textStat.setText("History of tests done");

            useBTN.setVisible(false);
        }
        else if(event.getSource()==CINFO){
            // Get processor name

            btnDhry.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);
            lblStat.setText("Computer Information");
            textStat.setText("Get COmp INFO");
            useBTN.setVisible(false);

        }
        else if(event.getSource()==ABOUT){
            btnDhry.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);

            lblStat.setText("About the Bomb Benchmark ");
            textStat.setText("Welcome to the Bomb Benchmark, where we explode the limits of computer performance. Our project was developed by a group of university students with a passion for computer science and programming. Our team consists of four dedicated students who share a common goal of improving their programming skills and expanding their knowledge of computer architecture.\n" +
                    "\n" +
                    "We believe that benchmarking tools play a crucial role in assessing the performance of computer systems and optimizing their efficiency. Therefore, we developed the Bomb Benchmark to provide a reliable and user-friendly tool for measuring the performance of CPUs and GPUs.");
            useBTN.setVisible(false);

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblStat.setText("About the Bomb Benchmark ");
        textStat.setText("Welcome to the Bomb Benchmark, where we explode the limits of computer performance. Our project was developed by a group of university students with a passion for computer science and programming. Our team consists of four dedicated students who share a common goal of improving their programming skills and expanding their knowledge of computer architecture.\n" +
                "\n" +
                "We believe that benchmarking tools play a crucial role in assessing the performance of computer systems and optimizing their efficiency. Therefore, we developed the Bomb Benchmark to provide a reliable and user-friendly tool for measuring the performance of CPUs and GPUs.");
        btnDhry.setVisible(false);
        btnPi.setVisible(false);
        btnThr.setVisible(false);
        useBTN.setVisible(false);

    }
}
