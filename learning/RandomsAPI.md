## Randoms API 학습 기록

### import
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
```
<br>

### 클래스 상수
```java
private static final Random defaultRandom = ThreadLocalRandom.current();
```
```java
/**
 * Returns the current thread's {@code ThreadLocalRandom}.
 *
 * @return the current thread's {@code ThreadLocalRandom}
 */
public static ThreadLocalRandom current() {
    if (U.getInt(Thread.currentThread(), PROBE) == 0)
        localInit();
    return instance;
}

// current 함수에서 반환하는 instance
static final ThreadLocalRandom instance = new ThreadLocalRandom();

// instance로 생성하는 객체 ThreadLocalRandom
/**
 * Field used only during singleton initialization.
 * True when constructor completes.
 */
boolean initialized;

/** Constructor used only for static singleton */
private ThreadLocalRandom() {
    initialized = true; // false during super() call
}
```

<br>

### 학습 내용

- ThreadLocalRandom은 `java.util.Random`을 상속
  > 굳이 상속 받아 ThreadLocalRandom을 사용하는 이유
  >
  > **결론**

  동시성 문제가 발생할 수 있기 때문
  > **이유**

  `java.util.Random`의 Random 함수는 현재 시간을 기준으로(seed값) 선택하여 난수값 생성을 한다. 멀티 스레드 환경에서 하나의 Random 인스턴스에서 전역으로 난수값을 반환한다. 즉, 같은 시간에 동시 요청이 올 경우 경합을 벌이며 성능상의 문제를 가져올 수 있다. 같은 수를 반환할 가능성은 없지만 계속해서 경합을 벌이며 시간상의 손해를 초래한다.
  > **실제 서비스 적용 사례 (나의 예상)**

  실제로 회원가입시 문자 인증번호를 난수로 생성하여 보낸다고 가정해보자. 여러 회원이 동시에 요청을 할 경우 인증번호가 가는데까지 시간이 걸리게 된다. 유저를 이를 인식하지 못하고 계속 요청하고 앞의 상황이 반복되며 점점 악화된다. 결국 서버 장애를 불러온다. (~~이미 유저는 이탈되었을 가능성이 크다~~)


- ThreadLocalRandom은 스레드마다 인스턴스를 생성하여 각각 난수값을 반환
    - 동시 요청으로 인한 경쟁을 하지 않으므로 성능 상승

<br>

### 메소드
#### pickNumberInRange
```java
public static int pickNumberInRange(final int startInclusive, final int endInclusive) {
    validateRange(startInclusive, endInclusive);
    return startInclusive + defaultRandom.nextInt(endInclusive - startInclusive + 1);
}
```
1. validateRange()를 사용하여 시작, 종료 범위의 유효성 검증
2. startInclusive, endInclusive 사이의 숫자 하나를 반환

#### pickUniqueNumbersInRange
```java
public static List<Integer> pickUniqueNumbersInRange(
    final int startInclusive,
    final int endInclusive,
    final int count
) {
    validateRange(startInclusive, endInclusive);
    validateCount(startInclusive, endInclusive, count);
    final List<Integer> numbers = new ArrayList<>();
    for (int i = startInclusive; i <= endInclusive; i++) {
        numbers.add(i);
    }
    return shuffle(numbers).subList(0, count);
}
```
1. validateRange()를 사용하여 시작, 종료 범위의 유효성 검증
2. validateCount()를 사용하여 count의 유효성 검증
3. 시작~종료 범위의 정수를 numbers List에 추가
4. shuffle()로 무작위로 순서를 섞음
5. 인덱스 0~count까지 배열 반환

<br>

### 생각할 사항

> 더 간편한 **pickUniqueNumbersInRange**가 아닌 **pickNumberInRange**를 선택한 이유  

- 사용하려는 형태의 반환값이 반드시 배열이 아닐 수도 있기 때문

<br>

### 자료 출처
https://bit.ly/3U0JQGx  
https://bit.ly/3FEFDUs  
https://bit.ly/3DXwNjE