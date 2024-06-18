import java.util.*;
import java.io.*;

public class PageEntry{

  public String pageName;
  public PageIndex index;
  public static String[] connectorWords = {"a","an","the","they","these","this","for","is","are","was","of","or","and","does","will","whose"};

  // PageEntry class Constructor
  public PageEntry(String name){
    pageName = name;
    buildPageIndex();
  }

  // Method to build the PageIndex for the given pageName
  public void buildPageIndex(){
    index = new PageIndex();
    String line;
    String word;
    int wordCount = 1;
    try{
      BufferedReader br = new BufferedReader(new FileReader("./webpages/" + pageName));
      while((line = br.readLine()) != null){
        String[] parsedLine = line.replace('{',' ').replace('}',' ').replace('[',' ').replace(']',' ').replace('<',' ').replace('>',' ').replace('=',' ').replace('(',' ').replace(')',' ').replace('.',' ').replace(',',' ').replace(';',' ').replace('"',' ').replace('?',' ').replace('#',' ').replace('!',' ').replace('-',' ').replace(':',' ').replaceAll("'"," ").split("\\s+");
        if(parsedLine.length == 1 && parsedLine[0].equals("")){
          continue;
        }
        for(int i=0;i<parsedLine.length;i++){
          word = parsedLine[i].toLowerCase();
          //System.out.print(word + " ");
          Boolean connectorWordsFlag = false;
          for(int j=0;j<connectorWords.length;j++){
            if(connectorWords[j].equals(word)){
              connectorWordsFlag = true;
              break;
            }
          }
          if(!connectorWordsFlag){
            if(word.equals("stacks") || word.equals("structures") || word.equals("applications")){
              index.addPostionForWord(word.substring(0,word.length() - 1),new Position(this,wordCount));
            }
            else{
              index.addPostionForWord(word,new Position(this,wordCount));
            }
          }
          wordCount++;
        }
      }
      System.out.print(SearchEngine.ANSI_GREEN + "Page has been read successfully" + SearchEngine.ANSI_RESET);
    }
    catch(Exception ex){
      System.out.print(SearchEngine.ANSI_RED + "File Not Found" + SearchEngine.ANSI_RESET);
    }
    System.out.println("");
  }

}
