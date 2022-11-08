## 기능 목록

### ___Controller___ 컨트롤러
#### [GameController](https://github.com/ghchoi0427/java-baseball/blob/ghchoi0427/src/main/java/baseball/controller/GameController.java)
 - 게임 시작하기
 - 숫자 맞추기 시작
 - 스트라이크 판정 후 재시작 여부 판별

### ___View___ 뷰
#### [GameView](https://github.com/ghchoi0427/java-baseball/blob/ghchoi0427/src/main/java/baseball/view/GameView.java)
- 게임 시작 알림
- 볼, 스트라이크 개수 출력
- 게임 종료 알림
- 종료, 재시작 명령어 입력받기
- 시스템 입력 읽기

### ___Validation___ 유효성
#### [InputValidation](https://github.com/ghchoi0427/java-baseball/blob/ghchoi0427/src/main/java/baseball/validation/InputValidation.java)
- 입력값 검증하기
- 숫자인지 검증하기

### ___Util___ 유틸
#### [GameLogic](https://github.com/ghchoi0427/java-baseball/blob/ghchoi0427/src/main/java/baseball/util/GameLogic.java)
- 게임이 종료됐는지 판별하기
- 숫자를 비교해 볼, 스트라이크 결과 반환하기
- 스트라이크 개수 세기
- 볼 개수 세기
- 스트라이크 판정
- 볼 판정
#### [RandomUtil](https://github.com/ghchoi0427/java-baseball/blob/ghchoi0427/src/main/java/baseball/util/RandomUtil.java)
- 숫자 생성하기