package com.lukaszdutka.easyjava.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsService {

    public Set<Person> getSetOfPeople(List<Person> input) {
        return input.stream()
                .collect(Collectors.toSet());
    }

    public List<String> getOnlyNames(List<Person> input) {
        return input.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    public List<Person> returnsOnlyDevelopersThatKnow(List<Person> input, String skill) {
        return input.stream()
                .filter(person -> person.getSkills().contains(skill))
                .collect(Collectors.toList());
    }

    public List<Person> getPeopleOrderedByAge(List<Person> input) {
        return input.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toList());
    }

    public void printNames(List<Person> input) {
        input.stream()
                .map(Person::getName)
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }

    public void printNamesForLogging(List<Person> input) { // many steps in stream
        input.stream()
                .peek(System.out::println)
                .filter(p -> p.getName().startsWith("A") || p.getName().startsWith("B"))
                .peek(p -> System.out.println(p + " xD"))
                .collect(Collectors.toList());
    }

    public List<String> getListOfSkills(List<Person> input) {
        return input.stream()
                .flatMap(p -> p.getSkills().stream())
                .collect(Collectors.toList());
    }

    public List<String> getDistinctListOfSkills(List<Person> input) {
        return input.stream()
                .flatMap(p -> p.getSkills().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Person> getTwoOldestPeople(List<Person> input) {
        return input.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .collect(Collectors.toList());
    }

    public Person getSecondYoungestPerson(List<Person> input) {
        return input.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not enough people in the input."));
    }

    public int getOldestAge(List<Person> input) {
        return input.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);
    }
}