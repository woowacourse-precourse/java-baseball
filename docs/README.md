# 미션 - 숫자 야구

## 기능 목록

### 1. initializeGame
    * 숫자 야구 게임을 시작하는 함수

### 2. finishOrRestart
    * match가 true가 된 후, 게임을 재시작 할 것인지 끝낼 것인지 user의 입력값을 통해 판별한다.
    * 1을 입력하면 true를 반환하여 재시작하고, 2를 입력하면 false를 반환하여 게임을 끝낸다.

### 3. computerRandomNumber
    * List에 random number을 넣어주어 맞춰야할 컴퓨터 숫자를 반환한다.

### 4. getUserNumber
    * match가 true가 될 때까지 반복한다
    * user에게 숫자를 입력받는다

### 5. isValidUserNumber
    * user가 입력한 숫자가 올바른지 확인한다.
    * isAllNumber와 isDuplicate함수를 호출한다.
    * if문에 걸릴시 exception error로 처리한다.

### 6. isAllNumber
    * 입력된 값이 모두 숫자(1~9)인지 확인한다.

### 7. isDuplicate
    * 입력된 값 중에 중복된 숫자가 있는지 확인한다.

### 8. isContainZero
    * 입력된 값 중에 0이 있는지 확인한다.

### 9. compareComputerAndUserNumber
    * match가 true가 될 때까지 반복한다.
    * computer의 random number와 user가 입력한 number을 비교한다.
    * existStrike와 existBall을 호출하여 strike와 ball의 개수를 센다.
    * checkResult를 통해 결과를 화면에 보여준다.

### 10. existStrike
    * strike가 있으면 true를 반환한다.

### 11. existBall
    * ball이 있으면 true를 반환한다.

### 12. checkResult
    * strike, ball, 낫싱 중 무엇인지 판별하고, 3strike일 경우에는 match를 true로 해준다.
    * StringBuilder에 문자를 담아 함수 값을 반환한다.
