# 기능 구현 설명

기능 구현을 크게 `model`, `process`, `utils` 세 패키지로 나눴다.

- `model` 패키지는 매 판마다의 게임이나 결과 메시지같은 전달 객체용 클래스를 가지고 있다.
- `process` 패키지는 두 수를 비교하는 메서드를 가진 클래스나 게임의 큰 흐름같은 핵심 로직이 있다.
- `utils` 패키지는 난수 생성이나 사용자 입력값에 대한 기능이 있다.

<br>

### 게임 진행 흐름

1. 게임을 시작하면 새로운 난수가 생성되어 새로운 게임 객체에 세팅된다. 
2. 그 후 사용자가 입력하면 입력값에 대한 유효성검사를 거쳐 게임 객체에 세팅된 후 비교 과정에 들어간다.
3. 비교가 완료된 후 생성되는 결과를 출력한다.
4. 2~3 과정을 반복하고, 만약 3스트라이크로 게임이 끝났을 시 재시작 여부를 물어본다.
5. 재시작 여부 입력값에 대한 유효성검사를 거쳐 재시작이라고 판단되면 새 게임 객체와 난수를 생성한다, (1 과정으로 돌아간다.)

<br>

# 기능 구현 목록

## Model

### Game 

- `userInputNumber`과 `radnomNumber`를 필드로 가지고 있는 객체

### Result

- `getResultMsg()`: `strikeCount`와 `ballCount`에 따라 결과 메시지를 생성하여 반환.
- `is3Strike()`: `strikeCount`에 따라 3스트라이크 여부 판단.

<br>

## Process

### Comparison

- `numberToList()`: 3자리 숫자를 `size`가 3인 리스트로 변환해 반환.
- `getStrikeCount()`: 스트라이크 개수 반환.
- `getBallCount()`: 볼 개수 반환.
- `compareDigit()`: 숫자리 리스트 두개를 비교해 자리수는 다르지만 같은 숫자가 있는지 판별. (볼 개수 카운트에 사용)

### Process

- `initialize()`: 새 게임 시작. 새 `Game` 객체와 난수 생성.
- `getUserInput()`: `UserInput`에서 유효성검사를 마친 사용자 입력값을 가지고 `getResult()` 호출.
- `getResult()`: 입력받을 때 마다 `Result`에서 생성한 결과 메시지를 출력하고, 3스트라이크인 경우 게임 종료.
- `checkRestart()`: 게임 재시작 여부를 묻고, `UserInput`에서 유효성 검사를 마친 사용자 입력값을 가지고, 재시작시 `initailize()` 호출.

<br>

## Utils

### RandomNumber

- `createRandomNum()`: `camp.nextstep.edu.missionutils.Randoms` 클래스의 `pickNumberInRange()` 메서드를 이용해 `size()`가 3인 중복없는 숫자 리스트 생성.  `isValidateDigitNum()`을 이용해 앞자리가 0인지 여부를 판단하고 0이 아니라면 `numListToIntValue()`를 이용해 세자리의 숫자로 만든 후 받아온 `Game` 객체에 세팅.
- `isValidateDigitNum()`: 숫자 리스트를 받아와 제일 앞자리의 수가 0인지 판단.
- `numListToIntValue()`: 숫자 리스트를 받아와 세자리 숫자로 변환해 반환.

### UserInput

- `setUserInput()`: `camp.nextstep.edu.missionutils.Console` 클래스를 이용해 입력값을 받아 `validateNumber()`, `validateNumberOfDigit()`, `validateDuplicateNumber()`를 이용해 유효성 검사를 한 후 통과시 입력값을 숫자로 변환해 받아온 `Game` 객체에 세팅.

- `getNewGameStatusInput()`: `camp.nextstep.edu.missionutils.Console` 클래스를 이용해 입력값을 받아 `validateNumber()`, `validateNewGameNumber()`를 이용해 유효성 검사를 한 후 통과시 입력값을 숫자로 변환해 반환.

- `validateNumber()`: 입력값이 숫자인지 아닌지 유효성 검사

- `validateNumberOfDigit()`: 입력값이 3자리인지 아닌지 유효성 검사

- `validateDuplicateNumber()`: 입력값에 중복된 숫자가 있는지 유효성 검사

- `validateNewGameNumber()`: 새게임 시작 여부 입력값이 1또는 2인지 유효성 검사

  

