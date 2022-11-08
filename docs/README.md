**기본 메커니즘**

- computer 3개 수 선택
    - player 3개 수 입력
    - computer 결과 출력
        - 스트라이크, 볼, 낫싱
- 컴퓨터가 모두 맞히면 종료
- 게임 종료 시
    - 1입력: 다시 시작
    - 2입력: 완전 종료
- 잘못된 값 입력 시 `IllegalArgumentException` 발생시킨 후 종료


**구현할 기능 목록**

- **BaseballGame**
    - 생성자
        - player, computer 할당
    - `initializeGame`
        - computerNumber 생성
        - `printStartMessage`
            - “숫자 야구 게임을 시작합니다”
        - `playGame`
        - `checkRestartGame`
    - `playGame`
        - while(isNotThreeStrike) 안에서 게임 하다가 탈출하면 `printClearMessage`
    - `printClearMessage`
        - “3개의 숫자를 모두 맞히셨습니다! 게임 종료”
    - `checkRestartGame`
        - if (isRestartNumber) → startGame
    - `isRestartNumber`
    - 올바른 입력인지 검사: `validateInputNumber`
      - `validateNumberLength`
      - `validateNumberRepeat`
          - 매개변수 string을 set으로 만들어 size비교
      - `validateNumberOrNotNumber`
          - regex 활용
- **Player**
    - 모든 매서드에서 `IllegalArgumentException()`
    - 3개 수 입력: `getPlayerNumber`
        - “숫자를 입력해주세요 : 713”
            - readLine으로 받아오기
    - `getRestartOrEndNumber`
- **Computer**
    - 3개 수 선택: `getComputerNumber`
    - 스트라이크, 볼, 낫싱 검사: `checkNumber`
        - `checkStrike` , `checkBall`
    - 클리어 여부: `isNotThreeStrike`
    - 결과값: `getComputerResult`
- **Constant**
    - constants.GameConstant에 정리