---
docs: SystemComputerModel 기능 구현 목록
## 기능 구현

- setRandomNumber()
    - 임의의 랜덤값을 하나씩 받아 중복되지 않는 세자리 수를 만들었다.
- isReadyToExit()
    - 게임이 종료되고, 재시작할지 묻는 질문에 2번을 눌렀다면, 그 상태를 출력하기 위해 만들었다.
- getScore()
  -입력받을 값을 한 자리씩 비교한다
  -IS_STRIKE_OR_BALL을 이용하여 STRIKE/BALL/NOTHING을 구분하게 하였다.
- IS_STRIKE_OR_BALL
  -한 자리 씩 비교하여, 값과 자릿수가 같으면 STRIKE
  -값은 같으나, 자릿수가 다르면 BALL을 리턴하게 하였다