## 구현 기능 목록

###  예외 처리
-  입력 수 길이가 `3` 인지 체크 : `inputValidtor()`
-  게임이 끝났을때 입력 숫자가 `1` 과 `2` 인지 체크 : `startAndEnd()`

###  유저
-  사용자의 입력을 받는 기능 : `userInput()` -> `tolistUser()` (++ 유저를 String->List<Integer>로 입력)
-  게임 재시작 여부를 입력 받는 기능 : `restartGame()`

### 숫자 야구 게임 진행
-  컴퓨터가 숫자(정답)를 랜덤으로 고르는 기능 : `computerNum()`
-  스트라이크인지 체크하는 기능 : `toStrike()`
-  볼인지 체크하는 기능 : `toBall()`
-  재시작과 종료를 판별하는 기능 : `validatorNumber()`
-  3개의 숫자를 모두 맞힐 경우: `allCorrect()`
-  입력수에 대한 결과를 볼, 스트라이크 개수로 표시 : `resultHint()`

###  출력
-  게임 시작 문구 출력하는 기능 : `startGame()`
-  게임의 결과를 문구로 알려주는 기능 : `succesGame()`
-  게임 종료 및 재시작 여부 문구 출력하는 기능 : `restartGameV()`