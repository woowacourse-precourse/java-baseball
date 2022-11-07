### 사전 학습 목록
- [x] TDD란 무엇이며 왜 필요한가?
- [x] 테스트 코드는 어떻게 작성하는가? (Junit5, AssertJ)
- [x] intellij-java-wooteco-style.xml 인텔리제이에 적용시키기
- [x] 코드 컨벤션이란?
- [x] 우테코 코드 컨벤션 숙지
- [x] 우테코 커밋 메시지 컨벤션 숙지

---
### 기능 구현 목록
 - BaseballView
   - void startApplication() : 숫자 야구 게임 어플리케이션을 시작한다
     - (private) void startNewGame() : 새로운 숫자 야구게임을 시작한다
       - (private) boolean inputNumber() : 플레이어가 컴퓨터가 생각하고 있는 숫자를 예측해서 입력한다
       - (private) printBallStrikeNothing(List<Integer> result) : 플레이어가 입력한 숫자에 대한 결과를 출력한다
     - (private) boolean restartGame() : 숫자 야구 게임을 재시작할지 여부를 결정하고 재시작하거나 종료한다
- BaseballController
  - List<Integer> getBallAndStrikeCount(String inputString) : 플레이어가 입력한 숫자의 유효성을 검사하고 볼과 스트라이크의 개수를 반환한다 
    - (private) List<Integer> stringToIntegerList(String inputString) : 플레이어가 입력한 문자열에 중복된 숫자가 있는지 검사하고 숫자 배열로 변환한다
  - boolean restartGame(String inputCommand) : 게임 재시작 여부 명령어의 유효성을 검사하고 컴퓨터에게 새로운 숫자를 할당한다
- BaseballService
  - List<Integer> getBallAndStrikeCounts(List<Integer> inputNumberList) : 숫자 리스트를 컴퓨터의 리스트와 비교하여 볼과 스트라이크의 개수를 담은 배열을 반환한다
  - void setAnswerNumberList() : 컴퓨터의 숫자리스트를 새로 할당함
    - (private) void addRandomNumberToList(List<Integer> list) : 컴퓨터의 숫자 리스트에 중복이 없도록 새로운 리스트를 할당