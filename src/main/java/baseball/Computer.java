package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
  public List<Integer> answer = new ArrayList<>();

  public Computer(){
    while(answer.size() < 3){
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if(!answer.contains(randomNumber)){
        answer.add(randomNumber);
      }
    }
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
