# 숫자야구 - 기능 구현 목록

- [x] 입력과 출력을 처리해주는 UI로직을 처리하는 클래스 추가
    - [x] 입력을 처리하는 inputView 클래스
        - [x] 야구 숫자를 입력받는 메소드
        - [x] 게임 재시작 여부를 입력
            - [x] 1과 2를 제외한 값이 입력되었을 때 IllegalArgumentException 발생
    - [x] 출력을 처리하는 outputView 클래스
        - [x] 게임 시작 문구 출력
        - [x] 게임의 결과(볼, 스트라이크, 낫싱)를 템플릿에 맞게 출력
        - [x] 3스트라이크 메세지 출력
        - [x] 게임 재시작 여부를 출력

- [x] 숫자 야구게임에서 사용될 수를 저장하고, 조건을 정의하는 BaseballNumber Class
    - [x] 멤버변수로 List<Integer> numbers 멤버변수를 가짐
    - [x] BaseballNumber의 유효성을 체크해주는 validate 메소드들
        - [x] 입력된 값이 null 일 때
        - [x] 입력된 수가 세 자리의 수가 아닐 때
        - [x] 입력된 수의 자릿수 중에서 중복이 있을 때
        - [x] 입력된 수의 자릿수의 범위가 1~9가 아닐 때
    - [x] number를 unmodifialbeList로 반환해 불변성 보장

- [x] BaseballNumber 끼리의 결과를 계산해줄 BaseballGameCalculator 클래스
    - [x] 게임의 결과(볼, 스트라이크)를 반환하는 로직

- [x] 게임의 결과를 저장해줄 BaseballGameResult 클래스
    - [x] 3스트라이크를 판단하는 메소드
    - [x] ball과 strike의 개수를 저장하고 이를 반환할 getter 메소드추가
    - [x] 테스트 코드를 위해 equal, hashcode 오버라이딩
    - [x] nothing 여부를 생성자에서 체크하고, 이를 boolean 형태로 반환

- [x] 전체적인 게임의 흐름을 조정할 Controller 클래스
    - [x] 게임을 초기화하고 진행하는 메소드
    - [x] 게임의 흐름을 제어하는 메소드

---

# 고민해야 할 점

### Com 클래스와 User 클래스의 부모클래스인 User 클래스가 꼭 필요할까?

- 필요한 이유
    - Com과 User 클래스 둘 모두 BaseballNumber를 가지고, BaseballNumber를 각자의 방법으로 생성한다는 공통점
- 필요하지 않은 이유
    - 굳이? 필요할까? 라는 생각
    - BaseballNumber를 생성하는 방법도, Com의 경우는 랜덤생성이라 파라미터가 없고,
      User는 String을 Argument로 사용해서 통일이 안됨.

  필요 없다고 판단함.

### Com 클래스와 User 클래스가 필요가 있을까?

- 필요한 이유
    - Com 역할을 하는 변수가 랜덤생성이란 결과물이 아닌 다른 방법으로 BaseballNumber를 호출하는 위험 또는,
      User 역할의 BaseballNumber 가 랜덤생성 할 수도 있으니, 이를 Controller에서 타입으로 규약을 거는 것
- 필요하지 않은 이유
    - Com와 User 클래스가 다른 점이라 봤자 생성방법 뿐인데, 굳이 나눠야 할까?

### 클래스 구성에 대해 고민할 점

- BaseballNumber 라는 클래스의 객체를 생성하는 두 가지 방법이 있고, 각자의 방법으로 생성한 객체가 필요함.
    1. BaseballNumber라는 abstract Class를 만들고, 이를 상속 받은 친구 ComBaseballNumber와 UserBaseballNumber를 정의
    2. BaseballNumber 클래스를 하나 정의하고, 해당 클래스에 정적 팩토리 메소드로, 생성방법 두 가지 정의
       2번 채택

### 사용자의 입력에 대한 BaseballNumber의 유효성 검증을 어디서 해야 할까?

- User 클래스에서 해야 한다.
    - 유효성에서 벗어나는 경우가 사용자의 입력일 때 밖에 없다.
- BaseballNumber 클래스에서 해야 한다.
    - 개념적으로 보면 BaseballNumber자체의 값에 대한 유효성이니 BaseballNunber 클래스에서 해야한다.

### BaseballNumber의 numbers가 랜덤생성되는 메소드는 어디에 정의해야 할까?

- Com 클래스에서 해야 한다.
    - 랜덤으로 BaseballNumber를 생성할 일이 Com일 경우 밖에 없다.
- BaseballNumber 에서 랜덤으로 수를 생성하는 메소드를 추가한다.
    - 개념적으로 생성하는 것이 BaseballNumber이기에 BaseballNumber에서 추가해야한다.
    - 추후에 BaseballNumber의 조건이 바뀌면, BaseballNumber뿐 아니라,
      Com 클래스에서도 수정을 해야 한다.

### 게임을 재시작할 경우, 프로그램의 효율성을 고민해봐야 할 점

- BaseballNumber 객체를 계속해서 재생성 할 것인가?
    - 재생성 한다.
        - 장점 : 기존 BaseballNumber의 멤버변수인 numbers에 final을 붙여 어느정도 불변성 보장이 된다.
        - 단점 : 객체를 생성하는 것은 무거운 일이기 때문에, 효율이 나오지 못할 수 있다.
        - 구현 방법 : 기존 코드를 그대로 유지
    - 재생성 하지 않고, BaseballNumber의 number 객체의 값만 수정한다.
        - 장점 : 코드가 많이 반복해도, 직접적인 numbers의 값만 수정하는 것이라, 재생성할 때보다, 더 자원을 아낄 수 있음.
        - 단점 : numbers 객체의 값이 계속 변하기 때문에 불변성 보장이 되지 않음.
        - 구현 방법 :
            1. numbers 객체 자체를 재생성하는 방법
            2. numbers 객체는 두고, numbers 객체 내부의 값만 조정하는 법