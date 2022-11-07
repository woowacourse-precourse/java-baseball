
## 각 메소드별 설명, 설계
- void inGame()
  - 게임에 들어가는 메소드
  - 내부에 do ~ while문을 통해서 조건이 true이면 계속해서 반복한다
- void printStartGame()
  - 게임의 시작 문구를 출력하는 메소드
- int makeRandomNumber()
  - 랜덤한 세자리 숫자를 만들고 리턴하는 메소드
  - 주어진 random 라이브러리를 활용한다
- int insertNumber()
  - 사용자로부터 숫자를 입력받는 메소드
  - 아래의 주어진 조건이 아닐떄 예외를 뱉도록 한다
    - 숫자가 아닐떄
    - 숫자이지만 3자리가 아닐떄
    - 3자리 중에 서로 같은 숫자가 있을떄 
  - 주어진 console 라이브러리를 활용한다
- boolean checkNumber(int number)
  - insertNumber의 각 예외 케이스를 검사하며 true/false값을 리턴한다
- int[] judge(int answer, int value)
  - 사용자가 입력한 값과 정답을 서로 비교 후 원소가 2개인 상태 배열을 만들어서 리턴한다
  - 아래의 주어진 조건에 따라서 원소값을 결정한다
    - 스트라이크일 경우 첫번쨰 원소 +1
    - 볼일 경우에 두번째 원소 +1
- void printJudge(int[] score)
  - score 배열을 보고 값을 출력한다
  - 값은 아래의 주어진 조건에 따라서 결정한다
    - [0,0]일 경우 낫싱
    - 첫번쨰 원소 -> 스트라이크 수
    - 두번쨰 원소 -> 볼 수 
- boolean isEnd(int[] score)
  - 게임이 끝났는지 여부를 판단해서 값을 리턴한다
  - 값은 아래의 주어진 조건에 따라서 결정한다
    - [3,0]일 경우 true
    - 그 외의 경우 false
- void printEndGame(boolean state)
  - 게임의 끝남 여부를 출력한다
  - state가 true이면 게임의 끝을 아니면 아무 값도 출력하지 않는다
- boolean isContinueOrEnd()
  - 게임의 재시작 여부를 판단한다
  - insertNumber()를 호출해서 값을 받는다
  - 만약 값이 1,2가 아닌 값이면 예외를 뱉도록 한다
  - 1일 경우에 true를 반환한다
  - 2일 경우에 false를 반환한다

## 각 메소드별 체크 리스트
- [ ] void printStartGame()
- [ ] int makeRandomNumber()
- [ ] int insertNumber()
- [ ] boolean checkNumber(int number)
- [ ] int [] judge(int answer, int value)
- [ ] void printJudge(int[] score)
- [ ] boolean isEnd(int[] score)
- [ ] void printEndGame(boolean state)
- [ ] boolean isContinueOrEnd()
- [ ] void inGame()

## 각 메소드별 테스트 케이스

### void printStartGame()
- "숫자 야구 게임을 시작합니다." 가 정상적으로 출력되는지 확인

### int makeRandomNumber()
- 만들어진 것이 숫자, 3자리인지, 서로 다른지 확인

### int insertNumber()
- 입력받은 것이 문자일때 예외 상황이 잘 출력되는지 확인
- 입력받은 것이 실수일떄 예외 상황이 잘 출력되는지 확인
- 입력받은 숫자가 음수일떄 예외 상황이 잘 출력되는지 확인
- 입력받은 숫자가 4자리일때 예외 상황이 잘 출력되는지 확인
- 입력받은 숫자의 100의 자리, 10의 자리 숫자가 서로 같을때 예외 상황이 잘 출력되는지 확인
- 입력받은 숫자의 10의 자리, 1의 자리 숫자가 서로 같을때 예외 상황이 잘 출력되는지 확인
- 입력받은 숫자의 100의 자리, 1의 자리 숫자가 서로 같을때 예외 상황이 잘 출력되는지 확인
- 입력받은 숫자의 모든 자릿수가 서로 같을때 예외 상황이 잘 출력되는지 확인
- 입력받은 숫자가 세자리이고 모든 자릿수가 다를떄 예외 상황이 잘 출력되지 않는 것을 확인

### boolean checkNumber(int answer)
- insertNumber에서 대부분 확인이 되었으니 따로 테스트 케이스를 작성하지 않는다

### int [] judge(int answer, int value)
- answer와 value가 완전히 같은 경우 [3,0]이 나오는지 확인한다
- answer와 value의 완전히 다를 경우 [0,0]가 나오는지 확인한다
- answer와 value의 2개의 숫자와 자릿수가 일치할떄 [0,2]가 나오는지 확인한다
- answer와 value의 1개의 숫자와 자릿수가 일치할떄 [0,1]가 나오는지 확인한다
- answer와 value의 1개의 숫자가 일치하지만 자릿수는 다를때 [0,1]가 나오는지 확인한다
- answer와 value의 2개의 숫자가 일치하지만 자릿수는 다를때 [0,2]가 나오는지 확인한다
- answer와 value의 모든 숫자가 일치하지만 자릿수가 모두 다를떄 [0,3]가 나오는지 확인한다
- answer와 value의 1개의 숫자와 자릿수가 같으면서 1개의 숫자가 일치하지만 자릿수가 모두 다를떄 [1,1]가 나오는지 확인한다
- answer와 value의 1개의 숫자와 자릿수가 같으면서 2개의 숫자가 일치하지만 자릿수가 모두 다를떄 [1,2]가 나오는지 확인한다
- answer와 value가 모두 다를 경우 [0,3]이 나오는지 확인한다

### void printJudge(int[] score)
- score가 [3,0] 일떄 "3스트라이크"가 출력되는지 확인한다
- score가 [0,0] 일떄 "낫싱"이 출력되는지 확인한다
- score가 [1,0] 일떄 "1스트라이크"이 출력되는지 확인한다
- score가 [2,0] 일떄 "2스트라이크"이 출력되는지 확인한다
- score가 [1,1] 일떄 "1볼 1스트라이크"이 출력되는지 확인한다
- score가 [1,2] 일떄 "2볼 1스트라이크"이 출력되는지 확인한다
- score의 첫번쨰 원소가 0,1,2,3이 아닐 경우에 예외가 출력되는지 확인한다
- score의 두번쨰 원소가 0,1,2,3이 아닐 경우에 예외가 출력되는지 확인한다

### boolean isEnd(int[] score)
- score가 [3,0] 일떄 true를 리턴하는지 확인한다
- score가 [0,3] 일떄 false를 리턴하는지 확인한다
- score가 [1,2] 일떄 false를 리턴하는지 확인한다
- score가 [2,1] 일떄 false를 리턴하는지 확인한다

### void printEndGame(boolean state)
- state가 true일때 "3개의 숫자를 모두 맞히셨습니다! 게임 종료"와 ""게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."가 출력되는지 확인한다
- state가 false일때 아무것도 출력되지 않는지 확인한다

### boolean isContinueOrEnd()
- 입력값이 1일떄 true값이 리턴되는지 확인한다
- 입력값이 2일떄 false값이 리턴되는지 확인한다
- 입력값이 3일떄 예외가 발생하는지 확인한다
- 입력값이 문자일떄 예외가 발생하는지 확인한다
- 입력값이 실수일떄 예외가 발생하는지 확인한다
- 입력값이 음수일떄 예외가 발생하는지 확인한다

### void inGame()
- 내부의 함수들이 모두 테스트되었으므로 따로 테스트하지 않는다
