## 숫자 야구 with 자바 기초 강의 정리

### 강의를 들으며 깨달은 부분

* 기능 목록이 무엇인지
    * 처음에 기능 목록
* Hit 여부 판단하는 로직
* 테스트 코드를 작성하기 편하게 코드를 작성하자.
  * `@BeforeEach`,`@ParameterizedTest`,`@CsvSource`의 기능을 알았지만, 클래스를 역할에 따라 나누지 않았기 때문에 내 코드에서는 작은 테스트를 작성하기 힘들었다.


### 기능 목록 정리

- [ ] 1부터 9까지의 서로 다른 임의의 수 3개를 생성한다. - NumberGenerator.createRandomNumbers()
- [ ] 컴퓨터의 수(3자리)와 플레이어의 수(3자리)를 비교할 수 있다. - Referee.compare()
    - [ ] 몇 개의 숫자가 같은지를 알 수 있다. - Judgment.correctCount()
    - [ ] 특정 자리에 특정 숫자가 있는지 알 수 있다. - Judgment.hasPlace()
- [ ] 같은 수가 같은 자리에 있으면 스트라이크이다.
- [ ] 같은 수가 다른 자리에 있으면 볼이다.
- [ ] 같은 수가 전혀 없으면 낫싱이다.

### 빌드 도구

- 빌드 도구 : 라이브러리 관리

### Java 설명

- 상수, 클래스 변수, 메서드

### 객체 지향 프로그래밍

1. 기능을 가지고 있는 클래스를 인스턴스화(=객체) 한다.
2. 필요한 기능을 (역할에 맞는) 인스턴스가 수행하게 한다.(의인화)
3. 각 결과를 종합한다.

### 테스트 코드 작성하기

```java
import java.lang.reflect.Array;
import java.util.Arrays;

class RefereeTest {
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @ParameterizedTest //아래의 반복적인 테스트 하나의 테스트로 묶기
    @CsvSource({"1,2,3,0볼 3스트라이크", "7,8,9,아웃", "2,3,1,3볼 0스트라이크", "1,3,2,2볼 1스트라이크"})
    public void compare(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 스트라이크3() {
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3));
        assertThat(result).isEqualTo("0볼 3스트라이크");
    }

    @Test
    void 아웃() {
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(7, 8, 9));
        assertThat(result).isEqualTo("0볼 3스트라이크");
    }

    @Test
    void 볼3() {
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(2, 3, 1));
        assertThat(result).isEqualTo("3볼");
    }

    @Test
    void 볼2_스트라이크1() {
        String result = referee.compare(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1));
        assertThat(result).isEqualTo("2볼 1스트라이크");
    }
}
```
