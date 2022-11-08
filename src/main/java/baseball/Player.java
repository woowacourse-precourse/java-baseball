package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Player {
  private ArrayList<Integer> numbers;
  private static final int MAX_SIZE = 3;
  public static final int RESTART = 1;
  public static final int EXIT = 2;

  public String inputNumbers(){
    System.out.print("숫자를 입력해주세요 : ");
    return Console.readLine();
  }

  public String inputGameStatusData(){
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    return String.valueOf(Console.readLine());
  }

  public void decideNumbers(String input){
    validateConsistsOfNumber(input);
    validateNumberLength(input);
    addNumber(input);
    validateOverlap();
  }

  public void addNumber(String input){
    this.numbers = new ArrayList<>();

    for(int i = 0; i < input.length(); i++){
      int number = Integer.parseInt(String.valueOf(input.charAt(i)));
      if(!this.numbers.contains(number)){
        this.numbers.add(number);
      }
    }
  }

  public void validateConsistsOfNumber(String input){
    String pattern = "^[0-9]*$";
    boolean result = Pattern.matches(pattern, input);

    if(!result) {
      throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
    }
  }

  public void validateNumberLength(String input){
    if(input.length() != MAX_SIZE){
      throw new IllegalArgumentException("3개의 숫자만 입력할 수 있습니다.");
    }
  }

  public void validateOverlap(){
    if(this.numbers.size() != MAX_SIZE){
      throw new IllegalArgumentException("중복된 숫자가 있으면 안됩니다.");
    }
  }

  public int validateGameStatusData(String input){
    try{
      int result = Integer.parseInt(input);
      if(result != RESTART && result != EXIT){
        throw new RuntimeException();
      }
      return result;
    }catch(Exception e){
      throw new IllegalArgumentException("0 또는 1을 입력해야 합니다.");
    }
  }

  public ArrayList<Integer> getNumbers(){
    return this.numbers;
  }
}
