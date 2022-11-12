# 구현할 기능목록
1. 컴퓨터 수 만들기<br>
   (1~9 사이 / 서로 다른 / 세자리 수)<br>
   <br>

2. 플레이어 수 입력받기
    1) `camp.nextstep.edu.missionutils.Console.readLine()` 을 사용해 입력 받기
    2) 입력 유효성 체크
        * 숫자인지
        * 1~9 사이 / 서로 다른 세 자리 수 인지
        * 잘못된 값을 입력할 경우 `IllegalArgumentException`발생 후 애플리케이션 종료
          <br>

3. 플레이어 수와 컴퓨터 수 비교하기
    1) 플레이어 수 자리마다 비교하기
    2) 분기문1 : 플레이어의 n자리수를 컴퓨터가 포함하는지
        * 포함하지 않으면 -> 낫싱
        * 포함하면 -> 볼
    3) 분기문2 : 플레이어의 n자리 수와 컴퓨터의 n자리수가 일치하는지
        * 일치하지 않으면 -> 볼
        * 일치하면 -> 스트라이크
          <br>
4. 비교한 결과 출력하기<br>
   <br>
5. 정답인지 확인하기<br>
   -**정답이면, 반복을 끝내고, 6번으로 가기**<br>
   -**정답이 아니면, 2로 돌아가 반복하기**
   <br>
   <br>
6. 게임을 계속할 것인지 묻기(입력받기)
    1) `camp.nextstep.edu.missionutils.Console.readLine()` 을 사용해 입력 받기
    2) 입력 유효성 체크
        * 1 또는 2인지
        * 잘못된 값을 입력할 경우 `IllegalArgumentException`발생 후 애플리케이션 종료
    3) 재시작인지 아닌지 확인하기
        - 1번(재시작)이면, 1로 돌아가 반복하기
        - 2번(게임종료)이면, 프로그램 종료하기
          <br>
          <br>

---
# 단위 테스트 코드 작성 및 FIX
1. <컴퓨터 수 생성하기 메서드> TEST
    - [X] 컴퓨터 수 범위 테스트 (1<= number<=9)
    - [X] 컴퓨터 수 서로 다른지 테스트<br><br>
2. <플레이어 수 유효성 체크하기 메서드> TEST
    - [X] 유효하지 않은 경우 예외 발생 테스트<br>
      <strong>* ERROR #1 :\"120"을 입력했을 때, 예외 발생 안함 </strong><br>
      -> 해결 : 0을 포함하면, 무조건 예외 발생<br>
      -> <u>문제점 : 게임에서 숫자의 범위가 바뀐다면? 코드 수정이 불가피함</u><br>
      <strong>* ERROR #? :\"1123"을 입력했을 때, 예외 발생 안함. 유효한 수 123 이라고 판단하였다 </strong><br>
      -> 해결 : 유효성 체크하기 메서드 3가지로 세분화
      `isCorrectSize`, `isInRange`, `isNotDuplicated` <br><br>
3. <컴퓨터 수와 플레이어 수 비교하기 메서드> TEST
    - [X] 비교한 결과 옳은지 테스트<br>
      <strong>* ERROR #2 :컴퓨터수가 플레이어수를 포함하기만 하면, ball 개수 ++ 되는 오류 발생 </strong><br>
      -> 해결 : if 스트라이크, { 명령 }에 return문 추가<br><br>
4. <비교값 문자열로 만들기 메서드> TEST
    - [X] 결과값이 문자열 형식에 맞는지 테스트<br><br>
5. <전체 게임 실행> TEST
    - [X] 올바르게 동작하는지 테스트<br>
      <strong>* ERROR #3 :\"123"을 입력하면, {49,50,51} 이 List<Integer>에 입력됨 </strong><br>
      -> 원인 : char가 int 타입으로 바뀌면서, 유니코드가 리스트에 저장됐기 때문이다.<br>
      -> 해결 : intStream에 `.map(i->i-'0')` 추가하여 유니코드 값이 아닌 숫자 저장되도록 함<br>
    - [X] 사용자가 유효하지 않은 값 입력하면 예외 발생 테스트<br>
      <strong>* ERROR #4 : 유효하지않은 값 입력해도, 예외 발생 안함 </strong><br>
      -> 원인 : main메서드에서 예외 처리함<br>
      -> 해결 : main메서드의 try-catch문 제거<br><br>

---
# 클린코드를 위해 고려할 점
## 1.게임에서 요구하는 숫자(N자리 수, 수의 범위)가 바뀔 경우에 코드 수정이 용이한가?<br>
    NO.
    -> 해결방향 1: 게임의 룰에 해당되는 숫자들을 상수화(private final) 한다
    -> 해결방향 2: 게임에서 반복적으로 사용되는 문구도 상수화 한다
<br><br>
## 2. Application 파일에 모든 메서드를 담았다. 가독성이 좋은가?<br>
    NO.
    -> 해결방향 : (내용)에 관련된 메서드를 묶어, 클래스를 분리한다


- Application(실행) 클래스)
  - 
    - Controller 클래스의 인스턴스 생성해서, 실행하기
- Controller(게임의 로직) 클래스
  - 
    - private 상수 목록 :
        - `computerNumber` : 컴퓨터 수 저장 할 변수
        - `isPlaying` : 게임 실행 중인지 boolean 변수
        - `String 스트라이크, 볼, 낫싱` : 게임 문구
        - `COMMAND_RESTART` : 재시작 숫자 (Rule 사용)
        - `COMMAND_END` : 게임종료 숫자 (Rule 사용)
    - `generate()` : 게임의 전체 로직 작동 메서드
    - `checkAnswer()`, `checkBallOrStrike()` : 컴퓨터와 플레이어 수 비교 메서드
    - `createHint()` : 힌트 문자열로 생성 메서드
    - `isCorrect()` : 정답 확인 메서드
    - `restartOrEnd()` : 재시작 or 게임 종료 메서드
- View(사용자 인터페이스::입출력) 클래스
  - 
    - `getUserInput()` : 플레이어 수 입력받는 메서드
    - `printHint()` : 힌트 출력하는 메서드
    - `getExitInput()` : 게임 끝난 후, 재시작/종료 입력받는 메서드

- Model(게임에서 다루는 요소) 클래스
  - 
    - private 상수 목록:
        - `DISITS` : 숫자의 자릿수 (Rule사용)
        - `RANDOM_MIN` : 숫자 범위의 최솟값 (Rule사용)
        - `RANDOM_MAX` : 숫자 범위의 최댓값 (Rule사용)
    - `createComputerNumber()` : 컴퓨터 수 생성 메서드
    - `createPlayerNumber()` : 플레이어 수 생성 메서드
    - `stringToList()` : 사용자 입력 값을 List로 변환 메서드
- Vaildator (게임의 로직 중 유효성 체크) 클래스
  - 
    - private 상수 목록:
        - `DISITS` : 숫자의 자릿수 (Rule사용)
        - `RANDOM_MIN` : 숫자 범위의 최솟값 (Rule사용)
        - `RANDOM_MAX` : 숫자 범위의 최댓값 (Rule사용)
        - `COMMAND_RESTART` : 재시작 숫자 (Rule 사용)
        - `COMMAND_END` : 게임종료 숫자 (Rule 사용)
    - `isNumber` : 숫자인지 확인 메서드
    - `isValidNumber` : 게임의 RULE을 지키는 숫자인지 확인 메서드
    - `isCorrectSize` : 지정한 자리 수인지 확인 메서드
    - `isInRange` : 지정한 범위인지 확인 메서드
    - `isNotDuplicated` : 수가 중복되었는지 확인 메서드
    - `isValidCommandNumber` : 게임의 RULE을 지키는 명령 숫자인지 확인 메서드
- Rule (게임의 룰) Enum클래스
  - 
    - 게임 룰과 관련된 상수
      <BR>:`DISITS`, `RANDOM_MIN`, `RANDOM_MAX`, `COMMAND_RESTART`,`COMMAND_END`


<br><br>
3. 코드의 효율성이 좋은가? = 코드의 반복이 없는지