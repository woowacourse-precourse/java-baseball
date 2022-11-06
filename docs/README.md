# java-base ball 기능목록

# MVC 관점에서 java -base ball 기능목록 정리
## Model : Application의 데이터
### Game
- [x] 게임을 진행한다.
### Computer
- [x] 생성된 랜덤 숫자를 저장한다.
### Randoms
- [x] 랜덤 숫자를 생성한다.
### User
- [x] 입력값을 저장한다.
- [x] 숫자로 이루어진 String을 List 형태로 저장

## View
### Session
- [ ] 게임이 끝나지 않은 경우, 세자리 수를 입력 받는다.
- [ ] 게임의 종료를 전달받으면, 게임 재시작 여부를 입력 받는다.
### Printer
- [ ] 게임을 새로 시작할 때, 시작문구 출력
- [ ] HintMaker에서 받은 결과를 출력한다.
## Controller
### HintMaker
- [x] User 데이터와 Computer 데이터를 비교하여 같은 수가 전혀 없으면 낫싱을 반환한다.
- [x] User 데이터와 Computer 데이터를 비교하여 스트라이크 개수를 센다.
- [x] User 데이터와 Computer 데이터를 비교하여 볼의 개수를 센다.
- [x] 낫싱이면 낫싱을 반환하고, 낫싱이 아니면 스트라이크 개수와 볼의 개수를 반환한다.

### ExceptionProcessor
- [x] 다음과 같이 잘못된 값을 입력하는 경우를 확인한다. 
  - [x] 두개 이상의 같은 숫자를 받을 경우
  - [x] 문자를 3개 받지 않을 경우
  - [x] 숫자인 뭇자를 받지 않을 경우
- [x] 잘못된 값을 입력하는 경우  IllegalArgumentException을 발생시킨다.

