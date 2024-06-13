package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Exam;

public class ExamService {
    private Map<Integer, Exam> exams = new HashMap<>();
    private int nextId = 1;

    public boolean createExam(Exam exam) {
        int id = nextId++; // Assign next available ID to the exam
        exam.setId(id); // Set the ID of the exam
        exams.put(id, exam); // Add the exam to the map
        return true; // Exam created successfully
    }

    public Exam getExam(int id) {
        return exams.get(id);
    }

    public List<Exam> getAllExams() {
        return new ArrayList<>(exams.values());
    }
}

