module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
        requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires net.synedra.validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
           // requires com.almasb.fxgl.all;
            requires jdk.jfr;
    requires java.logging;
    requires java.management;
    requires jdk.management;
    requires com.github.oshi;
    requires com.sun.jna;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}