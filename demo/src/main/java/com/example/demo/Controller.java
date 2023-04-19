package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private void handleClicks(ActionEvent event){
        //System.out.println((event.getSource() instanceof Button && ((Button)event.getSource()).getId().equals("Bench")));

        if(event.getSource()==Bench){ // The right way to test since event.getSrouce().equals(Bench) doesn't work
            lblStat.setText("Benchmarking !");
            textStat.setText("To get started, please select the benchmarking options you would like to run from the list below. You can choose to run all available benchmarks or select specific ones based on your needs.\n" +
                    "\n" +
                    "Dhrystone Benchmark: This benchmark measures the speed of a CPU by calculating the number of Dhrystone operations per second. It is a widely used benchmarking tool for measuring the integer performance of a CPU.\n" +
                    "\n" +
                    "Pi Calculator Benchmark: This benchmark measures the floating-point performance of a CPU by calculating the value of pi using the Monte Carlo method. It is a popular benchmarking tool for measuring the performance of scientific computing applications.\n" +
                    "\n" +
                    "Threaded Benchmark: This benchmark measures the performance of a CPU by running multiple threads simultaneously. It is a useful tool for measuring the parallel processing capabilities of a CPU.\n" +
                    "\n" +
                    "Once you have selected the benchmarking options, click on the \"Run Benchmarks\" button to start the benchmarking process. Our tool will provide you with detailed performance metrics and analysis based on the benchmarks you have selected.");
            useBTN.setVisible(true);
            useBTN.setText("Being Benchmarking !");
            //panel1.setBackground(new Background(new BackgroundFill(Color.rgb(63,43,99), CornerRadii.EMPTY, Insets.EMPTY)));

        }
        else if(event.getSource()==HSTR){


            lblStat.setText("History ");
            textStat.setText("History of tests done");

            useBTN.setVisible(false);
        }
        else if(event.getSource()==CINFO){
            // Get processor name


            lblStat.setText("Computer Information");
            textStat.setText("Get COmp INFO");
            useBTN.setVisible(false);

        }
        else if(event.getSource()==ABOUT){


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

        useBTN.setVisible(false);

    }
}
