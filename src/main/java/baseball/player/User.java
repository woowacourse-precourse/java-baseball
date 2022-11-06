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
    putInputValueInList(input);
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
