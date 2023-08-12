package com.example.assignment3;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Assignment3 {

    @FXML
    private Rectangle box1, box2, box3, box4, box5, box6, box7, box8, box9;

    @FXML
    private ComboBox<String> colourComboBox;

    @FXML
    private Label name1, name2, name3, name4, name5, name6, name7, name8, name9, error;

    @FXML
    private TextField studentNameTextField;

    private List<Rectangle> boxes;
    private List<Label> names;
    private final List<String> usedColours = new ArrayList<>();

    @FXML
    void initialize() {
        boxes = List.of(box1, box2, box3, box4, box5, box6, box7, box8, box9);
        names = List.of(name1, name2, name3, name4, name5, name6, name7, name8, name9);

        if (colourComboBox.getItems().isEmpty()) {
            colourComboBox.getItems().addAll("Purple", "Orange", "Green", "Blue", "Red", "Pink", "Brown", "Yellow", "Grey");
        }
    }

    @FXML
    void addStudent() {
        String chosenColour = colourComboBox.getValue();
        String studentName = studentNameTextField.getText().trim();

        if (studentName.isEmpty()) {
            error.setText("Please enter your name.");
            return;
        }

        if (chosenColour == null || chosenColour.isEmpty()) {
            error.setText("Please select a colour.");
            return;
        }

        if (usedColours.contains(chosenColour)) {
            System.out.println("Error: Colour " + chosenColour + " is already in usedColors: " + usedColours);
            error.setText("Color already chosen. Pick another.");
            return;
        }

        Random random = new Random();
        boolean assigned = false;
        while (!assigned) {
            int index = random.nextInt(9); // Random index between 0 and 8
            if (names.get(index).getText().isEmpty()) {
                names.get(index).setText(studentName);
                boxes.get(index).setFill(Color.valueOf(chosenColour));
                assigned = true;
            }
        }

        usedColours.add(chosenColour); // Store the chosen colour to ensure it isn't selected again.
        System.out.println("Added colour: " + chosenColour + " to usedColours: " + usedColours);

        // Reset the text field and combo box for the next entry
        studentNameTextField.clear();
        colourComboBox.getSelectionModel().clearSelection();
        error.setText(""); // Clear the error message
    }
}