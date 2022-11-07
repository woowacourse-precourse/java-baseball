# 우아한 테크코스
## 프리코스
### java-baseball
#### 전홍석

---
### 기능 구현
* 상대방(컴퓨터)이 서로 다른 숫자 3개를 생성한다.
  1. computerRandomNo() 작성
* 플레이어에게 숫자 3개를 입력 받는다.
  1. playerGetNo() 작성
  2. 길이가 3이 되지 않을 경우 IllegalArgumentException 발생
* 플레이어에게 받은 숫자가 유효한지 검증한다.
  1. isDuplication() 중복이 있는지 확인하는 메서드
  2. isnumbers() 입력한 글자가 숫자인지 확인하는 메서드
  3. 위에 두 조건을 만족하지 못할경우 IllegalArgumentException 발생
* 플에이어의 숫자와 상대방의 숫자를 확인하는 메서드를 작성한다.
  1. countCheck() 메서드로 카운트를 확인하는 메서드
* baseball 게임을 작성한다.
  1. main에 작성
  2. playerPickNo() 플에이어가 새로운 게임을 시작하고 싶어하면
  새로운 숫자를 생성하는 메서드
