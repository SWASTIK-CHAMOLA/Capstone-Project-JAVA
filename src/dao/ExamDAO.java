package dao;

import model.Exam;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO {

    public boolean addExam(Exam exam) {

        String sql = "INSERT INTO exams(title,duration) VALUES(?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, exam.getTitle());
            stmt.setInt(2, exam.getDuration());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Exam> getAllExams() {

        List<Exam> exams = new ArrayList<>();
        String sql = "SELECT * FROM exams";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Exam exam = new Exam(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("duration")
                );

                exams.add(exam);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return exams;
    }
}