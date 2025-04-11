package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EarthquakeRecordsUI extends Application {

    private TableView<Earthquake> table = new TableView<>();

    public static class Earthquake {
        private final int earthquakeId;
        private final double magnitude;
        private final double depthKm;
        private final Timestamp eventTime;
        private final int locationId;

        public Earthquake(int earthquakeId, double magnitude, double depthKm, Timestamp eventTime, int locationId) {
            this.earthquakeId = earthquakeId;
            this.magnitude = magnitude;
            this.depthKm = depthKm;
            this.eventTime = eventTime;
            this.locationId = locationId;
        }

        public int getEarthquakeId() { return earthquakeId; }
        public double getMagnitude() { return magnitude; }
        public double getDepthKm() { return depthKm; }
        public Timestamp getEventTime() { return eventTime; }
        public int getLocationId() { return locationId; }
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Earthquake Records");

        TableColumn<Earthquake, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("earthquakeId"));

        TableColumn<Earthquake, Double> magCol = new TableColumn<>("Magnitude");
        magCol.setCellValueFactory(new PropertyValueFactory<>("magnitude"));

        TableColumn<Earthquake, Double> depthCol = new TableColumn<>("Depth (km)");
        depthCol.setCellValueFactory(new PropertyValueFactory<>("depthKm"));

        TableColumn<Earthquake, Timestamp> timeCol = new TableColumn<>("Event Time");
        timeCol.setCellValueFactory(new PropertyValueFactory<>("eventTime"));

        TableColumn<Earthquake, Integer> locCol = new TableColumn<>("Location ID");
        locCol.setCellValueFactory(new PropertyValueFactory<>("locationId"));

        table.getColumns().addAll(idCol, magCol, depthCol, timeCol, locCol);

        fetchEarthquakeData();

        VBox vbox = new VBox(table);
        Scene scene = new Scene(vbox, 800, 400);
        stage.setScene(scene);
        stage.show();
    }

    private void fetchEarthquakeData() {
        ObservableList<Earthquake> data = FXCollections.observableArrayList();

        String url = "jdbc:postgresql://localhost:5432/earthquake_db"; // adjust if needed
        String user = "myuser"; // or your user
        String password = "mypassword"; // update this

        String query = "SELECT earthquake_id, magnitude, depth_km, event_time, location_id FROM earthquake";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Earthquake eq = new Earthquake(
                        rs.getInt("earthquake_id"),
                        rs.getDouble("magnitude"),
                        rs.getDouble("depth_km"),
                        rs.getTimestamp("event_time"),
                        rs.getInt("location_id")
                );
                data.add(eq);
            }
            table.setItems(data);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
