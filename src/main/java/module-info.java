module cnpm.quanlynhankhau {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens oop_lecture to javafx.fxml;
    exports oop_lecture.application;
    opens oop_lecture.application to javafx.fxml;
    exports oop_lecture.controllers;
    opens oop_lecture.controllers to javafx.fxml;
}