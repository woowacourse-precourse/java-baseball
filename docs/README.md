## 구현 기능 목록

### 🔗 예외 처리
- [x] 입력 수 중복 체크 : `NumberValidator.isNotDuplicateDigits()`
- [x] 입력 수 길이가 `3` 인지 체크 : `NumberValidator.isThreeDigits()`
- [x] 입력 수가 0 이하의 정수인지 체크 : `NumberValidator.isPositiveDigits()`
- [x] 입력 수가 한글, 영문, 특수문자 제외 숫자로만 이루어졌는지 체크 : `NumberValidator.isDigits()`
- [x] 게임이 끝났을때 입력 숫자가 `1` 과 `2` 인지 체크 : `NumberValidator.isValidCommandDigit()`

### 🔗 입력
- [x] 사용자의 입력을 받는 기능 : `Player.setInputBalls()`
   + 예외 처리 : `1번`, `2번`, `3번`
  
- [x] 게임 재시작 여부를 입력 받는 기능 : `Player.getRestartResponse()`
   + 예외 처리 : `4번`

### 🔗 숫자 야구 게임 진행 
- [x] 컴퓨터가 숫자(정답)를 랜덤으로 고르는 기능 : `Computer.createRandomNumber()`
- [x] 스트라이크인지 체크하는 기능 : `Referee.getStrikeCount()`
- [x] 볼인지 체크하는 기능 : `Refree.getBallCount()`
- [x] 재시작과 종료를 판별하는 기능 : `GameController.setActionOfRestartAndExit()`
   + 종료라면 반복문을 멈추고, 재시작이라면 정답 난수 재생성

### 🔗 출력
- [x] 게임 시작 문구 출력하는 기능 : `OutputView.printInit()`
- [x] 게임의 결과를 적절한 문구로 알려주는 기능 : `Game.toString()`
   + `n` 볼 `n` 스트라이크
- [x] 게임 종료 및 재시작 여부 문구 출력하는 기능 : `OutputView.printFinishAndRestart()`