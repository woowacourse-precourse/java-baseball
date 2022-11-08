package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("랜덤숫자가 서로다른 숫자를 가지고 있는지 확인")
    void createRandomTargetNum() throws Exception{
        List<Integer> targetNum = getTargetNum();
        Set<Integer> set = new HashSet<>(targetNum);

        Assertions.assertThat(set.size()).isEqualTo(targetNum.size());
    }

    @Test
    @DisplayName("랜덤숫자가 3개 선택되었는지 확인")
    void RandomNumSize() throws Exception {
        List<Integer> targetNum = getTargetNum();
        Assertions.assertThat(targetNum.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자 잘못된 값 입력시 오류 발생")
    void badInputException() throws Exception{
        Application app= new Application();
        Method inputValidate = getInputValidateMethod(app);

        Assertions.assertThatThrownBy(()->
                inputValidate.invoke(app,List.of("1234"))).getRootCause()
                        .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                inputValidate.invoke(app,List.of("112"))).getRootCause()
                        .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                inputValidate.invoke(app,List.of("103"))).getRootCause()
                        .isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    @DisplayName("1을 입력하면 게임 재시작 , 2는 종료")
    void restartOrEnd() throws Exception {
        String data = setSystemIn_1_or_2();
        boolean result = getResultEndGame();

        if(data.equals("1")){
            Assertions.assertThat(result).isEqualTo(false);
        }
        if(data.equals("2")){
            Assertions.assertThat(result).isEqualTo(true);
        }

    }


    @Test
    @DisplayName("게임 재시작 혹은 종료시 입력값 검증")
    void optionValidate() throws Exception {
        Application app = new Application();
        Method optionValidate = app.getClass().getDeclaredMethod("optionValidate", int.class);
        optionValidate.setAccessible(true);

        Assertions.assertThatThrownBy(()->
                 optionValidate.invoke(app, 0))
                        .isInstanceOf(InvocationTargetException.class)
                                .getRootCause().isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1,  3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        Assertions.assertThatThrownBy(()-> runException("1234"))
                .isInstanceOf(Exception.class);


    }

    @Override
    public void runMain(){
        Application.main(new String[]{});

    }

    private List<Integer> getTargetNum() throws  Exception {
        Application app= new Application();
        Method createRandomTargetNum = app.getClass().getDeclaredMethod("createRandomTargetNum");
        createRandomTargetNum.setAccessible(true);
        createRandomTargetNum.invoke(app);

        Field targetField = app.getClass().getDeclaredField("targetNum");
        targetField.setAccessible(true);
        List<Integer> targetNum = (List<Integer>) targetField.get(app);
        return targetNum;
    }

    private Method getInputValidateMethod(Application app) throws NoSuchMethodException {
        Method inputValidate = app.getClass().getDeclaredMethod("inputValidate", List.class);
        inputValidate.setAccessible(true);
        return inputValidate;
    }


    private boolean getResultEndGame() throws Exception {
        Application app= new Application();
        Method endGame = app.getClass().getDeclaredMethod("endGame");
        endGame.setAccessible(true);
        boolean result = (boolean) endGame.invoke(app);
        return result;
    }
    private String setSystemIn_1_or_2() {
        String data = String.valueOf(Randoms.pickNumberInList(List.of(1,2)));
        InputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
        return data;
    }
}
