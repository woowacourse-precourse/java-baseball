[기능 구현 목록]
1. 입력
- 컴퓨터 : 1-9까지 서로 다른 3자리의 수
  Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
- 시스템 : 게임 시작 1
         게임 종료 2 

2. 출력
- (gameStartMessage)
  - 게임 시작 문구 출력 
          "숫자 야구 게임을 시작합니다."
          "숫자를 입력 해 주세요."
- (userPickNumber)
  - 사용자에게 숫자 입력 받기 
    사용자가 입력하는 값은`camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


- 숫자를 입력했을 때
    [시스템]
    결과 : -볼 - 스트라이크
        같은자리에 같은 숫자 = 스트라이크
        자리는 다르지만 숫자 포함 = 볼
        하나도 못 맞췄을 때 = 낫싱
        숫자 똑같이 맞췄을 때 = "3 스트라이크"
                           "3개의 숫자를 모두 맞히셨습니다. 게임종료"
- "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."