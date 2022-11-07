## 숫자 야구 미션 - 구현 기능 목록

### Game Class
- 직접직인 게임 진행과 관련된 함수는 Game 클래스에 별도로 구현한다.
- Game Class 는 인스턴스 변수로 서로 다른 수로 구성된 3자리 수의 숫자를 List 형태로 갖는다.
- Game Class 는 인스턴스 변수로 유저가 입력한 3자리 숫자를 List 형태로 갖는다.
- Game Class 에는 랜덤 숫자 생성 시 이용할 ```NUM_START_RANGE``` 와 ```NUM_END_RANGE``` 가 final 클래스 변수로 존재한다.
- Game Class 내부에 구현할 함수는 아래와 같다.


__1. generateRandomNumber__
   - 기능: ```camp.nextstep.edu.missionutils``` 에서 제공하는 ```Random``` 을 사용하여 랜덤한 3자리 수를 return 함
   - 파라미터: (start, end)


__2. getUserInput__
   - 기능: 사용자로부터 서로 다른 세 개의 수를 입력받고 List 형태로 반환한다. 입력값을 읽을 때는 ```camp.nextstep.edu.missionutils``` 의 ```Console```을 사용한다.
   - 잘못된 입력이 들어오면 게임을 종료한다. ```endGame()``` 함수 호출
   - 파라미터: None
   - 예외처리는 ```InputValidation``` 클래스의 ```isInputValid()``` 함수로 수행함


__3. endGame__
  - 기능: 게임을 종료한다는 메시지를 출력함


__4. start__
   - 기능: 게임을 실행하는 함수, 위 함수들을 이용하여 게임을 진행함
   - result 의 return 값에 따라 (즉, 3스트라이크가 나올 때까지) 게임을 반복하여 실행함
   - 파라미터: None


__5. restart__
- 기능: 게임을 재실행하는 함수, 사용자의 입력값이 1 이면 재시작하며 2 이면 종료한다.
- 파라미터: None
- 예외: 1이나 2가 아닌 다른 입력값이 들어왔을 때 ```isValidRestartInput()``` 함수를 이용해서 ```IllegalArgumentException``` 를 발생시킨다.


### Hint Class
- 사용자가 입력한 값을 게임의 정답과 비교하고 힌트를 출력하는 것과 관련된 함수들은 Hint Class 에 구현한다.

__1. result__
- 기능: 사용자가 입력한 숫자와 1번에서 생성한 숫자를 비교하여 length 2짜리 리스트로 return 함
    - { 볼 개수, 스트라이크 개수 }
- 파라미터: 컴퓨터가 생성한 랜덤 숫자, 사용자가 입력한 숫자


__2. checkBall__
- 기능: ball 의 개수를 리턴함 (0 혹은 1)
- 파라미터: (사용자가 입력한 숫자 중 하나, game 인스턴스의 randomNum)


__3. printResult__
- 기능: ```result()``` 의 결과를 "1볼 1스트라이크" 와 같은 형태로 출력함
- 파라미터: (result 가 담긴 리스트)

### InputValidation Class
- 사용자의 입력값의 유효성을 검사하는 함수들은 InputValidation 클래스에 별도로 구현한다.
- isInputValidation Class 는 ```isInputValid``` 라는 함수로 String 형태의 input 을 검사하며, 내부적으로 세부적인 함수의 실행을 통해 예외를 처리한다.
- 예외 -> ```IllegalArgumentException```
    - 같은 숫자가 2번 이상 반복될 때
    - 길이가 3 을 초과할 때
    - 0이 포함되어 있을 때
    - 숫자가 아닌 다른 값을 입력했을 때


 __1.isValidInput__
- 기능: 사용자가 입력한 String input 이 길이가 3을 초과하거나 0을 포함하면 예외를 던지고 아래 두 함수를 호출한다.
- 파라미터: (input)


__2. isIntegerStr__
- 기능: String input 이 숫자로만 이루어져 있는지 확인한다.
- 파라미터: (input)


__3. isIntegerStr__
- 기능: String input 에 중복되는 character 가 있는지 확인한다.
- 파라미터: (input)


__4.isValidRestartInput__
- 기능: 재시작 여부에 대해 물었을 때의 입력값을 검사한다. (재시작은 1, 종료는 2)
- 파라미터: (input)
