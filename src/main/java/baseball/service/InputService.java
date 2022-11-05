package baseball.service;

import static baseball.controller.GameController.BEGIN;
import static baseball.controller.GameController.END;
import static baseball.controller.GameController.RANDOM_NUMBER_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputService {

  public List<Integer> getPlayerNumbers() {
    System.out.print("숫자를 입력해주세요 : ");
    String playerInput = readLine();
    return convertStringToIntegerList(playerInput);
  }

  private static List<Integer> convertStringToIntegerList(String playerInput) {
    return Stream.of(playerInput.split(""))
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toList());
  }

  public boolean DoesPlayerWantToRestart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String playerInput = readLine();
    return playerInput.equals("1");
  }

}
