package baseball.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import baseball.view.View;

public class Judgement {
  private final int MAX_NUMBER_SIZE = 3;
  private int strikeCount;
  private int ballCount;
  private static final int INIT_COUNT = 0;
  //private final HashMap<String, Integer> STRIKE_AND_BALL;

  Judgement() {
    init();
  }

  private void init() {
    strikeCount = INIT_COUNT;
    ballCount = INIT_COUNT;
  }

  private List<Integer> sortList(List<Integer> list) {
    Collections.sort(list);
    return list;
  }

  private List<Integer> getSameNumbers(List<Integer> myNumbers, List<Integer> computerNumbers) {
    List<Integer> sameNumberList = new ArrayList<>();
    for (int numberIndex = 0; numberIndex < MAX_NUMBER_SIZE; numberIndex++) {
      if (myNumbers.get(numberIndex).equals(computerNumbers.get(numberIndex))) {
        sameNumberList.add(myNumbers.get(numberIndex));
      }
    }
    return sameNumberList;
  }

  private boolean isStrike(int sameNumber, List<Integer> myNumbers, List<Integer> computerNumbers) {
    if (myNumbers.indexOf(sameNumber) == computerNumbers.indexOf(sameNumber)) {
      return true;
    }
    return false;
  }

  public void judgeStrikeAndBall(List<Integer> myNumbers, List<Integer> computerNumbers) {
    init();
    List<Integer> sameNumbers = getSameNumbers(sortList(myNumbers), sortList(computerNumbers));
    for (int sameNumber : sameNumbers) {
      if (isStrike(sameNumber, myNumbers, computerNumbers)) {
        strikeCount++;
      }
      if (!isStrike(sameNumber, myNumbers, computerNumbers)) {
        ballCount++;
      }
    }
    printStrikeAndBall();
  }

  public boolean isThreeStrike() {
    if (strikeCount == MAX_NUMBER_SIZE) {
      return true;
    }
    return false;
  }

  private void printStrikeAndBall() {
    if (strikeCount == 0 && ballCount == 0) {
      View.printNothing();
    } else if (strikeCount == INIT_COUNT) {
      View.printBall(ballCount);
    } else if (ballCount == 0) {
      View.printStrike(strikeCount);
    } else {
      View.printStrikeAndBall(ballCount, strikeCount);
    }
  }
}
