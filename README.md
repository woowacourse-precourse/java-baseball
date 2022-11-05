# 미션 - 숫자야구

# 💻 기능 목록 사항

<hr>


### ✔️ Game

**게임을 진행하는 클래스입니다**

- 애플리케이션 실행 시 게임을 시작

- 사용자가 3개의 숫자를 맞춘 경우(3스트라이크) 게임을 새로 시작할지, 종료할 지 결정

###
### ✔️ GameInput

- 사용자의 입력 값을 받는 기능 구현
- 게임이 종료된 경우 새로 시작할지, 종료할 지에 대한 입력 값을 받는 기능 구현

###
### ✔️ GameOutput

- 게임 시작 문구를 출력
- Score 에서 전달받은 결과를 출력
- 게임 종료 문구를 출력
- 게임 재시작 여부를 출력

###
### ✔️ User

- 사용자가 입력 한 수를 저장하는 기능 구현
- 게임 재시작 여부에 대한 입력 값을 저장하는 기능 구현

###
### ✔️ Computer

- 1~9까지 서로 다른 수로 이루어진 3자리 수를 생성 및 저장하는 기능 구현

###
### ✔️ Score
**사용자의 입력 값에 대한 결과를 계산하는 클래스입니다**

- 사용자의 입력 값 중 스트라이크 개수를 계산하는 기능 구현
- 사용자의 입력 값 중 볼 개수를 계산하는 기능 구현
- 스트라이크와 볼의 개수를 출력
- 스트라이크와 볼이 없는 경우 낫싱을 출력


###
### ✔️ UserInputException
**예외처리 클래스입니다**

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 애플리케이션을 종료
#####
**[예외사항]** 입력한 값이 3자리가 아닌 경우
#####
**[예외사항]** 게임이 끝난 경우 입력 값이 1 또는 2가 아닌 경우
#####
**[예외사항]** 입력 값이 정수가 아닌 경우
#####
**[예외사항]** 입력한 값에 중복이 있는 경우
#####
**[예외사항]** 입력 값에 0이 포함 된 경우
