# 미션 - 숫자 야구 기능 목록

---

### 1. 게임을 시작을 셋팅하는 클래스/메서드
- **BaseballGameStater.java**
  - operate() : 유저 입력 값 셋팅/검증 및 컴퓨터 랜덤 입력값 셋팅
  - operateReferee() : 심판 객체 생성 후 심판의 판정 시작

### 2. 컴퓨터의 숫자를 발급하는 클래스/메서드 (camp.nextstep.edu.missionutils.Randoms 활용)
- **Computer.java**
  - generateNumber() : 컴퓨터의 랜덤 숫자를 발급한다.

### 3. 사용자의 입력값을 검증하고 List로 변환하는 메서드
- **User.java**
  - stringConvertToStringList() : 사용자의 입력값을 리스트로 변환한다. 이 과정에서 입력값 검증을 수행한다.

### 4. 스트라이크를 카운트하는 메서드
- **Referee.java**
  - countStrike() : 현재 순회중인 컴퓨터 랜덤 숫자의 인덱스, 컴퓨터의 랜덤 숫자, 유저 입력값을 매개변수로 하여 스트라이크 판정을 수행한다.
  - 반환값은 int 형이다.

### 5. 볼을 카운트하는 메서드
- **Referee.java**
    - ballStrike() : 현재 순회중인 컴퓨터 랜덤 숫자의 인덱스, 컴퓨터의 랜덤 숫자, 유저 입력값을 매개변수로 하여 볼 판정을 수행한다.
    - 반환값은 int 형이다.


### 6. 스트라이크/볼 카운트를 토대로 어떤 문구를 출력할지 결정하는 메서드
- **Referee.java**
  - judgement() : 스트라이크/볼 카운트를 수행하는 메서드를 호출하여, 최종 스트라이크/볼 카운트를 Map<> 으로 반환한다.
  - sayJudgement() : 카운트된 스트라이크/볼 Map을 토대로 문구를 출력한다.

### 7. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키는 예외처리 역할 등 입력 값 검증을 수행하는 메서드
- **UserInputValidator.java**
  - validate() : 입력값이 1 ~ 9 사이의 숫자가 아니거나, 중복된 숫자를 입력할 시 IllegalArgumentException을 발생시킨다.