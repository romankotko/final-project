package com.company;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final var students = Set.of(
                new Student(
                        "Buhaiets Dmytro",
                        new Program(
                                Curriculum.JAVA_DEVELOPER,
                                LocalDateTime.of(2021, 6, 1, 10, 0),
                                new Course("Java", Duration.ofHours(16)),
                                new Course("JDBC", Duration.ofHours(24)),
                                new Course("Spring", Duration.ofHours(16))

                        )
                ),
                new Student(
                        "Kotko Roman",
                        new Program(
                                Curriculum.AQE,
                                LocalDateTime.of(2021, 6, 1, 10, 0),
                                new Course("Test design", Duration.ofHours(10)),
                                new Course("Page object", Duration.ofHours(16)),
                                new Course("Selenium", Duration.ofHours(16))
                        )
                )
        );


        final var scanner = new Scanner(System.in);

        while (true) {
            System.out.println(" 1. short log");
            System.out.println(" 2. long log");
            System.out.print("Choose: ");
            switch (scanner.nextByte()) {
                case 1:
                    for (var student : students) {
                        System.out.println("--------------------------");
                        System.out.println(student.shortLog());
                    }
                    break;
                case 2:
                    for (var student : students) {
                        System.out.println("--------------------------");
                        System.out.println(student.longLog());
                    }
                    break;
                default:
                    System.out.print("Request not found.");
            }
        }
    }
}
