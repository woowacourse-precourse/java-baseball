

숫자야구 게임 기능 요구 사항



BaseballGameLauncher 

- 게임을 실행하고 전달받는 메시지에 따라 재시작 혹은 종료를 결정한다.
- BaseballGame을 멤버 변수로 가진다

BaseballGame

- 다시 시작할 수 있는 게임 1판을 담당한다.
- Player로 부터 입력값을 받아 BaseballGameManager에 따라 게임을 진행한다.
- Player와 BaseballGameManager를 멤버변수로 가진다.

Player

- 게임 진행과 관련된 메시지를 입력한다.
- 답을 예측하여 추측한 답을 전송한다.
- 정답을 맞히면 게임 재시작 여부를 전송한다.
- InputValidator를 멤버 변수로 가진다.

InputValidator

- Player가 입력한 값을 검증한다.
- 잘못된 값을 전송시 예외를 반환한다.

BaseballGameManager

- 전반적인 게임의 로직을 담당한다.
- Player가 입력한 값을 바탕으로 결과를 제공한다.
- NumberAdministrator를 멤버 변수로 가진다.

NumberAdministrator

- 유저가 맞혀야할 랜덤한 숫자와 그와 관련된 요소를 담당한다.
- 랜덤한 숫자를 생성한다.
- 스트라이크와 볼 카운트를 계산한다.

