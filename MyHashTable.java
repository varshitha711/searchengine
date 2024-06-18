import java.util.*;
import java.io.*;

public class MyHashTable{

  private MyLinkedList<WordEntry>[] wordEntryBucket;

  // MyHashTable class Constructor
  public MyHashTable(){
    wordEntryBucket = (MyLinkedList<WordEntry>[])new MyLinkedList[100];
    for(int i=0;i<100;i++){
      wordEntryBucket[i] = new MyLinkedList<WordEntry>();
    }
  }

  // Hash Function
  private int getHashIndex(String str){
    int hashCode = 0;
    int strLength = str.length();
    char[] strCharArray = str.toCharArray();
    for(int i=0;i<strLength;i++){
      hashCode += strCharArray[i]*37^(strLength - i - 1);
    }
    return hashCode%100;
  }

  // Method to add WordEntries
  public void addPositionsForWord(WordEntry w){
    int wordIndex = getHashIndex(w.word);
    if(wordEntryBucket[wordIndex] != null){
      for(int i=0;i<wordEntryBucket[wordIndex].getSize();i++){
        WordEntry iterator = wordEntryBucket[wordIndex].elementAt(i);
        if(iterator.word.equals(w.word)){
          iterator.allPositions.addAll(w.allPositions);
          return;
        }
      }
    }
    WordEntry newWord = new WordEntry(w);
    wordEntryBucket[wordIndex].addLast(newWord);
    return;
  }

  // Method to search for given String
  public MySet<PageEntry> getPages(String str){
    int wordIndex = getHashIndex(str);
    if(wordEntryBucket[wordIndex] != null){
      for(int i=0;i<wordEntryBucket[wordIndex].getSize();i++){
        WordEntry iterator = wordEntryBucket[wordIndex].elementAt(i);
        if(iterator.word.equals(str)){
          MySet<PageEntry> pages = new MySet<PageEntry>();
          for(int j=0;j<iterator.getAllPositionsForThisWord().getSize();j++){
            pages.addElement(iterator.getAllPositionsForThisWord().elementAt(j).getPageEntry());
          }
          return pages;
        }
      }
    }
    return null;
  }

  // Method to get all positions of given word
  public MyLinkedList<Position> getPosition(String str){
    int wordIndex = getHashIndex(str);
    if(wordEntryBucket[wordIndex] != null){
      for(int i=0;i<wordEntryBucket[wordIndex].getSize();i++){
        WordEntry iterator = wordEntryBucket[wordIndex].elementAt(i);
        if(iterator.word.equals(str)){
          return iterator.allPositions;
        }
      }
    }
    return null;
  }

}
