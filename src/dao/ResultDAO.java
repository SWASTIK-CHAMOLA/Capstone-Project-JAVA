package dao;

import model.Result;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultDAO {

    public boolean saveResult(Result result) {

        String sql = "INSERT INTO results(student_id,exam_id,score,exam_date) VALUES(?,?,?,?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, result.getStudentId());
            stmt.setInt(2, result.getExamId());
            stmt.setInt(3, result.getScore());
            stmt.setString(4, result.getExamDate());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public List<Result> getResultsByStudent(int studentId) {

        List<Result> results = new ArrayList<>();

        String sql = "SELECT * FROM results WHERE student_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, studentId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Result r = new Result(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("exam_id"),
                        rs.getInt("score"),
                        rs.getString("exam_date")
                );

                results.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }
}