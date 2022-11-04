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