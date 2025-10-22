package org.example;

public class CourseBuilder {
    private Course course;

    public CourseBuilder(Course baseCourse) {
        this.course = baseCourse;
    }

    public CourseBuilder withMentor(String mentorName) {
        course = new MentorSupportDecorator(course, mentorName);
        return this;
    }

    public CourseBuilder withCertificate() {
        course = new CertificateDecorator(course);
        return this;
    }

    public CourseBuilder withGamification(int points) {
        course = new GamificationDecorator(course, points);
        return this;
    }

    public Course build() {
        return course;
    }
}
