package baseball.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import baseball.view.View;

public class Judgement {
  private final String STRIKE = "strike";
  private final String BALL = "ball";
  private final int MAX_NUMBER_SIZE = 3;
  private final HashMap<String, Integer> STRIKE_AND_BALL;

  Judgement() {
    STRIKE_AND_BALL = new HashMap<>();
  }

  private void init() {
    STRIKE_AND_BALL.clear();
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

  private void putStrike() {
    STRIKE_AND_BALL.put(STRIKE, STRIKE_AND_BALL.getOrDefault(STRIKE, 0) + 1);
  }

  private void putBall() {
    STRIKE_AND_BALL.put(BALL, STRIKE_AND_BALL.getOrDefault(BALL, 0) + 1);
  }

  public void judgeStrikeAndBall(List<Integer> myNumbers, List<Integer> computerNumbers) {
    init();
    List<Integer> sameNumbers = getSameNumbers(sortList(myNumbers), sortList(computerNumbers));
    for (int sameNumber : sameNumbers) {
      if (isStrike(sameNumber, myNumbers, computerNumbers)) {
        putStrike();
      } else {
        putBall();
      }
    }
    printStrikeAndBall();
  }

  public boolean isThreeStrike() {
    if (STRIKE_AND_BALL.get(STRIKE) == MAX_NUMBER_SIZE) {
      return true;
    }
    return false;
  }

  private void printStrikeAndBall() {
    if (STRIKE_AND_BALL.isEmpty()) {
      View.printNothing();
    } else if (STRIKE_AND_BALL.get(STRIKE) == 0) {
      View.printBall(STRIKE_AND_BALL.get(BALL));
    } else if (STRIKE_AND_BALL.get(BALL) == 0) {
      View.printStrike(STRIKE_AND_BALL.get(STRIKE));
    } else {
      View.printStrikeAndBall(STRIKE_AND_BALL.get(BALL), STRIKE_AND_BALL.get(STRIKE));
    }
  }
}
