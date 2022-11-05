package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Player {
  private final ArrayList<Integer> numbers;
  private static final int MAX_SIZE = 3;
  private boolean progress;
  public Player(boolean progress){
    this.numbers = new ArrayList<>();
    this.progress = progress;
  };

  public ArrayList<Integer> decideNumbers(){
    String input = Console.readLine();
    String pattern = "^[0-9]*$";
    boolean result = Pattern.matches(pattern, input);

    if(!result) {
      throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
    }
    addNumber(input);
    if(this.numbers.size() != MAX_SIZE){
      throw new IllegalArgumentException("서로 다른 3개의 숫자를 입력해야 합니다.");
    }
    return this.numbers;
  }

  public void addNumber(String input){
    for(int i = 0; i < input.length(); i++){
      int number = Integer.parseInt(String.valueOf(input.charAt(i)));
      if(!this.numbers.contains(number)){
        this.numbers.add(number);
      }
    }
  }
}
