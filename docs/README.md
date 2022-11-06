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
    - `countSamePlace` : 같은 자리에 있는지 파악하는 함수
    - `countDifferentPlace` : 같은 자리는 아니지만 같은 수가 있는지 파악하는 함수

### ✔️ About 야구 게임 종료 혹은 재시작

- `restartGame` : 게임 재시작 여부를 입력받는 함수
  - 1이 입력되면 다시 게임 시작 함수 호출, 2가 입력되면 게임 종료