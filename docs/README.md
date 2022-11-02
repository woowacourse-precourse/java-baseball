# 2주차 미션 숫자 야구


## 기능 구현 목록
1. 컴퓨터 세자리 수 삽입
```
1~9 사이의 숫자
서로 다른 3개의 숫자
랜덤 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
```

2. 사용자 숫자 입력
```
사용자 입력 값은 camp.nextstep.edu.missionutils.Console의 readLine() 활용

예외처리) 
         1. 세자리가 아닌 경우
         2. 숫자가 아닌 문자가 입력됐을경우
         3. 같은 숫자가 있을 경우
```

3. 게임 실행
```
strike 숫자 체크
ball 숫자 체크
```

4. 게임 결과
```
세자리 숫자가 모두 같은 경우 - 게임 새로 시작 1, 종료 2
세자리 숫자가 모두 같지 않은 경우 - 사용자 숫자 재 입력
```