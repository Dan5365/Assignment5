package org.example;

public class ITAcademyFactory implements CourseFactoryAbstract {
    @Override
    public Course createMathCourse() {
        return new GamificationDecorator(new MathCourse(), 200);
    }

    @Override
    public Course createProgrammingCourse() {
        return new MentorSupportDecorator(new ProgrammingCourse(), "Ms. Taylor");
    }
}
