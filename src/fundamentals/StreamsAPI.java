package fundamentals;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsAPI {
    public static void main(String[] args) {
        List<Student> list = List.of(
                new Student("Martin", 12),
                new Student("Ann", 12),
                new Student("Mike", 12),
                new Student("Susan", 13),
                new Student("Eliud", 14),
                new Student("Richard", 8),
                new Student("Ben", 8),
                new Student("David", 6)
        );
        //filter
        //list.stream().filter(s -> s.getScore() == 12).forEach(System.out::println);
        //sort
        Stream<Student> sorted = list.stream().sorted(Comparator.comparing(Student::getScore).reversed());
        sorted.forEach(System.out::println);

        Stream<Student> studentStream = list.stream().filter(s -> s.getScore() > 10);
        Optional<Student> max = studentStream.max(Comparator.comparing(Student::getScore));
        max.map(s->s.getName()).ifPresent(System.out::println);
    }
}
