# 미션 - 숫자 야구

## 기능 목록
- [ ] 게임이 종료되면 게임을 다시 시작하거나 완전히 종료할 수 있다. - Computer().continueOrQuit()
- [x] 컴퓨터의 서로 다른 임의의 수 3개를 선택한다. - Computer.selectNumbers()
    - [x] 랜덤한 수를 받는다. - Ball.getRandomNumber()
- [ ] 컴퓨터는 입력한 숫자에 대한 결과를 출력한다. - Computer.printResult()
    - [ ] 컴퓨터는 플레이어의 입력한 숫자와 비교할 수 있다. - Computer.compareNumbers()
        - [ ] 플레이어는 서로 다른 3개의 숫자를 입력할 수 있다. - Player.inputNumbers()
            - [x] 잘못된 값이 입력되는것을 검사한다. - Player.checkWrongInput()
        - [ ] 몇개의 숫자가 같은지 알 수 있다. - Computer.checkSameNumbersCount()
        - [ ] 같은 자릿수인지 알 수 있다. - Computer.checkSameNumberOfDigit()