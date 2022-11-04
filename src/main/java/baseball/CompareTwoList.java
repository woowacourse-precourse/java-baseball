package baseball;

import java.util.ArrayList;
import java.util.List;

public class CompareTwoList {

  public List<Integer> compareLists(List<Character> users, List<Character> computers) {
    List<Integer> strikeBall = new ArrayList<>();
    strikeBall.add(0, checkIndexStrike(users, computers));
    strikeBall.add(1, checkIndexBall(users, computers));
    return strikeBall;
  }

  private int checkIndexStrike(List<Character> user, List<Character> computers) {
    int strike = 0;
    for (int i = 0; i < user.size(); i++) {
      if (user.get(i) == computers.get(i)) {
        strike++;
      }
    }
    return strike;
  }

  private int checkIndexBall(List<Character> user, List<Character> computers) {
    int ball = 0;
    if (user.get(0) == computers.get(1) || user.get(0) == computers.get(2)) {
      ball++;
    }
    if (user.get(1) == computers.get(0) || user.get(1) == computers.get(2)) {
      ball++;
    }
    if (user.get(2) == computers.get(0) || user.get(2) == computers.get(1)) {
      ball++;
    }
    return ball;
  }
}
