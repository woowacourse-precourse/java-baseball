package baseball.domain.number;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
  public static final String NUMBER_ERROR_MESSAGE = "각 자리 숫자는 1에서 9사이어야 합니다.";
  private static final Integer START_INCLUSIVE = 1;
  private static final Integer END_INCLUSIVE = 9;

  private Integer number;

  public Number() {
    int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    validateNumber(randomNumber);
    this.number = randomNumber;
  }

  /*
  * [TEST] 1 ~ 9 사이의 숫자가 아닐 때 에러 발생 확인 생성자
  */
  public Number(Integer number) {
    validateNumber(number);
    this.number = number;
  }

  private void validateNumber(int number) {
    if(number < 1 || number > 9){
      throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
    }
  }

  public Integer getNumber(){
    return this.number;
  }
}

