package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class MyNumber {
  private List<Integer> myNumber;

  public MyNumber() {
    myNumber = new ArrayList<>();
  }

  private void init() {
    myNumber.clear();
  }

  public void setMyNumber(String inputNumberString) {
    init();
    myNumber = changeStringToList(inputNumberString);
  }

  private List<Integer> changeStringToList(String inputNumberString) {
    List<Integer> inputNumberList = new ArrayList<>();
    for (char number : inputNumberString.toCharArray()) {
      inputNumberList.add(Character.getNumericValue(number));
    }
    return inputNumberList;
  }

  public List<Integer> getMyNumber() {
    return myNumber;
  }
}
