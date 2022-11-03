# 기능목록
## 객체별 구현목록
### ComputerNumberGenerator
컴퓨터에 저장된 수가 3개가 될 때 까지 반복한다.
1. insertNumber() : 랜덤값 1~9가 이미 있지 않으면 저장시킨다.
   1. createRandomNumber : 랜덤값 1~9 출력 함수
   2. isAlreadyInNumbers : 이미 있으면 true 리턴 함수
   3. putNumber : 값을 저장시키는 함수
2. makeThreeDigitNumber() : 1~9의 세자리 랜덤 값을 생성한다.
   1. insertNumber() 3번 반복
3. returnNumbersToArray : 리스트에 저장한 숫자들을 배열로 리턴해준다.

### PlayerInputFilter
1. getInput() : readLine으로 입력한 문자열을 반환한다.
2. checkException(String input) : 입력한 문자열로 에러가 발생하는지 체크한다.
   1. isNotNumber(String input) : 입력한 문자열에 숫자가 아닌게 있을 떄 참을 반환한다.
   2. noNumberException() : IllegalArgumentException와 메세지로 예외처리한다.
   3. isNotThreeDigit(String input) : 문자열의 길이가 3이 아니면 참을 반환한다.
   4. notThreeDigitException() : IllegalArgumentException와 메세지로 예외처리한다.
   5. containsZero(String input) : 문자열에 0이 있으면 참을 반환한다.
   6. containsZeroException() : IllegalArgumentException와 메세지로 예외처리한다.
   7. containsSameNumber(String input) : 문자열에 같은 숫자가 존재하면 참을 반환한다.
   8. containsSameNumberException() : IllegalArgumentException와 메세지로 예외처리한다.
3. insertNumbers()
   1. getInput() : 문자열을 받아온다.
   2. checkException(String input) : 문자열 예외처리를 확인한다
   3. convertNumbersToArray(String input) : 문자열을 int형 배열로 전환해 리턴한다.

### GameSystem
1. makeGame() : 게임을 생성한다. gameSet이 2가 아닌동안 반복한다.
   1. setGameStatus() : 전역변수 gameSet = 1로 설정
   2. initializeGame() : game에 대한 초기값을 설정해준다.
      1. setComputerNumber() : ComputerNumberGenerator.makeThreeDigitNumber()후에 returnListToArray해준다.
   3. startGame() : 게임을 시작시킨다. strikeCount == 3 일때까지 반복한다.
      1. setPlayer() : PlayerinputFilter.insertNumber()를 이용해 전역변수 정수형 배열 player에 입력한 문자열을 숫자 3개로 저장한다.
      2. initializeScore() : 전역변수 strikeCount, ballCount = 0으로 초기화한다.
      3. countScore() : 플레이어의 숫자들과 컴퓨터의 숫자들을 비교해 점수를 만든다.
         1. checkComputerWithPlayerNumber() : 반복문으로 0부터 2까지 인덱스를 이용해 컴퓨터와 사람을 비교한다.
         2. scoreGameWithIndex(int index) : 인덱스를 이용해 플레이어와 컴퓨터를 비교한다.
         3. isStrike(int index) : 플레이어 인덱스의 숫자와 컴퓨터 인덱스 숫자가 같다면 참을 반환
         4. isBall(int index) : 플레이어 인덱스의 숫자가 컴퓨터 인덱스의 숫자와는 다르지만 컴퓨터가 해당 값을 가지고 있다면 참을 반환
         5. increaseStrike() : 전역변수 strikeCount를 1증가 시켜준다.
         6. increaseBall() : 전역변수 ballCount를 1증가시킨다.
      4. getResultOfScores() : 점수들에 따른 결과를 출력해준다.
         1. isNothing() : strikeCount == 0 && ballCount == 0일 때 참을 반환한다.
         2. printNothing() : “낫싱”을 출력해준다.
         3. isOnlyBall() : strikeCount == 0 && ballCount != 0일때 참을 반환한다.
         4. printOnlyBall() : “a 볼”을 출력해준다.
         5. isOnlyStrike() : strikeCount != 0 && ballCount == 0일때 참을 반환한다.
         6. printOnlyStrike() : “b 스트라이크”를 출력한다.
         7. isBothBallAndStrike() : strikeCount !=0 && ballCount != 0일때 참을 반환한다.
         8. printBothBallAndStrike() : “a볼 b스트라이크” 를 출력한다.
   4. DetermineToEndOrNot() : 게임을 계속할지 끝낼지 확인한다. 정수 opinion이 1도 2도 아니면 반복한다. 
      1. askOpinion() : 입력을 받아 정수로 반환한다.
      2. isMoreGame(int opinion) : 정수가 1이면 참을 반환
      3. isEndOfGame(int opinion) : 정수가 2이면 참을 반환
      4. finishGame() : gameSet=2로 초기화한다. 
      5. isNotRightAnswer() : 1도 2도 아닐 경우 참을 반환한다.
      6. askAnotherOpinion() : 다른 답을 요청한다. 


