import java.util.*;
import java.io.*;

// MySet class
public class MySet<T>{

  // LinkedList implementation of SET
  public MyLinkedList<T> myList = new MyLinkedList<T>();

  // Method to check if the set is empty
  public Boolean IsEmpty(){
    return myList.getSize() == 0;
  }

  // Method to check if the member is already present
  public Boolean IsMember(T obj){
    return myList.contains(obj);
  }

  // Method to insert elements to the set
  public void addElement(T obj){
    if(IsMember(obj)){
      // System.out.println("Already present in the set");
      return;
    }
    myList.addLast(obj);
    return;
  }

  // Method to delete elements from the set
  public void Delete(T obj){
    // Sanity check
    if(!IsMember(obj)){
      // System.out.println("Not present in the set");
      return;
    }
    myList.remove(obj);
    return;
  }

  // Method to get union of sets
  public MySet<T> union(MySet<T> a){
    MySet<T> unionSet = new MySet<T>();
    unionSet.myList.addAll(this.myList);
    for(int i=0;i<a.myList.getSize();i++){
        unionSet.addElement(a.myList.elementAt(i));
    }
    return unionSet;
  }

  // Method to get intersection of sets
  public MySet<T> intersection(MySet<T> a){
    // Sanity check
    if(myList.getSize() == 0 || a.myList.getSize() == 0){
      // System.out.println("One of the sets is empty");
      return null;
    }
    MySet<T> intersectionSet = new MySet<T>();
    for(int i=0;i<myList.getSize();i++){
      if(a.IsMember(myList.elementAt(i))){
        intersectionSet.myList.addLast(myList.elementAt(i));
      }
    }
    return intersectionSet;
  }

  /*
  public static void main(String[] args) {
    MySet<Integer> set = new MySet<Integer>();

    set.addElement(1);
    set.addElement(2);
    set.addElement(3);
    set.addElement(3);
    set.addElement(4);
    set.addElement(5);
    set.Delete(2);
    set.Delete(2);
    for(int i=0;i<set.myList.getSize();i++){
      System.out.println(set.myList.elementAt(i));
    }

    MySet<Integer> set2 = new MySet<Integer>();
    set2.addElement(1);
    set2.addElement(2);
    set2.addElement(3);
    set2.addElement(4);
    System.out.println("");
    for(int i=0;i<set2.myList.getSize();i++){
      System.out.println(set2.myList.elementAt(i));
    }

    MySet<Integer> un = set.union(set2);
    System.out.println("");
    for(int i=0;i<un.myList.getSize();i++){
      System.out.println(un.myList.elementAt(i));
    }

    MySet<Integer> in = set.intersection(set2);
    System.out.println("");
    for(int i=0;i<in.myList.getSize();i++){
      System.out.println(in.myList.elementAt(i));
    }
  }
  */

}
