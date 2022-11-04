package baseball.dataStorage;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {

  private static List<Integer> solution = new ArrayList<>(List.of(0, 0, 0));
  private static List<Integer> answer = new ArrayList<>(List.of(0, 0, 0));
  private static int countStrike;
  private static int countBall;

  public static void resetAllData() {
    solution = new ArrayList<>(List.of(0, 0, 0));
    answer = new ArrayList<>(List.of(0, 0, 0));
    resetResult();
  }

  public static void resetResult() {
    countStrike = 0;
    countBall = 0;
  }

  public static List<Integer> getSolution() {
    return solution;
  }

  public static List<Integer> getAnswer() {
    return answer;
  }

  public static int getCountBall() {
    return countBall;
  }

  public static int getCountStrike() {
    return countStrike;
  }

  public static void setSolution(List<Integer> solution) {
    DataStorage.solution = solution;
  }

  public static void setAnswer(List<Integer> answer) {
    DataStorage.answer = answer;
  }

  public static void setAnswer(int index, int answer) {
    DataStorage.answer.set(index, answer);
  }

  public static void setCountStrike(int strike) {
    DataStorage.countStrike = strike;
  }

  public static void setCountBall(int ball) {
    DataStorage.countBall = ball;
  }

  public static void countOneStrike() {
    DataStorage.countStrike = countStrike + 1;
  }

  public static void countOneBall() {
    DataStorage.countBall = countBall + 1;
  }

  //입력받은 세 자리 수를 DataStorage에 저장하는 메서드
  public static void storeAnswer(int num) {
    for (int i = 2; i >= 0; i--) {
      DataStorage.setAnswer(i, num % 10);
      num /= 10;
    }
  }
}
