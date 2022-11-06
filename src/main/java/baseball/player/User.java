package baseball.player;

import baseball.utils.Regex;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class User {
  private List<Integer> user = new ArrayList<>();

  public void inputClear(){
    user.clear();
  }

  public void createUserInput(){
    String input = Console.readLine();
    isValidInputValue(input);
    putInputValueInList(input);
  }

  public void isValidInputValue(String input) {
    if(!Regex.getRegexMatcherResult("^[1-9]{1,3}$", input)){
      throw new IllegalArgumentException("invalid user input");
    }
  }

  public void putInputValueInList(String input){
    String[] strList = input.split("");

    for(String s : strList) {
      user.add(stringToInt(s));
    }
  }

  public Integer stringToInt(String s) {
    return Integer.valueOf(s);
  }

  public List<Integer> getUserList(){
    return this.user;
  };

}
