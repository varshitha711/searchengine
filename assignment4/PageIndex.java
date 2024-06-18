import java.util.*;
import java.io.*;

public class PageIndex{

  public MyLinkedList<WordEntry> allWordEntries = new MyLinkedList<WordEntry>();

  // Method to add WordEntry to a Page
  public void addPostionForWord(String str,Position p){
    for(int i=0;i<allWordEntries.getSize();i++){
      if(allWordEntries.elementAt(i).word.equals(str)){
        allWordEntries.elementAt(i).addPosition(p);
        return;
      }
    }
    WordEntry newWord = new WordEntry(str);
    newWord.addPosition(p);
    allWordEntries.addLast(newWord);
    return;
  }

  // Method to get all WordEntries of a page
  public MyLinkedList<WordEntry> getWordEntries(){
    return allWordEntries;
  }

}
