public class a1main extends Coin {
    a1main(){
      super(0);
    }
    
  public static void main(String[] args){
    int balance = 0;
    Coin quarter = new Coin(25);
    Coin dime = new Coin(10);
    Coin nickle = new Coin(5);
    String resultA = "";
    String resultB = "";
    String resultC = "";
 
    while(balance < 100){
      resultA = quarter.getSideUp();
      resultB = dime.getSideUp();
      resultC = nickle.getSideUp();
      if(resultA == "heads"){
        balance = balance + quarter.typesOfCoin;
      }
      if(resultB == "heads"){
        balance = balance + dime.typesOfCoin;
      }if(resultC == "heads"){
        balance = balance + nickle.typesOfCoin;
      }
    }
    
    System.out.println("Current balance is: " + balance);
    if(balance == 100){
      System.out.println("Win because balance is 1 USD");
    }
    else if(balance > 100){
      System.out.println("Lose because balance is over 1 USD");
    }
    
  }
}
