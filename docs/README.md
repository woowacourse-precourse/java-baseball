## ✅ 기능 목록

### Computer

- [x] 1에서 9까지 서로 다른 임의의 수 3개를 선택한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms` 의 `pickNumberInRange()`를 활용한다.

- [ ] SystemMessage 를 출력한다.
  - 사용자가 입력한 숫자에 대한 결과 출력
  - 프로그램을 진행하기 위한 문구 출력

### Player

- [ ] 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console` 의 `readLine()`을 활용한다.

- [ ] 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수를 입력한다.
  - 게임을 종료하였을 때 1을 누르면 게임이 재시작되어야 한다.
  - 게임을 종료하였을 때 2를 누르면 Application이 종료되어야 한다.

- [ ] 예외 처리
  - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다.

### SystemMessage
- [x] SystemMessage 를 상수로 정의한다.
  - 숫자 야구 게임을 시작합니다.
  - 숫자를 입력해주세요 :
  - 볼
  - 스트라이크
  - 낫싱
  - 3개의 숫자를 모두 맞히셨습니다! 게임 종료
  - 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
  