# 👩🏻‍💻 구현 기능 목록

### ✔️ About 야구 게임를 위한 수 생성

- `playBaseballGame` : 야구 게임을 진행하는 함수
  - `createComputerNumber` : 서로 다른 랜덤 3 숫자 생성하는 함수 (컴퓨터)
  - `inputUserNumber` : 서로 다른 임의의 3가지 숫자 입력받는 함수 (사용자)

### ✔️ About 사용자 수 검증

- `checkValidationUserNumber` : 사용자가 입력한 수에 대해 검증하는 함수
  - 잘못된 값 입력할 경우 <b>IllegalArgumentException</b> 발생시킨 후 애플리케이션 종료
    - `isDifferent` : 서로 다른 숫자가 맞는가
    - `isThreeNumber` : 3개의 숫자가 맞는가
    - `isNotZero` : 0을 포함하지 않고 있는가

### ✔️ About 컴퓨터 수와 사용자 수 비교

- `compareNumber` : <b>낫싱, 스트라이크, 볼</b>을 비교하는 함수
  - `includeSame` : <b>낫싱</b> 판별 함수
    - 같은 수가 없으면 <b>낫싱</b> 출력
  - <b>스트라이크</b>, <b>볼</b> 판별 함수
    - `countStrike` : 스트라이크 파악하는 함수
    - `countBall` : 볼 파악하는 함수
    - `resetStrikeBall` : <b>스트라이크</b>, <b>볼</b> 수를 0으로 초기화시키는 함수
- `userNumberResult` : 유저가 입력한 숫자에 대해 <b>낫싱, 스트라이크, 볼</b>에 대한 정보를 출력하는 함수

### ✔️ About 야구 게임 종료 혹은 재시작

- `askRestartGame` : 게임 재시작 여부를 입력받는 함수
  - `checkValidationRestartNumber` : 입력받은 재시작 수에 대해 검증하는 함수
- `restartGame`
  - 1이 입력되면 다시 게임 시작 함수 호출, 2가 입력되면 게임 종료


# 🛠 최종 구조
- `constant` : 상수와 메시지를 관리하는 패키지
  - `GameConstant`
  - `GameMessage`
- `game` : 야구게임이 진행되는 주 클래스를 관리하는 패키지
  - `BaseballGame`
    - `playBaseballGame`
    - `askRestartGame`
    - `restartGame`
  - `CompareNumbers`
    - `compareNumber`
    - `userNumberResult`
    - `resetStrikeBall`
    - `includeSame`
    - `countStrike`
    - `countBall`
- `number` : 야구게임에 필요한 숫자를 관리하는 패키지
  - `ComputerNumber`
    - `createComputerNumber`
  - `UserNumber`
    - `inputUserNumber`
    - `checkInputUserNumber`
- `validator` : 사용자 입력 값에 대한 검증 클래스 관리하는 패키지
  - `RestartNumberValidator`
    - `checkValidationRestartNumber`
  - `UserNumberValidator`
    - `checkValidationUserNumber`
    - `isDifferent`
    - `isThreeNumber`
    - `isNotZero`