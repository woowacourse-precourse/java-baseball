# 기능 목록

## 절차

- [ ]  Player의 입력을 받아 Game에 전달
    - [ ]  Game이 종료를 선언하기 전까지 반복
- [ ]  Game이 종료를 선언할 경우, Player의 입력(1, 2)을 받기
- [ ]  종료 후 게임을 지속할지 말지를 전달할 수 있다.
- 키보드 입력을 enum 객체로 변환하여 전달한다.
- [ ]  모든 입력에는 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 를 사용한다.


## 객체가 할 수 있는 일

### 컴퓨터 (Game, 상대방)

- [ ] 게임을 초기화할 수 있다.
    - [ ]  숫자 정하기: 랜덤으로 숫자를 정할 수 있다.
    - [ ] `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 을 사용한다.
- [ ]  사용자 입력을 받아 전달할 수 있다.
    - 키보드로 입력받은 숫자로 `GameInput` 객체를 생성한다.
- [ ]  GameInput을 전달 받아 스트라이크/볼/낫싱 여부를 계산한다.
- [ ]  게임을 종료할 수 있다.


### 숫자 (GameInput)

- [ ]  숫자를 입력했을 때 값을 검증할 수 있다.
    - [ ] 올바르지 않을 경우 `IllegalArgumentException` 예외를 던진다.
    - [ ] 이 예외를 받은 프로그램은 종료된다.
- [ ]  숫자의 자릿수를 분리해 보관/관리할 수 있다.

### 게임 종료 후 명령 (FinishInput)

- [ ] 숫자를 인자로 받아 의미를 가진 객체를 반환할 수 있다.
