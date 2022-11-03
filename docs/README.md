## 기능 목록

### GameState
* 게임의 현재 상태를 저장하는 변수.

### initGame()
* 게임을 초기화한다.
* 상태 변수 state를 RUNNING으로 초기화하고 새로운 answer를 생성한다.

### handleUserInput()
* 사용자로부터 입력을 받는다.
* 세 자리 숫자 - 볼카운트를 계산한다.
* 한 자리 숫자 - 새로 시작 또는 게임을 종료한다.

### checkValidity()
* 유효하지 않으면 IllegalArgumentException을 던진다.
* state를 EXIT_WITH_EXCEPTION으로 설정한다.

### decideBallCount()
* answer와 input을 비교해 볼 카운트를 결정한다.
* 모든 숫자가 일치하면 state를 THREE_STRIKE로 설정한다.

### restartGame()
* 게임을 다시 사작하기 위해 initGame()을 호출한다.

### quit()
* 게임을 종료한다.