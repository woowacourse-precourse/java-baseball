package baseball;

import baseball.numbergenerator.NumberGeneratorRandomImpl;
import baseball.numbergenerator.NumberGeneratorSequenceImpl;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        Application.setNumberGenerator(new NumberGeneratorSequenceImpl(List.of(135, 589)));

        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );

        Application.setNumberGenerator(NumberGeneratorRandomImpl.getInstance());
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 볼스트라이크스코어1스트라이크1볼(){
        Integer computerNumber = 583;
        Integer userNumber = 532;
        Map<String, Integer> score = Application.calculateScore(computerNumber, userNumber);
        assertThat(score.get(ScoreConst.STRIKE)).isEqualTo(1);
        assertThat(score.get(ScoreConst.BALL)).isEqualTo(1);
    }

    @Test
    void 볼스트라이크스코어0스트라이크3볼(){
        Integer computerNumber = 123;
        Integer userNumber = 231;
        Map<String, Integer> score = Application.calculateScore(computerNumber, userNumber);
        assertThat(score.get(ScoreConst.STRIKE)).isEqualTo(0);
        assertThat(score.get(ScoreConst.BALL)).isEqualTo(3);
    }

    @Test
    void 스코어1볼1스트라이크정상출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Integer computerNumber = 583;
        Integer userNumber = 532;
        Map<String, Integer> score = Application.calculateScore(computerNumber, userNumber);

        Application.printScore(score);
        assertThat(out.toString()).isEqualTo("1볼 1스트라이크\n");
    }

    @Test
    void 스코어3볼0스트라이크정상출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Integer computerNumber = 123;
        Integer userNumber = 231;
        Map<String, Integer> score = Application.calculateScore(computerNumber, userNumber);

        Application.printScore(score);
        assertThat(out.toString()).isEqualTo("3볼\n");
    }

    @Test
    void 스코어낫싱정상출력(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Integer computerNumber = 123;
        Integer userNumber = 456;
        Map<String, Integer> score = Application.calculateScore(computerNumber, userNumber);

        Application.printScore(score);
        assertThat(out.toString()).isEqualTo("낫싱\n");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
