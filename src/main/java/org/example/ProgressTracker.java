package org.example;

import org.example.model.Student;

import java.util.*;
public class ProgressTracker {
    // map: studentId -> (courseName -> progress)
    private static final Map<java.util.UUID, Map<String, Integer>> store = new HashMap<>();


    public static void setProgress(Student student, String courseName, int percent) {
        store.computeIfAbsent(student.getId(), k -> new HashMap<>()).put(courseName, percent);
    }
    public static int getProgress(Student student, String courseName) {
        return store.getOrDefault(student.getId(), Map.of()).getOrDefault(courseName, 0);
    }
}