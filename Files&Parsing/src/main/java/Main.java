

public class Main {
    public static String PATH = "movementList.csv";

    public static void main(String[] args) {
        Movements movements = new Movements(PATH);
        System.out.println("Сумма расходов: " + movements.getExpenseSum());
        System.out.println("Сумма доходов: " + movements.getIncomeSum());
        System.out.println("Сумма расходов по организации: ");
        movements.getGroupExpence().forEach((k,v)-> System.out.printf("%s - %,.2fруб.\n", k, v));


    }
    }

