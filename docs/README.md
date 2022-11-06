기능 명세
- 
- 출력
  - 프로그램 시작 문구 출력 / ui package > OutputText class > startGame func
  - 프로그램 종료 문구 출력 / ui package > OutputText class > endGame func
  - 숫자 입력 문구 출력 / ui package > OutputText class > inputNumber func
  - Strike, Ball 문구 출력 / ui package > OutputText class > strike, ball, strikeAndBall, nothing func


- 게임 프로세스
  1) 시작
        - 랜덤 컴퓨터 값 생성 / process package > InitGame class > createComputerNumber func
  2) 과정
        - 사용자가 추측한 컴퓨터 숫자 입력 / process package > MainGame class > inputGuessNumber func
        - 사용자가 입력한 값 올바른지 판단 / process package > MainGame class > isRightInput func  
        - 컴퓨터값, 인풋값 Strike, Ball 판단 / process package > MainGame class > judge func 
  3) 끝

