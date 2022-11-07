# 미션 - 숫자야구

---

## 🎯목표

숫자 야구 게임을 개발한다. 숫자 야구 게임이란, 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

---

## 👀요구사항 분석

- 프로그램은 시작하며 `"숫자 야구를 시작합니다.\n"`를 출력한다.
- 프로그램은 사용자의 입력을 기다린다.
- 사용자는 서로 다른 1~9 사이의 숫자 3자를 입력한다.
  - 서로 다른 1~9 사이의 숫자 3자가 아닌 입력은 잘못된 값이다.
  - ex) `"121"`, `"1 23"`, `"!23"`, `"#$^"`, `"1234"`, `"102"`, `"015"` 등
- 프로그램은 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 종료된다.
- 프로그램은 서로 다른 임의의 숫자 3자를 지닌다.
- 사용자의 입력은 사용자가 입력한 숫자 3자가 프로그램이 지닌 숫자 3자와 동일할 때까지 반복한다.
- 프로그램은 지닌 숫자 3자와 사용자의 입력 숫자 3자를 비교한다.
- 프로그램은 `볼`과 `스트라이크`을 센다.
- `볼`은 사용자가 입력한 숫자 중 프로그램이 지닌 숫자와 종류가 같으나 위치가 다른 숫자의 개수이다.
- `스트라이크`는 사용자가 입력한 숫자 중 프로그램이 지닌 숫자와 종류가 같고 위치도 같은 숫자의 개수이다.
- 프로그램은 사용자 입력 후에 `볼`과 `스트라이크`을 출력한다.
  - 출력시에 `"<볼>볼 <스트라이크>스트라이크"` 형식으로 출력한다.
- 프로그램은 `볼`과 `스트라이크` 모두 0 이면 `"낫싱"`을 출력한다.
- 프로그램은 사용자의 입력과 지닌 숫자 3자가 동일할 경우, `"3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"`를 출력한다.
- 프로그램은 게임이 종료 전 `"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."`를 출력하고 사용자 입력을 기다린다.
  - 프로그램은 사용자 입력이 1일 때, 게임을 새로 시작한다.
  - 프로그램은 사용자 입력이 0일 때, 게임을 종료한다.

---

## 📜객체 설계

### 📝클래스 다이어그램

```mermaid
classDiagram
class Startable {
  +void start()
}
class Game {
  +void finsh()
}
class SimpleStdIOGame {
  -String name
  -GameStatus gameStatus
  #void writeGameMessage()*
  #void readInput()*
  #void checkInput()*
  +void operateRule()*
  #void writeOutput()*
  #void loopGame()
  -boolean isFinish()
  -boolean isStart()
}
class NumberBaseballStdIOGame {
  -void countBall()
  -void countStrike()
  -void prepareOutputData()
  -boolean isStrike(idx)
  -boolean isBall(idx)
  -void count() 
}
class GameStatus {
  -boolean isStart
  -boolean isFinish
}
class StdIOGameStatus {
  -String inputData
  -String outputData
}
class NumberBaseballStdIOGameStatus {
  -Map~Character,Integer~ targetNumber
  -int ballCount
  -int strikeCount
}
class GameManager {
  +void restartGame()
  +void startGame()
  +boolean doesGameStart()
  +boolean doesGameFinish()
}
class NumberBaseballStdIOGameManager {
  -NumberBaseballStdIOGameManager INSTANCE
  -Game game
  +NumberBaseballStdIOGameManager getInstance()
}
<<interface>> Startable
<<interface>> Game
<<abstract>> SimpleStdIOGame
<<interface>> GameManager
<<Singleton>> NumberBaseballStdIOGameManager
Startable <|-- Game
Game <|-- SimpleStdIOGame
SimpleStdIOGame ..|> NumberBaseballStdIOGame
GameStatus <|-- StdIOGameStatus
StdIOGameStatus <|-- NumberBaseballStdIOGameStatus
NumberBaseballStdIOGame "1" --* "1" NumberBaseballStdIOGameStatus : has
GameManager ..|> NumberBaseballStdIOGameManager
NumberBaseballStdIOGameManager "1" --* "1" NumberBaseballStdIOGame : has
```

#### Startable

시작 할 수 있음을 표현한 간단한 **인터페이스**

- 시작할수 있다.
  - `void start()`

#### Game

게임을 표현한 **인터페이스**이다. `Startable`을 상속한다.
- 게임을 끝낸다.
  - `void finish()`

#### SimpleStdIOGame

표준 입출력을 이용한 간단한 게임을 표현한 **추상 클래스**이다. `Game`을 상속한다.

- 게임의 이름을 지닌다.
  - `private String name`
- 게임의 상태를 지닌다.
  - `private GameStatus gameStatus`
- 게임 상태에 따라 메시지를 출력한다.
  - `protected abstract void writeGameMessage()`
- 입력을 받는다.
  - `protected abstract void readInput()`
- 입력에 오류를 점검한다.
  - `protected abstract void checkInput() throws IllegalArgumentException`
- 입력을 게임의 규칙에 따라 판단한다.
  - `public abstract void operateRule()`
    - 판단에 따라 게임의 상태가 변한다.
- 판단에 따라 출력을 낸다.
  - `protected abstract void writeOutput()`
- 게임의 로직을 반복한다.
  - `protected void loopGame()`
  ```java
  protected void loopGame() {
    writeGameMessage();
    while (!isFinish()) {
        readInput();
        checkInput();
        operateRule();
        writeOutput();
    }
    writeGameMessage();
  }
  ```
- 게임이 끝났는지 검사한다.
  - `private boolean isFinish()`
- 게임이 시작했는지 검사한다.
  - `private boolean isStart()`

#### NumberBaseballStdIOGame

표준 입출력을 이용한 숫자야구 게임을 표현한 **클래스**이다. `SimpleStdIOGame`을 상속한다.
- `볼`을 계산한다.
  - `private void countBall()`
- `스트라이크`를 계산한다.
  - `private void countStrike()`
- 현재 상태를 보고 출력문을 작성한다.
  - `private void prepareOutputData()`
- 사용자 입력의 인덱스와 프로그램이 지닌 숫자의 인덱스를 비교한다.
  - `private boolean isStrike(int idx)`
  - `private boolean isBall(int idx)`
- `볼`과 `스트라이크`를 계산한다.
  - `private void count()`

#### GameStatus

게임의 상태를 나타내는 **클래스**이다.
- 게임의 상태 값을 갖는다.
  - `private boolean isStart`
  - `private boolean isFinish`

#### StdIOGameStatus

표준 입출력을 이용한 게임의 상태를 나타내는 **클래스**이다. `GameStatus`를 상속한다.
- 입력 데이터를 갖는다.
  - `private String inputData`
- 출력 데이터를 갖는다.
  - `private String outputData`

#### NumberBaseballStdIOGameStatus

표준 입출력을 이용한 숫자야구 게임의 상태를 나타내는 **클래스**이다. `StdIOGameStatus`를 상속한다.
- 사용자가 맞춰야하는 숫자 3자를 갖는다.
  - `private Map<char,int> targetNumber`
- `볼`을 담을 데이터를 갖는다.
  - `private Integer ballCount`
- `스트라이크`를 담을 데이터를 갖는다.
  - `private Integer strikeCount`

#### GameManager

게임의 시작과 종료를 관리하는 **인터페이스**이다.
- 게임을 재시작한다.
  - `public void restartGame()`
- 게임을 시작한다.
  - `public void startGame()`

#### NumberBaseballStdIOGameManager

표준 입출력을 이용한 숫자 야구 게임의 시작과 종료를 관리하는 **클래스**이다. `GameManager`를 구현한다.
- 프로그램 상에 하나의 객체만 존재한다.
- 표준 입출력을 이용한 숫자 야구 게임을 갖는다.
  - `private final Game game`
- 게임이 끝난 상태인지 검사한다.
  - `public boolean doesGameFinish()`
- 게임이 시작한 상태인지 검사한다.
  - `public boolean doesGameStart()`