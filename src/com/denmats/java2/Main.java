package com.denmats.java2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Human> osoby = Arrays.asList(
                new Human("Katarzyna", "Palichleb", 31),
                new Human("Małgorzata", "Stasiak", 32),
                new Human("Paweł", "Stasiak", 30),
                new Human("Daniel", "Wojda", 24),
                new Human("Piotr", "Wysota", 21),
                new Human("Maciej", "Chmielowski", 30),
                new Human("Aleksnadra", "Rzęchowska", 29),
                new Human("Adam", "Małysz", 45),
                new Human("Paweł", "Kukiz", 51),
                new Human("Andrzej", "Duda", 52),
                new Human("Tomasz", "Kot", 45),
                new Human("Bill", "Gates", 60),
                new Human("Robert", "Wieckiewicz", 54),
                new Human("Alicja", "Makota", 9),
                new Human("Harry", "Potter", 11),
                new Human("Antonio", "Banderas", 52),
                new Human("Andrzej", "Sapkowski", 70),
                new Human("Pawel", "Delag", 46),
                new Human("Gandalf", "Thewhite", 999),
                new Human("Jakub", "Wedrowycz", 95)
        );

        //Wyswietlanie najmlodszej i nastarszej osoby
        Human theYoungest = osoby.stream()
                .min(Comparator.comparing(Human::getAge))
                .orElseThrow(NoSuchElementException::new);
        Human theOldest = osoby.stream()
                .max(Comparator.comparing(Human::getAge))
                .orElseThrow(NoSuchElementException::new);
        System.out.println("Najmlodsza osoba to: " + theYoungest);
        System.out.println("Najstarsza osoba to: " + theOldest);
        System.out.println();


        //Sortowanie wg wieku danej osoby:
        List<Human> sortedAge = osoby.stream()
                .sorted(Comparator.comparingInt(Human::getAge))
                .collect(Collectors.toList());
        System.out.println("Posortowana lista wg wieku rosnaco");
        sortedAge.forEach(System.out::println);
        System.out.println();

        // Wyswietlenie osób niepelnoletnich:
        List<Human> minor = osoby.stream()
                .filter(h -> h.getAge() < 18)
                .collect(Collectors.toList());
        System.out.println("Osoby niepelnoletnie to: ");
        minor.forEach(System.out::println);
        System.out.println();

        //Liczenie sredniego wieku osob
        double aver = osoby.stream()
                .mapToDouble(Human::getAge)
                .average()
                .orElse(Double.NaN);
        System.out.println("Srednia wieku wynosi: " + aver);
        System.out.println();

        //Odwrotnie alfabetycznie
        List<Human> reversAlph = osoby.stream()
                .sorted(Comparator.comparing(Human::getName).reversed())
                .collect(Collectors.toList());

        System.out.println();
        System.out.println("Posortowane wg imion w odwrotnej kolejnosci alfabetycznej:");
        reversAlph.forEach(System.out::println);
        System.out.println();

        //Imiona konczace się na "a"
        List<Human> endsWithA = osoby.stream()
                .filter(h -> h.getName().endsWith("a"))
                .collect(Collectors.toList());
        System.out.println("Prawdopodobnie kobiety:");
        endsWithA.forEach(System.out::println);

        //zamien Paweł na Gaweł
        List<Human> gawelPawel = osoby.stream()
                .filter(p -> p.getName().equals("Paweł"))
                .map(p -> {
                    String name = p.getName().replace('P', 'G');
                    Human temp = new Human(name, p.getSurname(), p.getAge());
                    return temp;
                })
                .collect(Collectors.toList());

        gawelPawel.forEach(System.out::println);
    }
}

class Human {
    private final String name;
    private  final String surname;
    private final int age;

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return name + " "+surname+" "+age;}

}










