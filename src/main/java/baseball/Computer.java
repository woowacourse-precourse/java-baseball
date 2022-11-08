package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
  public List<Integer> answer = new ArrayList<>();
  static String STRIKE = "%d스트라이크";
  static String BALL = "%d볼";
  static String NOTHING = "낫싱";

  public Computer(){
    while(answer.size() < 3){
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if(!answer.contains(randomNumber)){
        answer.add(randomNumber);
      }
    }
  }

  public String state(String input){
    if(isNothing(input)){
      return NOTHING;
    }
    String result = "";
    if(getBallCount(input) > 0){
      result += String.format(BALL, getBallCount(input));
    }
    if(getStrikeCount(input) > 0){
      if(!result.isEmpty()){
        result += " ";
      }
      result += String.format(STRIKE, getStrikeCount(input));
    }

    return result;
  }

  public boolean isNothing(String input){
    for(int i = 0; i<answer.size(); i++){
      if(answer.contains(input.charAt(i) - '0')){
        return false;
      }
    }
    return true;
  }

  public boolean isStrike(int number, int index){
    if(answer.get(index) == number){
      return true;
    }
    return false;
  }
  public boolean isBall(int number, int index){
    if(!isStrike(number, index)){
      if(answer.contains(number)){
        return true;
      }
    }
    return false;
  }
  public int getBallCount(String input){
    int count = 0;
    for(int i=0; i<answer.size(); i++){
      int number = input.charAt(i) - '0';
      if(isBall(number, i)){
        count += 1;
      }
    }
    return count;
  }

  public int getStrikeCount(String input){
    int count = 0;
    for(int i=0; i<answer.size(); i++){
      int number = input.charAt(i) - '0';
      if(isStrike(number, i)){
        count += 1;
      }
    }
    return count;
  }

  public boolean isGameOver(String input){
    for(int i = 0; i<answer.size(); i++){
      if(answer.get(i) != input.charAt(i)){
        return false;
      }
    }
    return true;
  }

}
