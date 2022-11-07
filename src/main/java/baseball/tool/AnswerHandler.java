package baseball.tool;

import baseball.dataStorage.DataStorage;
import java.util.List;

public class AnswerHandler {

  private List<Integer> solution;
  private List<Integer> awnserList;

  public boolean isStrike() {
    return DataStorage.getCountStrike() == 3;
  }

  public void calcResult() {
    DataStorage.resetResult();
    solution = DataStorage.getSolution();
    awnserList = DataStorage.getAnswer();
    for (int i = 0; i < awnserList.size()&&i<solution.size(); i++) {
      if (awnserList.get(i).equals(solution.get(i))) {
        DataStorage.countOneStrike();
      } else {
        checkBall(i);
      }
    }
  }

  private void checkBall(int index) {
    for (int k : solution) {
      if (awnserList.get(index) == k) {
        DataStorage.countOneBall();
        break;
      }
    }
  }
}
