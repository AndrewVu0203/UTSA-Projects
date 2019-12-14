import java.io.*; 
import java.util.*; 

public class a2main {
  static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args){
    checkArray();
  }
  
  public static ArrayList<String> accessingFileIntoArray(){   
   
    ArrayList<String> result = new ArrayList<String>();
    try{
      File file = new File("WorldSeriesWinners.txt");
      Scanner inputFile = new Scanner(file);
      while(inputFile.hasNextLine()){
        // put value into ArrayList result
        result.add(inputFile.nextLine());
      }
    }
    catch(FileNotFoundException e){
      System.out.println("File not found, error is: " + e);  
    }    
    return result;
  }
  
  public static void checkArray(){
    int howManyTimes = 0;
    ArrayList<String> result = new ArrayList<String>();
    String userInput = scanner.nextLine();
        
    result = accessingFileIntoArray();
     
    for(int i = 0 ; i < result.size(); i++){ 
      if(result.get(i).equals(userInput)){ 
        howManyTimes = howManyTimes + 1;
      }
    }
    
    System.out.println(howManyTimes);
  }
  
}


