# 🔍 라이브러리 분석

---

## Console 분석

### readLine()
- 사용자의 입력을 받는 메소드

### getInstance()
- 전역변수로 선언되 있는 Scanner 반환
- null이거나 닫혀있을 때는 새로운 Scanner 생성

### isClosed()
- scanner의 sourceClosed 변수 반환
>sourceClosed : 자원이 종료되었는지 확인 변수(Boolean is true if source is done)
- getDeclaredField()
    - Java Reflection을 사용하면 특정 인스턴스의 멤버변수, 메소드 등에 접근 할 수 있다.
    - private인 멤버변수에 접근하기 위해서 getDeclaredFields 사용
- setAccessible()
    - getDeclaredField 메소드로 멤버변수 정보에는 접근 가능하나 값에는 접근이 불가능하다.
    - private 멤버 변수 값을 read/write 하기 위해서는 setAcccesible을 통해 접근을 허용 해줘야 된다.


## Randoms 분석

>ThreadLocalRandom : 자바7에서 추가된 기능으로 스레드 별로 난수 생성을 할 수 있는 랜덤 클래스, current() 라는 정적 메서드를 통해 객체를 얻도록 되어 있다.

### pickNumberInList()
- validateNumbers() 체크 후
-  파라미터로 넘어온 list 중 에서 랜덤 값 반환

### pickNumberInRange()
- validateRange() 체크 후
- startInClusive부터 endInclusive 사이 숫자 중 랜덤 숫자 반환

### pickUniqueNumbersInRange()
- validateRange() 체크
- validateCount() 체크 후
- list에 startInclusive부터 endInclusive 까지 숫자를 추가해 shuffle() 한 뒤 subList()를 이용해 count 수만큼 반환
- 중복되지 않는 하나의 리스트에서 모든 수를 반환하기 때문에 반환된 숫자는 모두 unique하다.

### shuffle()
- 파라미터로 넘어온 list 내의 숫자 섞기

### validateNumbers()
- 파라미터로 넘어온 list가 비었으면 IllegalArgumentException 발생

### validateRange()
- startInclusive가 endInclusive보다 작으면 IllegalArgumentException 발생
- endInclusive가 Integer 최대값과 같은 경우 IllegalArgumentException 발생
- 전체 범위가 Integer 최대값이 넘어 가는 경우 IllegalArgumentException 발생

### validateCount()
- count가 0보다 작거나 전체 개수 보다 크면 IllegalArgumentException 발생

## Assertions 분석

### assertSimpleTest()
- assertTimeoutPreemptively(SIMPLE_TEST_TIMEOUT, executable)
- 테스트가 SIMPLE_TEST_TIMEOUT 안에 실행되는지 테스트

> assertTimeoutPreemptively() : Executable을 실행해 TIMEOUT이 지나는 순간 테스트를 종료해 테스트가 성공한지 확인

### assertRandomTest()
- 테스트가 RANDOM_TEST_TIMEOUT 안에 제대로 실행되는지 테스트
- MockedStatic 객체를 이용해 static 메소드 테스트
- verification이 실행되면 value값들 Return

> 왜 MockedStatic을 썼을까 궁금했다.
> 
> Mockito는 final과 static 메서드를 mocking 하는걸 지원하지 않음
> 
> mocking은 이 static mock이 생성된 쓰레드에만 영향을 미치며 다른 쓰레드에서 이 객체를 사용하는 건 안전하지 않다.
> 이 객체의 ScopedMock.close()가 호출되면 static mock이 해제된다. 이 객체가 닫히지 않으면 static mock 객체는 시작 쓰레드에서 활성 상태로 유지된다.
> 따라서 예를 들어 JUnit 규칙이나 확장을 사용해 명시적으로 관리되는 경우가 아니면 try-with-resources 문 안에서 이 객체를 만드는 것이 좋다.

### assertRandomNumberInListTest
- pickNumberInList(anyList())가 RANDOM_TEST_TIMEOUT 안에 제대로 실행되는지 테스트

> 특정한 값이 아닌 임의이 값에 대해 실행하고 싶을 때 ArgumentMatchers를 이용해 인자 값을 지정하면 된다.
> 
> Matchers 클래스는 anyList()뿐 아니라 anyInt(), anyString(), anyLong() 등 다양한 메서드를 제공한다.

### assertRandomNumberInRangeTest
- pickNumberInRange(anyInt(), anyInt())가 RANDOM_TEST_TIMEOUT 안에 제대로 실행되는지 테스트

### assertRandomUniqueNumbersInRangeTest
- pickUniqueNumbersInRange(anyInt(), anyInt(), anyInt())가 RANDOM_TEST_TIMEOUT 안에 제대로 실행되는지 테스트

### assertShuffleTest
- shuffle(anyList())가 RANDOM_TEST_TIMEOUT 안에 제대로 실행되는지 테스트

참고:
- https://onlyfor-me-blog.tistory.com/445