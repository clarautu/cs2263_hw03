package cs2263_hw03;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.LinkedList;

public class CourseProcessor extends Application {

    public static void main(String args[]){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        LinkedList<Course> courseList = new LinkedList<>(); // Linked list to hold entered courses

        primaryStage.setTitle("Course Processor");

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
        // Button to print the courses
        Button print = new Button("List Courses");

        // Event handler for when Button Submit is pressed
        EventHandler<ActionEvent> submitForm = new EventHandler<ActionEvent>() {
            /**
             * Retrieve user entered values and create a new Course
             * @param e The Event from button submit
             */
            public void handle(ActionEvent e) {
                Label label = new Label();
                Scene feedback = new Scene(label, 300, 50);
                try {
                    String dep = departments.getValue().toString();
                    int num = Integer.parseInt(courseNum.getText());
                    String name = courseName.getText();
                    int credits = Integer.parseInt(courseCredits.getText());
                    Course course = new Course(dep, num, name, credits);
                    label.setText(course.toString() + "\n Course successfully added.");
                    courseList.add(course);
                } catch (Exception exception) {
                    label.setText("There was a problem with your inputs.");
                }
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(feedback);
                stage.showAndWait();
            }
        };
        submit.setOnAction(submitForm); // Attach submitForm to Button submit

        /**
         * Displays a list of all user entered courses
         * @param e The Event from button print
         */
        EventHandler<ActionEvent> printCourses = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                VBox courses = new VBox();
                for (Course c : courseList) {
                    courses.getChildren().add(new Label(c.toString()));
                }
                Scene showCourses = new Scene(courses, 400, 300);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(showCourses);
                stage.showAndWait();
            }
        };
        print.setOnAction(printCourses); // Attach printCourses to Button print

        // Create the scene to display - Hold Hboxes in a VBox to display vertically
        Scene scene = new Scene(new VBox(departRow, numRow, nameRow, creditRow, submit, print), 500, 500);

        // Add scene to the primary stage and show the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
