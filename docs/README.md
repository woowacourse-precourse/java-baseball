# 🚀 숫자 야구 게임 구현에 필요한 기능의 목록

## 🎯 중점을 둔 점
2주 차 미션 메일에서 언급한 내용을 바탕으로 기능을 구현하기 위해 노력했습니다.

### 🔍 함수(또는 메서드) 분리
  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들었습니다. 구현한 메서드의 기능은 아래와 같습니다.

#### `initializeGame()`
- 게임을 시작하기 위한 메소드. `ball`과 `strike`의 값을 0으로 초기화
- 이후 `RandomNumber()`와 `GameProcess()`를 호출함으로써 게임이 진행

#### `GameProcess()`
- 게임을 진행하기 위한 메소드. 반복문을 통해 `UserInput()` 또는 `displayResult()`를 호출하여 게임을 진행

#### `displayResult()`
- 결과를 출력하기 위한 메소드. 호출된 시점의 전역변수인 `strike`와 `ball`의 갱신된 값을 바탕으로 조건문 따른 메세지를 출력 
- 3개의 숫자를 모두 맞힐 경우 `restartGame()`을 호출

#### `restartGame()`
- displayResult() 내에서 호출이 된 경우, 사용자로부터 2를 입력받아 게임을 종료하거나 `initializeGame()`을 호출하여 재시작

#### `RandomNumber()`
- 컴퓨터가 게임을 위한 난수를 생성하여 `List<Integer>`로 반환하는 함수
- 자릿수를 의미하는 `COUNT`만큼 반복하여 범위 내의 값을 선택해 `output`에 `add`

#### `isRedundant()`
- 후술할 `UserInput()`에서 사용자가 입력한 값의 중복을 검사하는 메소드
- 중복이 존재하는 경우 `true`, 그렇지 않은 경우 `false`를 출력

#### `isValid()`
- 후술할 `UserInput()`에서 사용자가 입력한 값의 유효성을 검증하는 메소드
- 예외가 발생한 경우 `IllegalArgumentException`을 `throw`

#### `UserInput()`
- 사용자로부터 `String`의 형태로 입력을 받아 후술할 `splitDigits()`를 호출
- 이후 반환값을 `isValid()`의 인자로 전달하여 유효성을 검증

#### `splitDigits()`
- 인자로 전달받은 `String`을 자릿수 별로 분리하여 `List<Integer>`로 반환하는 메소드
- 전달받은 `String`을 `character`형 배열로 변환한 길이만큼 반복하여 분리한 자릿수를 `output`에 `add`

#### `addStrikeCount()`
- strike 시 전역변수 `strike`의 값을 1 증가

#### `addBallCount()`
- ball 시 전역변수 `ball`의 값을 1 증가

#### `compareDigits()`
- 사용자와 컴퓨터가 선택한 숫자를 인자로 전달받아 비교를 진행하기 위한 메소드
- strike, 즉 같은 수가 같은 자리에 있는 경우 `addStrikeCount()`를 호출
- ball, 즉 같은 수가 다른 자리에 있는 경우 `addBallCount()`를 호출

#### `validateNewGameInput()`
- 재시작 시 사용자의 입력값의 유효성 검증
- 1 또는 2가 아닌 경우 `IllegalArgumentException`을 `throw`

### 🔍 각 함수별로 테스트를 작성
