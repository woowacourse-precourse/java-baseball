package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;


public class Computer {

  private final List<Integer> answer;

  public Computer() {
    this.answer = new ArrayList<>(3);
  }

  public void setAnswer() {
    while (answer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!answer.contains(randomNumber)) {
        answer.add(randomNumber);
      }
    }
  }

  public Integer getEachNumber(int index) {
    return answer.get(index);
  }

  public List<Integer> getAnswer(){
    return answer;
  }

}
