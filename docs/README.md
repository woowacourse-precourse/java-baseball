## 😀 baseball 기능 구현 목록  
✔️숫자 생성 기능
* pickNumberInRange()를 활용한 서로 다른 3자리의 수를 생성하는 기능 구현

✔️현재 스코어 계산 기능
* Random으로 생성된 baseball 세자리 숫자와 사용자가 입력한 세자리 숫자를 비교하여 점수계산 기능 구현

✔️게임 사용자 입력 기능
* 사용자 야구번호 입력 기능 구현
* 게임 재시작 or 종료 입력 기능 구현

✔️게임 출력 문구 기능
* 야구 게임 시작 출력 기능 구현
* 현재 스코어 출력 문구 기능 구현
* 정답(3스트라이크)일 경우 축하 메시지 출력 후 게임 재시작, 종료 출력 문구 기능 구현

✔️사용자가 입력한 입력값 예외 사항 기능 구현 목록
* 사용자가 중복된 숫자 입력 시 예외사항 기능 구현
* 사용자가 숫자가 아닌 잘못된 값 입력에 대한 예외사항 기능 구현
* 사용자가 입력 가능한 숫자 범위를 초과하여 입력 시 예외사항 기능 구현
* 사용자가 세자리가 아닌 숫자를 입력햇을 예외사항 기능 구현

---
## Test 주요 내용   
* Baseball UI 출력 내용 작동 test
* 사용자 Console.readLine 입력시 정상 작동 test
* computerRandomNumber 생성 test -> 서로 다른 세자리인가?
* compuberRandomNumber 와 사용자 세자리 입력 비교 test -> ballCount, strikeCount 갯수 test
* 사용자 입력시 입력문자 valdate test -> ex) 중복, 숫자가 아닌 다른 입력값, 범위밖 입력값일 경우 IllegalArgumentException
