기능 구현 목록(2주차 : 숫자 야구 게임)-최종
===
---
## ✨설계 계획
- 1회성 게임으로 기능을 구현 및 검증
  - 구현메서드 : `void game()`
- 1회성 게임 Test 후, `main`메서드에서 `game`메서드 호출하여 다회성 게임으로 구현
- 최종 테스트 검증 및 리팩토링


## 🍀 1회성 게임 기능 구현 메서드 : `void game()`
> 1회에 해당하는 게임을 실행<br>
> 실행 시, 결과에 대한 내용을 콘솔창에 출력(ex. 1볼 2스트라이크)

1. `List<Integer> createRandomThreeDigitNumber()` :
   - 중복되지 않은 랜덤한 3자리 숫자를 List에 담아 반환


2. `List<Integer> userInputToList(String userInput)` :
   - String으로 입력된 user의 입력을 List로 반환


3. `List<Integer> strikeAndBallCounter(List<Integer> computer, List<Integer> user) ` :
   - computer와 user의 숫자를 비교하여, 스트라이크/볼 개수를 List에 담아 반환
   - 스트라이크/볼 카운팅을 위해, 자료구조로 Map 사용
   - 메서드 호출 스택
     - `countDigitMatched(computer, user)`
     - `countContainedAll(computer, user)`


4. `int countDigitMatched(List<Integer> computer, List<Integer> user)` :
    - computer 와 user의 List의 동일한 index에 동일한 값을 가지는 개수를 반환


5. `int countContainedAll(List<Integer> computer, List<Integer> user)` :
    - user List를 순서대로 읽고, computer List에 포함되는 값의 개수를 반환 

6. `void printResult(int strikes, int balls)` :
    - 스트라이크/볼 개수에 따른 출력


7. `void inputValidationOfUser(String input)` :
    - 사용자의 야구게임을 위한 숫자 입력 유효성 검증
    - 유효하지 않을 경우 `IllegalArgumentException` 발생 및 애플리케이션 종료


8. `void inputValidationOfStartEndCondition(String input)` :
    - 게임 종료 후, [재시작 / 종료] 입력의 유효성 검증
    - 유효하지 않을 경우 `IllegalArgumentException` 발생 및 애플리케이션 종료


## 🍀 다회성 게임 기능 구현
> `main()`메서드에 기능 구현<br>
> `while`내부 `game()` 메서드를 호출하여 반복 가능한 게임을 구현<br>
> 3스트라이크 성공하여 게임 종료시, 게임 재시작(1) or 종료(2)에 관한 사용자의 입력을 요청
> 재시작 종료에 대한 입력은 `runState` 에 저장하며, while문은 이 상태값을 참조하여 재시작과 종료 판단

## 🍀 테스트 검증(MyTest)
- [x] `inputValidationOfUser(String input)` 테스트 완료
  - 사용자가 입력한 값이 유효한 입력인지 검증<br></br>
- [x] `inputValidationOfStartEndCondition(String input) ` 테스트 완료
  - 게임 종료 시, 사용자가 재시작/종료 여부에 대한 입력이 유효한지 검증 <br></br>
- [x] `createRandomThreeDigitNumber()` 테스트 완료
  - 컴퓨터가 세자리의 중복되지 않은 숫자값을 만들어 내는지 검증<br></br>
- [x] `strikeAndBallCounter(List<Integer> computer, List<Integer> user)` 테스트 완료
  - 컴퓨터와 유저의 값을 비교하여, 스트라이크/볼 수를 센 결과를 검증<br></br>
- [x] `printResult(int strikes, int balls) ` 테스트 완료
  - 콘솔에 출력된 결과가 유효한지 검증 

## 🍀 Future work
    Junit Test Code 추가 학습