package algorithms.sortingAlgorithms;

import utils.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Saurav", 70, 85));
        students.add(new Student("Amit", 71, 87));
        students.add(new Student("Abhishek", 77, 85));

        System.out.println("List before sorting : ");

        for(Student student : students) {
            System.out.println(student.name + " " + student.averageMark + " " + student.rollNumber);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("List after sorting by average marks : ");

        Collections.sort(students, (s1, s2) -> s1.averageMark - s2.averageMark);

        for(Student student : students) {
            System.out.println(student.name + " " + student.averageMark + " " + student.rollNumber);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("List after sorting by average marks followed by name : ");

        // Condition ? execute if true : execute if false;
        Collections.sort(students,
                (s1, s2) ->
                        s1.averageMark != s2.averageMark
                                ? s1.averageMark - s2.averageMark : s1.name.compareTo(s2.name));

        for(Student student : students) {
            System.out.println(student.name + " " + student.averageMark + " " + student.rollNumber);
        }
    }
}

