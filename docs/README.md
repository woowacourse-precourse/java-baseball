## ✏️ 기능 목록

- User 객체 (게임유저)

    - 유저에게 입력값을 받는다. 단 형식에 벗어나면 오류를 발생시킨다.
    
        - 입력값의 길이가 3자여야 한다.
        - 숫자 외의 값은 들어올 수 없다.
        - 자릿수가 중복되면 안된다.
    - 유저에게 게임을 다시 시작할 건지 물어본다. 단 형식에 벗어나면 오류 발생
        - 입력값이 1, 2를 제외한 값들을 모두 예외처리한다.

  
- Opponent 객체 (상대방)

    - 3자리의 난수를 생성한다. 단 각 자리는 서로 다를것

        - 난수생성 함수 (1 ~ 9) 난수 발생
        - 자리중복 함수 (3자리 중복되지 않게 생성)


- Game 객체 (게임장)

    - 게임을 시작하는 함수
    
        - 유저와, 상대방을 생성한다.
        - 유저에게는 입력값을 받아 상대방(컴퓨터)와 비교한다.
          - 스트라이크를 체크한다.
          - 볼을 체크한다.
          - 현재 상황을 출력한다.
        - 위의 내용을 반복한다. 단 모두 맞히면 종료한다.
        - 다시 게임할 것인지 물어본다.


- Valid 객체 (각 객체들의 유효성을 검사하는객체)

    - 유저의 입력값을 예외처리 하는 함수작성(User)
    
    - 게임의 재시작에서 1 or 2가 아닌 값 들어 오면 예외 처리(Game)

작성 순서
1. 각 객체들의 기능을 구현한다.
2. 정상적으로 동작했을 때 예외처리를 작성한다.


게임장에서 상대방과 내가 게임을 한다.


---

- ## BaseBall
  - Field
    - Message
      - start (시작 메시지)
      - required_num (입력 메시지)
      - match (스트라이크, 볼 메시지)
      - end (3스트라이크 시 종료 메시지)
      - restart (다시 입력 받을건지 메시지)
    - State
      - start (현재 참여 상태)
      - strike (입력받은 값 스트라이크 갯수)
      - ball (입력받은 값 볼 갯수)
      - SIZE (입력받을 수의 크기)
    - Object
      - User (사용자)
      - Opponent (상대방, 컴퓨터)
  - Method
    - playGame (게임 시작)
      - checkStrike (스트라이크 체크) 
      - checkBall (볼 체크)
        - equalCharacter (문자열 체크)
      - print_State (스트라이크, 볼 상태 출력)
      - right_answer (3스트라이크 일때 종료 or 재시작)
        - restart (다시 시작할건지 체크)
      - init_Strike_Ball (사용자에게 입력받기 전에 초기화)
- ## User
  - Field
    - state
      - number (사용자 입력 숫자)
  - Method
    - input_Number (사용자에게 입력받는 함수)
    - restart (사용자에게 재시작 여부)

- ## Opponent
  - Field
    - State
      - number (상대방, 컴퓨터 숫자)
      - MAX (9)
      - MIN (1)
      - SIZE (자릿수 크기)
  - Method
    - checkOverlap (자릿수 중복 확인)
    - createNums (컴퓨터 난수 생성)

- ## Valid (유효성 확인)
  - Method
    - userInput (유저의 입력값 확인 함수)
      - outOfRange (3자리를 벗어 났을 때)
      - notMatch (정수가 아닐 때)
      - checkOverlap (중복된 숫자가 포함 됐을 때)
    - userRestart (유저에게 재시작 입력값 확인)

                      
