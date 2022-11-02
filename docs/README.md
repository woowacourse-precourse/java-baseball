## 기능목록
#### 모델

1. BallNumber
   1. 랜덤생성,수동생성, 범위제한 /hashCode/ equals/TestCase
2. Ball
   1. BallNumber 받고 생성 , equals / hashCode/TestCase
3. RandomNumber
   1. 1 부터 9 까지 랜덤된 숫자 생성
4. BallList
   1. Ball를 추가 기능
   2. computerBallList와 userBallList 비교 하고 힌트를 받고 BallReport 반환하는 기능
      - 같은 수가 같은 자리에 있으면 스트라이크,
      - 다른 자리에 있으면 볼
      - 같은 수가 전혀 없으면 낫싱
   3. Ball 포함 여부 기능
5. JudgmentType
   1. 스트라이크 / 볼 / 난
6. BaseBallGame
   1. 1~ 9번까지 서로 다른 임의의 3개 Ball을 생성 (Ball에 순서 포함) 하고 comBallList 생성기능(1~9)
   2. user에서 입력받은 숫자를 userBallList로 변환하고 comBallList와 비교하고 게임 종료 여부 확인 기능
7. BallReport
   1. 스트라이크 / 볼  담은다.


#### 입력뷰
1. InputView
   1. user에게 3자리수를 입력받습니다.
2. InputViewValidator
   2. 일력받은 숫자가 서로 다른 3자리 수 인자 확인기능
3. InputRestartGameOrNot
   1. 입력받은 숫자를 근거로 게임 재시작 기능

#### 출력뷰
1. OutPutView
   1. baseGame 에서 발생한 힌트를 가지고 출력 기능
