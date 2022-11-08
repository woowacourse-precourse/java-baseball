# 구현할 기능 목록

### 1. 애플리케이션에서 게임을 실행

```
1~9 사이의 서로 다른 3개의 숫자를 
camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 랜덤 값을 생성
```

### 2. 게이머가 추측한 숫자를 입력
```
게이머가 camp.nextstep.edu.missionutils.Console의 readLine()를 활용하여 
1~9 사이의 서로 다른 3개의 숫자를 입력

예외 사황) 1. 입력의 길이가 3이 아닌 경우
           2. 문자가 있을 경우
           3. 같은 숫자가 있을 경우
           4. 숫자 0이 있을 경우
           IllegalArgumentException을 발생시켜 애플리케이션을 종료시킨다.
```

### 3. 컴퓨터가 응답
```
게이머가 추측한 숫자를 토대로
스트라이크의 개수, 볼의 개수, 낫싱 여부를 제공
```

### 4. 게임 재시작 여부
```
게임 재시작에 관하여 숫자 입력
1을 입력 시 재시작
2를 입력 시 종료
예외사항) 입력 결과가 1이나 2가 아닌 경우 IllegalArgumentException을 발생시켜 애플리케이션을 종료시킨다.
```
