# 숫자야구 - 기능 구현 목록

- [ ] 입력과 출력을 처리해주는 UI로직을 처리하는 클래스 추가
  - [x] 입력을 처리하는 inputView 클래스
    - [x] 야구 숫자를 입력받는 메소드
    - [x] 게임 재시작 여부를 입력
      - [x] 1과 2를 제외한 값이 입력되었을 때 IllegalArgumentException 발생
  - [ ] 출력을 처리하는 outputView 클래스
    - [x] 게임 시작 문구 출력
    - [ ] 게임의 결과(볼, 스트라이크, 낫싱)를 템플릿에 맞게 출력
    - [x] 3스트라이크 메세지 출력
    - [x] 게임 재시작 여부를 출력

- [ ] 숫자 야구게임에서 사용될 수를 저장하는 BaseballNumber 클래스(일급 컬렉션)
  - [x] 멤버변수로 List<Integer> numbers 멤버변수
  - [ ] 사용자의 입력에 맞는 BaseballNumber 생성하는 생성자
  - [ ] 사용자의 입력(문자열)을 멤버변수로 변환해주는 메소드
    - [ ] 문자열을 IntegerList로 변환하는 메소드
  - [ ] BaseballNumber의 유효성을 체크해주는 validate 메소드들
    - [ ] 입력된 값이 수가 아닐 때
    - [ ] 입력된 수가 세 자리의 수가 아닐 때
    - [ ] 입력된 수의 자릿수 중에서 중복이 있을 때
    - [ ] 입력된 수의 자릿수의 범위가 1~9가 아닐 때

- [ ] BaseballNumber를 멤버변수로 가지는 User abstract class
  - [ ] 맞춰야 될 BaseballNumber를 저장하는 Computer class
    - [ ] 멤버변수로 BaseballNumber를 가짐
    - [ ] 조건에 맞는 랜덤한 BaseballNumber를 생성하는 메소드
  - [ ] 사용자의 입력을 BaseballNumber로 저장할 Player class
    - [ ] 멤버변수로 BaseballNumber를 가짐
    - [ ] 사용자에 입력에 맞는 BaseballNumber를 생성하는 메소드

- [ ] BaseballNumber 끼리의 결과를 계산해줄 BaseballGameCalculator 클래스
  - [ ] 게임의 결과(볼, 스트라이크, 낫싱)를 반환하는 로직

- [ ] 전체적인 게임의 흐름을 조정할 Controller 클래스
  - [ ] 게임을 초기화하고 진행하는 메소드
  - [ ] 게임의 흐름을 제어하는 메소드


---


# 고민해야 할 점
1. Computer 클래스와 Player 클래스의 부모클래스인 User 클래스가 꼭 필요할까?
   - 필요한 이유
     - 
   - 필요하지 않은 이유
     - 
2. 사용자의 입력에 대한 BaseballNumber의 유효성 검증을 어디서 해야 할까?
   - Player 클래스에서 해야 한다.
     - 유효성에서 벗어나는 경우가 사용자의 입력일 때 밖에 없다.
   - BaseballNumber 클래스에서 해야 한다.
     - 개념적으로 보면 BaseballNumber자체의 값에 대한 유효성이니 BaseballNunber 클래스에서 해야한다.
3. 