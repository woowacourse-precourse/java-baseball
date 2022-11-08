# 기능 분할

- 객체
    - Application 애플리케이션
        - main()
    - Game Manager 게임 매니저
      - 생성자
      - doGame() : void // 게임 진행
        - setComputerSetting(Computer) : void // 컴퓨터 설정 세팅
        - setUserSetting(Player) : void // 유저 설정 세팅
        - verifyUserAnswer(Computer,Player) : void // 볼,스트라이크,낫싱 판별
          - hasSameNumber(Computer,Player, int) : void // 같은 수인지 확인
          - hasSameDigit(Computer,Player, int) : void // 같은 자리인지 확인
        - printUserAnswer(Player) : void // 사용자 입력 결과값 출력
          - printNothing(Player) : void     // 낫싱 케이스
          - printStrike(Player) : void     // 스트라이크만 있는 케이스
          - printBallOrStrike(Player) : void     // 볼 혹은 스트라이크 케이스
        - askRestart() : void // 게임 재시작 여부 질의
    - Player 플레이어
      - getUserInput() // 사용자 입력
        - pushGuessingNumber() // 입력값을 ArrayList에 삽입
    - Computer 컴퓨터
      - generateAnswer() // 난수 생성

# 기능 구현 계획표

| Day1 금 | Day2 토 | Day3 일 | Day4 월 | Day5 화 |
| --- | --- |---| --- |----|
| Bottom-Up 설계/구현 #1 | Bottom-Up 설계/구현 #2 | Top-Down 기능동작 확인 | 기능 구현 마감 & 리팩토링 | 최종 리팩토링 |