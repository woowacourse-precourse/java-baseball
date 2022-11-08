## 기능 목록 단위

본 프로그램에는 3개의 클래스가 존재하며, 다음과 같이 기능을 담당하고 있습니다.

아래에는 기능에 대응하는 함수명(매개변수 생략)이 적혀있습니다.

### 1. Manager Class

- 게임을 본격적으로 시작하는 기능
  `Manager.play()`
- 사용자의 입력을 받는 기능
  `Manager.getUserInput()`
- 게임의 재시작 또는 종료 여부를 사용자에게 묻는 기능
  `Manager.checkContinuity()`
  
### 2. Checker Class

- 사용자가 잘못된 값을 입력했는지 확인하는 기능
  `Checker.IsWrongInput()`
- 사용자의 입력과 컴퓨터의 정답을 비교하는 기능
  `Checker.CompareUserInputWithAnswer()`

### 3. Utility Class
- 숫자 야구 게임에 필요한 상수를 정의 (별도의 기능은 아님)
- 랜덤 숫자 3개로 이루어진 컴퓨터의 수를 생성하는 기능
  `Utility.makeThreeRandomNumber()`
- 사용자의 입력과 컴퓨터의 정답을 비교해 볼, 스트라이크 계산하는 기능
  `Utility.CalculateBallAndStrike()`