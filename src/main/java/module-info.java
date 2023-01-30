module oop_lecture {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

	requires java.desktop;
    requires com.gluonhq.charm.glisten;
	requires org.seleniumhq.selenium.api;
	requires org.seleniumhq.selenium.chrome_driver;


	exports oop_lecture.application;
    opens oop_lecture.application;

    exports oop_lecture.controllers;
    opens oop_lecture.controllers;

    exports oop_lecture.models;
    opens oop_lecture.models;

    exports oop_lecture.utility;
    opens oop_lecture.utility;
}