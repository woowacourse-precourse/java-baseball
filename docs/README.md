# 미션 - 숫자 야구
## 기능 목록
1. NumberBaseball 클래스 구현
2. 예외처리
3. 테스트

## 1. NumberBaseball 클래스
### - Constants -
- NUMBER_SIZE: 3
- START_NUMBER: 1
- END_NUMBER: 9
- ASCII_ZERO: 48
- ASCII_NINE: 57
- ASCII_ONE: 49
- ASCII_TWO: 50

### - Properties -
- numbers: char [3]
    - 서로다른 3자리의 수(1 ~ 9)

### - Constructors -
- [x] NumberBaseball() 구현

### - Methods -
- [x] void gameStart() 구현
  - "숫자 야구 게임을 시작합니다." 출력 후 줄 바꿈
  - 최초 1회는 playGame() 호출
  - isRestart()가 true 라면 playGame() 호출
- [x] void playGame() 구현
  - "숫자를 입력해주세요 : " 출력
  - 게임 플레이어가 서로 다른 3자리 수 입력(Console)
  - strikeCount 가 3일 경우 종료
      - "3개의 숫자를 모두 맞히셨습니다! 게임 종료" 출력 후 줄 바꿈
  - ball, strike Count 가 둘다 0보다 클 경우 "n볼 m스트라이크" 출력
  - ballCount, strikeCount 가 0일 경우 "낫싱" 출력
  - 종료 되지 않으면 계속 진행
- [x] boolean isRestart() 구현
  - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 후 줄 바꿈
  - 게임 플레이어가 1 또는 2 입력(Console)
  - "1"일 경우 재시작(true), 2일 경우 종료(false)
- [x] int getBallCount(String presentNumber)
  - numbers 기준으로 숫자는 같지만 다른 자리에 있을 경우의 개수를 반환
- [x] int getStrikeCount(String presentNumber)
  - numbers 기준으로 숫자가 같으면서 같은 자리일 경우의 개수를 반환
- [x] boolean isBall(char value, int index)
  - 볼인지 확인하는 함수(indent 3을 넘지 않기 위해 만든 도우미 함수)
- [x] void checkNumberCharacter() 
  - 숫자가 아닌 예외처리하는 함수
- [x] void setNumbers()
  - 서로 다른 3자리의 수 준비

## 2. 예외처리
### IllegalArgumentException
- [x] 사용자가 잘못된 값을 입력할 경우
    - '사용자'는 NumberBaseball 에서는 '게임 플레이어'

## 3. 테스트
### NumberBaseBall 테스트
- [x] playGame() 테스트
    - 3스트라이크에 게임이 종료되는지 확인
    - 볼과 스트라이크가 정상적으로 출력되는지 확인
    - 볼이 정상적으로 출력되는지 확인
    - 스트라이크가 정상적으로 출력되는지 확인
    - "숫자 야구 게임을 시작합니다."를 출력하는지 확인(@AfterEach) 
- [x] 예외 처리 테스트(IllegalArgumentException)
  - playGame() 예외 테스트
    - 3자리 초과 입력하는 경우
    - 3자리 미만을 입력하는 경우
    - 문자가 포함된 입력을 하는 경우
  - isRestart() 예외 테스트
    - 1자리 숫자를 초과하는 경우
    - 1, 2 아닌 숫자를 입력하는 경우
    - 문자를 입력하는 경우