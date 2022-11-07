# 미션 - 숫자 야구 기능 목록

---

### 1. 게임을 시작을 셋팅하는 클래스/메서드
- **BaseballGameStater.java**
  - **operate()** : 유저 입력값을 받는 메서드를 호출하고, 컴퓨터의 랜덤값을 생성하는 메서드를 호출한다.
  - **operateReferee()** : 심판 객체 생성 후 심판의 판정 시작

### 2. 컴퓨터의 숫자를 발급하는 클래스/메서드 (camp.nextstep.edu.missionutils.Randoms 활용)
- **Computer.java**
  - **generateNumber()** : 컴퓨터의 랜덤 숫자를 발급한다.
    - 반환 형태는 List<String> 형 이다.

### 3. 사용자의 입력값을 검증하고 List로 변환하는 메서드
- **User.java**
  - **stringConvertToStringList()** : Console.readline() 메서드를 활용하여 사용자에게 값을 입력받고 리스트로 변환한다. 이 과정에서 입력값 검증을 수행한다.

### 4. 스트라이크를 카운트하는 메서드
- **Referee.java**
  - **checkStrikeCondition()** : 현재 순회중인 유저 입력값의 인덱스, 컴퓨터 값의 인덱스, 유저 입력값, 컴퓨터 값을 매개변수로 하여 스트라이크 조건에 부합하는지 검증한다.  
    - 반환 형태는 boolean 이다.
  - **countStrike()** : checkStrikeCondition() 메서드를 호출하여 획득한 boolean 값을 토대로 strikeCount를 조정한다. 
    - 반환 형태는 int 이다.

### 5. 볼을 카운트하는 메서드
- **Referee.java**
  - **checkBallCondition()** : 현재 순회중인 유저 입력값의 인덱스, 컴퓨터 값의 인덱스, 유저 입력값, 컴퓨터 값을 매개변수로 하여 볼 조건에 부합하는지 검증한다.
    - 반환 형태는 boolean 이다.
  - **countBall()** : checkBallCondition() 메서드를 호출하여 획득한 boolean 값을 토대로 ballCount를 조정한다.
    - 반환값은 int 형이다.

### 6. 스트라이크/볼 카운트를 토대로 어떤 문구를 출력할지 결정하는 메서드
- **Referee.java**
  - **judgement()** : countStrike(), countBall() 를 호출하여, 최종 스트라이크/볼 카운트를 Map 으로 반환한다.
  - **sayJudgement()** : judgement()에서 획득한 반환값을 토대로 {스트라이크/볼/낫싱} 문구를 출력한다.

### 7. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키는 예외처리 역할 등 입력 값 검증을 수행하는 메서드
- **UserInputValidator.java**
  - **validate()** : 입력값이 1 ~ 9 사이의 숫자가 아니거나, 중복된 숫자를 입력할 시 IllegalArgumentException을 발생시킨다.