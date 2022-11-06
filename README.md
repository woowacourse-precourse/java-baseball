# 미션 - 숫자 야구

---

## 🚀 기능 목록

- ### abstractClasses 패키지
  - [X] **InputChecker**
  - 입력이 유효한지 검사하는 추상클래스입니다.
  - 추상 메서드 isInputErroneous를 가지고 있습니다.

  - [X] **Game**
  - 게임 구현에 사용될 추상클래스입니다.
  - 추가적인 게임 구현시 사용(ex. 여러가지 미니게임들을 포함한 게임팩)
  - 상수 status, gameName과 추상메서드 initialize, terminate, operate를 가집니다.
    - [X] getStatus
    - 게임의 상태를 알려줍니다.
    - [X] getGameName
    - 게임의 이름을 알려줍니다.
    - [X] setStatus
    - 게임의 상태를 설정합니다.

- ### baseball 패키지
  - [X] **Messages**
    - 게임 작동에 필요한 메시지들을 포함한 Enum 클래스입니다.
    - [X] Messages 생성자
    - 매개변수로 받은 메시지 문자열을 저장합니다.
    - [X] printMessage
      - 저장된 메시지를 콘솔에 출력합니다.
    - [X] printScore
      - 점수를 출력합니다.

  - [ ] **BaseballInputChecker**
    - 숫자 야구 게임의 입력이 유효한지 검사하는 클래스입니다.
    - [ ] hasLengthOf
    - 문자열의 길이가 매개변수 값과 일치하는지 검사합니다.
    - [ ] hasDigitsOnly
    - 문자열이 숫자만 포함했는지 검사합니다.
    - [ ] isInputErroneous
    - 유효 입력을 검사하기 위해 외부로 노출되는 메서드입니다. 
    - 게임 상태와 입력을 인자값으로 받습니다.
      - [ ] isGuessCommandValid
      - 게임 도중일 경우, 숫자 야구 게임에 유효한 입력인지 검사합니다.
      - [ ] isEndCommandValid
      - 게임 종료일 경우, 재시작/종료 입력인지 검사합니다.

  - [ ] **BaseballGame**
    - 숫자야구 게임을 위한 클래스입니다.
      - [X] BaseballGame 생성자
      - 게임 인스턴스를 생성합니다.
        - [X] getBaseballNumber
        - 야구 게임의 클리어 조건 숫자를 알려줍니다.
        - [X] setBaseballNumber
        - 야구 게임의 클리어 조건을 설정합니다.

      - [X] initialize
      - 게임을 초기화 합니다. 
      - 게임 상태를 게임중으로 바꾸고, 랜덤한 숫자들을 선정해 클리어 조건 숫자로 저장합니다.
        - [X] getRandomNumbersOf
        - 매개변수 개수 만큼의 랜덤 숫자를 생성합니다.
      - [X] terminate
      - 게임을 종료시킵니다.
      - 게임 상태를 게임끝으로 바꿉니다.
      
      - [X] operate
      - 게임 상태에 따라 입력을 처리합니다.
        - [X] playTurn
        - 숫자 야구 게임 한 턴을 진행합니다.
          - [X] getGuessResult
          - 숫자 하나씩 검사하며 스트라이크와 볼의 갯수를 센다.
            - [X] getDigitResult
            - 숫자 하나가 스트라이크인지, 볼인지, 아웃인지 알려준다.
            - [ ] isGameOver
            - 게임 종료 조건을 충족했는지 확인합니다.
        - [ ] askNewGame
        - 새로운 게임을 시작할지 확인합니다.

---

## ✏ 과제 진행 중 배운 점

- ## 좋은 코드 리뷰란? [[참조](https://soojin.ro/review/review-comments)]
  - ### 코드 리뷰의 목적: 
  
    **전체적인 코드 품질을 꾸준히 개선하기 위함**
  
  - ### 코드 리뷰를 잘 작성하는 법:

    - **친절하게 작성하기**
      - 의견의 충돌이 일어나는 부분이기 때문에 갈등이 일어나기 쉽다.
      - 작성자가 아니라 코드에 대한 의견을 제시한다.
    - **이유를 설명하기**
      - 듣는 사람이 납득할만한 이유를 제시해야한다.
      - 제안이 어떻게 코드 품질을 개선하는지 설명을 해주면 좋다.
    - **방향 제시하기**
      - 리뷰어가 상세한 설계까지 해줄 의무는 없다.
      - 하지만 본인의 적절한 판단 하에 문제점을 지적하기만 할 수도 있고 좀 더 상세하게 방향을 제시할 수도 있다.

  - ### 중점적으로 볼 것:
    1. **기능**

       작성자가 의도한 대로 코드가 동작하는가? 반례는 없는가?

    2. **복잡도**

       코드를 더 간단히 할 수는 없는가? 오버엔지니어링 된 부분은 없는가?

    3. **테스트**
    
        테스트가 적합한가? 적절한 단위로 나뉘어 있는가?
    
    4. **이름**

        변수, 메서드, 클래스 등의 이름이 한 눈에 봐도 이해할 정도로 명료한가? 너무 길지는 않은가?

    5. **주석**
    
        주석이 명료하고 도움이 되는가? 정말 필요한 주석만 있는가?

    6. **스타일**
    
        정해진 스타일 가이드를 따르고 있는가? 스타일 변경은 별도의 CL에서 관리되었는가?

    7. **문서**

       코드에 대응되는 문서를 제대로 최신화 시켰는가?

- ## Junit5로 유닛 테스트 작성 시 사용가능한 어노테이션 [[참조](https://donghyeon.dev/junit/2021/04/11/JUnit5-%EC%99%84%EB%B2%BD-%EA%B0%80%EC%9D%B4%EB%93%9C/)]
  - **@Nested** : 비슷한 테스트를 묶어주기 위해 사용한다.
  - **@DisplayName** : 테스트 클래스나 테스트 메소드에 이름을 붙여줄 때 사용한다.
  - **@DisplayNameGeneration** : 클래스에 해당 애노테이션을 붙이면 @Test 메소드 이름에 언더바(_)로 표시한 모든 부분은 공백으로 처리된다.
  - **@BeforeEach** : 테스트 메소드가 실행되기 전에 실행된다.
  - **@AfterEach** : 테스트 메소드가 실행되고 난 후 실행된다.
  - **@BeforeAll**: 모든 테스트를 시작하기 전 딱 한 번만 실행 된다.
  - **@AfterAll**: 모든 테스트가 완전히 끝난 후 딱 한 번만 실행 된다.
  - **@Tag** : 테스트를 필터링할 때 사용한다.
  - **@Disabled** : 테스트 클래스나, 메소드의 테스트를 비활성화 한다.
  - **@Timeout** : 주어진 시간안에 테스트가 끝나지 않으면 실패한다.

- ## if문 없이 분기 처리하기 [[참조](https://dublin-java.tistory.com/38)]

  ```java
  public class Calculator {
  private static Map<String, BiFunction<Double, Double, Double>> operators = new HashMap<>();

    static {
      operators.put("+", (num1, num2) -> num1 + num2);
      operators.put("-", (num1, num2) -> num1 - num2);
      operators.put("*", (num1, num2) -> num1 * num2);
      operators.put("/", (num1, num2) -> num1 / num2);
      }
    public static double calculate(String operator, double num1, double num2) {
        return operators.get(operator).apply(num1, num2);
    }
  }
  ```
  분기의 **조건**들을 **해시맵의 키**로 설정하고 수행할 **함수**를 함수형 API를 사용해 **밸류**로 넣어주면, get과 apply 메서드로 함수를 실행할 수 있다.