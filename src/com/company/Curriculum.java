package com.company;

public enum Curriculum {
    JAVA_DEVELOPER ("Java Developer"),
    AQE("AQE");

    private final String name;

    private Curriculum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

