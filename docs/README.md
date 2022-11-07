# 우아한테크코스 웹 백엔드 2주차<br> java-baseball(숫자야구) by 김민찬

## 전체 구조

### 1. 상태 관리 변수 `keepPlaying`을 `true`의 값을 갖도록 선언하고, `true`인 동안 아래의 과정을 반복한다.

### 2. 함수 `createTargetNumber()`를 실행하여 컴퓨터의 세 자리수를 `targetNumber`에 저장한다.

### 3. 함수 `guessNumber()`를 실행하여 게임 한 판을 진행한다.

### 4. 함수 `inputKeepPlaying()`를 실행하여 게임을 다시 진행할지 결정한다.

<br>

### 각 단계 및 기능에 대한 구체적인 설명은 다음과 같다.

<br><br><br>

### 1. 상태 관리 변수 `keepPlaying`

- 기능 설명
    - 게임을 계속해서 진행할 것인지에 대한 정보를 `boolean` 변수 `keepPlaying`으로 관리한다.
    - `keepPlaying`의 초기값은 `true`이며, 게임이 종료된 이후 `inputKeepPlaying()`을 통해 다시 결정된다.

<br>

### 2. 컴퓨터의 세 자리수를 만드는 함수 `createTargetNumber()`

- 요구사항
  - `1`부터 `9`까지의 서로 다른 수로 이루어진 `3`자리의 수를 생성한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.


- 기능 설명
  1. 리스트 `targetNumber`를 초기화한다.
  2. `Randoms.pickNumberInRange(1, 9)`를 통해 생성된 숫자가 이미 `targetNumber`에 들어있는지 확인한 후 없다면 추가한다.
  3. `targetNumber`의 길이가 3이 될 때까지 과정 ii.을 반복하고, 길이가 3이 되면 반환한다.


- 테스트 함수
  1. `createTargetNumber_정상_생성_확인()` : 지정한 값을 활용해 생성한 `targetNumber`가 제대로 생성되는지 확인
  2. `createTargetNumber_정상_생성_확인_중복_제거()` : 랜덤에서 반영되는 값에 중복이 있을 때 `targetNumber`가 제대로 생성되는지 확인

  - 랜덤 함수에서 3, 1, 3, 1, 1, 1, 3, 1, 3, 1, 1, 1, 8 이 순서대로 반환될 경우 `targetNumber` 는 `3, 1, 8`을 순서대로 가지는 리스트

  3. `createTargetNumber_생성_결과_유효성_확인()` : 랜덤 생성한 `targetNumber`의 길이, 원소가 서로 다른지, 각 자리가 1과 9 사이인지 검증

  - 랜덤 생성 후 50회 반복 검증

<br>

### 3. 사용자가 게임을 진행하는 함수 `guessNumber()`

- 요구사항
  - 사용자로부터 서로 다른 `3`개의 숫자를 입력받아 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이라는 결과를 출력한다.
  - 위 과정을 반복해 `3`개의 숫자를 모두 맞히면 게임을 종료한다.
  - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


- 기능 설명
  1. 두 정수 변수 `Ball`, `Strike`를 담은 `List<Integer>` `BallStrikeCount`를 생성하고 각 값을 `0`으로 초기화한다.

  - 후술되는 `Ball`, `Strike`는 각각 `BallStrikeCount`의 `0`, `1`번째 index의 값을 칭한다.

  2. 함수 `inputUserNumber()`를 실행하여 유저의 입력값 `userNumber`를 입력받는다.
  3. 함수 `judgeUserNumber()`를 실행하여 유저의 입력값에 대한 결과를 `Ball`, `Strike`의 값에 저장한다.
  4. 함수 `printResult()`를 실행하여 `Ball`, `Strike`의 값에 따라 결과를 출력한다.
  5. `Strike`가 `3`가 될 때까지 과정 i.~ iv.를 반복한다.

<br> 

### 3 - 1 . 사용자의 입력을 받는 함수 `inputUserNumber()`

- 요구사항
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


- 기능 설명
  1. `Console.readLine()`을 활용하여 사용자의 입력을 `userInput`에 받는다.
  2. `userInput`를 `List<String>` 형태로 변환한 `userInputList`를 생성한다.
  3. `userInputList`에 대하여 `verifyInput()`을 실행하여 규칙에 맞지 않는다면 예외를 발생시킨다.
  4. `userInputList`의 원소 각각을 정수로 변환한 `List<Integer>` `userNumber`을 생성한다.
  5. `userNumber`을 반환한다.

<br> 

### 3 - 1 - 1 . 사용자의 입력을 검증하는 함수 `verifyInput()`

- 요구사항
  - `userInput`은 서로 다른 세 자리의 수(각 자리 숫자는 `1` 이상)이다.
  - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.


- 기능 설명
  1. 정규표현식을 활용하여 `userInput`의 길이가 3자리의 숫자이고 각 자리가 1 이상인지 검증한다.
  2. `userInput`의 각 문자가 서로 다른지 검증한다. 이는 각 자리 숫자의 집합을 생성하여 확인한다.
  3. 틀리다면 `IllegalArgumentException`을 일으킨다.


- 테스트 함수
  1. `verifyInput_길이_예외_확인()` : 입력 문자열의 길이가 `TARGET_LENGTH`가 아닌 경우 `IllegalArgumentException`을 발생시킨다.
  2. `verifyInput_숫자_예외_확인()` : 입력 문자열이 숫자가 아니거나 `0`인 경우 `IllegalArgumentException`을 발생시킨다.
  3. `verifyInput_중복_예외_확인()` : 입력 문자열 중 중복된 문자가 있는 경우 `IllegalArgumentException`을 발생시킨다.
  4. `verifyInput_정상_작동_확인()` : 조건에 맞는 문자열 입력시 출력 혹은 예외가 발생하지 않는다.

<br> 

### 3 - 2 . 사용자의 입력에 대해 결과를 판단하는 함수 `judgeUserNumber()`

- 요구사항
  - 사용자로부터 서로 다른 `3`개의 숫자를 입력받아 같은 수가 같은 자리에 있으면 `스트라이크`, 다른 자리에 있으면 `볼`, 같은 수가 전혀 없으면 `낫싱`이라는 결과를 출력한다.
  - `1볼 1스트라이크`와 같이 볼을 먼저 출력한다.
  - `3`개의 숫자를 모두 맞힐 경우 `"3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료"`를 출력한다.


- 기능 설명
  1. 각 자리 숫자에 대해 `judgeEachNumber()`를 활용하여 `Ball`, `Strike`의 값을 변경한다.

<br> 

### 3 - 2 - 1 . 사용자의 입력 각 자리 숫자 결과를 판단하는 함수 `judgeEachNumber()`

- 기능 설명
  1. 해당 숫자가 `targetNumber`에 있는지 확인한다.
  2. i.에서 있다면 입력받은 자릿수와 `targetNumber`에서의 자릿수를 비교하여 `Ball` 또는 `Strike`의 값을 1 늘린다.


- 테스트 함수
  1. `judgeEachNumber_볼_확인()` : `볼`이 반환되어야 하는 모든 자릿수 조합에 대해 `볼`이 나오는지 확인
  2. `judgeEachNumber_스트라이크_확인()` : `스트라이크`가 반환되어야 하는 모든 자릿수 조합에 대해 `스트라이크`가 나오는지 확인
  3. `judgeEachNumber_낫싱_확인()` : `낫싱`이 반환되어야 하는 모든 자릿수 조합에 대해 `낫싱`이 나오는지 확인

<br>

### 3 - 3 . 결과를 출력하는 함수 `printResult()`

- 요구사항
  - 1볼 1스트라이크와 같이 볼을 먼저 출력한다.
  - 3개의 숫자를 모두 맞힐 경우 "3스트라이크\n 3개의 숫자를 모두 맞히셨습니다! 게임 종료"를 출력한다.
    - 구현 시 코드의 간결함을 위해 "3개의 숫자를 모두 맞히셨습니다! 게임 종료"는 다음 단계에서 출력되도록 조정하였다.


- 기능 설명
    1. `resultString`을 `""`으로 초기화한다.
    2. `Ball`이 `0`이 아닌 경우 `resultString`에 `{$Ball}볼 `을 추가한다.
    3. `Strike`가 `0`이 아닌 경우 `resultString`에 `{$Strike}스트라이크`를 추가한다.
    4. `resultString`이 `""`인 경우 `"낫싱"`으로 변경한다.
    5. `String`의 `trim()` 메소드를 활용하여 tailing whitespace를 제거한다.
    6. `resultString`을 출력한다.

<br> 

### 4 . 게임을 다시 진행할지 입력받는 함수 `inputKeepPlaying()`

- 요구사항
    - `"게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."`을 출력한다.
    - 사용자가 `1`을 입력할 경우 새로운 게임을 시작하고, `2`를 입력할 경우 완전히 종료한다..
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.


- 기능 설명
    1. `Console.readLine()`을 활용하여 사용자의 입력을 `userInput`에 받는다.
    2. `userInput`이 `"1"`인 경우 `continue`, `"2"`인 경우 `keepPlaying`을 `false`로 변경한다.
    3. `userInput`이 `"1"`, `"2"` 모두 아닌 경우 `IllegalArgumentException`을 일으킨다.