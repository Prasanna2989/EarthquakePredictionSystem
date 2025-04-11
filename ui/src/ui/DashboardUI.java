package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

        // Action for View Earthquake Records
        viewEarthquakesBtn.setOnAction(e -> {
            try {
                new EarthquakeRecordsUI().start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


        // Action for View Seismic Stations
        viewStationsBtn.setOnAction(e -> {
            // Here you would open a new window to show seismic station information
            showSeismicStationsWindow();
        });

        // Action for Generate Predictions
        predictionsBtn.setOnAction(e -> {
            // Trigger earthquake prediction logic here
            generatePredictions();
        });

        // Action for Import USGS Data
        dataUploadBtn.setOnAction(e -> {
            // Here you would implement data import from USGS (e.g., by API or file upload)
            importUSGSData();
        });

        // Layout
        VBox vbox = new VBox(15, viewEarthquakesBtn, viewStationsBtn, predictionsBtn, dataUploadBtn);
        vbox.setStyle("-fx-padding: 30; -fx-alignment: center;");

        // Scene and Stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Earthquake Prediction Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to show earthquake records
    private void showEarthquakeRecordsWindow() {
        // You could fetch records from the database and display them in a new window.
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Earthquake Records");
        alert.setHeaderText("Displaying Earthquake Records");
        alert.setContentText("This will display the earthquake records.");
        alert.showAndWait();
    }

    // Method to show seismic stations
    private void showSeismicStationsWindow() {
        // You could display seismic stations info in a new window.
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Seismic Stations");
        alert.setHeaderText("Displaying Seismic Stations");
        alert.setContentText("This will display the seismic stations.");
        alert.showAndWait();
    }

    // Method to generate earthquake predictions
    private void generatePredictions() {
        // You can replace this with the logic for generating predictions.
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Generate Predictions");
        alert.setHeaderText("Generating Earthquake Predictions");
        alert.setContentText("This will generate earthquake predictions based on available data.");
        alert.showAndWait();
    }

    // Method to import USGS data
    private void importUSGSData() {
        // Implement file upload or API data fetch from USGS here.
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Import USGS Data");
        alert.setHeaderText("Importing USGS Data");
        alert.setContentText("This will import data from the USGS.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
