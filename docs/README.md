# Pre-Course 2주차 기능 목록

## 1. 공통 제한 사항

---

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현
    - 2까지만 허용
- `3항 연산자` 사용 금지
- 함수(또는 메서드)가 한 가지 일만 하도록 설계
- 기능 목록이 정상 동작하는지 테스트 코드로 확인
    - `JUnit 5 & AssertJ` 사용

## 2. 기능 목록

### 2.1 Random Number 생성

---
> **기능**
> - 각 자리수가 서로 다른 3자리 수 생성


> **구현 로직**
> - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 사용
> - 1~9 사이의 랜덤 값 생성
> - 해당 값이 문자열에 존재하지 않는다면, 문자열에 추가
> - 문자열의 길이가 3이 되면 반환

> **Related methods**
>  - `generateRandomNumber()`
>  - `main(String[] args)`

<br></br>
### 2.2 사용자 입력값 검증

---
> **기능**
> - 입력값이 3자리 수 인지 검증
> - 입력값의 각 자리수가 1~9 사이의 수인지 검증
> - 입력값의 각 자리수가 서로 다른지 검증
> - 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생

> **구현 로직**
> - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용해 입력받음
> - 입력된 문자열의 길이가 3인지 확인
> - 문자열의 각 문자가 1~9 사이인지 for문을 사용해 확인
> - `HashSet`을 사용해 입력값의 각 자리수가 서로 다른지 확인
> - 위 조건 중 하나라도 만족하지 못하면 `IllegalArgumentException` 발생


> **Related methods**
>  - `isAllUnique(String number)`
>  - `isAllInRange(String number)`
>  - `validateInputNumber(String inputNumber)`
>  - `playGame(String randomNumber)`

<br></br>
### 2.3 입력값과 랜덤값 비교

---

> **기능**
> - Random Number와 입력값을 비교
    >   - 특정 수가 같은 자리에 있으면 Strike Count 증가
>   - 특정 값이 다른 자리에 있으면 Ball Count 증가

> **구현 로직**
> - Random Number와 입력값을 for문을 사용해 같은 수가 같은 자리에 있는지 계산
> - Random Number와 입력값을 for문을 사용해 같은 수가 다른 자리에 있는지 계산

> **Related methods**
>  - `checkStrike(String randomNumber, String inputNumber)`
>  - `checkBall(String randomNumber, String inputNumber)`


<br></br>
### 2.4 결과 출력

---
> **기능**
> - 비교 결과를 "~볼 ~스트라이크"의 형식으로 출력
> - 볼 또는 스트라이크 값이 0이면 출력하지 않는다.
    >   - ex) "~스트라이크", "~볼"
> - Random Number와 입력값을 비교해 같은 수가 없으면 "낫싱" 출력

> **구현 로직**
> - 위 `2.3 입력값과 랜덤값 비교` 의 결과값을 바탕으로 출력
> - 볼과 스트라이크 모두 0이면 "낫싱" 출력


> **Related methods**
>  - `printResult(int ballCount, int strikeCount)`

<br></br>
### 2.5 Game Play

---
> **기능**
> - random Number를 인자로 받아 게임 시작
> - Strike 수가 3이면 종료 메시지 출력 후 게임 종료

> **구현 로직**
> - `2.2 사용자 입력값 검증`, `2.3 입력값과 랜덤값 비교` , `2.4 결과 출력` 기능을 모두 사용
> - 3스트라이크일 때, 종료 메시지 출력 후 게임 종료


> **Related methods**
>  - `playGame(String randomNumber)`
>  - `validateInputNumber(inputNumber)`
>  - `checkBall(randomNumber, inputNumber)`
>  - `checkStrike(randomNumber, inputNumber)`
>  - `printResult(ballCount, strikeCount)`
>  - `main(String[] args)`

<br></br>
### 2.6 재시작/종료 여부 확인

---
> **기능**
> - 게임 종료 시 값을 입력 받아 입력값에 따라 재시작 또는 애플리케이션 종료

> **구현 로직**
> - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용해 추가 진행 여부를 입력 받음
    >   - 입력 값이 "1" 이면 재시작
>   - 입력 값이 "2" 이면 애플리케이션 종료
>   - 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생

> **Related methods**
>  - `main(String[] args)`

