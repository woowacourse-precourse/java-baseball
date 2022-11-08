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
    checkPlayerNumbers(playerInput);
    return convertStringToIntegerList(playerInput);
  }

  private void checkPlayerNumbers(String input) {
    if (isValidateLength(input) || hasDuplicateNumbers(input) || hasInvalidRange(input)) {
      throw new IllegalArgumentException();
    }
  }

  private boolean isValidateLength(String input) {
    return input.length() != RANDOM_NUMBER_SIZE;
  }

  private boolean hasDuplicateNumbers(String input) {
    List<Integer> numberList = convertStringToIntegerList(input);
    Set<Integer> numberSet = new HashSet<>(numberList);
    return numberList.size() != numberSet.size();
  }

  private boolean hasInvalidRange(String input) {
    return input.chars()
        .map(Character::getNumericValue)
        .anyMatch(this::isInValidateRange);
  }

  private boolean isInValidateRange(int number) {
    return number < BEGIN || number > END;
  }

  private static List<Integer> convertStringToIntegerList(String playerInput) {
    return Stream.of(playerInput.split(""))
        .mapToInt(Integer::parseInt)
        .boxed()
        .collect(Collectors.toList());
  }

  public boolean doesPlayerWantToRestart() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String playerInput = readLine();
    checkValidateGameStatus(playerInput);
    return playerInput.equals(GameStatus.RESTART.getStatus());
  }

  private void checkValidateGameStatus(String playerInput) {
    if (!playerInput.equals(GameStatus.RESTART.getStatus()) &&
        !playerInput.equals(GameStatus.END.getStatus())) {
      throw new IllegalArgumentException();
    }
  }

  private enum GameStatus {
    RESTART("1"),
    END("2"),
    ;
    private final String status;

    GameStatus(String status) {
      this.status = status;
    }

    public String getStatus() {
      return status;
    }
  }
}
