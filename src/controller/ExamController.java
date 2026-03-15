package controller;

import dao.QuestionDAO;
import dao.ResultDAO;
import model.Question;
import model.Result;
import utils.DateUtil;

import java.util.List;
import java.util.Map;

public class ExamController {

    private QuestionDAO questionDAO;
    private ResultDAO resultDAO;

    public ExamController() {
        questionDAO = new QuestionDAO();
        resultDAO = new ResultDAO();
    }

    public List<Question> getExamQuestions(int examId) {
        return questionDAO.getQuestionsByExam(examId);
    }

    public int calculateScore(List<Question> questions, Map<Integer, String> answers) {

        int score = 0;

        for (Question q : questions) {

            String studentAnswer = answers.get(q.getId());

            if (studentAnswer != null && studentAnswer.equals(q.getCorrectAnswer())) {
                score++;
            }
        }

        return score;
    }

    public boolean saveResult(int studentId, int examId, int score) {

        Result result = new Result();

        result.setStudentId(studentId);
        result.setExamId(examId);
        result.setScore(score);
        result.setExamDate(DateUtil.getCurrentDate());

        return resultDAO.saveResult(result);
    }
}