package org.example;


public class Main {
    public static void main(String[] args) {
        StudentPortalFacade facade = new StudentPortalFacade();


        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Student Temirgaly = new Student("Temirgaly");

// Build course: MathCourse + Mentor + Certificate
        Course math = new MathCourse();
        math = new MentorSupportDecorator(math, "Dr. Ivanov");
        math = new CertificateDecorator(math);

        Course TemirgalyMath = new CertificateDecorator(new MathCourse());
        Course TemirgalyProg = new GamificationDecorator(
                new MentorSupportDecorator(new ProgrammingCourse(), "Ms. Taylor"), 300
        );


// Build course: ProgrammingCourse + Gamification
        Course prog = new ProgrammingCourse();
        prog = new GamificationDecorator(prog, 200);


// Enroll students
        facade.enrollInCourse(alice, math);
        facade.enrollInCourse(bob, prog);
        facade.enrollInCourse(Temirgaly, math);
        facade.enrollInCourse(Temirgaly, prog);


// Simulate learning journey for Alice
        facade.startLearning(alice, math);
        facade.deliverLesson(alice, math);
        facade.deliverLesson(alice, math);
        facade.completeCourse(alice, math);


        // Simulate learning journey for Temirgaly
        facade.startLearning(Temirgaly, math);
        facade.deliverLesson(Temirgaly, math);
        facade.completeCourse(Temirgaly, math);

        facade.startLearning(Temirgaly, prog);
        facade.deliverLesson(Temirgaly, prog);
        facade.completeCourse(Temirgaly, prog);


// Simulate learning for Bob
        facade.startLearning(bob, prog);
        facade.deliverLesson(bob, prog);



// Show status and leaderboard
        facade.showStudentStatus(alice);
        facade.showStudentStatus(bob);
        facade.showStudentStatus(Temirgaly);
        Leaderboard.printTop(10);

    }
}