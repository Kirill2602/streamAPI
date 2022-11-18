package org.example;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = getAnimal();

        //Filter
        List<Animal> predator = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR)).toList();
        predator.forEach(System.out::println);
        System.out.println("###################################");
        //Sort
        List<Animal> sorted = animals.stream()
                .sorted(Comparator.comparing(Animal::getAge)).toList();
        sorted.forEach(System.out::println);
        System.out.println("####################################");
        //All match
        boolean allMatch = animals.stream().allMatch(animal -> animal.getAge() < 50);
        System.out.println(allMatch);

        //Any match
        boolean anyMatch = animals.stream().anyMatch(animal->animal.getAge() > 10);
        System.out.println(anyMatch);
    }

    private static List<Animal> getAnimal() {
        return List.of(
                new Animal("Слон", 20, Classification.HERBIVORE),
                new Animal("Рысь", 5, Classification.PREDATOR),
                new Animal("Лев", 7, Classification.PREDATOR),
                new Animal("Гиена", 4, Classification.PREDATOR),
                new Animal("Лошадь", 2, Classification.HERBIVORE),
                new Animal("Жираф", 3, Classification.HERBIVORE),
                new Animal("Гибон", 9, Classification.OMNIVOROUS)
        );
    }
}