package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JunitPracticeTest {
    //1. 로또 번호 개수 테스트 : 로또 생성하는 객체와 금액이 필요함
    @DisplayName("로또 번호 갯수 테스트")
    @Test
    void lottoNumberSizeTest() {
        // given : 무슨 데이터를 주었을때
        final JunitPractice lottoNumberGenerator = new JunitPractice();
        final int price = 1000;

        // when : 어떤 함수를 실행하면 (실행한 결과 담기)
        final List<Integer> lotto =  lottoNumberGenerator.operate(price);

        // then : 어떤 결과가 나와야하는지 (로또가 6개인지)
        assertThat(lotto.size()).isEqualTo(6);
    }

    //2.로또 번호 범위 테스트 : 모든 로또 숫자가 1에서 5 사이인지.
    @DisplayName("로또 번호 범위 테스트")
    @Test
    void lottoNumberRangeTest() {
        // given : 무슨 데이터를 주었을때
        final JunitPractice lottoNumberGenerator = new JunitPractice();
        final int price = 1000;

        // when : 어떤 함수를 실행하면
        final List<Integer> lotto =  lottoNumberGenerator.operate(price);

        // then : 어떤 결과가 나와야하는지 (로또 번호가 1에서 45 사이 숫자인지)
        assertThat(lotto.stream().allMatch(v->1<=v && v<=45)).isTrue();
    }


    //3. 잘못된 로또 금액 테스트 : money가 1000원 아닌경우
    @DisplayName("잘못된 로또 금액 테스트")
    @Test
    void lottoNumberInvalidMoneyTest() {
        // given
        final JunitPractice lottoNumberGenerator = new JunitPractice();
        final int price = 2000;

        // when (어떤 함수 실행하면 = 실행한 결과(예외) 담기)
//        final RuntimeException exception = assertThrows(RuntimeException.class, () -> lottoNumberGenerator.generate(price));

        // then (발생한 예외가 지정한 예외와 같은지)
//        assertThat(exception.getMessage()).isEqualTo("올바른 금액이 아닙니다.");
        assertThrows(RuntimeException.class, () -> lottoNumberGenerator.operate(price));
    }

    //Assertions.assertThrows의
    // 두 번째 인자인 함수를 실행하여
    // 첫 번째 인자인 예외 타입과 같은지(혹은 캐스팅이 가능한 상속 관계의 예외인지) 검사
}
