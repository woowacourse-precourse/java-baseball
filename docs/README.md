## 구현 사항
- 게임 시작 문구 출력
- 사용자 입력값 검증
  - 입력값의 자리 수 확인
  - 입력값이 숫자로만 이루어졌는지 확인
  - 입력값이 중복이 발생하였는지 확인
- 컴퓨터의 값 생성
- 컴퓨터와 사용자 입력값 비교
- 입력값 별 출력 형식 지정

### 클래스 기능
- Application
  - Game을 시작하는 컨트롤러
- BaseballNumber
  - 사용자 입력값 검증
  - 다른 BaseballNumber와 strike, ball 비교 가능
- Game
  - 사용자 입력값을 받아 게임 1회에 대한 결과(PlayResult) 반환
  - 게임 초기화 시 컴퓨터 숫자 생성
- PlayResult
  - 1회 게임 결과에 대한 strike, ball 결과를 가지고 있는 객체
  - 게임이 끝났는지 여부 검사
- InputView, ResultView
  - print 기능