package baseball;

import baseball.View.Constant;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

  private int[] answer;
  private boolean[] alreadyUse;

  public void makeNum() {

    answer = new int[Constant.NUMBER_LENGTH];
    alreadyUse = new boolean[Constant.MAX_VALUE + 1];

    int i = 0;
    while (i < Constant.NUMBER_LENGTH) {
      int number = Randoms.pickNumberInRange(1,9);
      if (!alreadyUse[number]) {
        alreadyUse[number] = true;
        answer[i] = number;
        i++;
      }
    }
  }

  public int[] getAnswer() {
    return answer;
  }

}
