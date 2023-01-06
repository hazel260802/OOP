module oop_lecture {
    requires javafx.controls;
    requires javafx.fxml;


    opens oop_lecture to javafx.fxml;
    exports oop_lecture.application;
    opens oop_lecture.application to javafx.fxml;
    exports oop_lecture.controllers;
    opens oop_lecture.controllers to javafx.fxml;
}