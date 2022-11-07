## ⚾ 숫자 야구 게임 (박정윤)

### < 기능 구현 목록 >

### 초기 설정

- [x] **컴퓨터** 랜덤 3자리 숫자
    - [x] `예외 처리`
        - [x] 각 자리 숫자가 1부터 9범위를 벗어나는 경우
        - [x] 각 자리 숫자에 중복이 있는 경우
        - [x] 입력 값의 길이가 3이 아닌 경우
        - [x] 숫자가 아닌 값이 들어온 경우
        - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

### 메인 MVP
- [x] <입력> **게임 플레이어** 랜덤 3자리 숫자
    - `포맷` 숫자 야구 게임을 시작합니다.
    - `포맷` 숫자를 입력해주세요 : 123
    - [x] `예외 처리`
        - [x] 각 자리 숫자가 1부터 9범위를 벗어나는 경우
        - [x] 각 자리 숫자에 중복이 있는 경우
        - [x] 입력 값의 길이가 3이 아닌 경우
        - [x] 숫자가 아닌 값이 들어온 경우
        - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료
- [x] 게임 로직
    - [x] 스트라이크: 같은 수가 같은 자리 
    - [x] 볼: 같은 수가 다른 자리
    - [x] 낫싱: 같은 수가 전혀 없을 때
      - 낫싱은 스트라이크, 볼 모두 없을 때
- [x] 승패 판단
    - [x] 컴퓨터가 선택한 3개의 숫자를 모두 맞혔을 때 승리(3스트라이크)
- [x] 게임 종료 조건
  - [x] 승리했을 때 게임 종료
  - `포맷` 3개의 숫자를 모두 맞히셨습니다! 게임 종료
  - [x] <입력> 게임 재시작 : 1, 종료 : 2를 입력받는다.
    - `포맷` 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
    - [x] `예외 처리`
      - [x] 숫자가 1 또는 2가 아닌 경우
- [x] <출력>
  - 게임 로직으로 승패 판단을 하여 결과를 출력한다.
  - `포맷` 3스트라이크, 1볼 1스트라이크, 2볼

---

### < 폴더 구조 >

```
├─main
│  └─java
│      └─baseball
│          │  Application.java
│          │  test.java
│          │
│          ├─controller
│          │      BaseBallGame.java
│          │
│          ├─domain
│          │      GameLogic.java
│          │      RandomNumbers.java
│          │
│          ├─validator
│          │      NumbersValidator.java
│          │      NumberValidator.java
│          │
│          └─view
│                  InputView.java
│                  OutputView.java
│
└─test
    └─java
        ├─baseball
        │      ApplicationTest.java
        │      BaseBallGameTest.java
        │      InputTest.java
        │
        └─study
                StringTest.java
```

