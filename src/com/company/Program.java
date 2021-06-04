package com.company;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

public class Program {
    private final Curriculum curriculum;
    private final LocalDateTime startDate;
    private final Set<Course> courses;

    public Program(Curriculum curriculum , LocalDateTime startDate, Course ...courses) {
        this.startDate = startDate;
        this.courses = Set.of(courses);
        this.curriculum = curriculum;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Duration getDuration() {
        var programDuration = Duration.ZERO;
        for (var course : courses)
            programDuration = programDuration.plus(course.getDuration());
        return programDuration;
    }

    //TODO Optimize algorithm
    public LocalDateTime getEndDate(){
        var programDuration = getDuration();
        var endDate = startDate;
        var courseDays = programDuration.toHours() / 8;
        while (courseDays != 0) {
            if (endDate.getDayOfWeek() != DayOfWeek.SATURDAY && endDate.getDayOfWeek() != DayOfWeek.SUNDAY)
                courseDays--;
            endDate = endDate.plusDays(1);
        }

        return endDate.plusHours(programDuration.toHours() % 8);
    }

    public boolean isFinished() {
        return getEndDate().isBefore(LocalDateTime.now());
    }

}
