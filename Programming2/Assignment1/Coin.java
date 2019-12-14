import java.util.Random;

public class Coin {
  String sideup = "a";
  int typesOfCoin;
  
    public Coin(int typesOfCoin){
        this.typesOfCoin = typesOfCoin; 
        sideup = "heads";
        sideup = "tails";
    }
    public void toss(){
        Random random = new Random();
        if(random.nextInt(2) == 0){
          sideup = "heads";
        }
        else{
          sideup = "tails";
        }
    }
    public String getSideUp(){
      toss();
       return sideup;
    }
    
  public static void main(String[] args){
    int heads = 0;
    int tails = 0;
    Coin coin = new Coin(0);
    
    String result = "";
    for(int i = 0 ; i < 20; i++){
      result = coin.getSideUp();
      if(result == "heads"){
        heads++;
      }
      else{
        tails++;
      }
    }

    System.out.println("Current side: " + result);
    System.out.println("No. of heads: " + heads);
    System.out.println("No. of tails: " + tails);

  }
  
}
