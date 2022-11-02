package baseball.game;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.lang.Character.getNumericValue;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.IntPredicate;

public class Baseball implements Game {

  private static final int GOAL_DIGIT = 3;
  private static final int START_POSSIBLE_NUMBER = 1;
  private static final int END_POSSIBLE_NUMBER = 9;

  private final int[] computerNumbers = new int[GOAL_DIGIT];
  private final int[] playerNumbers = new int[GOAL_DIGIT];

  private int strike;
  private int ball;

  public Baseball() {
    this.strike = 0;
    this.ball = 0;
    setComputerNumbers();
  }

  private void setComputerNumbers() {
    List<Integer> uniqueNumbers = pickUniqueNumbersInRange(START_POSSIBLE_NUMBER,
        END_POSSIBLE_NUMBER, GOAL_DIGIT);
    for (int i = 0; i < GOAL_DIGIT; i++) {
      computerNumbers[i] = uniqueNumbers.get(i);
    }
  }

  @Override
  public void play() {
    do {
      input();
    } while (isNotCorrect());
  }

  private boolean isNotCorrect() {
    return this.strike != GOAL_DIGIT;
  }

  private void input() {
    String playerInput = Console.readLine();
    if (isInvalid(playerInput)) {
      throw new IllegalArgumentException();
    }
  }

  private boolean isInvalid(String playerInput) {
    return isInvalidLength(playerInput) ||
        isAllCharacterNotNumeric(playerInput) ||
        isAnyDigitInvalidRange(playerInput);
  }

  private boolean isInvalidLength(String playerInput) {
    return playerInput.length() != GOAL_DIGIT;
  }

  private boolean isAllCharacterNotNumeric(String playerInput) {
    return playerInput.chars()
        .allMatch(Character::isDigit);
  }

  private boolean isAnyDigitInvalidRange(String playerInput) {
    return playerInput.chars()
        .anyMatch(digit -> isInvalidRange((char) digit));
  }

  private boolean isInvalidRange(char digit) {
    return START_POSSIBLE_NUMBER > getNumericValue(digit) ||
        getNumericValue(digit) > END_POSSIBLE_NUMBER;
  }
}
