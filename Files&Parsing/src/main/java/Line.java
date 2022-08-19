public class Line {
  private  String nameOfOperation;
  private Double expense;

  public Line(String nameOfOperation, Double expense) {
    this.nameOfOperation = nameOfOperation;
    this.expense = expense;
  }

  public String getNameOfOperation() {
    return nameOfOperation;
  }

  public Double getExpense() {
    return expense;
  }

  }

