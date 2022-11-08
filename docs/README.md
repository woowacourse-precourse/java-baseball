---

## 구현 기능 목록
### 컴퓨터

1. 1~9 까지 서로 다른 임의의 수 3개 선택 : `createRandomNumber()`
2. 플레이어가 입력한 숫자에 대한 결과 판단 : `judgeNumber()`

### 플레이어

1. 서로 다른 3개 숫자 입력한 것 반환 : `inputNumber()`
2. 다시 시작 및 게임 종료 입력한 것 반환 : `inputContinuation()`

### 게임 매니져

- 게임을 순서에 맞게 시작 : `startGame()`
- 플레이어 의지에 따라 게임 종료 및 다시시작 : `continueGame()`
- 게임 지속 여부를 플레이어에게 전달받고 게임 시작/종료 결정 : `getContinuation()`
- Illegal reflective access 경고 비활성화 : `disableWarning()`

---