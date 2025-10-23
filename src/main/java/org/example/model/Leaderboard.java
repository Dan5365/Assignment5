package org.example.model;

import java.util.*;
public class Leaderboard {
    private static final Map<java.util.UUID, Integer> points = new HashMap<>();
    private static final Map<java.util.UUID, String> names = new HashMap<>();


    public static void addPoints(Student student, int pts) {
        points.put(student.getId(), points.getOrDefault(student.getId(), 0) + pts);
        names.put(student.getId(), student.getName());
    }


    public static int getPoints(Student student) { return points.getOrDefault(student.getId(), 0); }


    public static void printTop(int topN) {
        System.out.println("--- Leaderboard Top " + topN + " ---");
        points.entrySet().stream()
                .sorted((a,b) -> Integer.compare(b.getValue(), a.getValue()))
                .limit(topN)
                .forEach(e -> System.out.println(names.get(e.getKey()) + " : " + e.getValue() + " pts"));
    }
}