package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
  private RandomNumber random_number = new RandomNumber();

  public Game() {

  }

  public boolean routine() {
    while (true) {
      RoutineForOneInput routineForOneInput = new RoutineForOneInput(random_number.getRandomNumber());
      if (routineForOneInput.routine()) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        return true;
      }
    }
  }

  public boolean restart() {

    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    int num = Integer.parseInt(readLine());

    if (num == 1)
      return true;
    else if (num == 2)
      return false;
    else {
      throw new IllegalArgumentException();
    }
  }
}
