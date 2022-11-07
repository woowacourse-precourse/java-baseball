package baseball.console;

public class ConsoleOutput {

  public void printStartMessage() {
    final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    System.out.println(START_MESSAGE);
  }

  public void printEndMessage() {
    final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    System.out.println(END_MESSAGE);
  }
}
