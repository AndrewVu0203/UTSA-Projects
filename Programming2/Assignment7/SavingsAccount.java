public class SavingsAccount extends BankAccount
{
  private boolean active;
  
  public SavingsAccount(float bal, float rate)
  {
    super(bal, rate);
    if(bal < 25)
      active = false;
    else
      active = true;
  }
  public void withdraw(float amount)
  {
    if(active)
      super.withdraw(amount);
  }
  public void deposit(float amount)
  {
    if(!active)
    {
      if(amount + balance < 25)
        return;
    }
    super.deposit(amount);
  }
  public void monthlyProcess()
  {
    if(numWithdrawals > 4)
    {
      monthlyCharge += numWithdrawals - 4;
    }
    super.monthlyProcess();
    if(balance < 25)
      active = false;
  }
}
