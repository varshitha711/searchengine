import java.util.*;
import java.io.*;

public class Position{

  public final PageEntry page;
  public final int wordPosition;

  // Position class Constructor
  public Position(PageEntry p,int i){
    page = p;
    wordPosition = i;
  }

  // Method to return PageEntry
  public PageEntry getPageEntry(){
    return page;
  }

  // Method to return wordPosition
  public int getWordIndex(){
    return wordPosition;
  }

  // Method to check if given Position is identical
  public boolean equals(Position p){
    return page.equals(p.getPageEntry()) && wordPosition == p.getWordIndex();
  }

}
