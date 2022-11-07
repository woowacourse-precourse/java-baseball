package baseball;

import baseball.generator.RandomNumberGenerator;

import java.util.List;

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
    int strikes = 0;
    for (int pos = 0; pos < guessedNumber.size(); pos++) {
      if (isStrike(guessedNumber, pos)) {
        strikes++;
      }
    }
    return strikes;
  }

  private int checkBall(List<Integer> guessedNumber) {
    int balls = 0;
    for (int guessedPos = 0; guessedPos < guessedNumber.size(); guessedPos++) {
      for (int answerPos = 0; answerPos < this.answer.size(); answerPos++) {
        if (isBall(guessedNumber, guessedPos, answerPos)) {
          balls++;
          break;
        }
      }
    }
    return balls;
  }

  private boolean isStrike(List<Integer> guessedNumber, int pos) {
    return guessedNumber.get(pos).equals(this.answer.get(pos));
  }

  private boolean isBall(List<Integer> guessedNumber, int guessedPos, int answerPos) {
    return guessedPos != answerPos && guessedNumber.get(guessedPos).equals(this.answer.get(answerPos));
  }
}

