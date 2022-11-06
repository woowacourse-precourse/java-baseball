package baseball.number;

public class NumberList {
  private static final Integer NUMBER_LIST_SIZE = 3;
  private final Number[] numberList;

  public NumberList() {
    this.numberList = new Number[NUMBER_LIST_SIZE];
  }

  public Number[] getNumberList() {
    return this.numberList;
  }
}
