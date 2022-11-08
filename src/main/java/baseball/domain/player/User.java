package baseball.domain.player;

import baseball.utils.Input;
import baseball.utils.Regex;
import java.util.ArrayList;
import java.util.List;

public class User {
  private List<Integer> user = new ArrayList<>();

  private void init(){
    user.clear();
  }

  public void createUserInput(){
    init();
    Input input = new Input();
    isValidInputValue(input.getInput());
    putInputValueInList(input.toIntList());
  }

  private void isValidInputValue(String input) {
    if(!Regex.getRegexMatcherResult("^[1-9]{1,3}$", input)){
      throw new IllegalArgumentException("invalid user input");
    }
  }

  private void putInputValueInList(int[] numList){
    for(int num : numList) {
      user.add(num);
    }
  }

  public List<Integer> getUserNumberList(){
    return this.user;
  };

}
