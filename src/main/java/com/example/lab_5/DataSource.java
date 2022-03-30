package com.example.lab_5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class DataSource {
    public ObservableList<StudentRecord> marks = FXCollections.observableArrayList();

    public DataSource(){}
    public DataSource(Path path) {

        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path)));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] x = line.split(splitBy);
                marks.add(new StudentRecord(x[0], x[1], x[2], x[3]));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ObservableList<StudentRecord> getMarks() {
        return marks;
    }

    public void setMarks(ObservableList<StudentRecord> marks) {
        this.marks = marks;
    }

    public void add(String x1, String x2, String x3, String x4){
        marks.add(new StudentRecord(x1, x2, x3, x4));
    }
}
