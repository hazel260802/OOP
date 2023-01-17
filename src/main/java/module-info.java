module oop_lecture {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

	requires java.desktop;
    requires com.gluonhq.charm.glisten;
    requires selenium.api;
    requires selenium.chrome.driver;


    // opens oop_lecture to javafx.fxml;
    exports oop_lecture.application;
    opens oop_lecture.application;

    exports oop_lecture.controllers;
    opens oop_lecture.controllers;
}