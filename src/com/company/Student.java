package com.company;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public record Student(String name, Program program) {
    static private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM y - EEEE", Locale.US);

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("STUDENT:\t" + name
                + "\nCURRICULUM:\t" + program.getCurriculum()
                + "\nSTART_DATE:\t" + program.getStartDate().format(dateTimeFormatter)
                + "\nCOURSE\tDURATION(hrs)"
                + "\n----------------------------\n");

        int i = 0;
        for (var course : program.getCourses())
            stringBuilder
                    .append(++i)
                    .append(". ")
                    .append(course.toString())
                    .append('\n');

        return stringBuilder.toString();
    }

    public String shortLog() {
        var log = name + " (" + program.getCurriculum() + ") - Training ";

        if (program.isFinished()) {
            var passed = Duration.between(program.getEndDate(), LocalDateTime.now());
            log += "completed. " + passed.toDaysPart() + " d " + passed.toHoursPart()
                    + " hours have passed since";
        } else {
            var left = Duration.between(LocalDateTime.now(), program.getEndDate());
            log += "is not finished. " + left.toDaysPart() + " d " + left.toHoursPart()
                    + " hours are left until the end.";
        }

        return log;
    }

    public String longLog() {
        var log = name
                + "\nWORKING_HOURS:\tfrom 10:00 to 18:00"
                + "\nPROGRAM:\t" + program.getCurriculum()
                + "\nDURATION:\t" + program.getDuration().toHours() + "h "
                + "\nSTART_DATE:\t" + program.getStartDate().format(dateTimeFormatter)
                + "\nEND_DATE:\t" + program.getEndDate().format(dateTimeFormatter)
                + "\nTRAINING ";

        if (program.isFinished()) {
            var passed = Duration.between(program.getEndDate(), LocalDateTime.now());
            log += "completed. " + passed.toDaysPart() + " d " + passed.toHoursPart()
                    + " hours have passed since";
        } else {
            var left = Duration.between(LocalDateTime.now(), program.getEndDate());
            log += "is not finished. " + left.toDaysPart() + " d " + left.toHoursPart()
                    + " hours are left until the end.";
        }

        return log;
    }
}
