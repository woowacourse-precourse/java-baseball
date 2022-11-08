package baseball.domain.player;

import baseball.domain.number.Number;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Computer {
  public static final Integer COMPUTER_NUMBER_SIZE = 3;
  public static final String COMPUTER_NUMBER_SIZE_ERROR_MESSAGE = "컴퓨터가 생성하는 숫자는 세 자리이어야 합니다.";
  public static final String COMPUTER_DUPLICATE_NUMBER_ERROR_MESSAGE = "컴퓨터가 생성하는 각각의 숫자는 서로 중복되지 않습니다.";

  private Set<Integer> computer = new LinkedHashSet<>();

  public Computer() {
    init();
    createRandomThreeDigitNumber();
    validateComputerNumber();
  }

  /*
   * [TEST] 컴퓨터의 숫자가 세 자리 미만이거나 초과일 때 오류 발생
   */
  public Computer(List<Integer> numList) {
    init();
    computer.addAll(numList);
    validateComputerNumber();
  }

  private void init(){
    this.computer.clear();
  }

  private void createRandomThreeDigitNumber() {
    while (getSize() < COMPUTER_NUMBER_SIZE) {
      Number randomNumber = new Number();
      this.computer.add(randomNumber.getNumber());
    }
  }

  private void validateComputerNumber() {
    if(!getSize().equals(COMPUTER_NUMBER_SIZE)){
      throw new IllegalArgumentException(COMPUTER_NUMBER_SIZE_ERROR_MESSAGE);
    }
  }

  private Integer getSize(){
    return this.computer.size();
  }

  public List<Integer> getNumberList() {
    return List.copyOf(this.computer);
  }
}
