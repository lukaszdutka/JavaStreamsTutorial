package com.lukaszdutka.easyjava.streams;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamsServiceTest {

    private final StreamsService streamsService = new StreamsService();

    private final Person alina = new Person("Alina", 25, List.of("Java", "React"));
    private final Person brian = new Person("Brian", 19, List.of("Java", "Kotlin"));
    private final Person clark = new Person("Clark", 35, List.of("C", "C++"));

    private final List<Person> standardInput = List.of(alina, brian, clark);

    @Test
    @DisplayName("[collect] Returns set of people")
    public void returnsSetOfPeople() {
        //given
        List<Person> input = List.of(alina, alina, brian);

        //when
        Set<Person> result = streamsService.getSetOfPeople(input);

        //then
        assertEquals(Set.of(alina, brian), result);
    }

    @Test
    @DisplayName("[map] Returns list of names of given people")
    public void returnsListOfNames() {
        //when
        List<String> result = streamsService.getOnlyNames(standardInput);

        //then
        assertEquals(List.of("Alina", "Brian", "Clark"), result);
    }

    @Test
    @DisplayName("[filter] Returns list of people that know certain skill")
    public void returnsListOfPeopleThatKnowCertainSkill() {
        //when
        List<Person> result = streamsService.returnsOnlyDevelopersThatKnow(standardInput, "Java");

        //then
        assertEquals(List.of(alina, brian), result);
    }

    @Test
    @DisplayName("[sorted] Returns list of people ordered by age")
    public void returnsListOfPeopleOrderedByAge() {
        //when
        List<Person> result = streamsService.getPeopleOrderedByAge(standardInput);

        //then
        assertEquals(List.of(brian, alina, clark), result);
    }

    @Test
    @DisplayName("[forEach] Do something for each element")
    public void doSomethingForEachElement() {
        streamsService.printNames(standardInput);
    }

    @Test
    @DisplayName("[peek] Do something, but mostly for logging")
    public void doSomethingButMostlyForLogging() {
        streamsService.printNamesForLogging(standardInput);
    }

    @Test
    @DisplayName("[flatMap] Get list of skills")
    public void getListOfSkills() {
        //when
        List<String> skills = streamsService.getListOfSkills(standardInput);

        //then
        assertEquals(List.of("Java", "React", "Java", "Kotlin", "C", "C++"), skills);
    }

    @Test
    @DisplayName("[distinct] Get distinct list of skills")
    public void getDistinctListOfSkills() {
        //when
        List<String> skills = streamsService.getDistinctListOfSkills(standardInput);

        //then
        assertEquals(List.of("Java", "React", "Kotlin", "C", "C++"), skills);
    }

    @Test
    @DisplayName("[limit] Get only two oldest people")
    public void getOnlyTwoOldestPeople() {
        //when
        List<Person> oldestPeople = streamsService.getTwoOldestPeople(standardInput);

        //then
        assertEquals(List.of(clark, alina), oldestPeople);
    }

    @Test
    @DisplayName("[skip] Get second youngest person")
    public void getSecondYoungestPerson() {
        //when
        Person secondYoungestPerson = streamsService.getSecondYoungestPerson(standardInput);

        //then
        assertEquals(alina, secondYoungestPerson);
    }

    @Test
    @DisplayName("[mapToInt, max] Get oldest age of peoples")
    public void getOldestAge() {
        //when
        int oldestAge = streamsService.getOldestAge(standardInput);

        //then
        assertEquals(35, oldestAge);
    }
}