package baseball.view;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ViewTest{

    @Test
    @DisplayName("사용자 입력 성공: 중복되지 않은 서로다른 3자리수 입력")
    void case1(){
        //given
        InputView inputView = new InputView();
        //when
        String userInput = "123";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        List<Integer> numbers = inputView.requestInput();
        //then
        Assertions.assertThat(numbers).isEqualTo(Stream.of(userInput.split("")).map(Integer::parseInt).collect(Collectors.toList()));
    }

    @Test
    @DisplayName("사용자 입력 실패: 중복된 숫자 입력")
    void case2(){
        //given
        InputView inputView = new InputView();
        //when
        String userInput = "111";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThatThrownBy(inputView::requestInput).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("사용자 입력 실패: 3자리가 아닌 숫자 입력")
    void case3(){
        //given
        InputView inputView = new InputView();
        //when
        String userInput = "12345";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThatThrownBy(inputView::requestInput).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("사용자 입력 성공: 게임 종료시 1 또는 2 입력")
    void case4(){
        //given
        InputView inputView = new InputView();
        //when
        String userInput = "1";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        boolean result = inputView.questionInput();
        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("사용자 입력 실패: 게임 종료시 1또는 2가 아닌 숫자 입력")
    void case5(){
        //given
        InputView inputView = new InputView();
        //when
        String userInput = "6";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //then
        Assertions.assertThatThrownBy(inputView::questionInput).isInstanceOf(IllegalArgumentException.class);

    }


}
