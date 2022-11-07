# ⚾️ 숫자 야구 - 요구 사항

## 기능 요구 사항 - 실행 결과 예시를 통한 flow 분석

- Application 시작
  - 게임 시작 문구 출력
  - Computer Balls 생성 `Randoms의 pickNumberInRange()의 return 값은 int`
  - 입력 문구 출력
- User 입력
  - `Console의 readLine()의 return 값은 String`
    - 문자열을 통해 Balls 생성할 수 있어야함
  - 정상 처리
    - continue
  - 예외 처리(잘못된 값)
    - `IllegalArgumentException` 발생
      - 중복
      - parseInt 불가능한 경우
      - readLine().length != 3
        - 큰 경우
        - 작은 경우
- 입력 값을 통해 생성된 Balls와 Computer Balls 비교(한 Inning)
  - 입력 결과 출력
  - `Computer Balls와 입력 값이 같은 경우`
- 숫자를 맞추면(`Computer Balls와 입력 값이 같은 경우`)
  - 게임 종료 문구 출력
  - 재시작 여부 문구 출력
    - 재시작
      - 입력문구 출력
    - 종료
      - Application 종료

# 구현할 기능 목록

## Model(Domain)

### Ball

- [x] Ball
  - [x] 1~9 사이의 정수값을 가진다.
  - [x] 같은 Ball은 같은 값과 같은 위치이다.
- [ ] BallType
  - [ ] 스트라이크, 볼, 낫싱

### Balls: 3개의 Ball을 갖는 컬렉션 클래스

- [x] `Randoms`의 `pickNumberInRange()`를 통해 computerBalls를 생성한다.
- [x] 문자열을 입력 받아 `Balls`를 생성한다.
- [x] 제약 조건
  - [x] 3개의 Ball을 갖는다.
  - [x] 중복된 Ball을 갖지 않는다.

### Computer

- [x] RandomNumber를 통해 Balls를 생성한다.

### RandomNumber

- [x] 3개의 정수값을 랜덤으로 생성한다.
  - [x] 1~9 사이의 정수값을 가진다.
  - [x] 3개의 정수값은 중복되지 않는다.

### GameResult

- [ ] 같은 수가 같은 자리에 있으면 Strike
- [ ] 같은 수가 다른 자리에 있으면 Ball
- [ ] 같은 수가 전혀 없으면 Nothing

## View

### InputView

- [ ] `숫자 야구 게임을 시작합니다.` 출력
- [ ] `숫자를 입력해주세요 : ` 출력
- [ ] 게임 재시작 문구 출력 `게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.` 출력

### OutputView

- [ ] 게임 시작 문구 출력
  - [ ] `숫자 야구 게임을 시작합니다.` 출력
- [ ] 입력한 숫자에 대한 결과 출력
  - [ ] `x볼, y스트라이크` 개수 출력
  - [ ] 하나도 없는 경우 `낫싱` 출력
  - [ ] 3개의 숫자를 모두 맞힐 경우 `3스트라이크` 출력
    - [ ] `3개의 숫자를 모두 맞히셨습니다! 게임 종료` 출력

## Controller

### Game

- [ ] 게임을 시작한다.
- [ ] 게임을 종료한다.
- [ ] 게임을 재시작한다.
- [ ] 사용자 입력을 InputView를 통해 받는다.
- [ ] 게임 결과를 OutputView에 전달한다.
