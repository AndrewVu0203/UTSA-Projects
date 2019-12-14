public class a7main
{
  public static void main(String[] args)
  {
    float balance = (float)(Math.random() * 5000 + 1000);
    float deposit = (float)(Math.random() * 1000);
    float withdrawals = (float)(Math.random() * 1000);
    float rate = 12;
    
    SavingsAccount sv = new SavingsAccount(balance, rate);
   
    System.out.println("Balance original: " + sv.balance);
    sv.deposit(deposit);
    System.out.println("Balance after deposit more: " + sv.balance);
    sv.withdraw(withdrawals);
    System.out.println("Balance after withdrawals out: " + sv.balance);

      
  }
}
