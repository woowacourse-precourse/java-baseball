# 미션 - 숫자 야구

## 🚨 개발 고려 사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 `test/java/study`를 참고하여 학습한 후 테스트를 구현한다.
## 🚀 기능 요구 사항
- 판정 기준
    - 같은 수가 같은 자리 : 스트라이크
    - 다른 자리 : 볼
    - 같은 수가 전혀 없음 : 낫싱
- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택
    - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료(1:새로 시작 / 2:종료)
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료

## 객체 리스트
    Baseball : 야구 게임 계산
        - boolean gaming : 현재 게임중인지 여부
        - int guessNumber : 추정 숫자
        - List<Integer> targetNumber : 정답 숫자
        - BallCount ballCount : 볼 / 스트라이크 카운트
    
    BallCount : 볼 / 스트라이크 카운트
        - Integer ballCount : 볼 카운트
        - Integer strikeCount : 스트라이크 카운트

## 주요 기능 리스트
1. 1에서 9까지 서로 다른 임의의 수 3개를 선택 기능(private)
    - `Baseball.resetTarget()`
    1. targetNumber 최신화
    2. `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`사용
2. 숫자 입력 받기 기능(public)
    - `Baseball.setGuessNumber(int guessNumber)`
    1. parameter로 받은 수가 (1)1~9로 이루어진 (2)서로 다른 (3)세자리 정수인지 Validation
    2. guessNumber 최신화
3. 볼/스트라이크 계산 기능(private)
    - 볼 카운트 계산 : `BallCount.ruleBallCount()`
    1. 3자리수 loop 돌면서 다른 자리 수와 같은 수가 있으면 count up
    - 스트라이크 카운트 계산 :`BallCount.ruleStrikeCount() `
    1. 3자리수 loop 돌면서 다른 자리 수와 같은 수가 있으면 count up
    

## 필요 메소드 리스트 
### Controller
1. GuessNumber를 읽어오는 read 기능 
   - `readGuessNumber`
2. GuessResult를 출력하는 write 기능
   - `printGuessResult`

### Baseball
1. Getter : `ballCount`
2. 게임 시작 기능(public)
    - `start()`
    1. gaming = true
    2. resetTargetNumber() 호출
    3. 게임 시작 문구 출력
3. 게임 재시작 기능(public)
    - `restart()`
    - targetNumber, guessNumber, BallCount 초기화
4. 게임 종료 기능(public)
    - `end()`
    - Gaming == false
5. 현재 게임중인지 확인하는 기능
    - `isGaming()`
6. GuessResult 기능(public)
    - `getGuessResult()`

### BallCount
1. Getter : `ballCount`, `strikeCount`
2. 비교 계산후 결과 종류 확인하는 기능
   - `getGuessResult()`
   - return GuessResult

## 기능 Flow
- Baseball.start()로 게임 시작(targetNumber 초기화)
- while 문 안에서 Baseball.isGaming = true 인 경우 로직 수행
- Controller.readGuessNumber()로 숫자 입력 받기
- Baseball.setGuessNumber(입력받은 숫자)
- Baseball.getGuessResult()로 결과 경우의 수 받기(ENUM)
  - BALL_STRIKE
    - Baseball.getBallCount(), Baseball.getStrikeCount() 로 볼/스트라이크 카운트 출력
  - ONLY_BALL / ONLY_STRIKE 
    - 각각 볼과 스트라이크 만 출력
  - NOT_SING
    - "낫싱" 출력
  - END
    - "3스트라이크
      3개의 숫자를 모두 맞히셨습니다! 게임 종료
      게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력 
    Baseball.chooseContinue()
      - 1 : Baseball.restart()
      - 2 : Baseball.end()
- 
  




   
