# 기능목록
## 객체별 구현목록
### ComputerNumberGenerator
컴퓨터에 저장된 수가 3개가 될 때 까지 반복한다.
1. insertNumber() : 랜덤값 1~9가 이미 있지 않으면 저장시킨다.
   1. createRandomNumber : 랜덤값 1~9 출력 함수
   2. isAlreadyInNumbers : 이미 있으면 true 리턴 함수
   3. putNumber : 값을 저장시키는 함수
2. makeThreeDigitNumber() : 1~9의 세자리 랜덤 값을 생성한다.
   1. insertNumber() 3번 반복
3. returnNumbersToArray : 리스트에 저장한 숫자들을 배열로 리턴해준다.

### PlayerInputFilter
1. getInput() : readLine으로 입력한 문자열을 반환한다.
2. checkException(String input) : 입력한 문자열로 에러가 발생하는지 체크한다.
   1. isNotNumber(String input) : 입력한 문자열에 숫자가 아닌게 있을 떄 참을 반환한다.
   2. noNumberException() : IllegalArgumentException와 메세지로 예외처리한다.
   3. isNotThreeDigit(String input) : 문자열의 길이가 3이 아니면 참을 반환한다.
   4. notThreeDigitException() : IllegalArgumentException와 메세지로 예외처리한다.
   5. containsZero(String input) : 문자열에 0이 있으면 참을 반환한다.
   6. containsZeroException() : IllegalArgumentException와 메세지로 예외처리한다.
   7. containsSameNumber(String input) : 문자열에 같은 숫자가 존재하면 참을 반환한다.
   8. containsSameNumberException() : IllegalArgumentException와 메세지로 예외처리한다.
3. insertNumbers()
   1. getInput() : 문자열을 받아온다.
   2. checkException(String input) : 문자열 예외처리를 확인한다
   3. convertNumbersToArray(String input) : 문자열을 int형 배열로 전환해 리턴한다.

### GameSystem
1. gameSet = 1로 변수를 정한다. 
2. gameSet이 1일 동안 반복시킨다. 
   1. 배열에 컴퓨터의 값을 랜덤하게 구해 저장시킨다. 
   2. 배열에 사용자의 값을 입력받아 저장시킨다. 
   3. 컴퓨터와 사용자의 값이 3스트라이크가 될때 까지 반복한다. 
      1. 사람의 수를 첫째 자리부터 셋째자리까지 비교한다. 
          1. 만약 그 숫자가 존재하고 자리까지 같다면 스트라이크 1증가
          2. 만약 그 숫자가 존재하지만 자리가 다르면 볼이 1증가
      2. 결과를 출력한다. 
         1. "a볼 b스트라이크"로 출력한다. 
            1. a==0이면 "b스트라이크"로 출력한다. 
            2. b==0이면 "a볼"로 출력한다. 
            3. a==0 && b==0이면 "낫싱"으로 출력한다. 
   4. "3개의 숫자를 모두 맞추셨습니다! 게임 종료" 를 출력한다. 
   5. "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"를 출력한다. 
3. 입력을 받는다. (1 또는 2)
   1. 값이 1 또는 2인지 확인한다. 
      1. 값이 1또는 2가 아닐 경우 재입력을 요구한다. 
   2. gameSet에 값을 저장한다. 
      1. gameSet의 값에 따라 반복문이 반복될지, 종료될지 정해진다.

