package baseball.dto;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

class InputSignalTest {

  @Test
  void 잘못된신호입력시_실패() {
    String givenNotMatchSignalNumber = "-";
    String givenNotMatchSignalLength = "11";

    Throwable givenNotMatchSignalNumberThrown = catchThrowable(
        () -> new InputSignal(givenNotMatchSignalNumber));
    Throwable givenNotMatchSignalLengthThrown = catchThrowable(
        () -> new InputSignal(givenNotMatchSignalLength));

    assertAll(
        () -> assertThat(givenNotMatchSignalNumberThrown).isInstanceOf(
            IllegalArgumentException.class),
        () -> assertThat(givenNotMatchSignalLengthThrown).isInstanceOf(
            IllegalArgumentException.class)
    );
  }

  @Test
  void 신호입력_성공(){
    String givenSignal = "1";

    InputSignal inputSignal = new InputSignal(givenSignal);

    assertThat(inputSignal.getSignal()).isEqualTo(1);
  }
}