# 기능목록
## 클래스별 구현목록

## 모델
### Player
1. getNumbers() : 정수 리스트를 리턴한다. 
2. setNumbers(String input) : 문자열을 입력받아 리스트로 모델에 저장한다. 

### Computer
컴퓨터에 저장된 수가 3개가 될 때 까지 반복한다.
1. insertNumber() : 랜덤값 1~9가 이미 있지 않으면 저장시킨다.
   1. createRandomNumber : 랜덤값 1~9 출력 함수
   2. isAlreadyInNumbers : 이미 있으면 true 리턴 함수
   3. putNumber : 값을 저장시키는 함수
2. makeThreeDigitNumber() : 1~9의 세자리 랜덤 값을 생성한다.
   1. insertNumber() 3번 반복
3. getNumbers() : 정수형 리스트를 반환한다. 

## 예외처리
### PlayerException
checkException(String input) : 입력한 문자열로 에러가 발생하는지 체크한다.
1. isNotNumber(String input) : 입력한 문자열에 숫자가 아닌게 있을 떄 참을 반환한다.
2. isNotThreeDigit(String input) : 문자열의 길이가 3이 아니면 참을 반환한다.
3. containsZero(String input) : 문자열에 0이 있으면 참을 반환한다.
4. containsSameNumber(String input) : 문자열에 같은 숫자가 존재하면 참을 반환한다.
5. wrongNumberException() : "입력은 1부터 9중 서로 다른 3개의 숫자여야 합니다."로 예외처리한다. 

## 뷰
### PlayerView
1. requestInput() : 입력 요청문을 출력한다. 
2. readInput() : 입력문을 받아 문자열로 저장한다. 
3. PlayerException을 통해 예외처리한다.
4. getInput() : 저장 문자열을 반환한다. 

### ScoreResultView
전역변수 ballCount, strikeCount를 가진다.
1. setBallCount(int ballCount) : 볼을 개수만큼 입력받아 전역변수를 초기화한다. . 
2. setStrikeCount(int strikeCount) : 스트라이크를 개수만큼 입력받아 전역변수를 초기화한다. 
3. getResultOfScores(String result) : 점수들에 따른 결과를 문자열로 출력해준다. 
4. makeResultString() : 스트라이크와 볼로, 문자열을 반환한다. 
   1. isNothing() : strikeCount == 0 && ballCount == 0일 때 참을 반환한다.
   2. printNothing() : “낫싱”을 반환한다.
   3. isOnlyBall() : strikeCount == 0 && ballCount != 0일때 참을 반환한다.
   4. printOnlyBall() : “a 볼”을 반환한다.
   5. isOnlyStrike() : strikeCount != 0 && ballCount == 0일때 참을 반환한다.
   6. printOnlyStrike() : “b 스트라이크”를 반환한다.
   7. printBothBallAndStrike() : “a볼 b스트라이크” 를 반환한다.

### GameStatusView
1. askOpnion() : 게임 재실행에 대한 요청문을 출력한다. 
2. readOpinion() : 콘솔 입력을 문자열로 저장한다. 
3. isNotCorrectAnswer() : "1", "2"가 아니면 참을 반환
4. alertWrongAnswer() : 잘못된 문자열임을 출력한다. 
5. getOpinion() : 저장한 문자열을 리턴한다. 

## 서비스
### GameService
initializeScore() : 전역변수 strikeCount, ballCount = 0으로 초기화한다.
countScore() : 플레이어의 숫자들과 컴퓨터의 숫자들을 비교해 점수를 만든다.
1. checkComputerWithPlayerNumber() : 반복문으로 0부터 2까지 인덱스를 이용해 컴퓨터와 사람을 비교한다.
2. scoreGameWithIndex(int index) : 인덱스를 이용해 플레이어와 컴퓨터를 비교한다.
3. isStrike(int index) : 플레이어 인덱스의 숫자와 컴퓨터 인덱스 숫자가 같다면 참을 반환
4. isBall(int index) : 플레이어 인덱스의 숫자가 컴퓨터 인덱스의 숫자와는 다르지만 컴퓨터가 해당 값을 가지고 있다면 참을 반환
5. increaseStrike() : 전역변수 strikeCount를 1증가 시켜준다.
6. increaseBall() : 전역변수 ballCount를 1증가시킨다.
7. setPlayer(String input) : 뷰에서 받은 입력을 컨트롤러를 통해 받아 플레이어 객체에 저장시킨다. 
8. setComputer() : 컴퓨터 객체를 새로 만들고, makeThreeDigitNumbers()해준다. 

### GameStatusService
전역 변수 gameStart
1. 생성자 : gameStatus = true로 초기화
2. setGameStatus(String opinion)
   1. isEndOfGame(String opinion) : 문자열이 2이면 참을 반환
   2. stopGame() : gameStart = false로 초기화
   3. getGameStatus() : gameStatus를 반환


## 컨트롤러
### GameController
위의 클래스들을 참조한다. 
1. initializeGame() : GameStatusService를 생성해 gameStatusService를 참으로 초기화
2. setGame() : GameService에서 setComputer()를 해서 컴퓨터 난수 생성
3. startGame()
   1. clearScore() : GameService의 strikeCount, ballCount를 0으로 초기화해준다. 
   2. getPlayerNumbers() : PlayerView에서 입력 요청을 하고, 입력받은 문자열을 GameService에 넣어준다.  
   3. matchGame() : GameService에 setPlayer, setComputer을 해서 점수를 계산한다. 
   4. showPlayersScore() : GameService의 strikeCount, ballCount를 가져와 ScoreResultView로 보내 점수를 출력시킨다. 
   5. isThreeStrike() : GameService에서 스트라이크 개수를 가져와 3개면 참을 반환한다. 
   6. whatToDoNext() 
      1. getPlayersOpinion() : GameStatusView를 통해 입력을 받아온다. 
      2. setGameStatus(String opinion) : GameStatusService에 문자열 입력변수를 넣어 "2"이면 서비스의 gameStatus를 거짓으로 바꾼다. 
