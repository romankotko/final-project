package com.company;

import java.time.Duration;

public record Course(String name, Duration duration) {

    public Duration getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name + '\t' + duration.toHours();
    }
}
