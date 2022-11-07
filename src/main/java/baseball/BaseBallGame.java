package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseBallGame {
  public void start() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    System.out.println(getUserInputNum());
  }

  public String getUserInputNum() {
    System.out.print("1~9로 이루어진 세자리 정수를 입력하세요: ");
    return Console.readLine();
  }
}
