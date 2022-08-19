import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class Movements {

  List<Double> income;
  List<Double> expense;
  List<Line> table;

  public Movements(String pathMovementsCsv) {
    this.income = new ArrayList<>();
    this.expense = new ArrayList<>();
    this.table=new ArrayList<>();
    try {
      Reader csvData = new FileReader(pathMovementsCsv);
      CSVParser parser = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(csvData);
      for (CSVRecord csvRecord : parser) {
        Double incomeValue = Double.parseDouble(csvRecord.get("Приход").replace(",", "."));
        Double expenseValue = Double.parseDouble(csvRecord.get("Расход").replace(",", "."));
        income.add(incomeValue);
        expense.add(expenseValue);
        if (expenseValue!=0.0){
        String operationInfo= csvRecord.get("Описание операции").replaceAll("[0-9]| +|\\+*|\\.*", "")
            .replaceAll("/", " ").replaceAll("\\\\", " ").split("\\.")[0];

        table.add(new Line(operationInfo,expenseValue));
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
  public Map<String, Double> getGroupExpence(){
    Map<String, Double> map = new TreeMap<>();
    for(Line line:this.table){
      String key= line.getNameOfOperation();
      if (map.containsKey(key)){
        map.put(key, map.get(key).intValue()+line.getExpense());
      } else {
        map.put(key, line.getExpense());
      }
    }
    return map;
  }


  public double getExpenseSum() {
    double expenseSum = 0.0;
    for (Double aDouble : this.expense) {
      expenseSum += aDouble;
    }
    return expenseSum;
  }

  public double getIncomeSum() {
    double incomeSum = 0.0;
    for (Double aDouble : this.income) {
      incomeSum += aDouble;
    }
    return incomeSum;
  }
}
