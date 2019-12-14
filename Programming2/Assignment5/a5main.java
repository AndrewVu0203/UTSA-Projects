import java.util.*;

public class a5main {
  
  public  static void main (String[] args){
    PigLatinator pigLatinator = new PigLatinator();
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> list = new ArrayList<String>();
    String userInput;
    String[] eachWords;

    userInput = scanner.nextLine();
    eachWords = userInput.split(" ");
  
    PigLatinator.pigLatin(userInput, eachWords);
  }
}
