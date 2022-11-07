## java-baseball 구현할 기능 목록
### 1. 랜덤한 세자리 수 생성 함수(create computer random number)
    - 서로 다른 3자리 자연수
    - 1부터 9까지의 숫자로 구성

### 2. 사용자로부터 숫자 입력받는 함수(get user's input number)
    - 스트라이크 : 동일한 위치, 동일한 숫자인 경우 +1
    - 볼 : 다른 위치, 동일한 숫자인 경우 +1
    - 낫싱 : 같은 숫자가 0개인 경우

### 3. 사용자가 잘못된 값을 입력할 경우 예외처리(e)(check whether user number is valid)

### 3. 사용자가 입력한 숫자의 정답 검사(calculate score)
    - 볼과 스트라이크 모두 존재하는 경우: 볼 -> 스트라이크 순으로 추력
    - 정답 시 종료 문구 출력
    - 오답 시 사용자로부터 재입력 반복

### 5. 게임 시작과 종료(check whether continuing baseball game)
    - '1' 입력 시 재시작
    - '2' 입력 시 종료

### 6. 게임 실행 검사

### 7. 테스트 실행(set up test)
