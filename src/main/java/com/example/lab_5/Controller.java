package com.example.lab_5;


import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Controller {



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
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    private Path path;



    public void menuNew(){
        tableView.getItems().clear();
    }

    public void menuOpen(){
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\Ginthushan\\Desktop\\2020 LABS\\src\\main\\java\\com\\example\\lab_5"));
        File selectedFile = fc.showOpenDialog(null);
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        if (selectedFile != null){
            path = Path.of(selectedFile.getAbsolutePath());
        }


        DataSource dataSource = new DataSource(path);

        ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

        StudentId.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("id"));
        Assignments.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("assignment"));
        Midterm.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("midterm"));
        FinalExam.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("fexam"));
        FinalMark.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("final_mark"));
        Letter.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("letter"));


        tableView.setItems(dataSource.getMarks());

    }

    public void menuSaveAs(){
        File fc = new FileChooser().showSaveDialog(new Stage());

        if (fc != null){
            path = Path.of(fc.getAbsolutePath());
        }


        if (path == null){
            System.out.println("Please select a file first");
        }
        else{
            StudentRecord student = new StudentRecord();
            List <List<String>> arrList = new ArrayList<>();
            for (int i = 0; i < tableView.getItems().size(); i++){
                student = tableView.getItems().get(i);
                arrList.add(new ArrayList<>());
                arrList.get(i).add(student.getId());
                arrList.get(i).add(student.getAssignment());
                arrList.get(i).add(student.getMidterm());
                arrList.get(i).add(student.getFexam());
                arrList.get(i).add(student.getFinal_mark());
                arrList.get(i).add(student.getLetter());

            }
            System.out.println(arrList.get(0).get(0));

            try{
                FileWriter fw = new FileWriter(String.valueOf(path),false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                for (int i = 0; i < arrList.size(); i++) {
                    arrList.get(i).get(0);
                    pw.println(arrList.get(i).get(0)+","+arrList.get(i).get(1)+","+arrList.get(i).get(2)+","+arrList.get(i).get(3));
                    pw.flush();
                }
                pw.flush();
                pw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public void menuSave(){
        if (path == null){
            System.out.println("Please select a file first");
        }
        else{
            StudentRecord student = new StudentRecord();
            List <List<String>> arrList = new ArrayList<>();
            for (int i = 0; i < tableView.getItems().size(); i++){
                student = tableView.getItems().get(i);
                arrList.add(new ArrayList<>());
                arrList.get(i).add(student.getId());
                arrList.get(i).add(student.getAssignment());
                arrList.get(i).add(student.getMidterm());
                arrList.get(i).add(student.getFexam());
                arrList.get(i).add(student.getFinal_mark());
                arrList.get(i).add(student.getLetter());

            }
            System.out.println(arrList.get(0).get(0));

            try{
                FileWriter fw = new FileWriter(String.valueOf(path),false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                for (int i = 0; i < arrList.size(); i++) {
                    arrList.get(i).get(0);
                    pw.println(arrList.get(i).get(0)+","+arrList.get(i).get(1)+","+arrList.get(i).get(2)+","+arrList.get(i).get(3));
                    pw.flush();
                }
                pw.flush();
                pw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    public void initialize(){


    }

    @FXML
    void btnAdd(ActionEvent event) {

        StudentRecord s = new StudentRecord(txt1.getText(), txt2.getText(), txt3.getText(), txt4.getText());
        tableView.getItems().add(s);
    }

    public void menuExit(){
        Platform.exit();

    }

}

