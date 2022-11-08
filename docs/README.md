## ✅ 기능 목록

### BallGenerator
- [x] 컴퓨터 공 생성
  - 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange()`를 활용한다.

- [x] 사용자 공 생성
  - "숫자를 입력해주세요 : " 출력
  - 사용자로부터 1에서 9까지 서로 다른 임의의 수 3개를 입력받는다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console` 의 `readLine()`을 활용한다.

### Player
- [x] BallGenerator 가 생성한 player balls 를 가져온다.

- [x] 게임을 계속할건지 중단할건지 값을 입력받는다.

### Computer
- [x] BallGenerator 가 생성한 computer balls 를 가져온다.

- [x] 사용자의 입력 값에 따라 결과(스트라이크/볼/낫싱)를 카운트한다.

- [x] 결과를 출력한다. (Output 호출)
  - 오답인 경우
    - ex) "1볼 1스트라이크" 출력
  - 정답인 경우
    - "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력

### Game
- [x] 게임을 시작한다.
  - "숫자 야구 게임을 시작합니다." 출력

- [x] 게임을 진행한다.
  - Player 와 Computer 와 협력한다.

- [x] 게임이 끝나면 재시작 혹은 종료 여부를 물어본다.
  - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력

### Output
- [x] 시스템 메시지를 출력한다.

### InputValidator
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.
  - 게임 진행 중
    - 사용자의 입력 값이 3자리 수가 아닌 경우 예외
    - 사용자의 입력 값에 1부터 9 사이가 아닌 값이 포함되어 있는 경우 예외
    - 사용자의 입력 값에 중복이 포함된 경우 예외
  - 게임 종료 후
    - 게임이 끝나고 1과 2 가 아닌 다른 수를 입력한 경우 예외

### HintType
- [x] HintType 을 enum 타입으로 정의한다.
  - 볼
  - 스트라이크
  - 낫싱

### SystemMessage
- [x] SystemMessage 를 상수로 정의한다.
  - 숫자 야구 게임을 시작합니다.
  - 숫자를 입력해주세요 :
  - 3개의 숫자를 모두 맞히셨습니다! 게임 종료
  - 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.

### SystemValue
- [x] SystemValue 를 상수로 정의한다.
  - STRIKE_COUNT = 0
    - 스트라이크와 볼의 개수를 담는 리스트에서, 스트라이크 인덱스 
  - BALL_COUNT = 1
    - 스트라이크와 볼의 개수를 담는 리스트에서, 볼 인덱스
  - CONTINUE_GAME = 1
    - 게임을 새로 시작하려면 1 입력
  - STOP_GAME = 2
    - 게임을 종료하려면 2 입력
  - BALL_MINIMUM_VALUE = 1
    - 랜덤으로 생성하는 공의 최솟값
  - BALL_MAXIMUM_VALUE = 9
    - 랜덤으로 생성하는 공의 최댓값
  - COMPUTER_BALLS_SIZE = 3
    - 랜덤으로 생성하는 공의 개수
