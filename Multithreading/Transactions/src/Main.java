import com.sun.jdi.connect.spi.ClosedConnectionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {


  public static void main(String[] args) {

    Bank bank = new Bank();

    for (int i = 0; i < 10_000; i++) {
      bank.addAccount("408" + i, (long) (10_000 + Math.random() * 10_000));
       }

    long amountStart = bank.getSumAllAccounts();
    System.out.println("Всего денег в банке в начале - " + bank.getSumAllAccounts());

    List<Thread> threadList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      threadList.add(
          new Thread(() -> {
            System.out.println("Старт поток: " + Thread.currentThread().getName());
            String from = "408" + (int) (Math.random() * 10000);
            String to = "408" + (int) (Math.random() * 10000);
            long amount = (long) (Math.random() * 6000);
            for (int t = 0; t < 10_000; t++) {
              try {
                bank.transfer(from, to, amount);
                  } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }

            System.out.println("Стоп поток: " + Thread.currentThread().getName());
          })
      );
    }


    threadList.forEach(Thread::start);


    boolean isAlive = true;
    while (isAlive) {
      isAlive = threadList.stream().filter((t) -> t.isAlive()).count() > 0;
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }


    System.out.println("Всего денег в банке после переводов - " + bank.getSumAllAccounts());
    System.out.println("Отличие на - " + (amountStart - bank.getSumAllAccounts()));

  }
}
