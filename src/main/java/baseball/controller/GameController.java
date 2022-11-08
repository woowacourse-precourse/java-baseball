package baseball.controller;

import baseball.service.hint.Hint;
import baseball.service.hint.HintService;
import baseball.service.InputService;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {

  public static final int RANDOM_NUMBER_SIZE = 3;
  public static final int BEGIN = 1;
  public static final int END = 9;
  private final List<Integer> computerNumbers;

  private final InputService inputService = new InputService();
  private final HintService hintService = new HintService();

  public GameController() {
    this.computerNumbers = getRandomNumbers();
  }

  public void play() {
    Hint hint;
    do {
      List<Integer> playerNumbers = inputService.getPlayerNumbers();
      hint = hintService.getHint(computerNumbers, playerNumbers);
      hintService.printHint(hint);
    } while (hintService.isContinue(hint));
  }

  private List<Integer> getRandomNumbers() {
    List<Integer> randomNumbers = new ArrayList<>();
    while (randomNumbers.size() < RANDOM_NUMBER_SIZE) {
      int randomNumber = Randoms.pickNumberInRange(BEGIN, END);
      if (!randomNumbers.contains(randomNumber)) {
        randomNumbers.add(randomNumber);
      }
    }
    return randomNumbers;
  }

}
