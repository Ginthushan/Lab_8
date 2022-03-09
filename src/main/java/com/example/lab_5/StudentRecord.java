package com.example.lab_5;

public class StudentRecord {
    public String id;
    public float assignment;
    public float midterm;
    public float fexam;
    public float final_mark;
    public String letter;
    public StudentRecord(String id, float assignment, float midterm, float fexam) {
        this.id = id;
        this.assignment = assignment;
        this.midterm = midterm;
        this.fexam = fexam;
        this.final_mark = (float) (assignment * 0.2 + midterm * 0.3 + fexam * 0.5);

        if (final_mark > 80 && final_mark < 100){
            this.letter = "A";
        }
        if (final_mark > 70 && final_mark < 79){
            this.letter = "B";
        }
        if (final_mark > 60 && final_mark < 69){
            this.letter = "C";
        }
        if (final_mark > 50 && final_mark < 59){
            this.letter = "D";
        }
        if (final_mark > 0 && final_mark < 46){
            this.letter = "F";
        }
    }

    public String getId() {
        return id;
    }

    public float getAssignment() {
        return assignment;
    }

    public float getMidterm() {
        return midterm;
    }

    public float getFexam() {
        return fexam;
    }

    public float getFinal_mark() {
        return final_mark;
    }

    public String getLetter() {
        return letter;
    }
}
