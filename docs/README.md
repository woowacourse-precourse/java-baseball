## 구현할 기능 목록

### 1. 컴퓨터가 1-9사이에서 서로 다른 임의의 수 3개를 선택하는 기능
#### 메인 구현 함수
    List<Integer> pickTargetNumber()
### 2. 플레이어가 입력값을 검증하고 숫자의 값이 잘못된 경우 예외를 발생시키는 기능
#### 메인 구현 함수
    List<Integer> checkUserNumber(String userInput) throws IllegalArgumentException
#### 검증 목록
* 플레이어의 입력값의 길이가 3이 아닌 경우
* 플레이어의 입력값의 각 Character의 범위가 1부터 9 사이가 아닌 경우
* 플레이어의 입력값에 중복이 있는 경우
### 3. 플레이어와 컴퓨터의 숫자 값을 비교한 결과를 계산하는 기능
#### 메인 구현 함수
    GameResult Computer.compare(List<Integer> targetNumber)
### 4. 계산된 결과를 바탕으로 메세지를 출력하는 기능
#### 메인 구현 함수
    void printResult(GameResult result)
### 5. 계산된 결과를 바탕으로 게임을 종료하거나 다시 입력받는 기능
#### 메인 구현 함수
    boolean nextTurn(GameResult result), int run()
### 6. 게임이 종료된 경우 게임을 다시 시작하거나 완전히 종료하는 기능
#### 메인 구현 함수
    Applcation.main()