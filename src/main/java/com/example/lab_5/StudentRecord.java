package com.example.lab_5;

public class StudentRecord {
    public String id;
    public String assignment;
    public String midterm;
    public String fexam;
    public String final_mark;
    public String letter;
    public float x;

    public StudentRecord(){}
    public StudentRecord(String id, String assignment, String midterm, String fexam) {
        this.id = id;
        this.assignment = assignment;
        this.midterm = midterm;
        this.fexam = fexam;

        x = (float) (Float.parseFloat(assignment) * 0.2 + Float.parseFloat(midterm) * 0.3 + Float.parseFloat(fexam) * 0.5);

        this.final_mark = Float.toString(x);

        if (x > 80 && x < 100){
            this.letter = "A";
        }
        if (x > 70 && x < 79){
            this.letter = "B";
        }
        if (x > 60 && x < 69){
            this.letter = "C";
        }
        if (x > 50 && x < 59){
            this.letter = "D";
        }
        if (x > 0 && x < 46){
            this.letter = "F";
        }
    }

    public String getId() {
        return id;
    }

    public String getAssignment() {
        return assignment;
    }

    public String getMidterm() {
        return midterm;
    }

    public String getFexam() {
        return fexam;
    }

    public String getFinal_mark() {
        return final_mark;
    }

    public String getLetter() {
        return letter;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public void setMidterm(String midterm) {
        this.midterm = midterm;
    }

    public void setFexam(String fexam) {
        this.fexam = fexam;
    }
}
