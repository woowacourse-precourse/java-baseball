package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// 컴퓨터의 난수 생성
public class CreateRandomNumber {
  public static String numberMaker() {
    List<Integer> number = new ArrayList<>();

    while (number.size() < Constant.REQUIRED_NUMBER_LENGTH) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!number.contains(randomNumber)) {
        number.add(randomNumber);
      }
    }

    StringBuilder strNumber = new StringBuilder();
    for (Integer integer : number) {
      strNumber.append(integer);
    }

    return strNumber.toString();
  }
}
