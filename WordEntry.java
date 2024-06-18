import java.util.*;
import java.io.*;

public class WordEntry{

  public String word;
  public MyLinkedList<Position> allPositions = new MyLinkedList<Position>();

  // WordEntry class Constructor
  public WordEntry(String str){
    word = str;
  }

  // WordEntry class Constructor
  public WordEntry(WordEntry w){
    word = w.word;
    allPositions.addAll(w.allPositions);
  }

  // Method to add postion entry for the word
  public void addPosition(Position p){
    allPositions.addLast(p);
  }

  // Method to add multiple postion entries for the word
  public void addPositions(MyLinkedList<Position> listP){
    allPositions.addAll(listP);
  }

  // Method to get all position entries of the word
  public MyLinkedList<Position> getAllPositionsForThisWord(){
    return allPositions;
  }

}
