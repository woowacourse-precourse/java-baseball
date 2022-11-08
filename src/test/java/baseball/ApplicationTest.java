package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    Service service;
    Field mapField, comInputField, sField, bField;
    HashMap<String, Integer> map;
    String comInput;
    int strike, ball;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @BeforeEach
    public void SetUp() throws Exception {
        service = new Service();
        service.initGame();

        mapField = service.getClass().getDeclaredField("map");
        comInputField = service.getClass().getDeclaredField("comInput");
        sField = service.getClass().getDeclaredField("strike");
        bField = service.getClass().getDeclaredField("ball");
        mapField.setAccessible(true);
        comInputField.setAccessible(true);
        sField.setAccessible(true);
        bField.setAccessible(true);

        map = (HashMap) mapField.get(service);
        comInput = (String) comInputField.get(service);
        strike = sField.getInt(service);
        ball = bField.getInt(service);
    }
    
    @Test
    @DisplayName("정상적으로 점수를 계산하는지 테스트")
    void calculateScoreTest() {
        assertThat(Objects.equals(new Score(3, 0), service.calculateScore(comInput)));
    }

    @Test
    @DisplayName("컴퓨터의 수 데이터가 정상적으로 해시맵에 저장되는지 테스트")
    void setComputerDataTest() throws Exception {
        String first = comInput.substring(0, 1);
        String second = comInput.substring(1, 2);
        String third = comInput.substring(2, 3);

        service.setComputerData();
        Assertions.assertAll(
                () -> Assertions.assertEquals(true, map.containsKey(first)),
                () -> Assertions.assertEquals(true, map.containsKey(second)),
                () -> Assertions.assertEquals(true, map.containsKey(third)),
                () -> Assertions.assertEquals(0, map.get(first)),
                () -> Assertions.assertEquals(1, map.get(second)),
                () -> Assertions.assertEquals(2, map.get(third))
        );
    }

    @AfterEach
    public void TearDown() throws Exception {
    }
}