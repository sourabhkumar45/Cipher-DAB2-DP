import java.util.*;
import java.io.*;

public class minHeapWithComparable {
    public static class implements Comparable<Student> {
        String name;
        int height;
        int weight;

        void Student(String s, int h, int w) {
            this.name = s;
            this.height = h;
            this.weight = w;
        }
        
        // this function works with System.out.println and help to display student as a whole object.
        public String toString() {
           return this.name+" -> "+this.height+" , "+this.weight);
        }

        public int compareTo(Student other) {
            return this.height - other.height;
        }

    }
    public static void main(String args[]) throws IOException {
        Student[] students = new Student[5];
        Student[0] = new Student("A", 180, 75); 
        Student[1] = new Student("B", 150, 85); 
        Student[2] = new Student("C", 165, 72); 
        Student[3] = new Student("D", 185, 65); 
        Student[4] = new Student("E", 177, 55); 

        PriorityQueue<Student> pq = new PriorityQueue<>();
        for(Student s: students) {
            pq.add(s);
        }

        while(pq.size()>0) {
            System.out.println(pq.remove()); // use of student.toString here
        }

    }

}