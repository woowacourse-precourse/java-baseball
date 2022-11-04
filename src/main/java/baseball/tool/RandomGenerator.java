package baseball.tool;

import baseball.dataStorage.DataStorage;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

  public void makeRandomNumber() {
    List<Integer> solution = new ArrayList<>();
    while (solution.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!solution.contains(randomNumber)) {
        solution.add(randomNumber);
      }
    }
    DataStorage.setSolution(solution);
  }

}
