# 기능 구현

## 1. 게임 전체

### 1) 게임 진행

- 정답 이후 게임을 추가 진행할 것인지를 질문
  - 게임 시작 (1), 종료 (2)
- 예외 처리
  - 1이나 2가 아닌 입력이 들어오면 IllegalArgumentException

## 2. 인게임

### 1) 게임 진행

#### 정답인 경우 
- 문구를 출력하며 게임 종료

#### 오답인 경우
- 비교 및 판단에서 전달한 내용을 출력

### 2) BaseballNumber 클래스 생성
- 생성되는 난수나 유저의 입력이 사실상 동일한 자료형
- 기준이 되는 BaseballNumber 클래스 생성
- 싱글톤 구현을 하도록 처리
- getInstance, get method, update method 구현
- exception 함수 구현
  - 1 ~ 9 사이의 숫자인지
  - 중복되는 숫자는 없는지

### 3) 정답 생성

- BaseballNumber 클래스를 상속받는 AnswerNumber
- 싱글톤 구현
  - ⭐️ 멀티 쓰레드 환경은 고려하지 않는다 ⭐️
- 난수 생성
  - camp.nextstep.edu.missionutils 라이브러리 사용
- 예외처리
  - 1 ~ 9 사이의 정수인지 확인
  - 3개의 숫자 중 중복되는 숫자가 있는 지 확인

### 4) 유저 입력

- BaseballNumber 클래스를 상속받는 UserNumber
- 싱글톤 구현
  - ⭐️ 멀티 쓰레드 환경은 고려하지 않는다 ⭐️
- 입력 받기
  - camp.nextstep.edu.missionutils 라이브러리 사용
- 예외처리
  - 1 ~ 9 사이의 정수인지 확인
  - 3개의 숫자 중 중복되는 숫자가 있는 지 확인

### 5) 비교 및 판단

- Comparator class에서 strike, ball 상태 변수 관리
- 비교 method, get method

#### 스트라이크 판정
- 각 자리의 숫자 비교
#### 볼 판정
- 정답과 유저 입력에 중복은 없다고 가정
- (contains 갯수 - 스트라이크 판정 수) = ball 판정