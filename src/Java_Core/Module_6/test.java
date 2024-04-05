package Java_Core.Module_6;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class test {
    public static void main(String args[]) {
        ArrayList<Optional<Person>> people = new ArrayList<>(Arrays.asList(
                Optional.ofNullable(new Person("Mamai")),
                Optional.ofNullable(new Person(null)),
                Optional.ofNullable(null),
                Optional.ofNullable(new Person("Arthas"))
        ));
        long count = people.stream()
                .filter(Optional::isPresent)
                .count();
        System.out.println(count);
        LocalDateTime left = LocalDateTime.of(LocalDate.of(2000, 1, 1), LocalTime.MIN);
        LocalDateTime right = LocalDateTime.of(LocalDate.of(2000, 1, 1), LocalTime.MIN);
        System.out.println(left.isAfter(right) || left.isBefore(right));

        Optional<String> optionalString = Optional.empty();
        optionalString.ifPresentOrElse(
                (value) -> System.out.println("1"),
                () -> System.out.println("2")
        );
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
