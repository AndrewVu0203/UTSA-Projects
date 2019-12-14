public class PreferredCustomer extends Customer{
  public int amountPurchase;
  public int amountDiscount;
  
  public PreferredCustomer(){
    amountPurchase = 0;
    amountDiscount = 0;
  }
  
  public PreferredCustomer(int amountPurchase, int amountDiscount){
    this.amountPurchase = amountPurchase;
    this.amountDiscount = amountDiscount;
  }
  public void setAmountPurchase(int amountPurchase){
    this.amountPurchase = amountPurchase;
  }
  public void setAmountDiscount(int amountDiscount){
    this.amountDiscount = amountDiscount;
  }
  public int getAmountPurchase(){
    return amountDiscount;
  }
  public int getAmountDiscount(){
    return amountPurchase;
  }
  
  public void howMuchDiscount(int amountPurchase){
    switch(amountPurchase){
      case 500: setAmountDiscount(5);
      break;
      case 1000: setAmountDiscount(6);
      break;
      case 1500: setAmountDiscount(7);
      break;
      case 2000: setAmountDiscount(10);
      break;
    }
    System.out.println("% of discount this customer can get is: " + amountDiscount + "% on future purchase");
  }
  
}
