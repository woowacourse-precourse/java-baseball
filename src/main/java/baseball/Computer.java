package baseball;

import baseball.View.Constant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {

  private ArrayList<Integer> answer;
  private boolean[] alreadyUse;

  public void makeNum() {

    answer = new ArrayList<>();
    alreadyUse = new boolean[Constant.MAX_VALUE + 1];

    int i = 0;
    while (i < Constant.NUMBER_LENGTH) {
      int number = Randoms.pickNumberInRange(1,9);
      if (!alreadyUse[number]) {
        alreadyUse[number] = true;
        answer.add(number);
        i++;
      }
    }
  }

  public ArrayList<Integer> getAnswer() {
    return answer;
  }

}
