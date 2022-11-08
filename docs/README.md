# 메서드 역할

---

### 입력 및 초기화

- main : 전체 반복문을 통해서 게임 진행, 종료를 관리한다.

```
while( ) {

}
```

- `makeRandomInteger()` : 컴퓨터의 랜덤 숫자 생성 메서드
- `inputNumber()` : 사용자 입력 메서드
- `inputExeption()` : 입력했을 때, 예외처리해주는 메서드
    - 숫자가 3개가 아닐 때
    - 숫자가 아닐 때
    - 서로 다른 숫자가 아닐 때
    - `throw new IllegalArgumentException()`

### 여기까지 입력

---

### 게임 시작

- `gaming()` : 게임 시작 메서드 boolean 반환해서 게임 끝났을 때 메서드도 종료
- `compareNum()` :  컴퓨터 난수와 사용자 입력한 수를 비교해주는 메서드
- `countBall()` : 볼 개수를 계산
- `countStrike()` : 스트라이크 개수를 계산
- `isGameOverPrint()` : 스트라이크, 볼, 게임종료를 판단해주는 메서드 (print문 출력)

### 여기까지 게임

---

### 종료

- `wantReGame()` : 새로 시작 or 종료 판단해서 boolean을 반환

### 다시 맨위로 반복 or 종료

---