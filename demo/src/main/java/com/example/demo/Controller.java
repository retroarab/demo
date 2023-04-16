package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
    private Text textStat;
    @FXML
    private void handleClicks(ActionEvent event){
        //System.out.println((event.getSource() instanceof Button && ((Button)event.getSource()).getId().equals("Bench")));

        if((event.getSource() instanceof Button && ((Button)event.getSource()).getId().equals("Bench"))){
            System.out.println("ASD");

            lblStat.setText("SA SE VADA BINEEEE");
            textStat.setText("MUIEEEE DINAMO");

            panel1.setBackground(new Background(new BackgroundFill(Color.rgb(63,43,99), CornerRadii.EMPTY, Insets.EMPTY)));

        }
        else if(event.getSource()==HSTR){
            System.out.println("ASD");

            lblStat.setText("SA SE VADA BINEEEE");
            textStat.setText("MUIEEEE DINAMO");
            panel1.setBackground(new Background(new BackgroundFill(Color.rgb(63,43,99), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else if(event.getSource()==CINFO){
            System.out.println("ASD");

            lblStat.setText("SA SE VADA BINEEEE");
            textStat.setText("MUIEEEE DINAMO");
            panel1.setBackground(new Background(new BackgroundFill(Color.rgb(63,43,99), CornerRadii.EMPTY, Insets.EMPTY)));
        }
        else if(event.getSource()==ABOUT){
            System.out.println("ASD");

            lblStat.setText("SA SE VADA BINEEEE");
            textStat.setText("MUIEEEE DINAMO");
            panel1.setBackground(new Background(new BackgroundFill(Color.rgb(63,43,99), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
