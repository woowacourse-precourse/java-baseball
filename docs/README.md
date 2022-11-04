# 숫자 야구 기능 목록

## class Computer
- List answer
- Computer()
    - 1~9까지 숫자 중 임의로 서로 다른 3가지 숫자를 골라 answer List에 추가한다
- boolean isBall(int digit)
    - 한 자리 숫자 digit을 입력 받고 answer에 있는지 boolean을 리턴한다
- boolean isStrike(int index, int digit)
    - answer의 index번째 값이 digit인지 boolean을 리턴한다
- int judgeDigit(int index, int digit)
    - index 위치의 digit이 아무것도 아니라면 0, 볼이라면 1, 스트라이크라면 2를 리턴한다
- void addJudgement(Result result, int index, int digit)
    - index 위치의 digit의 판정 결과를 result에 추가한다
- Result judgeNumber(String playerNumber)
    - playerNumber의 판정 결과를 Result 객체로 리턴한다

## class Result
- int ball
- int strike
- Result()
    - ball, strike 둘 다 0으로 초기화
- void addBall()
    - ball의 값을 1 증가시킴
- void addStrike()
    - strike의 값을 1 증가시킴
- boolean checkFinish()
    - strike가 3인지 리턴한다
- String ballToString()
    - ball이 0이라면 NULL을 리턴한다
    - ball.toString() + "볼" 을 리턴한다
- String strikeToString()
    - strike이 0이라면 NULL을 리턴한다
    - strike.toString() + "스트라이크" 를 리턴한다
- String toString()
    - ball과 strike 정보를 문자열로 리턴한다 둘 다 0이라면 "낫싱"을 리턴한다

## class Player
- String getNumber()
    - "숫자를 입력해주세요 : "를 출력하고 사용자로부터 입력받는다
- void isValidNumber(String number)
    - getNumber()로 받은 문자열이 올바른 입력이 아니면 예외를 발생시키고 종료한다
- String getRestart()
    - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."를 출력하고 사용자로부터 입력받는다
- void isValidRestart(String restart)
    - getRestart()으로 받은 문자열이 올바른 입력이 아니면 예외를 발생시키고 종료한다

## class Game
- void startMessage()
    - 게임 시작 문구 출력함
- void finishMessage()
    - 게임 종료 문구 출력함
- boolean checkRestart(String playerRestart)
    - 게임을 다시 시작할지 종료할 지 리턴한다
- void try()
    - Player 객체의 getNumber()를 호출해 입력받고 isValidNumber()를 호출해 검증한다
    - Computer 객체의 judgeNumber() 메소드를 호출해 결과를 받고 출력한다
    - checkFinish() 함수를 호출해 종료할 지 여부를 결정한다
- void start()
    - Computer 객체를 생성한다
    - 정답을 맞출 때 까지 try()를 반복한다
    - 종료메시지를 출력한다
- void restartLoop()
    - Player 객체를 생성한다
    - 시작메시지를 출력한다
    - 사용자가 종료할 때까지 start()를 반복한다
