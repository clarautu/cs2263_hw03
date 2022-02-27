package cs2263_hw03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.awt.*;

public class CourseProcessor extends Application {

    public static void main(String args[]){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Course Processor");
        primaryStage.setAlwaysOnTop(true);

        // Create a combobox for the departments and add all the options
        ComboBox departments = new ComboBox();
        departments.getItems().add("Computer Science");
        departments.getItems().add("Mathematics");
        departments.getItems().add("Chemistry");
        departments.getItems().add("Physics");
        departments.getItems().add("Biology");
        departments.getItems().add("Electrical Engineering");

        // Textfields for the course number, name, and credits
        TextField courseNum = new TextField();
        TextField courseName = new TextField();
        TextField courseCredits = new TextField();

        // Labels for the above textfields
        Label departLabel = new Label("Department: ");
        Label numLabel = new Label("Course Number: ");
        Label nameLabel = new Label("Course Name: ");
        Label creditLabel = new Label("Course Credits: ");

        // Create HBoxes to hold each label with it's associated control
        HBox departRow = new HBox(departLabel, departments);
        HBox numRow = new HBox(numLabel, courseNum);
        HBox nameRow = new HBox(nameLabel, courseName);
        HBox creditRow = new HBox(creditLabel, courseCredits);

        // Button to process the form
        Button submit = new Button("Submit");

        // Create the scene to display - Hold Hboxes in a VBox to display vertically
        Scene scene = new Scene(new VBox(departRow, numRow, nameRow, creditRow, submit), 500, 500);

        // Add scene to the primary stage and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
