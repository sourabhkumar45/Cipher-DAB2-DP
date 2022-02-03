import java.util.*;

import javax.swing.text.html.HTML;

import java.io.*;

public class minHeapWithComparator {
    static class Student implements Comparable<Student> {
        String name;
        int ht;
        int wt;
        int marks;

        Student(String s, int h, int w, int m) {
            this.name = s;
            this.ht = h;
            this.wt = w;
            this.marks = m;
        }
         // this function works with System.out.println and help to display student as a whole object.
         public String toString() {
            return this.name+" -> "+this.ht+" , "+this.wt+" , "+this.marks;
         }
 
         public int compareTo(Student other) {
             return this.ht - other.ht;
         }
    }
    public static void main(String args[]) throws IOException {
        PriorityQueue<Student> pqHt = new PriorityQueue<>(); 
        PriorityQueue<Student> pqWt = new PriorityQueue<>();   // sort basis of weight
        PriorityQueue<Student> pqMarks = new PriorityQueue<>(); // sort basis of marks 
    }
}