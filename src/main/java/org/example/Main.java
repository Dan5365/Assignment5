package org.example;

public class Main {
    public static void main(String[] args) {
        StudentPortalFacade facade = new StudentPortalFacade();

        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Student Temirgaly = new Student("Temirgaly");


        Course math = CourseFactory.create("science", "math")
                .withMentor("Dr. Ivanov")
                .withCertificate()
                .build();

        Course prog = CourseFactory.create("it", "programming")
                .withGamification(200)
                .build();

        Course TemirgalyMath = CourseFactory.create("science", "math")
                .withCertificate()
                .build();

        Course TemirgalyProg = CourseFactory.create("it", "programming")
                .withMentor("Ms. Taylor")
                .withGamification(300)
                .build();


        facade.enrollInCourse(alice, math);
        facade.enrollInCourse(bob, prog);
        facade.enrollInCourse(Temirgaly, TemirgalyMath);
        facade.enrollInCourse(Temirgaly, TemirgalyProg);


        simulateLearning(facade, alice, math, 2);
        simulateLearning(facade, Temirgaly, TemirgalyMath, 1);
        simulateLearning(facade, Temirgaly, TemirgalyProg, 1);
        simulateLearning(facade, bob, prog, 1);


        facade.showStudentStatus(alice);
        facade.showStudentStatus(bob);
        facade.showStudentStatus(Temirgaly);
        Leaderboard.printTop(10);
    }

    private static void simulateLearning(StudentPortalFacade facade, Student student, Course course, int lessons) {
        facade.startLearning(student, course);
        for (int i = 0; i < lessons; i++) {
            facade.deliverLesson(student, course);
        }
        facade.completeCourse(student, course);
    }
}
