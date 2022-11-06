기능 명세
- 
- 게임 객체
  1) 생성자
        - 랜덤 컴퓨터 값 생성 / unit package > init class > createComputerNumber func
  2) 과정
        - 사용자가 추측한 컴퓨터 숫자 입력 / unit package > Game class > inputGuessNumber func
        - 사용자가 입력한 값 올바른지 판단 / unit package > Game class > isRightInput func  
        - 컴퓨터값, 인풋값 Strike, Ball 계산 / unit package > Game class >  calculate func
        - 컴퓨터값, 인풋값 Strike, Ball 판단 / unit package > Game class > isAllStrike func 
  3) 끝
      - 재시작 및 종료 판단 / unit package > init class > stopGame func


- 출력
    - 프로그램 시작 문구 출력 / ui package > OutputText class > printStartGame func
    - 프로그램 종료 문구 출력 / ui package > OutputText class > printEndGame func
    - 숫자 입력 문구 출력 / ui package > OutputText class > printInputNumber func
    - Strike, Ball 문구 출력 / ui package > OutputText class > printJudgeStrike, printJudgeBall, printJudgeStrikeAndBall, printJudgeNothing func

