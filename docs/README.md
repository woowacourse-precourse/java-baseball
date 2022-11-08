# 미션 - 숫자 야구

## 진행 순서 및 기능 목록

0. 애플리케이션 실행
1. 게임 시작
    1. 게임 시작 안내 문구를 출력하는 기능
2. 컴퓨터가 정답을 생성하는 기능
    2. `1 ~ 9`까지의 숫자를 각 자릿수로 가지는 세 자릿수를 정답으로 생성하는 기능
        1. 각 자릿수는 중복되어서는 안 됨
        2. 각 자릿수는 무작위로 생성되어야 함
3. 게임 진행
    1. 플레이어에게 정답을 입력하라는 안내 문구를 출력하는 기능
    2. 플레이어가 정답을 입력하는 기능
        1. 세 자릿수여야 함
        2. 각 자릿수는 `1 ~ 9`까지의 숫자여야 함
        3. 각 자릿수는 중복되어서는 안 됨
    3. 플레이어의 정답과 컴퓨터의 정답을 비교하는 기능
        1. `스트라이크`가 몇 개 있는지 계산하는 기능
        2. `볼`이 몇 개 있는지 계산하는 기능
        3. `낫싱`인지 계산하는 기능
    4. 플레이어의 정답에 대한 결과 안내 문구를 출력하는 기능
    5. 플레이어의 정답과 컴퓨터의 정답을 비교한 결과를 통해 게임 결과를 확인하는 기능
       1. 정답이 아닐 시 게임 계속 진행
          1. `3번`으로 이동
       2. 정답일 시 게임 종료
          1. `4번`으로 이동
4. 게임 종료
   1. 3개의 숫자를 모두 맞혔으며, 게임이 종료되었다는 안내 문구를 출력하는 기능
   2. 플레이어가 게임을 새로 시작할것인지에 대한 안내 문구를 출력하는 기능
   3. 플레이어가 게임을 새로 시작할지에 대한 유무를 입력하는 기능
       1. 게임을 새로 시작(`1`), 애플리케이션 종료(`2`) 중 하나여야만 함
           1. 게임을 새로 시작한 경우 `1번`으로 이동
           2. 애플리케이션을 종료한 경우 `5번`으로 이동
5. 애플리케이션 종료

---

요구사항에는 없으나 `MVC`구조 내에서 발생한 예외와 사용자 입력으로 인한 예외를 구분하기 위해 `ApplicationRuntimeException` 예외를 추가했습니다.

## 패키지 구조

### src/main/java

```
└── src
    └── main
        └── java
            └── baseball
                ├── Application.java 
                ├── GameRunner.java 
                ├── domain
                │   ├── game
                │   │   ├── GameComputer.java
                │   │   └── GameResult.java
                │   └── number
                │       ├── GameNumber.java
                │       └── GameNumbers.java
                ├── mvc
                │   ├── controller
                │   │   ├── GameCommandController.java
                │   │   ├── GamePlayController.java
                │   │   └── GameSettingsController.java
                │   ├── exception
                │   │   └── ApplicationRuntimeException.java
                │   ├── model
                │   │   ├── DataMap.java
                │   │   ├── Model.java
                │   │   └── Request.java
                │   ├── structure
                │   │   ├── Adapter.java
                │   │   ├── FrontController.java
                │   │   ├── GameHandlerAdapter.java
                │   │   ├── GameHandlerManager.java
                │   │   ├── GameHandlerMapping.java
                │   │   ├── ModelAndView.java
                │   │   ├── adapter
                │   │   │   ├── GameCommandAdapter.java
                │   │   │   ├── GamePlayAdapter.java
                │   │   │   └── GameSettingsAdapter.java
                │   │   ├── consts
                │   │   │   ├── GameModelKeyConst.java
                │   │   │   └── GameRequestKeyConst.java
                │   │   └── enums
                │   │       └── GameCommand.java
                │   └── view
                │       ├── GameGuideView.java
                │       ├── GameHintView.java
                │       └── GameInputView.java
                └── util
                    ├── GameNumberConst.java
                    └── GameStatus.java

```

- `GameRunner` : 숫자 야구 게임 진행을 요청하는 클래스
- `domain`
  - `game` 
    - `GameComputer` : 컴퓨터 정답을 관리하는 클래스
    - `GameResult` : 플레이어 정답과 컴퓨터 정답을 비교한 결과를 관리하는 클래스
  - `number`
    - `GameNumber` : 정답으로 사용되는 숫자를 관리하는 `Wrapper` 클래스
    - `GameNumbers` : `GameNumber` 클래스를 관리하는 일급 컬렉션
- `mvc` 
  - `controller`
      - `GameCommandController` : `GameCommand`에 의한 처리 결과에 따라 게임 진행 상태를 결정하는 클래스
      - `GamePlayController` : 플레이어의 정답과 컴퓨터 정답을 비교해 결과를 계산하고 결과에 따라 게임 진행 상태를 결정하는 클래스
      - `GameSettingsController` : 게임이 시작될 때 컴퓨터 정답을 생성하고 게임 진행 상태를 결정하는 클래스
  - `exception`
    - `ApplicationRuntimeException` : `Model - View - Controller` 구조에서 발생하는 예외 `Wrapper` 클래스
  - `model` 
    - `DataMap` : 데이터를 관리하기 위한 기본 클래스
    - `Model` : `Controller`에서 외부로 전달하는 데이터를 관리하는 `DataMap` 확장 클래스
    - `Request` : `Controller`에서 필요한 데이터를 관리하는 `DataMap` 확장 클래스
  - `structure`
    - `Adapter` : `FrontController`에서 상황에 맞는 다른 `Controller`를 실행하기 위한 인터페이스
    - `FrontController` : 플레이어의 모든 요청을 받아 요청에 맞는 `Handler`인 `Controller`를 호출해 로직을 수행하고 게임 진행 상태를 반환받아 그에 맞는 로그를 출력하는 클래스
    - `GameHandlerAdapter` : 모든 `Adapter`를 관리하고 `Handler`인 `Controller`를 처리할 수 있는 `Adapter`를 반환하는 기능을 제공하는 클래스
    - `GameHandlerManager` : `GameHandlerAdapter`와 `GameHandlerMapping`을 내부적으로 가지고 있는 클래스
    - `GameHandlerMapping` : 모든 `Controller`를 관리하고 게임 상태에 따라 필요한 `Handler`인 `Controller`를 반환하는 클래스
    - `ModelAndView` : `Controller`가 외부로 전달하는 데이터와 `GameStatus`를 가지고 있는 클래스
    - `adapter`
      - `GameCommandAdapter` : `GameCommandController`를 실제로 실행하고 `GameStaus`와 필요한 데이터를 `ModelAndView`로 반환하는 클래스
      - `GamePlayAdapter` : `GamePlayController`를 실제로 실행하고 `GameStaus`와 필요한 데이터를 `ModelAndView`로 반환하는 반환하는 클래스
      - `GameSettingsAdapter` : 실제 `GameSettingsController`를 실제로 실행하고 `GameStaus`와 필요한 데이터를 `ModelAndView`로 반환하는 클래스
    - `consts`
      - `GameModelKeyConst` : `Model`에서 사용하는 `key`를 상수로 정의한 클래스
      - `GameRequestKeyConst` : `Request`에서 사용하는 `key`를 상수로 정의한 클래스
    - `enum`
      - `GameCommand` : 플레이어가 게임 종료 이후 게임을 재시작할지 애플리케이션을 종료할지에 대한 입력을 처리하는 `enum`
  - `view`
    - `GameGuideView` : 게임 시작 및 종료 안내 문구를 출력하는 `enum`
    - `GameHintView` : 플레이어의 정답과 컴퓨터 정답을 비교한 결과를 안내 문구로 출력하는 `enum`
    - `GameInputView` : 플레이어의 입력이 필요할 때 입력 안내 문구를 출력하는 `enum`
- `util`
  - `GameNumberConst` : 숫자 야구 게임의 숫자 관련 제한 사항을 상수로 정의한 클래스
  - `GameStatus` : 게임 상태를 정의한 `enum`

### src/test/java

```
└── src
    └── test
        └── java
            ├── baseball
            │     ├── ApplicationTest.java
            │     ├── GameRunnerTest.java
            │     ├── domain
            │     │     ├── game
            │     │     │     ├── GameComputerTest.java
            │     │     │     └── GameResultTest.java
            │     │     └── number
            │     │         ├── ConstructorTestExceptionMessage.java
            │     │         ├── StandardGameNumber.java
            │     │         ├── GameNumberTest.java
            │     │         └── GameNumbersTest.java
            │     ├── helper
            │     │     ├── exception
            │     │     │     ├── CannotReflectionException.java
            │     │     │     └── FieldNotFoundException.java
            │     │     ├── factory
            │     │     │     ├── FrontControllerFactory.java
            │     │     │     ├── GameComputerFactory.java
            │     │     │     └── stub
            │     │     │         └── StubGameNumbers.java
            │     │     └── util
            │     │         ├── DataMapTestUtils.java
            │     │         ├── GameGuideViewTestUtils.java
            │     │         ├── GameHintViewTestUtils.java
            │     │         ├── GameInputViewTestUtils.java
            │     │         ├── GameNumbersTestUtils.java
            │     │         ├── GameStatusTestUtils.java
            │     │         └── ReflectionFieldUtils.java
            │     └── mvc
            │         ├── controller
            │         │     ├── GameCommandControllerTest.java
            │         │     ├── GamePlayControllerTest.java
            │         │     └── GameSettingsControllerTest.java
            │         ├── model
            │         │     └── MapDataTest.java
            │         ├── structure
            │         │     ├── FrontControllerTest.java
            │         │     ├── GameHandlerAdapterTest.java
            │         │     ├── GameHandlerManagerTest.java
            │         │     ├── GameHandlerMappingTest.java
            │         │     ├── ModelAndViewTest.java
            │         │     └── adapter
            │         │         ├── GameCommandAdapterTest.java
            │         │         ├── GamePlayAdapterTest.java
            │         │         └── GameSettingsAdapterTest.java
            │         ├── util
            │         │     └── GameCommandTest.java
            │         └── view
            │             ├── GameGuideViewTest.java
            │             ├── GameHintViewTest.java
            │             ├── GameInputViewTest.java
            │             └── OutputSettings.java
            └── study
                └── StringTest.java
```

- `baseball/helper`
  - `exception` : 테스트를 위한 `Reflection` 진행 도중 실패 시 발생하는 예외 클래스가 위치한 패키지
  - `factory` : 테스트를 위한 특정 객체를 생성해 반환하는 클래스가 위치한 패키지
    - `stub` : 테스트를 위해 정의한 구체적인 방식대로만 동작하는 `Stub` 클래스가 위치한 패키지
  - `util` : 테스트를 위해 `Reflection` 기능을 수행하는 유틸리티 클래스가 위치한 패키지

