# 리팩토링

객체 별 의존도를 낮추는 방향으로 최대한 리팩토링했지만 아직 부족한 부분이 많이 보입니다.

어떻게 개선할 수 있을 지 의견 주시면 감사하겠습니다:)


### 1. 숫자 포장 객체 & 일급 컬렉션

#### 리팩토링 전

컴퓨터와 플레이어가 선택한 숫자를 아래와 같이 `List<Integer>` 타입으로 저장했다.

컴퓨터와 플레이어의 숫자 리스트를 반복문으로 접근해 각 원소를 차례로 비교했고,
볼/스트라이크 개수를 구할 때 중복되는 로직이 발생했다.

중복을 없애고자 아래 코드처럼 볼/스트라이크 개수를 한번에 계산했지만, 로직 간에 의존도가 높아진다는 문제가 있었다.

```java

public GameResult getBallStrikeResult(List<Integer> playerGuess){
    int strike=countStrike(playerGuess);
    int ball=countNumbersContainedInAnswer(playerGuess)-strike;

    return new GameResult(ball,strike);
}

private int countNumbersContainedInAnswer(List<Integer> playerGuess){
    return(int)playerGuess.stream()
        .filter(input->answer.contains(input))
        .count();
}

private int countStrike(List<Integer> playerGuess){
    int strike=0;
    for(int idx=0;idx<ANSWER_SIZE; idx++){
        if(playerGuess.get(idx)==answer.get(idx)){
            strike++;
        }
    }
    return strike;
}

```

<br/>

#### 리팩토링 후

숫자의 인덱스와 값을 저장하는 `Number` 객체와 `Number`의 일급 컬렉션인 `NumberCollection`을 추가했다.

객체 간에 메시지를 주고 받으며 독립적으로 볼/스트라이크 개수를 구하는 것이 가능해졌다.

<br/>

### 2. MVC 패턴 적용

#### 리팩토링 전
`Game`, `GameResult`, `Player` 클래스만 존재했다. 

입출력과 입력에 대한 유효성 검증, 로직이 모두 한 클래스에 섞여있어 역할 파악이 어려웠고,
적절히 분리되지 않아 테스트 코드도 구체적으로 작성하지 못했다.

#### 리팩토링 후

    model : 게임 진행 과정에서 생성되는 인스턴스 객체 및 생성자 패키지

    view : 사용자 입출력 관련 enum 타입의 싱글톤 객체 패키지

    controller : 사용자 입력에 따라 모델을 생성하고 게임 흐름을 제어하는 싱글톤 객체 패키지

    util : 게임 설정 관련 상수 및 입출력 메세지를 관리하는 유틸리티 클래스 패키지

    valid : 입력의 유효성을 검사하는 클래스 패키지

    exception : 사용자 입력 예외 외의 실행 예외 클래스 패키지


기능 목록의 모든 기능에 대한 테스트 코드 작성도 가능해졌다.

<br/>

### 3. Enum 타입 싱글톤 객첵

인스턴스 객체를 생성하지 않는 클래스를 enum 타입으로 선언하여 모두 싱글톤 객체로 구현했다.
(이펙티브 자바 아이템3 참조)

<br/>

### 4. 생성자 매개변수의 유효성 확인

클래스의 생성자에서 매개변수에 대한 유효성 검증 메서드를 호출했다. 
(이펙티브 자바 아이템49 참조)

유효하지 않은 값이 전달된 경우 `RuntimeException` 을 상속한 예외가 발생하도록 구현했다.
(@apptie 님의 코드를 참고했습니다!)

`Number`, `NumberCollection`, `GameResult` .. 나머지 클래스에 대해서도 추후 리팩토링 필요

<br/>


### 추가 리팩토링 필요
- [ ] `toString` 재정의
- [ ] `equals` 메서드를 재정의한 클래스에 대해 `hashCode` 메서드 추가
- [ ] javaDocs 작성
- [ ] DTO??

<br/>

---


## 기능 목록

### 출력

- [x] 게임 시작 안내 문구 출력
- [x] 게임 결과 출력
- [x] 올스트라이크 문구 출력

### 입력

- [x] 1에서 9까지 서로 다른 3가지 수 입력
- [x] 게임 재시작/종료 입력

### 예외

- [x] 플레이어의 숫자가 1에서 9까지 서로 다른 3가지 수가 아니면 `IllegalArgumentException` 발생
- [x] 게임 재시작/종료에 대한 입력이 1 혹은 2가 아니면 `IllegalArgumentException` 발생

### 게임 진행 로직

- [x] 컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개 선택


- [x] 플레이어의 숫자와 컴퓨터의 숫자 비교
    - [x] 같은 숫자, 같은 자리인지 확인
    - [x] 같은 숫자, 다른 자리인지 확인


- [x] 플레이어의 숫자 컬렉션과 컴퓨터의 숫자 컬렉션 비교
    - [x] 스트라이크 개수 반환
    - [x] 볼 개수 반환


- [x] 플레이어 숫자에 대한 게임 결과 객체 반환


- [x] 게임 결과를 문자열로 반환
    - [x] 볼/스트라이크의 개수가 모두 0이면 `낫싱` 반환
    - [x] 볼이 1개 이상, 스트라이크가 0개라면 `(볼 개수)볼` 반환
    - [x] 스트라이크가 1개 이상, 볼이 0개라면 `(스트라이크 개수)스트라이크` 반환
    - [x] 볼/스트라이크의 개수가 모두 1 이상이면 `(볼 개수)볼 (스트라이크 개수)스트라이크` 반환


- [x] 올스트라이크 확인