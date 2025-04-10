package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimpleUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI elements
        Label label = new Label("Enter your name:");
        TextField textField = new TextField();
        Button button = new Button("Say Hello");

        // Add action to the button
        button.setOnAction(e -> {
            String name = textField.getText();
            label.setText("Hello, " + name + "!");
        });

        // Layout container
        VBox vbox = new VBox(10, label, textField, button);
        vbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Set up the scene and stage
        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setTitle("Simple JavaFX UI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
