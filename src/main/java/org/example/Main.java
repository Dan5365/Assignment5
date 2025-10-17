package org.example;


public class Main {
    public static void main(String[] args) {
        StudentPortalFacade facade = new StudentPortalFacade();


        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        Student Temirgaly = new Student("Temirgaly");

// Build course
        Course math = new MathCourse();
        math = new MentorSupportDecorator(math, "Dr. Ivanov");
        math = new CertificateDecorator(math);

        Course TemirgalyMath = new CertificateDecorator(new MathCourse());
        Course TemirgalyProg = new GamificationDecorator(
                new MentorSupportDecorator(new ProgrammingCourse(), "Ms. Taylor"), 300
        );


// Build course
        Course prog = new ProgrammingCourse();
        prog = new GamificationDecorator(prog, 200);



        facade.enrollInCourse(alice, math);
        facade.enrollInCourse(bob, prog);
        facade.enrollInCourse(Temirgaly,  TemirgalyMath);
        facade.enrollInCourse(Temirgaly, TemirgalyProg);


// Simulate learning
        facade.startLearning(alice, math);
        facade.deliverLesson(alice, math);
        facade.deliverLesson(alice, math);
        facade.completeCourse(alice, math);


        facade.startLearning(Temirgaly, TemirgalyMath);
        facade.deliverLesson(Temirgaly, TemirgalyMath);
        facade.completeCourse(Temirgaly, TemirgalyMath);

        facade.startLearning(Temirgaly, TemirgalyProg);
        facade.deliverLesson(Temirgaly, TemirgalyProg);
        facade.completeCourse(Temirgaly, TemirgalyProg);


        facade.startLearning(bob, prog);
        facade.deliverLesson(bob, prog);



//status and leaderboard
        facade.showStudentStatus(alice);
        facade.showStudentStatus(bob);
        facade.showStudentStatus(Temirgaly);
        Leaderboard.printTop(10);

    }
}