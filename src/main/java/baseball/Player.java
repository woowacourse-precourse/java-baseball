package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Player {
  private ArrayList<Integer> numbers;
  private static final int MAX_SIZE = 3;
  public Player(){};

  public ArrayList<Integer> decideNumbers(String input){
    System.out.print("숫자를 입력해주세요 : ");
    //String input = "122";
    validateConsistsOfNumber(input);
    addNumber(input);
  }

  public void addNumber(String input){
    this.numbers = new ArrayList<>();

    for(int i = 0; i < input.length(); i++){
      int number = Integer.parseInt(String.valueOf(input.charAt(i)));
      if(!this.numbers.contains(number)){
        this.numbers.add(number);
      }
    }

    if(this.numbers.size() != MAX_SIZE){
      System.out.println(this.numbers);
      throw new IllegalArgumentException("중복된 숫자가 있으면 안됩니다.");
    }
  }

  public void validateConsistsOfNumber(String input){
    String pattern = "^[0-9]*$";
    boolean result = Pattern.matches(pattern, input);

    if(!result) {
      throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
    }
  }
}
