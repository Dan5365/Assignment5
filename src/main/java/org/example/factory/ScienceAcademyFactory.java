package org.example.factory;

import org.example.decorator.CertificateDecorator;
import org.example.MathCourse;
import org.example.decorator.MentorSupportDecorator;
import org.example.ProgrammingCourse;
import org.example.model.Course;

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
