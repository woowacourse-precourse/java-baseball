package baseball.util.number;

import static baseball.util.setting.BallSetting.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator implements NumberGenerator{

  public List<Integer> generate(){
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < BALL_SIZE.getBallSetting()) {
      int randomNumber = Randoms.pickNumberInRange(BALL_MIN_NUMBER.getBallSetting(), BALL_MAX_NUMBER.getBallSetting());
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
    return computer;
  }
}
