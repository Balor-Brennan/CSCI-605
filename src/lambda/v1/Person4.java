package lambda.v1;

import java.util.*;

public class Person4 {
    private String name;
    private Integer age;

    public Person4(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {

        Comparator<Person4> comparisonByAge = new Comparator<Person4>() {
            @Override
            public int compare(Person4 o1, Person4 o2) {
                return o1.age.compareTo(o2.age);
            }
        };
        List<Person4> people = Arrays.asList(
                new Person4("Alice", 20),
                new Person4("Bob", 22),
                new Person4("Carol", 21),
                new Person4("Aaron", 21));
        Collections.sort(people, comparisonByAge);
        System.out.println("Printing people list ordered by age in ascending order - Anonymous class");
        people.forEach(System.out::println);
        System.out.println("--------------");

        Collections.shuffle(people);
        System.out.println("Printing people list unordered");
        people.forEach(System.out::println);
        System.out.println("--------------");

        Comparator<Person4> lambdaComparison = (o1, o2) -> o2.age.compareTo(o1.age);
        System.out.println("Printing people list ordered by age in descending order - Lambda expression");
        Collections.sort(people, lambdaComparison);
        people.forEach(System.out::println);
        System.out.println("--------------");
        List<Person4> peeps = new ArrayList<>(people);
        peeps.sort(
                Comparator
                        .comparing(Person4::getAge)
                        .thenComparing(Person4::getName)
        );
        System.out.println("Printing people list ordered by age in asc order " +
                "and then by name in asc order - Method reference");
        peeps.forEach(System.out::println);

    }

    public String toString() {
        return name + ": " + age;
    }
}
