---
docs: SystemController 기능 구현 목록
## 기능 구현

-baseball()
-게임이 시작됨을 출력한다
-랜덤값을 호출하였다.
-종료가 될때까지, 게임이 재시작을 하게 해 주었다.
-재시작을 하기 위해 점수를 초기화 하였고, 다시 입력을 받아 점수를 계산하고 ThreeStrike면 다시 재시작할건지 물어보게 하였다
-calculateScore()
-increase_strike_or_ball()을 사용하여, 입력한 값이 어떤 점수인지 알려주게 해 주었다.
-increase_strike_or_ball()
-SystemScoreModel의 값이 BALL/STRIKE이면 해당 하는 인트 값들을 증가시키게 해 주었다.
-resetScore()
-BALL/STRIKE에 해당 하는 인트 값들을 0으로 초기화 한다
-readyToExit()
-systemComputerModel에 있던 isReadytoExit()을 갖고와서 True면 종료시키게 해주었다.
-printResult()
-SystemScoreModeltoString()을 출력한다
-THREESTRIKE면, 게임이 종료되었다는 문구를 출력시키게 해 주었다.
-SystemScoreModeltoString()
-BALL/STRIKE에 해당 하는 인트 값들로, 모두 0이면 NOTHING
-그리고 SystemScoreModeltoStringBuilder()을 사용하여 STRIKE  or  BALL을 리턴해주어 사용자가 입력한 값이 몇 볼/몇 스트라이크/낫싱인지 보여주게 했다.
-SystemScoreModeltoStringBuilder()
-BALL/STRIKE에 해당 하는 인트 값들이 0보다 크면 builder에 넣어 builder 값을 String 형식으로 반환해주었다.