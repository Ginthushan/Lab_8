package com.example.lab_5;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    private DataSource dataSource = new DataSource();

    @FXML
    private TableView<StudentRecord> tableView;

    @FXML
    private TableColumn<StudentRecord, String> StudentId;

    @FXML
    private TableColumn<StudentRecord, Float> Assignments;

    @FXML
    private TableColumn<StudentRecord, Float> Midterm;

    @FXML
    private TableColumn<StudentRecord, Float> FinalExam;

    @FXML
    private TableColumn<StudentRecord, Float> FinalMark;

    @FXML
    private TableColumn<StudentRecord, String> Letter;

    @FXML
    public void initialize(){
        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        StudentId.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("id"));
        Assignments.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("assignment"));
        Midterm.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("midterm"));
        FinalExam.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("fexam"));
        FinalMark.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("final_mark"));
        Letter.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("letter"));

        tableView.setItems(dataSource.getMarks());

    }
}

