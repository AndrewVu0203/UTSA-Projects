public class Customer extends Person{
  private int CustomerNumber;
  private boolean mailingList;
  
  public Customer(){
    this.CustomerNumber = 0;
    this.mailingList = false;
  }
  
  public Customer(int number, boolean list){
    this.CustomerNumber = number;
    this.mailingList = list;
  }
  
  public void setCustomerNumber(int number){
    this.CustomerNumber = number;
  }
  public void setMailingList(boolean list){
    this.mailingList = list;
  }  
  public int getCustomerNumber(){
    return CustomerNumber;
  }
  
  public boolean getMailingList(){
    return mailingList;
  }
   public String toString() {
     return "\nCustomer Information" + "\nCustomer Number: " + CustomerNumber + "\nCustomer Name: " + name + "\nCustomer Address: " + address + "\nCustomer Telephone #: " + telephone + "\nIs on mailing list? " + mailingList;
   }
  
  
  
}