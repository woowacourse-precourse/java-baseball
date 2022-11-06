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
- [ ] void setNumbers()
  - 서로 다른 3자리의 수 준비

## 2. 예외처리
### IllegalArgumentException
- [x] 사용자가 잘못된 값을 입력할 경우
    - '사용자'는 NumberBaseball 에서는 '게임 플레이어'

## 3. 테스트
### NumberBaseBall 테스트
- [ ] gameStart() 테스트
    - "숫자 야구 게임을 시작합니다."를 출력하는지 확인
- [ ] playGame() 테스트
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생 시키는지 확인
    - 스트라이크 3개일 때 "3스트라이크", "게임 종료"를 출력하는지 확인
    - 1볼 1스트라이크 일때 "1볼 1스트라이크'를 출력하는지 확인
    - 1볼일 때 "1볼"를 출력하는지 확인
    - 1스트라이크일 때 "1스트라이크"를 출력하는지 확인
    - 낫싱일 때 "낫싱"을 출력하는지 확인
- [ ] isRestart() 테스트
    - "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."를 출력하는지 확인
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생 시키는지 확인
- [ ] getBallCount(String presentNumber) 테스트
    - 볼이 0개일 때 0을 반환하는지 확인
    - 볼이 1개일 때 1을 반환하는지 확인
    - 볼이 2개일 때 2를 반환하는지 확인
    - 볼이 3개일 때 3을 반환하는지 확인
- [ ] getStrikeCount(String presentNumber) 테스트
    - 스트라이크가 0개일 때 0을 반환하는지 확인
    - 스트라이크가 1개일 때 1을 반환하는지 확인
    - 스트라이크가 2개일 때 2를 반환하는지 확인
    - 스트라이크가 3개일 때 3을 반환하는지 확인                                     