## 기능구현 목록

1. 랜덤 난수 생성
  - `isValidateDigitNum()`: 숫자 리스트를 받아 가장 앞의 수가 0인지 확인한다.
  - `numListToIntValue()`: 크기가 n인 숫자 리스트를 받아 n자리의 숫자로 만들어 반환한다.
  - `getRandomNum()`: `camp.nextstep.edu.missionutils.Randoms` 클래스의 `pickUniqueNumbersInRange()` 메서드를 사용해 중복되지 않는 3자리 숫자 리스트를 받아와 `isValidateDigitNum()`로 유효성 검사 후, `numListToIntValue()`를 이용해 `int` 타입으로 반환한다. 

2. 숫자 입력
  - `getUserInput()`: `camp.nextstep.edu.missionutils.Console` 클래스의 `readLine()` 메서드를 이용해 `String` 형식의 입력받은 후 아래의 메서드들을 통해 유효성 검사 후, `Integer.parseInt()`를 통해 `int` 타입으로 반환한다.
  - 예외 1) 숫자가 아닌 값 입력
    - `validateNumber()`: 숫자가 아닌 다른 값을 입력했을 때 `IllegalArgumentException` 예외 발생시킴
  - 예외 2) 3자리가 아닌 수 입력 (0으로 시작하는 수 포함)
    - `validateNumberOfDigits()`: 3자리 숫자가 아닐 때 `IllegalArgumentException` 예외 발생시킴
  - 예외 3) 서로 다른 3자리가 아닌 수
    - `validateDuplicateNumber()`: 입력값을 문자마다 `compareChar()`을 통해 비교함
    - `compareChar()`: 비교하는 두 문자가 같을 때 `IllegalArgumentException` 예외 발생시킴

3. 난수와 입력한 수 비교
  - 메서드 1) 3자리수를 쪼개서 배열로 반환
  - 메서드 2) 각 자리수를 비교해 스트라이크 개수 반환
  - 메서드 3) 각 자리수를 비교해 볼 개수 반환

4-1. 스트라이크 개수가 3이 아닌 경우 
  - 숫자 입력 단계로 이동

4-2. 스트라이크 개수가 3인 경우
  - 재시작 여부 입력
  - 재시작이면 1. 랜덤 난수 생성 단계로 이동

