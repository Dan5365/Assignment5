package org.example;

public class ScienceAcademyFactory implements CourseFactoryAbstract {
    @Override
    public Course createMathCourse() {
        return new CertificateDecorator(
                new MentorSupportDecorator(new MathCourse(), "Dr. Einstein")
        );
    }

    @Override
    public Course createProgrammingCourse() {

        return new ProgrammingCourse();
    }
}
