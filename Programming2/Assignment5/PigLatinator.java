public class PigLatinator {
  
  public static void pigLatin(String userInput, String[] eachWords){
        
    eachWords = userInput.split(" ");
    
    for(int i = 0;  i < eachWords.length; i++){
         String start = eachWords[i].substring(0,1);
         String end = eachWords[i].substring(1, eachWords[i].length());
    
         System.out.print(end + start + "AY ");
    }
  }
  
}
