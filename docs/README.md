
## **기능 목록**

- ***Class Computer***
  - setComputersList()
    - 상대방(컴퓨터)의 숫자 리스트를 정한다.
  - getComputerList()
    - 상대방(컴퓨터)의 숫자 리스트를 가져온다.

- ***Class Status***
  - initStatus()
    - 현재 게임 진행 상태 메세지를 초기화 한다. 초기값 : "INIT"
  - setStatusPlaying()
    - 게임 진행 상태 메세지를 "PLAYING"으로 바꾼다.
  - setStatusTERMINATING()
    - 게임 진행 상태 메세지를 "TERMINATING"으로 바꾼다. 
  - getStatus()
    - 게임 진행 상태 메세지를 가져온다.

- ***Class User***
  - scanInput()
    - 사용자의 입력을 받는다.
  - patternValidateInput()
    - 입력받은 3자리수의 각 자릿수문자가 1이상 9이하인지 검사한다. 있다면 예외발생.
  - duplicationValidateInput()
    - 패턴검사를 통과한 문자열에 중복되는 문자가 있는지 검사한다. 있다면 예외 발생, 없다면 리스트화
  - initValidatedUserInput()
    - 유효성 검사를 마친 입력이 들어갈 리스트를 초기화 한다.
  - scanInputWhenPlaying()
    - 게임이 진행중 일때 입력 시퀀스
  - answerValidateInput()
    - 입력받은 1자리수의 문자가 1 또는 2인지 검사한다. 조건을 만족못할 경우 예외발생, 있다면 리스트화.
  - scanInputWhenTerminating()
    - 3스트라이크로 게임이 종료되는 타이밍에 게임을 새로 시작 할지 선택하는 입력 시퀀스
  - scanInputByStatus()
    - 게임 진행 상태 메세지에따라 시퀀스를 결정한다.
  - getValidatedUserInput()
    - 유효성 검사가 끝난 리스트를 가져온다.

- ***Class Game***
  - gameStart()
    - 게임의 전체 진행 시퀀스
  - compare()
    - 사용자의 입력을 받고 상대방(컴퓨터)의 숫자를 비교한다.
  - retryOrNot()
    - 게임 재시작 여부에 대한 입력을 받고 재시작이면 gameStart() 호출, 종료라면 메서드 종료.
  - printMessages()
    - 비교 결과 메세지 출력한다.

## **기능 테스트 목록**

- ✅ ***컴퓨터의 숫자 리스트 생성 테스트***
- ✅ ***게임 진행 상태 설정 기능 테스트***
- ✅ ***유저 입력 패턴 검사 테스트***
- ✅ ***중복 검사 테스트***
- ✅ ***재시작 여부 유효성 검사 테스트***