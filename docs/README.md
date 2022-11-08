# 기능 정리
## baseBallGame
게임 전체를 관리하는 메소드

### 동작
1. 1을 입력받으면 게임을 새로 시작
   1. 난수를 생성하고 startGame 시작
2. 2를 입력 받으면 종료
---

## startGame
자릿수 마다 체크하는 메소드

1. 100의 자리
   1. CountStrike 호출
   2. CountBall 호출
2. 10의 자리
   1. CountStrike 호출
   2. CountBall 호출
3. 1의 자리
   1. CountStrike 호출
   2. CountBall 호출

### 동작
1. 각 자리마다 checkStrike, checkBall 메소드 호출
2. strike, ball 횟수 카운트
3. strike가 3이면 종료
4. 아니라면 "%d볼 %d스트라이크" 출력
5. 1 동작 실행

---
## generateNumber
난수를 생성하는 메소드
camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 List<Integer>에 난수 삽입

### Return
- List<Integer>
  - 3자리 서로 다른 한자리 자연수가 들어있는 배열이다.
---
## checkStrike 
스트라이크 체크하는 메소드

### Param 
- int number
  - 각 자릿수의 한 자리 숫자
- int digit
  - 현재 자릿수 [1|10|100]

### 동작
1. digit 자리의 생성된 숫자와 number와 일치하는지 확인  
2. 일치하면 isStrike = true;

### Return
  - boolean isStrike
    - 현재 자리의 수가 스트라이크이다.
---

## checkBall
볼 체크하는 메소드

### Param
- int number
    - 각 자릿수의 한 자리 숫자
- int digit
    - 현재 자릿수 [1|10|100]

### 동작
1. digit이 아닌 자리의 생성된 숫자와 number가 일치하는지 확인  
2. 일치하면 isBall = true;

### Return
- boolean isBall
    - 현재 자리의 수가 볼이다.
---

