package baseball;

import baseball.generator.RandomNumberGenerator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Computer {

  private List<Integer> answer;
  private final RandomNumberGenerator generator;

  public Computer(RandomNumberGenerator generator) {
    this.generator = generator;
    generateAnswer();
  }

  public boolean getPlayerWinOrNotAndPrintResult(List<Integer> guessedNumber) {
    int strikes = checkStrike(guessedNumber);
    int balls = checkBall(guessedNumber);
    printGuessResultMessage(strikes, balls);
    return isPlayerWinGame(strikes);
  }

  public void resetAnswer() {
    generateAnswer();
  }

  private void generateAnswer() {
    this.answer = this.generator.generate(3);
  }

  private boolean isPlayerWinGame(int strikes) {
    if (strikes == 3) {
      return true;
    }
    return false;
  }

  private void printGuessResultMessage(int strikes, int balls) {
    System.out.println(makeGuessResultMessage(strikes, balls));
  }

  private String makeGuessResultMessage(int strikes, int balls) {
    if (strikes == 0 && balls == 0) {
      return "낫싱";
    } else if (strikes == 0) {
      return balls + "볼";
    } else if (balls == 0) {
      return strikes + "스트라이크";
    }
    return balls + "볼 " + strikes + "스트라이크";
  }

  private int checkStrike(List<Integer> guessedNumber) {
    return checkScore(guessedNumber, pos -> isStrike(guessedNumber, pos));
  }

  private int checkBall(List<Integer> guessedNumber) {
    return checkScore(guessedNumber, pos -> isBall(guessedNumber, pos));
  }

  private int checkScore(List<Integer> guessedNumber, IntPredicate scoreCondition) {
    return (int) IntStream
            .range(0, guessedNumber.size())
            .filter(scoreCondition)
            .count();
  }

  private boolean isStrike(List<Integer> guessedNumber, int pos) {
    return guessedNumber.get(pos).equals(this.answer.get(pos));
  }

  private boolean isBall(List<Integer> guessedNumber, int guessedPos) {
    return IntStream
            .range(0, this.answer.size())
            .anyMatch(answerPos ->
                    answerPos != guessedPos
                            && guessedNumber.get(guessedPos).equals(this.answer.get(answerPos))
            );
  }
}