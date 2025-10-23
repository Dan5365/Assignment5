package org.example.factory;

import org.example.decorator.GamificationDecorator;
import org.example.MathCourse;
import org.example.decorator.MentorSupportDecorator;
import org.example.ProgrammingCourse;
import org.example.model.Course;

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
