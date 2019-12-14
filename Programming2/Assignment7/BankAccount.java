public abstract class BankAccount{
  
  float balance;
  float numDeposits;
  float numWithdrawals;
  float annualRate;
  float monthlyCharge;
  
  public BankAccount()
  {
    balance = 0;
    numDeposits = 0;
    numWithdrawals = 0;
    annualRate = 0;
    monthlyCharge = 0;
  }
  public BankAccount(float balance, float annualRate)
  {
    this.balance = balance;
    this.annualRate = annualRate;
  }
  public void deposit(float money)
  {
    balance = balance + money;
    numDeposits++;
  }
  public void withdraw(float money)
  {
    balance = balance - money;
    numWithdrawals++;
  }
  //
  public void calcInterest()
  {
    float monRate = annualRate / 12;
    float monInt = balance * monRate;
    balance += monInt;
  }
  public void monthlyProcess()
  {
    balance -= monthlyCharge;
    calcInterest();
    numWithdrawals = 0;
    numDeposits = 0;
    monthlyCharge = 0;
  }
}