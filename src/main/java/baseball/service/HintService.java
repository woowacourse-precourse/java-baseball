package baseball.service;

import java.util.List;

public class HintService {

  private final int strikeCount;
  private final int ballCount;

  public HintService(List<Integer> computerNumbers, List<Integer> playerNumbers) {
    this.strikeCount = getStrikeCount(computerNumbers, playerNumbers);
    this.ballCount = getBallCount(computerNumbers, playerNumbers);
  }

  int getStrikeCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
    int strikeCount = 0;
    for (int i = 0; i < computerNumbers.size(); i++) {
      if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
        strikeCount++;
      }
    }
    return strikeCount;
  }
  private int getBallCount(List<Integer> computerNumbers, List<Integer> playerNumbers) {
    int ballCount = 0;
    for (int i = 0; i < computerNumbers.size(); i++) {
      if (hasBall(computerNumbers, playerNumbers, i)) {
        ballCount += 1;
      }
    }
    return ballCount;
  }

  private boolean hasBall(List<Integer> computerNumbers, List<Integer> playerNumbers,
      int i) {
    for (int j = 0; j < playerNumbers.size(); j++) {
      if (i != j && computerNumbers.get(i).equals(playerNumbers.get(j))) {
        return true;
      }
    }
    return false;
  }

  public void printHint() {
    if (strikeCount == 0 && ballCount == 0) {
      System.out.println("끝");
    }
    if (ballCount != 0) {
      System.out.println(ballCount + "볼 ");
    }
    if (strikeCount != 0) {
      System.out.println(ballCount + "스트라이크");
    }
    System.out.println();
  }
}
