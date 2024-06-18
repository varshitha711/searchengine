import java.util.*;
import java.io.*;

public class InvertedPageIndex{

  public MyHashTable allWords = new MyHashTable();

  // Method to add pages
  public void addPage(PageEntry p){
    int wordEntrySize = p.index.allWordEntries.getSize();
    for(int i=0;i<wordEntrySize;i++){
      allWords.addPositionsForWord(p.index.allWordEntries.elementAt(i));
    }
  }

  // Method to find words from pages
  public MySet<PageEntry> getPagesWhichContainWord(String str){
    return allWords.getPages(str);
  }

}
