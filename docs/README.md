## 🔍 기능 목록

- void startGame()
  - 숫자 야구 게임을 시작하는 함수
  

- void showGameStart()
  - "숫자 야구 게임을 시작합니다."를 출력하는 함수


- void playGame(List<Integer>)
  - 숫자 야구 게임이 실제 진행되는 함수


- void putInRandomNumber(List<Integer>)
  - 랜덤한 숫자 세 개를 randomNumberList에 add하는 함수

  
- Integer putInNumber()
  - 사용자가 3개의 숫자를 입력하는 함수


- void addUserNumberInUserArray(int[], String)
  - 사용자가 입력한 숫자로 된 문자열을 숫자로 배열에 저장하는 함수


- void checkUserNumber(String)
  - 사용자가 잘못된 값을 입력했는지 체크하는 함수


- boolean checkingUserNumberIsCorrect(String)
  - 입력된 값을 실제로 체크하는 함수


- boolean checkUserNumberLength(String)
  - 입력된 값의 길이가 3인지 체크하는 함수


- boolean checkUserNumberIsInteger(String)
  - 입력된 값이 1~9 사이의 숫자인지 체크하는 함수


- boolean checkUserNumberIsDuplicate(String)
  - 입력된 값이 중복되는지 체크하는 함수


- Integer countingBall(int, int[], List<Integer>)
  - ball의 개수를 계산하는 함수


- Integer checkAndCountBall(int, int, int)경
  - 인수로 받은 두 수를 비교해 ball의 개수를 계산하는 함수

- Integer countingStrike(int, int[], List<Integer>)
  - strike의 개수를 계산하는 함수


- void printCount(int, int)
  - 결과를 출력하는 함수


- boolean checkThreeStrike(int)
  - 숫자 세 개를 모두 맞췄는지(strike = 3인지) 체크하는 함수


- void endGame()
  - 숫자 세 개를 모두 맞췄을 경우 게임을 종료하는 함수


- boolean replayGame()
  - 게임을 재시작할지, 종료할지 결정하는 함수
  

- void checkReplayNumber(String)
  - 게임의 재시작/종료 여부를 결정하는 입력값이 올바른지 체크하는 함수


- boolean checkReplayNumberLength(String)
  - 게임의 재시작/종료 여부를 결정하는 입력값의 길이가 1인지 체크하는 함수


- boolean checkReplayNumberCount(String)
  - 게임의 재시작/종료 여부를 결정하는 입력값이 1 혹은 2인지 체크하는 함수