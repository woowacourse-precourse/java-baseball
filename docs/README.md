## 기능 목록

### GameState
* 게임의 현재 상태를 저장하는 변수.

### initializeContext()
* 게임을 초기화한다.
* 상태 변수 state를 RUNNING으로 초기화하고 새로운 answer를 생성한다.

### handleUserInput()
* 사용자로부터 입력을 받아 다음과 같은 기능을 수행한다.
* 잘못된 입력 - IllegalArgumentException을 던진다.
* 세 자리 숫자 - 볼카운트를 계산하여 출력한다.
* 한 자리 숫자 - 새로 시작 또는 게임을 종료한다.