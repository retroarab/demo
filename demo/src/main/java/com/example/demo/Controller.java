package com.example.demo;



import com.example.demo.benchmark.BenchmarkRunner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import oshi.*;
import oshi.hardware.CentralProcessor;
import oshi.hardware.Display;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OperatingSystem;

import java.net.InetAddress;
import java.net.UnknownHostException;


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
    private TableColumn<DataObject, String> computerNameColumn;
    @FXML
    private TableColumn<DataObject, Double> piScoreColumn;
    @FXML
    private TableColumn<DataObject, Double> threadingScoreColumn;
    @FXML
    private TableColumn<DataObject, Double> dhrystoneScoreColumn;

    @FXML
    private TableView<DataObject> table;
    @FXML
    private ProgressBar progressBar;

    @FXML
    private void handleClicks(ActionEvent event) throws IOException {

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
            progressBar.setVisible(false);

            table.setVisible(false);

        }
        else if(event.getSource()==HSTR){
            useBTN.setVisible(false);
            btnPi.setVisible(false);
            btnThr.setVisible(false);
            btnDhry.setVisible(false);
            finB.setVisible(false);
            lblStat.setText("History ");
            textStat.setText("Previous tests : ");
            List<DataObject> dataList = new ArrayList<>();
            String filePath = "benchmark_results.csv";
            Path path = Paths.get(filePath);
            byte[] bytes = Files.readAllBytes(path);
            String fileContent = new String(bytes);
            String[] lines = fileContent.split("\n");
            for (String line : lines) {
                String[] values = line.trim().split("\\s*\\|\\s*");
                if (values.length == 4) {
                    String pcName = values[0];
                    double piScore = Double.parseDouble(values[1]);
                    double threadingScore = Double.parseDouble(values[2]);
                    double dhrystoneScore = Double.parseDouble(values[3]);
                    DataObject data = new DataObject(pcName, piScore, threadingScore, dhrystoneScore);
                    dataList.add(data);


                }
            }
            ObservableList<DataObject> data = FXCollections.observableArrayList(dataList);
            table.setItems(data);
            table.setVisible(true);
            computerNameColumn.setVisible(true);
            piScoreColumn.setVisible(true);
            threadingScoreColumn.setVisible(true);
            dhrystoneScoreColumn.setVisible(true);
            computerNameColumn.setCellValueFactory(new PropertyValueFactory<>("computerName"));
            piScoreColumn.setCellValueFactory(new PropertyValueFactory<>("piScore"));
            threadingScoreColumn.setCellValueFactory(new PropertyValueFactory<>("threadingScore"));
            progressBar.setVisible(false);

            dhrystoneScoreColumn.setCellValueFactory(new PropertyValueFactory<>("dhrystoneScore"));


            ObservableList<DataObject> kek = table.getItems();
        }
        else if(event.getSource()==CINFO) {
            progressBar.setVisible(false);
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
            lblStat.setText("Computer Information");

            table.setVisible(false);
                String ops = System.getProperty("os.name").toLowerCase();
                String gpu="";
                if (ops.contains("linux")) {
                    gpu=executeCommand("lspci | grep -i vga");
                } else if (ops.contains("windows")) {
                    gpu=executeCommand("wmic path Win32_VideoController get Name");
                } else {
                    System.out.println("Unsupported operating system: " + os);
                }
                gpu.replace("Name","");
            textStat.setText("Operating System: " + os + "\n\n" +
                    "RAM: \t " + ((totalMemory/(1024 * 1024 * 1024))+1) + " GB\n\n" +
                    "CPU: \t " + cpuModel + " (" + numCores + " cores)" + "\n\nGPU "+gpu +"\n"
            );

        }

        else if(event.getSource()==ABOUT){
            useBTN.setVisible(false);

            btnPi.setVisible(false);
            btnThr.setVisible(false);
            btnDhry.setVisible(false);
            table.setVisible(false);
            finB.setVisible(false);

            lblStat.setText("About the Bomb Benchmark ");
            textStat.setText("Welcome to the Bomb Benchmark, where we explode the limits of computer performance. Our project was developed by a group of university students with a passion for computer science and programming. Our team consists of four dedicated students who share a common goal of improving their programming skills and expanding their knowledge of computer architecture.\n" +
                    "\n" +
                    "We believe that benchmarking tools play a crucial role in assessing the performance of computer systems and optimizing their efficiency. Therefore, we developed the Bomb Benchmark to provide a reliable and user-friendly tool for measuring the performance of CPUs and GPUs.");
            useBTN.setVisible(false);

        }
    }

    private static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output.toString().trim();
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
    private void beginBenchmarking(ActionEvent event) throws InterruptedException, UnknownHostException {
        if(event.getSource()==useBTN){
            if (event.getSource() == useBTN) {

                BenchmarkRunner bench = new BenchmarkRunner();
                progressBar.setVisible(true);
                useBTN.setVisible(false);


                Task<Void> benchmarkTask = new Task<>() {
                    @Override
                    protected Void call() {
                        bench.runBenchmarks(pi, thr, dhry);
                        SystemInfo systemInfo = new SystemInfo();
                        HardwareAbstractionLayer hardware = systemInfo.getHardware();
                        CentralProcessor processor = hardware.getProcessor();
                        String cpuModel = processor.getProcessorIdentifier().getName();
                        Platform.runLater(() -> {
                            double score = bench.getTotalScore();
                            useBTN.setVisible(false);
                            finB.setVisible(true);
                            textFin.setText("The benchmark scores are:\n" +
                                    "Pi score: " + bench.getPiScore() + "\n" +
                                    "Threading score: " + bench.getThreadingScore() + "\n" +
                                    "Dhrystone score: " + bench.getDhrystoneScore() + "\n");

                            // Save benchmark results to a file
                            InetAddress localhost;
                            try {
                                localhost = InetAddress.getLocalHost();
                                String computerName = localhost.getHostName();
                                try (PrintWriter writer = new PrintWriter(new FileWriter("benchmark_results.csv", true))) {
                                    writer.println(cpuModel + " | " + bench.getPiScore() + "| " + bench.getThreadingScore() + "| " + bench.getDhrystoneScore() + "\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (UnknownHostException e) {
                                e.printStackTrace();
                            }
                            progressBar.setVisible(false);

                        });

                        return null;
                    }
                };

                benchmarkTask.setOnRunning(e -> progressBar.setProgress(ProgressBar.INDETERMINATE_PROGRESS));
                benchmarkTask.setOnSucceeded(e -> progressBar.setProgress(1.0));
                benchmarkTask.setOnFailed(e -> progressBar.setProgress(0.0));

                Thread benchmarkThread = new Thread(benchmarkTask);
                benchmarkThread.start();

            }
        }

    }
            /*
            BenchmarkRunner Bench = new BenchmarkRunner();
            Bench.runBenchmarks(pi,thr,dhry);
            double score = Bench.getTotalScore();
            useBTN.setVisible(false);
            finB.setVisible(true);
            textFin.setText("The benchmark scores are : \n Pi score : "+Bench.getPiScore()+"\n Threading score : "+Bench.getThreadingScore()+"\nDhrystone score : "+Bench.getDhrystoneScore()+"\n");
            InetAddress localhost = InetAddress.getLocalHost();
            String computerName = localhost.getHostName();
            try (PrintWriter writer = new PrintWriter(new FileWriter("benchmark_results.csv", true))) {
                writer.println(computerName + " | " + Bench.getPiScore() + "| " + Bench.getThreadingScore()  + "| " + Bench.getDhrystoneScore() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
             */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        finB.setVisible(false);
        lblStat.setText("About the Bomb Benchmark ");
        textStat.setText("Welcome to the Bomb Benchmark, where we explode the limits of computer performance. Our project was developed by a group of university students with a passion for computer science and programming. Our team consists of four dedicated students who share a common goal of improving their programming skills and expanding their knowledge of computer architecture.\n" +
                "\n" +
                "We believe that benchmarking tools play a crucial role in assessing the performance of computer systems and optimizing their efficiency. Therefore, we developed the Bomb Benchmark to provide a reliable and user-friendly tool for measuring the performance of CPUs and GPUs.");
        table.setVisible(false);
        progressBar.setVisible(false);

    }
}
