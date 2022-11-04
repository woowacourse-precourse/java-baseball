package baseball;

import java.util.List;

public class Output {

  public void printStrikeBall(List<Integer> strikeBall) {
    if (strikeBall.get(0) == 0 && strikeBall.get(1) == 0) {
      System.out.println("낫싱");
    }
    exceptNothing(strikeBall);
  }

  private void exceptNothing(List<Integer> strikeBall) {
    if (strikeBall.get(1) != 0 && strikeBall.get(0) == 0) {
      System.out.println(strikeBall.get(1) + "볼");
    } else if (strikeBall.get(1) == 0 && strikeBall.get(0) != 0) {
      System.out.println(strikeBall.get(0) + "스트라이크");
    } else if (strikeBall.get(1) != 0 && strikeBall.get(0) != 0) {
      System.out.println(strikeBall.get(1) + "볼 " + strikeBall.get(0) + "스트라이크");
    }
  }
}
