package challenges;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import fundamentals.Student;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(List.of(
                new Student("Martin", 12),
                new Student("Ann", 12),
                new Student("Mike", 12),
                new Student("Susan", 13),
                new Student("Eliud", 14),
                new Student("Richard", 8),
                new Student("Ben", 8),
                new Student("David", 6)
        ));
        Iterator iterator = priorityQueue.iterator();
        int currentScore = 0;
        int rank = 1;
        int rankTies = 0;
        while (iterator.hasNext()) {
            Student st = (Student) iterator.next();
            if (st.getScore() < currentScore) {
                rank += 1 + rankTies;
                rankTies = 0;
            }
            if (st.getScore() == currentScore) {
                rankTies++;
            }
            currentScore = st.getScore();
            System.out.println(MessageFormat.format("{0}: {1}-({2})",
                    st.getName(), st.getScore(), rank));
        }
    }


}
