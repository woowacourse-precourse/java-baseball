# 기능 설명

## Constant 패키지

### Constant 클래스
클래스 구현을 할 때 사용하는 리터럴 값을 상수로 만들어 저장해놓은 클래스

## controller 패키지
### BaseballGameController 클래스
Model의 값을 View에 전달하거나 플레이어의 입력 숫자를 바탕으로 힌트(x볼 x스트라이크)를 알려주는 등 기능에 대한 메서드를 구현해놓은 클래스

- start()

    - 게임을 시작하거나 재시작할 경우 랜덤한 정답을 생성한다. 플레이어의 입력 숫자에 대해 스트라이크와 볼의 정보를 알려주며 3스트라이크가 되었을 때 정답을 맞췄을 때 나오는 문구를 출력해주는 메서드


- receiveInputNumberFromPlayer()

    - 플레이어의 입력 숫자를 받아서 입력 조건을 체크해주는 AnswerNumber로 넘겨주는 메서드(View에서 값을 받아 Model로 넘겨주는 메서드)


- keepGoingOrDone()

   - 정답을 맞춘 후에 게임을 재시작할 건지(1) 종료할 건지(2)를 처리해주는 메서드
   - 재시작할 경우 true를 반환한다.
   - 플레이어의 입력이 1 또는 2가 맞는지 체크해주고 아니면 IllegalArgumentException을 발생시킨다.

    

## service 패키지

### HintService 클래스
정답(AnswerNumber)과 사용자의 입력숫자(PlayerNumber)를 받아 스트라이크와 볼 값을 Controller로 반환해주는 클래스 

- getHint()
  - 정답과 사용자의 입력 숫자를 매개변수로 받아와 스트라이크와 볼, 낫싱에 대한 정보를 String타입으로 반환해주는 메서드
 

- countStrike()
  - 정답과 사용자의 입력 숫자를 가지고 스트라이크의 수를 반환해주는 메서드 
  

- countBall()
  - 정답과 사용자의 입력 숫자를 가지고 볼의 수를 반환해주는 메서드


- nothing()
  - strike와 ball의 수가 0일 때 "낫싱"을 문자열에 추가해주는 메서드


- resetCount()
  - 힌트(스트라이크,볼 낫싱의 대한 정보)에 대한 기능을 작동시키기 전에 사용되는 변수들을 초기화 시켜주는 메서드


- printStrikeHint()
  - 스트라이크 값이 0이 아닐 때 문자열에 스트라이크에 대한 정보를 추가해주는 메서드


- printBallHint()
  - 볼 값이 0이 아닐 때 문자열에 볼에 대한 정보를 추가해주는 메서드


- isThreeStrike()
  - strike가 3인지 확인하고 3이 맞으면 true를 반환해주는 메서드


## exception 패키지

### Exception 클래스
발생할 수 있는 예외에 대한 메서드를 모아놓은 클래스

- isOneOrTwo(int number)
  - 정답을 맞힌 후에 게임을 사용자가 입력한 재시작(1) 또는 종료(2) 정보가 올바른지 확인하는 메서드
  - 입력받은 값이 1또는 2가 아니라면 IllegalArgumentException 발생
  - ("1 또는 2만 입력해주세요")

- isInputTypeNumber(String Number)
  - 유저가 입력한 값이 숫자가 맞는지 확인하는 메서드
  - 숫자가 아닐경우 IllegalArgumentException 발생
  - ("숫자만 입력해주세요")


- isInputLengthThree(String Number)
  - 플레이어가 입력한 값이 3자리가 맞는지 확인하는 메서드
  - 3자리가 아닐 경우 IllegalArgumentException 발생
  - ("입력 숫자 길이가 3이 아닙니다")


- isExistSameNumber(String Number)
  - 플레이어가 입력한 값이 겹치는지 확인해주는 메서드
  - 겹치는 경우 llegalArgumentException 발생
  - ("중복된 숫자가 존재합니다")


- isExistZeroInNumber(String number)
  - 플레이어가 입력한 값에 0이 포함되어 있는지 확인해주는 메서드
  - 0이 포함되어 있다면 llegalArgumentException 발생
  - ("0이 포함되면 안됩니다")


## model 패키지

### AnswerNumber 클래스
숫자야구 게임이 시작되면 랜덤한 정답을 생성하는 클래스

- getAnswer()
  - 정답을 가져오는 메서드


- getNewAnswer()
  - 게임이 시작될 때마다 새로운 랜덤 정답 숫자를 생성하는 메서드


- getRandomNumber()
  - 1 ~ 9 중에 랜덤하게 숫자를 생성하는 메서드


### PlayerNumber 클래스 
사용자가 입력한 슷자가 조건에 맞는 값이 맞는지 체크하고 저장하는 클래스 

- setPlayerNumber(String playerNumber)
  - 플레이어가 입력한 숫자가 입력 조건에 맞는 값인지 확인
  - 조건에 맞는 값이면 playerNumber 변수에 값 저장


- getPlayerNumber()
  - 플레이어가 입력한 값을 가져오는 메서드



## view 패키지

### InputView 클래스
사용자로 부터 입력을 받는 메서드를 구현한 클래스

- setPlayerNumber()
  - 플레이어의 숫자를 입력받는 메서드


- setNumberRestartOrEndGame()
  - 정답을 맞춘 후에 재시작(1) 또는 종료(2)에 대한 여부를 플레이어에서 입력받는 메서드

  

### OutputView 클래스
사용자의 입력을 통해 반환되는 값을 출력하는 클래스

- printRestartOrEndGame()
  - 정답을 맞춘 후에 재시작(1) 또는 종료(2)에 대해 물어보는 문구 출력


- printStartBaseballGame()
  - 숫자야구 게임 시작을 알려주는 문구 출력


- printHintMessage(String hintMessage)
  - 사용자의 입력 값과 정답을 통해 알아낸 스트라이크, 볼, 낫싱에 대한 정보를 출력


- printPlayerCorrectAnswerMessage()
  - 플레이어가 정답을 맞췄을 때(3 스트라이크) 출력


- printEndBaseballGameMessage()
  - 정답을 맞춘 뒤 플레이어가 종료(2)를 선택했을 때 출력 