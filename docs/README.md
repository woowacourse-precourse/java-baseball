# 구현할 기능 목록

## 메소드 목록

- [ ]  **1에서 9까지 서로 다른 임의의 수 3개인지 확인하는 메소드**
    - [ ]  Set에 넣었을 때의 크기가 3이 아니거나
    - [ ]  Set.contains(0)
    - [ ]  게임 플레이어가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - [ ]  return Boolean

- [ ]  **게임 플레이어에게 숫자 3개를 입력 받는 메소드**
    - [ ]  ArrayList<Integer> 입력 받기
    - [ ]  **1에서 9까지 서로 다른 임의의 수 3개인지 확인하는 메소드**
    - [ ]  return 사용자가 입력한 숫자 ArrayList

- [ ]  **정답 숫자 3개를 생성하는 메소드**
    - [ ]  컴퓨터는 **1에서 9까지** **서로 다른 임의의 수 3개**를 생성한다.
    - [ ]  return ArrayList

- [ ]  **스트라이크의 개수를 계산하는 메소드(playerNumberArray, answerNumberArray)**
    - [ ]  strikeCount = 0;
    - [ ]  wrongNumberIndexArray
    - [ ]  for int i=0; i≤3; i++
        - [ ]  playerNumberArray[i] == answerNumberArray[i]
            - [ ]  strikeCount = strikeCount + 1;
        - [ ]  playerNumberArray[i] != answerNumberArray[i]
            - [ ]  wrongNumberIndexArray.add(i);
    - [ ]  LinkedHashMap
        - [ ]  strikeCount: strikeCount
        - [ ]  wrongNumberIndexArray: wrongNumberIndexArray
    - [ ]  return LinkedHashMap;

- [ ]  **볼의 개수를 계산하는 메소드(playerNumberArray, answerNumberArray, strikeResult)**
    - [ ]  wrongPlayerNumberSet
    - [ ]  answerNumberSet
    - [ ]  for int i : strikeResult.wrongNumberIndexArray
        - [ ]  wrongPlayerNumberSet.add(**playerNumberArray[i])**
        - [ ]  answerNumberSet.add(**answerNumberArray[i])**
        - [ ]  교집합의 개수
    - [ ]  return 볼의 개수

- [ ]  **게임 플레이어가 입력한 숫자 3개를 판단하는 메소드**
    - [ ]  strikeResult = **스트라이크의 개수를 계산하는 메소드(playerNumberArray, answerNumberArray)**
    - [ ]  **볼의 개수를 계산하는 메소드(playerNumberArray, answerNumberArray, strikeResult)**
    - 123을 제시한 경우 : 1스트라이크
    - 456을 제시한 경우 : 1볼 1스트라이크
    - 789를 제시한 경우 : 낫싱
    - [ ]  return LinkedHashMap

- [ ]  **게임 플레이어가 맞춘 결과를 출력하는 메소드(decisionResult)**

- [ ]  **게임이 끝났는지 확인하는 메소드(decisionResult)**
    - [ ]  if (decisionResult.strikeResult.strikeCount == 3)
        - [ ]  finishResult = true;
    - [ ]  else if (decisionResult.strikeResult.strikeCount < 3)
        - [ ]  finishResult = false;

- [ ]  **게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력 받는 메소드**
    - [ ]  게임 플레이어에게 입력 받고
    - [ ]  return 1 or 2

- [ ]  **게임 진행 메소드(정답 숫자 ArrayList)**
    - [ ]  finishResult = false;
    - [ ]  while (finishResult == false) {
        - [ ]  **게임 플레이어에게 숫자 3개를 입력 받는 메소드**
        - [ ]  decisionResult = **게임 플레이어가 입력한 숫자 3개를 판단하는 메소드**
        - [ ]  **게임 플레이어가 맞춘 결과를 출력하는 메소드(decisionResult)**
        - [ ]  finishResult = **게임이 끝났는지 확인하는 메소드(decisionResult)**
    - [ ]  **게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력 받는 메소드**

- [ ]  **solution 메소드**

  int keepPlaying = 1;

  while (keepPlaying == 1) {

    - [ ]  정답 숫자 3개를 생성하는 메소드
    - [ ]  **게임 진행 메소드(정답 숫자 ArrayList)**

## 테스트 목록

- [ ]  규정에 맞지 않는 숫자 넣어서 예외 발생 시키는 경우 테스트