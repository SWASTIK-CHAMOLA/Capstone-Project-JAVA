package controller;

import dao.ExamDAO;
import dao.QuestionDAO;
import model.Exam;
import model.Question;

public class AdminController {

    private ExamDAO examDAO;
    private QuestionDAO questionDAO;

    public AdminController() {
        examDAO = new ExamDAO();
        questionDAO = new QuestionDAO();
    }

    public boolean createExam(String title, int duration) {

        Exam exam = new Exam();
        exam.setTitle(title);
        exam.setDuration(duration);

        return examDAO.addExam(exam);
    }

    public boolean addQuestion(int examId, String questionText,
                               String optionA, String optionB,
                               String optionC, String optionD,
                               String correctAnswer) {

        Question question = new Question();

        question.setExamId(examId);
        question.setQuestionText(questionText);
        question.setOptionA(optionA);
        question.setOptionB(optionB);
        question.setOptionC(optionC);
        question.setOptionD(optionD);
        question.setCorrectAnswer(correctAnswer);

        return questionDAO.addQuestion(question);
    }
}