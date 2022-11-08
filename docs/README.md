**기능 목록**
- Class - UserAnswer

    ```
    userNumber를 입력받아 배열에 저장하며,입력값이 적절한지 검사를 시행한다.
    입력 값이 부적절한 경우IllegalArgumentException을 발생시킨다.
    - Method : readFromUser, getUserAnswer, isEmpty, isDifferentNumber, isInSize, toIntegerList, clear
    - Variables : userNumber, userNumberString
    ```

  - method - readFromUser : camp.nextstep.edu.missionutils.Console의 readLine()을 활용하여 사용자의 답을 읽어들임
  - method - getUserAnswer : userAnswer를 return
  - method - isEmpty : 예외처리, 입력값 size가 0인경우 IllegalArgumentException 발생
  - method - isDifferentNumber : 예외처리, 같은 값이 있는 경우 IllegalArgumentException 발생
  - method - isInSize : 예외처리, size가 3이 아닌 경우 IllegalArgumentException 발생
  - method - isNumber : 예외처리, 1~9의 숫자가 아닌 경우 IllegalArgumentException 발생
  - method - toIntegerList : 입력받은 userAnswerString을 int ArrayList인 userAnswer에 저장
  - method - clear : userNumber를 clear

- Class - ComputerAnswer

  ```
  computerAnswer class는 아래의 역할을 수행한다.
  - 임의의 수3개를computerAnswer배열에 저장하고 리턴하는 클래스
  - Variables : ArrayList<Integer> computerNumber
  - Methods : createRandomAnswer, getComputerAnswer
  ```

    - method - *`createRandomAnswer : 난수를 3개 생성하여 computerNumber에 추가한다.`*
    - method - *`getComputerAnswer : computerNumber ArrayList를 Return한다.`*

- Class - StrikeBallCounter

    ```
    StrikeBallCounter Class는 아래의 역할을 수행한다.
    - userAnswer와 computerAnswer를 비교하여strike와ball의 개수를 count하여 return한다.
    - Variables : int strikeCount, int ballCount
    - Methods : compareAnswers, isStrike, isBall, getStrikeCount, getBallCount, clear
    ```

  - method - compareAnswers : userAnswer의 하나의 숫자가 computerAnswer에 포함되어있으면 isStrike와 isBall 메서드를 호출한다.
  - method - isStrike : 같은 인덱스에서 두 숫자가 같으면 strikeCount를 증가시킨다.
  - method - isBall : 같은 인덱스에서 두 숫자가 다르면 ballCount를 증가시킨다.
  - method - getStrikeCount : strikeCount를 반환한다.
  - method - getBallCount : ballCount를 반환한다.
  - method - clear : strikeCount와 ballCount를 초기화한다.

- Class - ProcessorPrinter

    ```
    ProcessorPrinter Class는 아래의 역할을 수행한다.
    - ballCount와 strikeCount가 0인지 확인하여 경우에 따른 출력type에 맞게 count를 출력한다.
    - Methods : processAndPrint, nothing, onlyBall, onlyStrike, bothStrikeBall
    ```

  - method - processAndPrint : ballCount와 strikeCount가 0이 아닌 경우 bothStrikeBall 메서드를 호출, strikeCount만 0이 아닌 경우 onlyStrike, ballCount만 0이 아닌 경우 onlyBall, 그 외는 nothing을 호출한다.
  - method - bothStrikeBall : Ball Strike의 순서로 카운트를 출력하도록 ResultPrinter의 메서드를 호출한다.
  - method - onlyStrike : Strike의 카운트만 출력하도록 ResultPrinter의 메서드를 호출한다.
  - method - onlyBall : Ball의 카운트만 출력하도록 ResultPrinter의 메서드를 호출한다.
  - method - nothing : 낫싱을 출력하도록 ResultPrinter의 메서드를 호출한다.

- Class - ResultPrinter

    ```
    ResultPrinter class는 아래의 역할을 수행한다.
    - ProcessorPrinter에서 호출함에 따라 strike, ball count를 출력한다.
    - Methods : rintNothing, printBall, printStrike, printSpace, printEndOfLine
    ```

  - method - printNothing : 낫싱을 출력한다.
  - method - printBall : ballCount와 볼을 출력한다.
  - method - printStrike : strikeCount와 스트라이크를 출력한다.
  - method - printSpace : 스페이스를 출력한다.
  - method - printEndOfLine : 개행문자를 출력한다.

- Class - GameRestarter

    ```
    GameRestarter Class는 아래의 역할을 수행한다.
    - 게임 스타트 메시지와 게임 종료 메세지를 출력한다.
    - restartFlag를 입력받는다.
    - Methods : printEndMessage, printStartMessage, getRestartFlag, endGame, restartGame
    - Variables : restartFlag
    ```

  - method - printEndMessage : 종료 메시지를 출력한다.
  - method - printStartMessage : 시작 메시지를 출력한다.
  - method - getRestartFlag : restartFlag 값을 retrun한다.
  - method - endGame : restartFlag 값이 2인 경우 게임을 종료한다.
  - method - restartGame : restartFlag 값이 1인 경우 게임을 재개한다.

- method - main
  - method - getUserAnswer : UserAnswer 메서드를 Group
  - method - getComputerAnswer : ComputerAnswer 메서드를 Group