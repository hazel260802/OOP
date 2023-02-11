module Wiki {
	requires javafx.controls;
	requires javafx.fxml;
	requires com.fasterxml.jackson.databind;


	opens oop_lecture.controllers;
	exports oop_lecture.controllers;


	opens oop_lecture.models;
	exports oop_lecture.models;
}