package org.example.factory;

import org.example.MathCourse;
import org.example.ProgrammingCourse;
import org.example.builder.CourseBuilder;
import org.example.model.Course;

public class CourseFactory {

    public static CourseBuilder create(String academyType, String courseType) {
        Course baseCourse;
        switch (academyType.toLowerCase()) {
            case "it":
                baseCourse = createITCourse(courseType);
                break;
            case "science":
                baseCourse = createScienceCourse(courseType);
                break;
            default:
                throw new IllegalArgumentException("Unknown academy type: " + academyType);
        }
        return new CourseBuilder(baseCourse);
    }

    private static Course createITCourse(String courseType) {
        switch (courseType.toLowerCase()) {
            case "programming":
                return new ProgrammingCourse();
            default:
                throw new IllegalArgumentException("Unknown IT course type: " + courseType);
        }
    }

    private static Course createScienceCourse(String courseType) {
        switch (courseType.toLowerCase()) {
            case "math":
                return new MathCourse();
            default:
                throw new IllegalArgumentException("Unknown Science course type: " + courseType);
        }
    }
}
