# 체크리스트

## UML 다이어그램
![UML_Diagram](https://user-images.githubusercontent.com/92911823/199688753-3951108b-dbe1-4e94-86f4-456e545d3bcf.jpg)
## FLOW CHART
![flowchart](https://user-images.githubusercontent.com/92911823/199688763-8738bed9-18c4-4557-93e5-31ce57c84d22.jpg)
1. 게임 시작
   1. 게임보드 생성 - GameBoard.getGameBoard() -> void
   2. 랜덤넘버로 BaseballNumbers 생성 - GameBoard.putRandomNumbers() -> void ->camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 이용
2. 입력 ->camp.nextstep.edu.missionutils.Console의 readLine() 이용
   1. 유효성 검사 성공 - BaseballGame.validCheck() -> Boolean
      1. 숫자인 경우
         1. 입력값을 List로 변환 후 BaseballNumbers 생성 후 BallCount에 저장 - GameBoard.putInputNumbers(List) -> BallCount
         2. 입력값과 랜덤값을 비교하여 ball,strike를 기존에 있던 BallCount에 저장 후 GameBoard의 BallCounts에 저장- GameBoard.comparebaseballNumbers(BallCount) -> BallCount
         3. 3스트라이크가 아닌 경우 볼카운트 출력 - GameBoard => BaseballGame => Application.main() -> String ex) “1 볼 2 스트라이크” or “1 볼” or “낫싱”
         4. 3스트라이크인 경우 게임 종료 후 재시작 여부 알림 - GameBoard => BaseballGame => Application.main() -> String ex) “3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.”
         5. “records”인 경우
            - 입력값과 결과가 기록된 것을 출력 - GameBoard.getBallCounts() => BaseBallGame => Application.main() -> String ex) “1, 3, 2 : 1 볼 1 스트라이크 \n 1, 2, 3 : 2 볼 ...”