## Layer 분리

-   Application: Controller에게 게임 실행 요청
-   Controller: 게임 실행 흐름을 제어하여 Application에 제공
    -   Application에게 게임 실행 메소드 제공
    -   요구사항에 맞는 실행 흐름 제어
    -   사용자 입력값 검증
    -   사용자 입력값을 Service에서 요구하는 타입으로 변환
    -   게임에 필요한 상세 로직은 Service를 통해 수행
-   Service: 게임에 필요한 비지니스 로직 구현

    -   게임 세팅: 1~9 범위의 3자리 난수 생성
    -   추측값에 대한 힌트 제공

## 기능 목록

### Application

-   BaseballGameController 인스턴스 생성 후, 게임 실행 요청

### Controller

-   run()

    -   Application에게 제공되는 게임 실행 메소드
    -   요구사항에 따라 제어된 실행 흐름을 제공한다.

-   validateUserInput(String)

    -   사용자 입력값이 valid한 BaseballGameNumber인지 판단
    -   Invalid Input
        -   null
        -   3자리가 아님
        -   [1-9] 범위가 아닌 문자 포함
        -   중복 숫자 포함
    -   만약 invalid 하다면, IllegalArgumentException을 던진다.

-   toIntegerList(String): List\<Integer>
    -   유저가 입력한 3자리 숫자 문자열을 List\<Integer>로 변환
    -   변환된 값은 Service method parameter로 사용

## Service

-   setGame()

    -   BaseBallGame 시작 전 세팅 단계
    -   List\<Integer>형식의 멤버변수에 [1-9] 범위의 중복이 없는 3자리 숫자를 초기화

-   guess(List\<Integer>): Hint
    -   User의 추측값에 대해 Hint를 반환한다.
    -   Hint에 대한 정의는 요구사항 참고
