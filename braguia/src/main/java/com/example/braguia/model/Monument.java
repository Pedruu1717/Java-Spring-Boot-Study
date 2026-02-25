package com.example.braguia;

public record Monument(long id, String name, String description) {

    @Override
    public String toString() {
        return String.format("Monument:%n id: %d%n name: %s%n description: %s%n", id, name, description);
    }
}