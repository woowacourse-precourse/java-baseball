# JAVA-BASEBALL

## 기능목록

### 1. generateNumber();

* 상대방(computer)의 3자리 숫자 생성하기  
[x] 3자리 숫자  
[x] 1 ~ 9 숫자만 (0 제외)  
[x] 각 자리의 수가 중복되지 않게 하기  

### 2. inputNumberOfUser();   
* 유저(사람)의 입력값(input) 3자리 생성하기   
[x] 문자열 입력값 받기   
[x] 세자리 정수인지 확인하기   
[x] 중복값 없는 3자리 넘버인지 확인하기   
[x] 넘버 중 0 들어있는지 확인하기   
[x] 조건에 맞지 않을 경우 `IllegalArgumentException` 발생   

### 3. countStrikes();   
* 스트라이크 갯수 세기   
[x] 게임 중 발생하는 strike 개수 세서 정수로 리턴   

### 4. countBalls();   
* 볼 갯수 세기   
[x] 게임 중 발생하는 ball 갯수 세서 정수로 리턴   

### 5. gameReferee();  
* 조건에 맞게 String 리턴 해주기   
[x] 볼, 스트라이크가 발생할 경우(0 이상일 경우) 카운트 후 리턴
[x] 볼, 스트라이크가 없을 경우(0일 경우) '낫씽' 리턴   
[x] 스트라이크 3개가 나올 경우 정답 및 게임종료 스트링 리턴   

### 6. gameProcess();   
* 5.gameReferee()의 정답 조건이 맞을때 까지 게임 진행   
[x] gameReferee()의 리턴 출력해주기   

### 7. selectReplay();   
* 조건에 맞게 게임 재진행 여부 확인하기   
[x] '2'를 input할 경우 게임 종료   
[x] '1'를 input할 경우 게임 재시작   
[x] 그 외의 입력값일 경우 `IllegalArgumentException` 발생   

### 8. main   
* 6.gameProcess(); => selectReplay() 순으로 실행   
[x] 게임 종료가 잘 되는가   
[x] 게임 종료 후 게임 재시작이 잘 되는가   
[x] 3차 이상의 게임 재시작도 잘 되는가

--------

### fix 4. countBalls(); => countRawBalls();
* 매직 넘버 사용으로 추후 유지 보수 확장이 어려워질 것으로 예상되어 collect.frequency로 중복값 개수 찾는 방법으로 변경   

### fix 5. gameReferee();
* 4번 변경점으로 로직이 gameReferee 메소드에서 countRawballs()에서 리턴 받은 값에 countStrike();를 빼서 ball 개수를 카운트함

