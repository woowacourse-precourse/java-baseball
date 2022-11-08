### 기능 목록 

- 랜덤 숫자를 생성하는 기능
  - Numbers 클래스
    - 숫자 정보를 담고 있는 클래스
  - NextStepNumberGenerator 클래스의 generateRandomNumber 메서드
    - 1~9 사이의 숫자
    - 숫자 3개를 생성
    - 중복 없는 숫자
  
- 사용자가 숫자를 입력하는 기능
  - 숫자 야구 게임 진행 중
    - ConsoleInput 클래스의 getNumber 메서드
      - 1~9 사이의 숫자를 입력
      - 숫자 3개를 입력
      - 중복 없이 입력
  - 게임 재시작 or 게임 종료
    - ConsoleInput 클래스의 getOneOrTwo 메서드
      - 1 또는 2를 입력
      - 숫자 1개를 입력

- 입력한 숫자를 검증하는 기능
  - validateUserInput 메서드
    - 입력된 문자의 길이가 3인지 판단
    - 입력된 문자가 1~9 인지 판단
    - 입력된 문자가 중복이 없는지 판단
  - validateOneOrTwo 메서드
    - 입력된 문자의 길이가 1 인지 판단
    - 입력된 문자가 1 이나 2 인지 판단
  
- 정답 숫자와 입력한 숫자를 비교하는 기능
  - GameService 클래스의 compareAnswerNumberAndInputNumber 메서드
    - 입력 숫자와 정답 숫자를 비교
    - Strike 개수와 Ball 개수를 반환
  
- 비교 결과를 출력하는 기능
  - ConsoleOutput 클래스의 printStrikeandBall 메서드
    - Strike 개수와 Ball 개수를 Console에 출력

- Strike의 개수가 3일 경우, 게임을 종료하는 기능
  - StrikeAndBall 클래스의 isThreeStrike 메서드
    - Strike의 개수가 3일 경우, true 반환
    - true 일 경우, 게임 종료
  
- 게임을 재시작 또는 종료하는 기능
  - Game 클래스의 playNewGameOrQuit 메서드
    - 입력된 숫자가 1일 경우, 재시작
    - 입력된 숫자가 2일 경우, 종료