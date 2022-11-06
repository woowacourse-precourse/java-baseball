## JAVA-BASEBALL

### TODO LIST
- 게임 시작을 알리는 함수(Game.init)
- 서로 다른 3자리 수를 만드는 함수(Game.makeThreeNums)
- 유저가 정답을 맞추면 게임 종료를 알리는 함수(Game.end)

- 유저의 게임 정답 입력을 받는 함수(User.getGameInput)
- 유저의 입력 형식을 확인하는 함수(User.checkGameInput)
  - 입력을 List<Integer>로 반환하는 함수(User.getGameInputFormat)
  - 입력의 길이를 확인하는 함수(User.checkGameInputLength)
  - 서로 다른 수 인지 확인하는 함수(User.checkGameInputDuplicate)
- 유저의 게임 재시작 여부 입력을 받는 함수(User.getRestartinput)

- 유저의 입력과 정답을 비교하여 힌트를 알려주는 함수(Hint.get)
- 볼의 개수를 세는 함수(Hint.countBall)
- 스트라이크의 개수를 세는 함수(Hint.countStrike)

- 함수별 test 작성