# 기능구현 목록
---
### Baseball 클래스
- 생성자: 정수형 클래스 변수에 객체 생성시 받은 숫자 저장
- printBaseball(): baseball 변수 출력

### BaseballList 클래스
- 생성자: List<Integer>를 통해 List<Baseball>를 생성하고 이를 저장
- printBaseballList(): baseballList 출력
- contains(): 해당 Baseball 객체를 갖는지 판단
- getBaseballByIndex(): 인덱스에 해당하는 Baseball 객체 리턴

### User 클래스
- setUserBaseballList(): 인풋으로 받은 문자열 BaseballList로 변경하여 저장
- getUserBaseballList(): 유저의 baseballList를 리턴
- isValidInput(): 정상적인 입력인지 판단하고 아니면 IllegalArgumentException() 처리

### Computer 클래스
- 생성가: 서로 다른 랜덤한 정수 받아서 baseballList로 저장
- getComputerBaseballList(): 컴퓨터의 baseballList를 리턴
- getStrikes(): 컴퓨터의 baseballList와 유저의 baseballList에 대해 인덱스와 값이 일치하는 개수 리턴
- getBalls(): 컴퓨터의 baseballList와 유저의 baseballList에 대해 strike가 아닌 baseball 중 동일한 값의 개수를 리턴

### Game 클래스
-- run(): 컴퓨터 객체를 생성, 게임 시작, 게임 재시작
-- runStage(): 유저 객체를 생성, 유저 baseballList 설정, 볼과 스트라이크 수 계산, 게임 종료 여부 판단
-- restartGame(): 인풋을 받아 게임 다시 시작할지 프로그램 종료할지 판단

### Message 클래스
-- 프린트할 문자열 모두 모아놓도록 구현

