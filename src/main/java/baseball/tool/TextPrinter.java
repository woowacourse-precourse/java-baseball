package baseball.tool;

import baseball.dataStorage.DataStorage;

public class TextPrinter {
  public static void printStartMessage(){
    System.out.println("숫자 야구 게임을 시작합니다.");
  }
  public static void printGetAnswer(){
    System.out.print("숫자를 입력해주세요 : ");
  }
  public static void printResult() {
    int ball= DataStorage.getCountBall();
    int strike=DataStorage.getCountStrike();
    String resultStr = "";
    if (ball > 0) {
      resultStr += ball + "볼 ";
    }
    if (strike > 0) {
      resultStr += strike + "스트라이크";
    }
    if (ball == 0 && strike == 0) {
      resultStr = "낫싱";
    }
    System.out.println(resultStr);
  }
  public static void printGetSignal(){
    System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

  }

}
