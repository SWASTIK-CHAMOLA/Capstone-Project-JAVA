package dao;

import model.Question;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {

    public boolean addQuestion(Question question) {

        String sql = "INSERT INTO questions(exam_id,question,optionA,optionB,optionC,optionD,correct_answer) VALUES(?,?,?,?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, question.getExamId());
            stmt.setString(2, question.getQuestionText());
            stmt.setString(3, question.getOptionA());
            stmt.setString(4, question.getOptionB());
            stmt.setString(5, question.getOptionC());
            stmt.setString(6, question.getOptionD());
            stmt.setString(7, question.getCorrectAnswer());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Question> getQuestionsByExam(int examId) {

        List<Question> questions = new ArrayList<>();

        String sql = "SELECT * FROM questions WHERE exam_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, examId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Question q = new Question(
                        rs.getInt("id"),
                        rs.getInt("exam_id"),
                        rs.getString("question"),
                        rs.getString("optionA"),
                        rs.getString("optionB"),
                        rs.getString("optionC"),
                        rs.getString("optionD"),
                        rs.getString("correct_answer")
                );

                questions.add(q);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
}