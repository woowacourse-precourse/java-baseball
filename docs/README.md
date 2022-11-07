## 📋 기능 목록

### Number

- 한 자리 숫자 또는 문자를 입력 받아 생성한다.
    - 1 ~ 9의 Number만 생성할 수 있다.
    - 범위를 벗어나는 입력을 받으면 예외가 발생한다.
- 다른 Number와 비교할 수 있다.
- 아래와 같은 이유로 같은 Number를 다시 생성하지 않고 재활용한다.
    - 생성되는 Number의 범위가 정해져 있다.
    - Number의 상태가 변하지 않는다.

### Numbers

- 사용자의 입력으로 Numbers를 생성한다.
    - 입력받은 숫자의 각 자리가 서로 다른지 검증한다.
- NumberGeneratationStrategy를 입력받아 Numbers를 생성할 수 있다.
- 다른 Numbers와 비교해 결과(Map)를 반환한다.
    - 다른 위치의 Number가 같으면 BALL
    - 같은 위치의 Number가 같으면 STRIKE
    - 같은 Number가 없으면 MISS

### BallTypes

- `123`, `135`을 비교할 때 하나의 Numbers를 기준으로 다른 Numbers와 비교한다. `123`(정답)을 기준으로 `456`(유저의 입력)과 비교한다고 가정할 때, `123`의 각각의 Number가 `456`에서 매칭되는 결과를 나타내는 것이 BallTypes다.
- `123`의 `1`은 `135`에서 STIKE다.
- `123`의 `2`는 `135`에서 MISS다.
- `123`의 `3`은 `135`에서 BALL이다.

### NumberGenerationStrategy

- 인터페이스
- 숫자 목록(List\<Integer>)을 생성한다.

### RandomNumbersGenerationStrategy

- NumbersGenerationStrategy를 구현한다.
- 랜덤으로 숫자 목록(List\<Integer>)을 생성한다.

### BaseballGame
1. 게임 시작 메시지를 출력한다.

2. 랜덤 숫자를 생성한다.

3. 다음 과정을 반복한다.

    1) 사용자의 입력을 받는다.

    2) 사용자의 입력으로 Numbers를 생성한다.

    3) 랜덤으로 생성된 Numbers와 사용자의 입력으로 생성된 Numbers를 비교한다.

    4) 결과를 출력한다.

    5) 두 Numbers가 일치하면 게임을 종료한다. 일치하지 않으면 `2 - i`을 실행한다.

4. 게임이 종료되면 재시작 여부를 입력받는다.

    1) 사용자가 재시작을 원할 경우 `1`을  실행한다.

    2) 사용자가 재시작을 원하지 않을 경우 종료 메시지를 출력하며 게임을 종료한다.
    
### Decision

- 사용자의 결정을 나타낸다.
    - RE_GAME(1): 재시작
    - END(2): 종료
- 입력을 받아 결정을 반환하는 기능을 수행한다. 잘못된 입력이 주어지면 예외가 발생한다.
    - 올바른 입력(1, 2) -> `RE_GAME`, `END`를 반환
    - 잘못된 입력(1, 2를 제외한 모든 입력) -> 예외 발생

### InputView

- 사용자의 입력을 반환한다.
    - 세 자리 숫자 형태가 아니면 예외가 발생한다.
    - 입력 형식에 대한 검증만 한다.

### OutputView

- 게임 진행 과정 및 결과를 출력한다.

### Result

- Map<BallTypes, Integer>를 입력받아 생성한다.

    | BallTypes | Integer |
    | --- | --- |
    | BALL | 1 |
    | STRIKE | 1 |
    | MISS | 1 |

    위와 같은 Map을 입력받아 생성한다.

- 결과에 따라 적절한 메시지를 반환한다.
    - 위 예시처럼 Result가 생성되었을 때 `1볼 1스트라이크`를 반환한다.
