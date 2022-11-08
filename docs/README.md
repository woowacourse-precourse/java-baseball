# 미션 - 숫자 야구

## 기능 목록
- [x] 게임이 종료되면 게임을 다시 시작하거나 완전히 종료할 수 있다. - Computer().continueOrQuit()
- [x] 게임을 시작할 수 있다. - Computer.playGame()
  - [x] 컴퓨터의 서로 다른 임의의 수 3개를 선택한다. - Computer.selectNumbers()
      - [x] 랜덤한 수를 받는다. - Ball.getRandomNumber()
  - [x] 플레이어는 입력을 받을 수 있다. - Player.getInput()
  - [x] 플레이어는 입력받은 값을 리스트로 변환한다. - Player.StringToList()
      - [x] 잘못된 값이 입력되는것을 검사한다. - Player.checkWrongInput()
  - [x] 몇개의 숫자가 같은지 알 수 있다. - Computer.checkSameNumbersCount()
  - [x] 같은 자릿수인지 알 수 있다. - Computer.checkSameNumberOfDigit()
  - [x] 컴퓨터는 볼, 스트라이크를 리스트로 변환한다. - Computer.getBallStrikeList()
  - [x] 컴퓨터는 입력한 숫자에 대한 결과를 출력한다. - Computer.printResult()
