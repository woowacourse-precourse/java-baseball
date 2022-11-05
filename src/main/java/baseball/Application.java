package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
  public static void main(String[] args) {
    setInput();
  }

  private static void setInput() {
    List<Integer> computerNumberGroup = setComputerNumberGroup();
    List<Integer> myNumberGroup = setMyNumberGroup();
    System.out.println(computerNumberGroup);
    System.out.println(myNumberGroup);
  }

  private static List<Integer> setComputerNumberGroup() {
    List<Integer> computerNumberGroup = new ArrayList<>();
    while (computerNumberGroup.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computerNumberGroup.contains(randomNumber)) {
        computerNumberGroup.add(randomNumber);
      }
    }
    return computerNumberGroup;
  }

  private static List<Integer> setMyNumberGroup(){
    List<Integer> myNumberGroup = Arrays.asList();
    String myNumberGroupByString = inputMyNumberGroupByString();
    if(isValidMyInput(myNumberGroupByString)){
      myNumberGroup = changeStringToList(myNumberGroupByString);
    }
    return myNumberGroup;
  }

  private static String inputMyNumberGroupByString() {
    String myNumberGroupByString = Console.readLine();
    return myNumberGroupByString;
  }

  private static boolean isValidMyInput(String inputNumberString) {
    if (!isValidLength(inputNumberString)) {
      throw new IllegalArgumentException("세자리가 아님");
    }
    if (!isNumeric(inputNumberString)) {
      throw new IllegalArgumentException("숫자가 아닌 문자 입력");
    }
    if (!isAnotherNumber(inputNumberString)) {
      throw new IllegalArgumentException("중복된 수 입력");
    }
    return true;
  }

  private static boolean isValidLength(String inputNumberString) {
    if (inputNumberString.length() == 3) {
      return true;
    } else
      return false;
  }

  private static boolean isNumeric(String inputNumberString) {
    try {
      Double.parseDouble(inputNumberString);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  private static boolean isAnotherNumber(String inputNumberString) {
    List<Character> inputNumberStringList = new ArrayList<>();
    for (char number : inputNumberString.toCharArray()) {
      inputNumberStringList.add(number);
    }
    Set<Character> inputNumberStringSet = new HashSet<>(inputNumberStringList);
    if (inputNumberStringList.size() != inputNumberStringSet.size()) {
      return false;
    }
    return true;
  }

  private static List<Integer> changeStringToList(String inputNumberString) {
    List<Integer> inputNumberList = new ArrayList<>();
    for(char number: inputNumberString.toCharArray()){
      inputNumberList.add(Character.getNumericValue(number));
    }
    return inputNumberList;
  }

  private static List<Integer> sortList(List<Integer> list){
    Collections.sort(list);
    return list;
  }
}

