import java.util.*;
import java.io.*;

class MyNode<T>{

	protected T object;
	protected MyNode next;

  // MyNode class Constructor
  public MyNode(){
    object = null;
    next = null;
  }

  // MyNode class Constructor
	public MyNode(T obj){
		object = obj;
		next = null;
	}

  // Method to set next node
	public void setNext(MyNode node){
		next = node;
	}

  // Method to get next node
	public MyNode getNext(){
		return next;
	}

  // Method to get node object
	public T getObj(){
		return object;
	}

	// Method to set node object
	public void setObj(T obj){
		object = obj;
	}

}

public class MyLinkedList<T>{

  public MyNode<T> first;
	public MyNode<T> last;
	public int size;

  // MyLinkedList class Constructor
	public MyLinkedList(){
		first = null;
		last = null;
		size = 0;
	}

  // Method to check for empty list
	public Boolean isEmpty(){
		return first == null;
	}

  // Method to get size of list
	public int getSize(){
		return size;
	}

	// Method to get first object
  public T getFirst(){
    return first.getObj();
  }

  // Method to get last object
  public T getLast(){
    return last.getObj();
  }

  // Method to add node in front of the list
	public void addFront(T obj){
		MyNode<T> newNode = new MyNode<T>(obj);
		size++;
		if(first == null){
			first = newNode;
			last = first;
		}
		else{
			newNode.setNext(first);
			first = newNode;
		}
	}

  // Method to add node at the end of the list
	public void addLast(T obj){
		MyNode<T> newNode = new MyNode<T>(obj);
		size++;
		if(first == null){
			first = newNode;
			last = first;
		}
		else{
			last.setNext(newNode);
			last = newNode;
		}
	}

  // Method to insert node at any point in the list
	public void insert(T obj,int index){
		MyNode<T> newNode = new MyNode<T>(obj);
		MyNode<T> iterator = first;
		size++;
		if(index == 0){
			addFront(obj);
			return;
		}
		if(index == size-1){
			addLast(obj);
			return;
		}
		for(int i=0;i<size;i++){
			if(i == index-1){
				MyNode<T> temp = iterator.getNext();
				iterator.setNext(newNode);
				newNode.setNext(temp);
				break;
			}
			iterator = iterator.getNext();
		}
	}

	// Method to set node at any point in the list
	public void set(T obj,int index){
		if(index >= size){
			return;
		}
		MyNode<T> iterator = first;
		for(int i=0;i<index;i++){
			iterator = iterator.getNext();
		}
		iterator.setObj(obj);
	}

  // Method to remove the front node
	public T deleteFront(){
		MyNode<T> iterator = first;
		first = first.getNext();
		size--;
		return iterator.getObj();
	}

  // Method to remove the last node
	public T deleteLast(){
		MyNode<T> iterator = first;
		MyNode<T> temp = first;
		while(iterator != last){
			temp = iterator;
			iterator = iterator.getNext();
		}
		last = temp;
		last.setNext(null);
		size--;
		return iterator.getObj();
	}

  // Method to remove node given a random index
	public T delete(int index){
		MyNode<T> iterator = first;
		if(index == 0){
			return deleteFront();
		}
		if(index == size-1){
			return deleteLast();
		}
    MyNode<T> temp = new MyNode<T>();
    MyNode<T> temp2 = new MyNode<T>();
		for(int i=0;i<size-1;i++){
			if(i == index-1){
				temp = iterator.getNext();
				temp2 = temp;
				temp = temp.getNext();
				iterator.setNext(temp);
				break;
			}
			iterator = iterator.getNext();
		}
		size--;
		return temp2.getObj();
	}

  // Method to remove node given an object
  public T remove(T obj){
    for(int i=0;i<size;i++){
      if(obj.equals(elementAt(i))){
        return delete(i);
      }
    }
    return null;
  }

  // Method to get object at given index from the list
	public T elementAt(int index){
		MyNode<T> iterator = first;
		if(iterator == null){
			System.out.println("EMPTY LIST\n");
			return null;
		}
		if(iterator.getNext() == null){
			return iterator.getObj();
		}
		for(int i=0;i<index && iterator.getNext() != null && i<size;i++){
			iterator = iterator.getNext();
		}
		return iterator.getObj();
	}

  // Method to check if given object is in the list
  public Boolean contains(T obj){
    for(int i=0;i<size;i++){
      if(obj.equals(elementAt(i))){
        return true;
      }
    }
    return false;
  }

  // Method to copy elements from a given list
  public void addAll(MyLinkedList<T> list){
    for(int i=0;i<list.getSize();i++){
      addLast(list.elementAt(i));
    }
    return;
  }

	/*
  public static void main(String[] args) {
    MyLinkedList<Integer> list = new MyLinkedList<Integer>();

    list.addLast(2);
    list.addFront(1);
    list.addLast(3);
    list.addLast(5);
    list.addLast(6);
    list.insert(4,3);
    for(int i=0;i<list.getSize();i++){
      System.out.println(list.elementAt(i));
    }
    System.out.println("");
    list.deleteFront();
    list.deleteLast();
    list.delete(2);
    for(int i=0;i<list.getSize();i++){
      System.out.println(list.elementAt(i));
    }
    System.out.println("\n"+list.contains(2));
    System.out.println(list.contains(4));

    MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
    list2.addLast(2);
    list2.addFront(1);
    list2.addLast(3);
    list2.addLast(5);
    list2.addLast(6);
    list2.insert(4,3);
    list.addAll(list2);
    System.out.println("");
    for(int i=0;i<list.getSize();i++){
      System.out.println(list.elementAt(i));
    }
  }
	*/

}
