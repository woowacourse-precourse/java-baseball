package baseball.util.number;

import static baseball.util.setting.BallSetting.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

  public final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
  public static final int TEST_NUMBER = 1000;

  @Test
  @DisplayName("랜덤으로 생성된 숫자가 세자리인지 판별")
  void 랜덤_숫자_세자리_판별(){
    for(int i=0; i<TEST_NUMBER; i++){
      assertThat(randomNumberGenerator
                     .generate().size()).isEqualTo(BALL_SIZE.getBallSetting());
    }
  }

  @Test
  @DisplayName("랜덤으로 생성된 숫자가 1~9인지 판별")
  void 랜덤_숫자_범위_판별(){
    for(int i=0; i<TEST_NUMBER; i++){
      randomNumberGenerator
          .generate().stream()
          .forEach(number -> assertThat(number).isBetween(BALL_MIN_NUMBER.getBallSetting(), BALL_MAX_NUMBER.getBallSetting()));
    }
  }
  @Test
  @DisplayName("랜덤으로 생성된 숫자에 중복되는 숫자가 있는지 판별")
  void 랜덤_숫자_중복값_검증(){
    for(int i=0; i<TEST_NUMBER; i++){
      Set<Integer> numberSet = new HashSet<>(randomNumberGenerator.generate());
      assertThat(numberSet.size()).isEqualTo(BALL_SIZE.getBallSetting());
    }
  }
}
