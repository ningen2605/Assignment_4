module student.assignment_4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires junit;


    opens student.assignment_4 to javafx.fxml;
    exports student.assignment_4;
}