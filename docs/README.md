## 기능목록
#### 모델

1. BallNumber
   1. 수동생성, 범위제한(1~9) 
   2. hashCode /equals
2. Ball
   1. BallNumber 받고 생성 
   2. equals / hashCode
3. Balls
   1. 숫자 리스트를 받고 Balls 생성 기능
   2. computerBalls와 userBalls 비교 하고 JudgementType를 받고 BallReport 반환하는 기능
   3. Ball 포함 여부 기능
   4. 범위 제한 기능
4. JudgmentType
   1. 스트라이크 / 볼 / 낫싱
   2. EnumMap 생성 기능 (EnumType(JudgementType))
5. BallReport
   1. JudgmentType로 수량 추가 기능
   2. 리스트로 출력 기능 (reportToList)
6. BaseBallGame
   1. 1~ 9번까지 서로 다른 임의의 3개 Ball을 생성하고 comBallList 저장 기능
   2. user에서 입력받은 숫자를 List로 변환하고 comBallList와 비교하고 격과를 반환
7. NumberToListChanger
   1. 숫자를 리스트로 변경 하는 기능



#### 입력뷰
Inputview
- 게임 입력 숫자 요청
- 게임 재시작 숫자 요청
  InputViewValidator
- 입력된 숫자 길이 확인 기능
- 입력된 숫자가 서로 다른 숫자 확인 기능
- TestCase 작성

#### 출력뷰
1. OutPutView
   1. baseGame 에서 발생한 힌트를 가지고 출력 기능
