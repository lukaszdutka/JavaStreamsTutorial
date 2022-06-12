package com.lukaszdutka.easyjava.streams;

import java.util.List;
import java.util.Objects;

class Person {
    private final String name;
    private final int age;
    private final List<String> skills;

    public Person(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && skills.equals(person.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, skills);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                '}';
    }
}