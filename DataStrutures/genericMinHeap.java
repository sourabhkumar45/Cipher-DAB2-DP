import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class genericMinHeap { 
  
  public static class myPriorityQueue<T> {
    ArrayList<T> data;

    public myPriorityQueue() {
      data = new ArrayList<>();
    }
    // public myPriorityQueue(int[] arr) {
    //     for(int a: arr) {
    //         add(a); 
    //     }
    // }
    // -> above contstructor is of nlogn, write constructor so that it can be done in O(n), where n = no. of nodes on heap
    // solution
    //  public myPriorityQueue(T[] arr) {
    //      for(int a: arr) {
    //          data.add(a);
    //      }

    //      for(int i = (data.size()/2)-1; i>=0; i--) {
    //          downheapify(i);
    //      }
    //  }

    public void add(T val) {
      // write your code here
      data.add(val);
      upHeapify(data.size()-1);
    }
    
    public void upHeapify(int i) {
      if(i==0) {
        return;
      }
      int parentIdx = (i-1)/2;
      if(data.get(parentIdx)>data.get(i)) {
        swap(i, parentIdx);
        upHeapify(parentIdx);
      }
    }

    public int remove() {
      // write your code here
      if(data.size()==0){
        System.out.println("Underflow");
        return -1;
      }
      swap(0, data.size()-1);

      int val = data.remove(data.size()-1);

      downheapify(0);

      return val;
    }
    public void downheapify(int i) {

      int miniIdx = i;

      int lIdx = 2*i + 1;
      if(lIdx<data.size() && data.get(lIdx)<data.get(miniIdx)) {
        miniIdx = lIdx;
      }

      int rIdx = 2*i + 2;
      if(rIdx<data.size() && data.get(rIdx)<data.get(miniIdx)) {
        miniIdx = rIdx;
      } 

      if(miniIdx!=i) {
        swap(miniIdx, i);
        downheapify(miniIdx);
      }
    }

    public void swap(int i, int j) {
      T ith = data.get(i);
      T jth = data.get(j);

      data.set(i, jth);
      data.set(j, ith);
    }

    public int peek() {
      // write your code here
      if(data.size()==0) {
        System.out.println("Underflow");
        return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    myPriorityQueue qu = new myPriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}