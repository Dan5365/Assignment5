package org.example.model;

import java.util.*;
public class Student {
    private final String name;
    private final UUID id = UUID.randomUUID();
    private final List<String> certificates = new ArrayList<>();
    private final Map<String,String> mentors = new HashMap<>();


    public Student(String name) { this.name = name; }
    public String getName() { return name; }
    public UUID getId() { return id; }
    public void addCertificate(String cert) { certificates.add(cert); }
    public List<String> getCertificates() { return Collections.unmodifiableList(certificates); }
    public void setMentor(String courseName, String mentor) { mentors.put(courseName, mentor); }
    public Map<String,String> getMentors() { return Collections.unmodifiableMap(mentors); }
}