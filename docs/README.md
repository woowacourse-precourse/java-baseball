## 기능 구현 목록

### 입력 (InputView)
- [x] 사용자에게 숫자 입력 받기 전에 "숫자를 입력해주세요 : " 출력

- [x] 서로 다른 숫자 3개 입력받기
  - [x] 숫자 3개 입력받기
  - [x] 예외 처리 (IllegalArgumentException) => 프로그램 종료
    - [x] null 또는 empty 인 경우 (UserNumbersDTO)

- [x] 게임 종료 시, "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력

- [x] 게임 종료 후 재시작 여부 선택 입력
  - [x] 1 : 재시작
  - [x] 2 : 게임 종료
  - [x] 예외 처리 (SelectedNumberForRestartDTO) : (IllegalArgumentException => 프로그램 종료)
    - [x] null 또는 empty 인 경우
    - [x] 알파벳인 경우
      - [x] 소문자
      - [x] 대문자
    - [x] 특수문자인 경우
    - [x] 한글인 경우
      - [x] 자음
      - [x] 모음
      - [x] 단어
    - [x] 공백인 경우
    - [x] 길이가 1이 아닌 경우
    - [x] 1~2 범위 벗어난 경우


### 출력 (OutputView)
- [x] 게임 시작 시 "숫자 야구 게임을 시작합니다." 시작 메시지 출력

- [x] 결과 출력
  - [x] 스트라이크만 있을 때 : "2스트라이크"
  - [x] 스트라이크와 볼 같이 있는 경우 : "1볼 2스트라이크"
  - [x] 볼만 있는 경우 : "1볼"
  - [x] 하나도 없는 경우 : "낫싱"
  - [x] 3스트라이크인 경우 : "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"


### 컨트롤러 (BaseBall)
- [x] 3스트라이크가 되기 전까지 반복해서 숫자를 입력 받는다.

### 도메인
- [x] 1 대 1 비교 (Ball)
  - [x] strike : 위치 : O, 숫자 : O
  - [x] ball : 위치 : X, 숫자 : O
  - [x] nothing : 위치 : X, 숫자 : X

- [x] 1 대 3 비교 (Balls)
  - [x] 1 strike : strike 인 공이 존재
  - [x] 1 ball : ball 인 공이 존재
  - [x] 1 nothing : strike 또는 ball 인 공이 존재하지 않는 경우

- [x] 3 대 3 비교 (Balls)
  - [x] 3개의 각 공이 strike, ball, nothing 중 어디에 속하는지 계산

- [x] 컴퓨터 (Balls)
  - [x] 서로 다른 임의의 수 3개 선택
  - [x] 예외 처리
    - [x] 1~9 범위 벗어난 경우
    - [x] 같은 번호가 존재하는 경우
    - [x] 길이가 3이 아닌 경우

- [x] 3 strike 시, 게임 종료 (Referee)

- [x] 입력받은 3개의 숫자 예외 처리 (IllegalArgumentException) => 프로그램 종료
  - [x] 알파벳인 경우 (BallNumber)
    - [x] 소문자
    - [x] 대문자
  - [x] 특수문자인 경우 (BallNumber)
  - [x] 한글인 경우 (BallNumber)
    - [x] 자음
    - [x] 모음
    - [x] 단어 (한 글자)
  - [x] 공백이 존재하는 경우 (BallNumber)
  - [x] 길이가 3이 아닌 경우 (BaseBallGame)
  - [x] 1~9 범위 벗어난 경우 (BallNumber)
  - [x] 같은 숫자가 존재할 경우 (Balls)

- [x] 포지션 예외 처리 (IllegalArgumentException)
  - [x] 0~2 범위 벗어난 경우 (BallPosition)

- [x] BALL 이 게임 종료에 영향을 미칠 경우 예외 처리 (AbstractScore)

- [x] Score(strike, ball)의 범위가 0~3 을 벗어난 경우 예외 처리