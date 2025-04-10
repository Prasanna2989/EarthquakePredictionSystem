package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create navigation buttons
        Button viewEarthquakesBtn = new Button("View Earthquake Records");
        Button viewStationsBtn = new Button("View Seismic Stations");
        Button predictionsBtn = new Button("Generate Predictions");
        Button dataUploadBtn = new Button("Import USGS Data");

        // Set button actions (just print for now – later we'll open new windows)
        viewEarthquakesBtn.setOnAction(e -> System.out.println("Navigate to Earthquake Records"));
        viewStationsBtn.setOnAction(e -> System.out.println("Navigate to Seismic Stations"));
        predictionsBtn.setOnAction(e -> System.out.println("Navigate to Predictions"));
        dataUploadBtn.setOnAction(e -> System.out.println("Importing data from USGS..."));

        // Layout
        VBox vbox = new VBox(15, viewEarthquakesBtn, viewStationsBtn, predictionsBtn, dataUploadBtn);
        vbox.setStyle("-fx-padding: 30; -fx-alignment: center;");

        // Scene and Stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Earthquake Prediction Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
