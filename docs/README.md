# 체크리스트

## UML 다이어그램
![UML_Diagram](https://user-images.githubusercontent.com/92911823/199688753-3951108b-dbe1-4e94-86f4-456e545d3bcf.jpg)
## FLOW CHART
![flowchart](https://user-images.githubusercontent.com/92911823/199688763-8738bed9-18c4-4557-93e5-31ce57c84d22.jpg)
1. 게임 시작
    1. 게임보드 생성
    2. 랜덤넘버로 BaseballNumbers 생성 ->camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 이용
2. 입력 ->camp.nextstep.edu.missionutils.Console의 readLine() 이용
    1. 유효성 검사 성공 o (BaseballNumbers.createBaseballNumbers(readline))
        1. 숫자인 경우 (true)
            1. 입력값을 3개의 숫자로 구분한 List로 변환 후 숫자 하나와 인덱스를 BaseballNumber에 저장 o (BaseballNumber(baseballNumber,index))
            2. 생성된 BaseballNumber를 BaseballNumbers에 저장 o (BaseballNumbers.putBaseballNumbers(baseballNumberList))
            3. 입력값과 랜덤값을 비교하여 BallCount에서 ball,strike를 저장 o (BallCount.validateBallCount())
            4. ball, strike가 저장된 BallCount를 GameBoard의 BallCounts에 저장 o (GameBoard.updateBallCounts(ballCount))
            5. 3스트라이크가 아닌 경우 볼카운트 출력 - String ex) “1 볼 2 스트라이크” or “1 볼” or “낫싱” o (GameBoard.showBallCount(inputBaseballNumbers))
            6. 3스트라이크인 경우 게임 종료 후 재시작 여부 알림 - String ex) “3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.”
        2. “records”인 경우 (false)
            - 입력값과 결과가 기록된 것을 출력 - String ex) “1, 3, 2 : 1 볼 1 스트라이크 \n 1, 2, 3 : 2 볼 ...”
        3. 그 외인 경우 (IllegalArgumentException)