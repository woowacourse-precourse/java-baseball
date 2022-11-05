package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

// 컴퓨터의 난수 생성
public class CreateRandomNumber {
  public static String numberMaker() {
    List<Integer> number = new ArrayList<>();

    while (number.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!number.contains(randomNumber))
        number.add(randomNumber);
    }

    return number.toString();
  }
}
