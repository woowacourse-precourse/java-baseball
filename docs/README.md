## 숫자 야구 미션 - 구현 기능 목록
__1. generateRandomNumber__
   - 기능: ```camp.nextstep.edu.missionutils``` 에서 제공하는 ```Random``` 을 사용하여 랜덤한 3자리 수를 return 함
   - 파라미터: None


__2. getUserInput__
   - 기능: 사용자로부터 서로 다른 세 개의 수를 입력받고 배열로 return 함, 입력값을 읽을 때는 ```camp.nextstep.edu.missionutils``` 의 ```Console```을 사용함
   - 파라미터: None
   - 예외처리
     - 같은 숫자가 2번 이상 반복될 때
     - 0이 포함되어 있을 때
     - 숫자가 아닌 다른 값을 입력했을 때


__3. result__
   - 기능: 사용자가 입력한 숫자와 1번에서 생성한 숫자를 비교하여 그 결과를 print 하고, length 2짜리 배열로 return 함
     - { 볼 개수, 스트라이크 개수 }
   - 파라미터: 컴퓨터가 생성한 랜덤 숫자, 사용자가 입력한 숫자


__4. game__
   - 기능: 게임을 실행하는 함수, 위 함수들을 이용하여 게임을 진행함
   - result 의 return 값에 따라 (즉, 3스트라이크가 나올 때까지) 게임을 반복하여 실행함
   - 파라미터: None