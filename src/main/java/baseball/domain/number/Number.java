package baseball.domain.number;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
  private static final Integer START_INCLUSIVE = 1;
  private static final Integer END_INCLUSIVE = 9;

  private Integer number;

  public Number() {
    this.number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
  }

  public Integer getNumber(){
    return this.number;
  }
}

