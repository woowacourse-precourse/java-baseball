## ✏️ 구현할 기능 목록
 ### 1. playGame
- 게임 실행
   1. 게임 시작 문구 출력
   2. 사용자 숫자 입력 문구 출력
   3. 입력값 예외 처리
      1. 사용자가 잘못된 값을 입력하는 경우 IllegalArgumentException 발생시킴
   4. 볼, 스트라이크 확인
   5. 3 스트라이크가 되면 게임 종료 및 게임 종료 문구 출력<br></br>

### 2. makeRandom
- computer 임의의 수 선택
   1. 1~9의 숫자 중 3개 임의로 선택해 list에 추가 <br></br>

### 3. splitNumber
- 입력된 3자리 숫자를 쪼개서 list에 추가 <br></br>

### 4. checkException
- user의 입력값에 대한 예외 확인
   1. 입력 가능한 값
      1. 3자리 수
      2. 1 ~ 9 (0 안됨)
      3. 서로 다른 수로 이루어져야 함 - containSameNumber 사용해 검사 <br></br>

### 5. containSameNumber
- 입력값에 같은 수가 중복되어 포함되는지 검사
   1. Hashmap 생성
   2. 입력한 숫자의 각 자릿수에 해당되는 숫자를 key로, index를 value로 Hashmap에 추가
   3. 이미 해당 key가 존재하면 중복되는 것이므로 false return
   4. 중복 없는 경우는 true return <br></br>

### 6. countBallAndStrike
- 스트라이크 (같은 수가 같은 자리에 있는 경우), 볼 (같은 수가 다른 자리에 있는 경우) 확인 및 개수 계산
   1. strike, ball을 key로, strike 개수, ball 개수를 value로 갖는 Hashmap 생성
   2. 같은 수, 다른 자리인 경우 ball에 개수 추가
      1. 자리와 관계 없이 해당 숫자가 computerNumber에 있는 경우 ball에 개수 추가
      2. 해당 숫자가 computerNumber에 있는 숫자와 자리도 같은 경우 strike에 해당되므로 ball에서 개수 차감
   3. 같은 수, 같은 자리인 경우 strike에 개수 추가 <br></br>

### 7. printResult
- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 출력
   1. 하나도 없는 경우 : "낫싱" 출력 <br></br>

### 8. playGameAgain
- 게임이 끝난 경우에 대한 처리
   1. 게임 다시 시작할지 종료할지에 대한 문구 출력
   2. 입력 가능한 값
      1. 1 : 재시작
      2. 2 : 종료