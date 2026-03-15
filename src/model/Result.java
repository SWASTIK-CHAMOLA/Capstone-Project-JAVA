package model;

public class Result {

    private int id;
    private int studentId;
    private int examId;
    private int score;
    private String examDate;

    public Result() {}

    public Result(int id, int studentId, int examId, int score, String examDate) {
        this.id = id;
        this.studentId = studentId;
        this.examId = examId;
        this.score = score;
        this.examDate = examDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }
}