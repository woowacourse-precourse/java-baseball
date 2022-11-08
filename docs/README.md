# ✅ 기능목록

<br/>

- [x] Application main method 구현
    - 구현한 BaseballGameController를 통하여 게임 시작

<br/>

### BaseballGameController
게임의 진행과 관련된 기능 구현

- [x] 게임 진행 method 구현
    - [x] player 3자리 수 입력받기
    - [x] 스트라이크/볼 수 결과 받아 출력하기
    - [x] 게임 진행 여부 입력받기



- Validation
    - [x] player의 3자리 수 입력 validation
        - 1~9 사이의 3개의 숫자인가
        - 각 자리수가 겹치지 않는가
        - Number Rule은 BaseballGameRule을 통하여 전달받을 수 있도록
    - [x] 게임 진행 여부 입력 validation
        - 1 또는 2 인가

<br/>

### BaseballGameRule
게임의 규칙과 관련되 기능 구현  
게임의 형식은 그대로 두고 규칙이 바뀐다면 본 클래스만 변경이 가능하도록



- [x] 판정 기준 컴퓨터 수 입력 - 입력형식 : `List<Integer>`
- [x] player의 입력값으로 판정 결과 리스트 반환 - 입력형식 : `List<Integer>`
    - [x] strike 판정
    - [x] ball 판정
- [x] 게임 승리 여부 확인

<br/>

### Score
야구게임 1턴의 점수 구현  

- [x] ball count와 strike count를 포함하여 생성
- [x] getter 구현
  - ball getter
  - strike getter
- [x] toString() 구현
  - 점수 표기 형식으로 출력할 수 있도록
  - ex) "낫싱" or "n볼 m스트라이크" 등 출력 요구사항 참고

<br/>

### GameUtil
게임의 진행, 규칙과 직접적 연관이 없는 기능 구현

- [x] 랜덤한 3자리 컴퓨터 수 생성 (refactor: BaseballGameController에서 이동)

<br/>

---
