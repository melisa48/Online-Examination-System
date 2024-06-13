package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import models.Exam;
import models.Question;
import services.ExamService;

public class ExamController {
    private ExamService examService;

    public ExamController() {
        examService = new ExamService();
    }

    public void createExam(Scanner scanner) {
        System.out.print("Enter exam title: ");
        String title = scanner.nextLine();
        System.out.print("Enter exam description: ");
        String description = scanner.nextLine();

        List<Question> questions = new ArrayList<>();
        while (true) {
            System.out.print("Enter question text: ");
            String questionText = scanner.nextLine();
            System.out.print("Enter option A: ");
            String optionA = scanner.nextLine();
            System.out.print("Enter option B: ");
            String optionB = scanner.nextLine();
            System.out.print("Enter option C: ");
            String optionC = scanner.nextLine();
            System.out.print("Enter option D: ");
            String optionD = scanner.nextLine();
            System.out.print("Enter correct option (A/B/C/D): ");
            String correctOption = scanner.nextLine();

            Question question = new Question(questionText, optionA, optionB, optionC, optionD, correctOption);
            questions.add(question);

            System.out.print("Add another question? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("no")) {
                break;
            }
        }

        Exam exam = new Exam(title, description, questions);
        if (examService.createExam(exam)) {
            System.out.println("Exam created successfully.");
        } else {
            System.out.println("Failed to create exam.");
        }
    }

    public void listExams() {
        List<Exam> exams = examService.getAllExams();
        if (exams.isEmpty()) {
            System.out.println("No exams available.");
        } else {
            System.out.println("Available exams:");
            for (Exam exam : exams) {
                System.out.println("ID: " + exam.getId() + ", Title: " + exam.getTitle());
            }
        }
    }

    public void takeExam(Scanner scanner) {
        listExams();
        System.out.print("Enter exam ID to take: ");
        int examId = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Exam exam = examService.getExam(examId);
        if (exam == null) {
            System.out.println("Exam not found.");
            return;
        }

        int score = 0;
        List<Question> questions = exam.getQuestions();
        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            System.out.println("A. " + question.getOptionA());
            System.out.println("B. " + question.getOptionB());
            System.out.println("C. " + question.getOptionC());
            System.out.println("D. " + question.getOptionD());
            System.out.print("Enter your answer (A/B/C/D): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(question.getCorrectOption())) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + questions.size());
        double percentage = ((double) score / questions.size()) * 100;
        System.out.printf("You scored %.2f%%\n", percentage);

        if (percentage >= 70) {
            System.out.println("You passed the exam.");
        } else {
            System.out.println("You failed the exam.");
        }
    }
}
