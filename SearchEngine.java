import java.util.*;
import java.io.*;

public class SearchEngine{

	public InvertedPageIndex invPageIndex;
	public MyLinkedList<String> addedPages = new MyLinkedList<String>();

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	// SearchEngine class Constructor
	public SearchEngine(){
		invPageIndex = new InvertedPageIndex();
	}

	public void performAction(String actionMessage){
		String[] parsedMessage = actionMessage.split("\\s+");
		System.out.println(ANSI_BLUE + actionMessage + ": " + ANSI_RESET);
		if(parsedMessage[0].equals("addPage")){
			if(!addedPages.contains(parsedMessage[1].toLowerCase())){
				invPageIndex.addPage(new PageEntry(parsedMessage[1].toLowerCase()));
				addedPages.addLast(parsedMessage[1].toLowerCase());
			}
			else{
				System.out.println(ANSI_RED + "Webpage " + ANSI_YELLOW + parsedMessage[1] + ANSI_RED + " has already been added" + ANSI_RESET);
			}
		}
		else if(parsedMessage[0].equals("queryFindPagesWhichContainWord")){
			MySet<PageEntry> pagesList = invPageIndex.getPagesWhichContainWord(parsedMessage[1].toLowerCase());
			if(pagesList == null){
				System.out.println(ANSI_RED + "No webpage contains word " + ANSI_YELLOW + parsedMessage[1].toLowerCase() + ANSI_RESET);
				System.out.println("");
				return;
			}
			for(int i=0;i<pagesList.myList.getSize();i++){
				if(i != pagesList.myList.getSize() - 1){
					System.out.print(ANSI_PURPLE + pagesList.myList.elementAt(i).pageName + ", " + ANSI_RESET);
				}
				else{
					System.out.print(ANSI_PURPLE + pagesList.myList.elementAt(i).pageName + " " + ANSI_RESET);
				}
			}
			System.out.print("\n");
		}
		else if(parsedMessage[0].equals("queryFindPositionsOfWordInAPage")){
			MyLinkedList<Position> allPositionsOfWord = invPageIndex.allWords.getPosition(parsedMessage[1].toLowerCase());
			MyLinkedList<Integer> requiredPositions = new MyLinkedList<Integer>();
			if(allPositionsOfWord != null){
				for(int i=0;i<allPositionsOfWord.getSize();i++){
					if(allPositionsOfWord.elementAt(i).page.pageName.equals(parsedMessage[2].toLowerCase())){
						requiredPositions.addLast(allPositionsOfWord.elementAt(i).wordPosition);
					}
				}
			}
			for(int i=0;i<requiredPositions.getSize();i++){
				if(i != requiredPositions.getSize() - 1){
					System.out.print(ANSI_PURPLE + requiredPositions.elementAt(i) + ", " + ANSI_RESET);
				}
				else{
					System.out.print(ANSI_PURPLE + requiredPositions.elementAt(i) + " " + ANSI_RESET);
				}
			}
			System.out.println("");
			if(requiredPositions.getSize() == 0){
				if(addedPages.contains(parsedMessage[2].toLowerCase())){
					System.out.println(ANSI_RED + "Webpage " + ANSI_YELLOW + parsedMessage[2].toLowerCase() + ANSI_RED + " does not contain word " + ANSI_YELLOW + parsedMessage[1].toLowerCase() + ANSI_RESET);
				}
				else{
					System.out.println(ANSI_RED + "Webpage " + ANSI_YELLOW + parsedMessage[2] + ANSI_RED + " has not been added" + ANSI_RESET);
				}
			}
			/*PageEntry checkPage = new PageEntry(parsedMessage[2].toLowerCase());
			for(int i=0;i<checkPage.index.allWordEntries.getSize();i++){
				if(checkPage.index.allWordEntries.elementAt(i).word.equals(parsedMessage[1].toLowerCase())){
					WordEntry requiredWord = checkPage.index.allWordEntries.elementAt(i);
					for(int j=0;j<requiredWord.allPositions.getSize();j++){
						if(j != requiredWord.allPositions.getSize() - 1){
							System.out.print(requiredWord.allPositions.elementAt(j).wordPosition + ", ");
						}
						else{
							System.out.print(requiredWord.allPositions.elementAt(j).wordPosition + " ");
						}
					}
					System.out.println("");
					break;
				}
			}*/
		}
		else{
			System.out.println("Unknown Query\n");
		}
		System.out.println("");
	}

}
