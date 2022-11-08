package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
  public static List<Integer> makeRandomNumber() {
    List<Integer> listRandomNumber = new ArrayList<>();
    while(listRandomNumber.size() < 3) {
      int randomValue = Randoms.pickNumberInRange(1, 9);

      if(listRandomNumber.contains(randomValue)) continue;

      listRandomNumber.add(randomValue);
    }

    return listRandomNumber;
  }
}
