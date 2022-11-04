# java -base ball 기능목록
- [ ] String을 입력받는 부분
  - [ ] 숫자 1이 들어올 경우, 무한입력을 받다가 정답 입력 시 종료
  - [ ] 숫자 2가 들어올 경우, 무한 입력을 받다가 정답 입력 시 컴퓨터에 저장하는 숫자를 새로 호출 

- [ ] String 입력을 제대로 받는지 판별하는 부분
  - [ ] 두개 이상의 같은 숫자를 받을 경우 예외처리
  - [ ] 문자를 3개 받지 않을 경우 예외처리
  - [ ] 숫자인 뭇자를 받지 않을 경우 예외처리
- [ ] 올바른 입력 형태의 String을 int arrayList로 변환

- [ ] RandomNumber 를 이용해서 Random하게 컴퓨터에 저장
- [ ] int arrayList를 볼, 스트라이크 개수로 표시

# MVC 관점에서 java -base ball 기능목록 정리
## Model : Application의 데이터
### Game
- [ ] 게임을 진행한다.
### Computer
- [ ] 생성된 랜덤 숫자를 저장한다.
### Generator
- [ ] 랜덤 숫자를 생성한다.
### User
- [ ] 입력값을 저장한다.

## View
### Session
- [ ] 게임이 끝나지 않은 경우, 세자리 수를 입력 받는다.
- [ ] GameEndForwarder에게 게임의 종료를 전달받으면, 게임 재시작 여부를 입력 받는다.
### Printer
- [ ] 게임을 새로 시작할 때, 시작문구 출력
- [ ] HintMaker로부터 받은 결과를 출력한다.
- [ ] GameEndForwarder에게 게임의 종료를 전달받으면, 게임 종료 메시지를 출력한다.
## Controller
### HintMaker
- [ ] User 데이터와 Computer 데이터를 비교하여 같은 수가 전혀 없으면 낫싱을 반환한다.
- [ ] User 데이터와 Computer 데이터를 비교하여 스트라이크 개수를 센다.
- [ ] User 데이터와 Computer 데이터를 비교하여 볼의 개수를 센다.
- [ ] 낫싱이면 낫싱을 반환하고, 낫싱이 아니면 스트라이크 개수와 볼의 개수를 반환한다.

### GameEndForwarder
- [ ] 정답을 맞추면, 종료 flag를 Session과 Printer에게 전달한다.

### ExceptionProcessor
- [ ] 다음과 같이 잘못된 값을 입력하는 경우를 확인한다. 
  - [ ] 두개 이상의 같은 숫자를 받을 경우
  - [ ] 문자를 3개 받지 않을 경우
  - [ ] 숫자인 뭇자를 받지 않을 경우
- [ ] 잘못된 값을 입력하는 경우  IllegalArgumentException을 발생시킨다.

