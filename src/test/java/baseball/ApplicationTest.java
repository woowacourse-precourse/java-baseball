package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
    @Test
	@DisplayName("야구공 3개 미만 입력 예외케이스")
    void 플레이어입력_예외_테스트() {
    	//given, when
    	String twoLengthBall = "12";
    	String oneLengthBall = "9";
    	String zeroLengthBall = "";
    	//then
    	assertThatThrownBy(() -> Application.checkLessThanThreeExecption(twoLengthBall)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkLessThanThreeExecption(oneLengthBall)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkLessThanThreeExecption(zeroLengthBall)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("야구공 3개 초과 입력 예외케이스")
    void 플레이어입력_예외_테스트2() {
    	//given, when
    	String fourLengthBall = "1234";
    	String tenLengthBall = "1234567890";
    	//then
    	assertThatThrownBy(() -> Application.checkMoreThanThreeException(fourLengthBall)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkMoreThanThreeException(tenLengthBall)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("야구공 숫자가 아닌 입력 예외케이스")
    void 플레이어입력_예외_테스트3() {
    	//given, when
    	String nonNumericBallOne = "1-2";
    	String nonNumericBallTwo = "가12";
    	String nonNumericBallThree = "1!";
    	//then
    	assertThatThrownBy(() -> Application.checkNonNumericCharacterException(nonNumericBallOne)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkNonNumericCharacterException(nonNumericBallTwo)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkNonNumericCharacterException(nonNumericBallThree)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("야구공 중복 숫자 입력 예외케이스")
    void 플레이어입력_예외_테스트4() {
    	//given, when
    	String duplicateBallOne = "112";
    	String duplicateBallTwo = "525";
    	String duplicateBallThree = "677";
    	String duplicateBallFour = "777";
    	//then
    	assertThatThrownBy(() -> Application.checkDuplicateBallsException(duplicateBallOne)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkDuplicateBallsException(duplicateBallTwo)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkDuplicateBallsException(duplicateBallThree)).isInstanceOf(IllegalArgumentException.class);
    	assertThatThrownBy(() -> Application.checkDuplicateBallsException(duplicateBallFour)).isInstanceOf(IllegalArgumentException.class);
    }
    
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
