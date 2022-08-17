import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts=new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
       Account from= accounts.get(fromAccountNum);
       Account to = accounts.get(toAccountNum);


       if(from.isBlocked()|| to.isBlocked()){
           return;
       }

       if(amount>50000){
           try {
               if(isFraud(fromAccountNum,toAccountNum,amount)){
                   from.block();
                   to.block();
                   return;
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }

      synchronized (from){
         synchronized (to){
           from.setMoney(from.getMoney()-amount);
           to.setMoney(to.getMoney()+amount);
         }
      }
}

    public long getBalance(String accountNum) {

        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        long sum=0;
        for (Map.Entry<String, Account> entry: accounts.entrySet()){
            sum+=entry.getValue().getMoney();
        }
        return sum;
    }
    public void addAccount(String accNumber, Long money){
      Account account=new Account();
      account.setAccNumber(accNumber);
      account.setMoney(money);
      accounts.put(accNumber, account);
    }


}
