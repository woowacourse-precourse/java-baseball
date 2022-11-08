# 미션 - 숫자 야구



### 입출력 요구 사항

---

##### 입력

- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

##### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시
- 하나도 없는 경우
- 3개의 숫자를 모두 맞힐 경우
- 게임 시작 문구 출력





### 추가된 요구 사항

---

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.

  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.

  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.





### 라이브러리

---

- ```camp.nextstep.edu.missionutils```에서 제공하는 ```Randoms``` 및 ```Console``` API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.





### 구현 기능

---

#### BaseballGame class

**필드**

- BaseballGameInputFilter inputFilter : 입력 유효성을 판단하고 IllegalArgumentException을 발생시키는 filter
- BaseballRefree refree : 입력된 숫자의 결과를 출력하고 경기 종료 여부를 반환
- boolean isContinued : 경기 지속 여부 flag

**메소드**

- runBaseballGame() -> void
  - 숫자 야구 게임 진행 메소드
- getAnswerNumbers() -> String
  - 숫자 야구 정답 숫자 문자열을 반환하는 메소드



#### BaseballRefree class

**필드**

- String answerNumber : 정답 숫자 문자열
- answerNumberFlags : 정답 숫자 문자열에 포함 여부 flag

**메소드**

- judge(String numbers) -> boolean
  - 입력받은 숫자 문자열이 정답인 경우 true, 아닌 경우 false 반환
- announceResult(int ballCount, int strikeCount) -> void 
  - 입력받은 숫자 문자열의 결과를 출력
- getBallCount(String numbers) -> int 
  - 입력받은 숫자 문자열 중에 정답에 포함되는 숫자의 개수 반환
- getStrikeCount(String numbers) -> int
  - 입력받은 숫자 문자열 중 정답에 포함되며 자리도 일치하는 숫자의 개수 반환
- setAnswerNumber(String answerNumber) -> void
  - 정답 숫자 문자열을 설정
- setAnswerNumberFlags() -> void
  - 정답 숫자들의 포함 여부를 list 에 표시



#### BaseballGameInputFilter class

**필드**

- BaseballGameInputFilter baseballGameInputFilter : BaseballGameInputFilter 객체

- int numberLength : 야구 게임 숫자 길이 

**메소드**

- BaseballGameInputFilter() 
  - 생성자
- getInstance() -> BaseballGameInputFilter
  - static BaseballGameInputFilter 객체 반환 (싱글톤)

- isValidLength(String input) -> boolean
  - 입력받은 문자열의 길이가 유효한 길이인지 확인
- isNumeric(String input) -> boolean
  - 입력받은 문자열이 숫자로 구성된 문자열인지 확인
- isNotDuplicated(String input) -> boolean
  - 입력받은 숫자 문자열에 중복된 숫자가 있는지 확인
- readNumbers() -> String
  - 사용자로부터 숫자 문자열을 입력받아 입력 요구사항에 맞는 입력인지 확인
  - 유효한 숫자 문자열이 아닌 경우 IlleagalArgumentException을 발생
- readIsContinued() -> boolean
  - 야구게임의 재실행 여부를 입력 받는다.  





### 입력 예외 처리

---

##### 올바르지 않은 서로 다른 3자리의 수

- 1-9 범위에 속하지 않는 숫자(0 혹은 음수)가 포함되는 경우
- 중복된 숫자가 있는 경우
- 길이가 3이 아닌 수
- 1-9의 범위의 숫자가 아닌 다른 문자

##### 재시작/종료를 구분하기 위한 1과 2중 하나의 수

- 1 혹은 2 중 하나가 아닌 다른 숫자
- 숫자 이외의 문자

