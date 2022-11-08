## 기능 구현 목록

### class Numbers

- 숫자야구의 답 또는 추측하는 숫자 3자리를 담고 있는 불변 클래스
- List<Integer> numbers : 숫자 3자리에 해당됨
- static Numbers of(int... nums), static Numbers of(List<Integer> numbers) : 정적 팩토리 메서드
  - 주어진 입력에 해당하는 Numbers 객체를 만들어 줌
  - validation 을 통과하지 못하는 입력이라면 IllegalArgumentException 반환
- boolean validation() : 올바른 입력인지 체크하는 private 메서드
  - 길이가 3인지 체크
  - 각 자릿수가 1에서 9 사이인지 체크
  - 각 자릿수가 모두 다른지 체크
- int get(int i) : 리스트 numbers 의 i번째 원소를 반환하는 메서드
- int indexOf(int i) : 리스트 numbers 에서 i의 위치를 반환하는 메서드
  - i가 리스트에 없다면 -1 반환 

### class Computer

- 숫자야구의 컴퓨터 역할
- Numbers answer : 답 3자리에 해당됨, 변경할 수 없는 상수
- Computer of(int... nums) : 정적 팩토리 메서드
  - 주어진 입력을 답으로 가지는 Computer 객체를 만들어준다
- Computer create() : 정적 팩토리 메서드
  - 숫자 야구의 답을 랜덤하게 생성하고, 이를 답으로 가지는 Computer 객체를 만들어준다 
  - 숫자를 중복해서 뽑지 않도록 구현한다
- Status status(User user) : user 가 추측한 답과 비교한 현재 상태를 반환하는 메서드
  - int strike(User user) : 스트라이크 개수를 계산하는 private 메서드
  - int ball(User user) : 볼 개수를 계산하는 private 메서드

### class User

- 숫자야구에서 정답을 맞추는 사람 역할
- Numbers guess : 추측한 답 3자리에 해당됨, 변경 가능함
- void guess() : 추측한 답을 입력받는 메서드
  - 입력된 문자열이 숫자가 아니라면 IllegalArgumentException 던져야 함
  - validation 통과하지 못하면 IllegalArgumentException 던져야 함
- int get(int i) : guess 의 i번째 원소를 반환하는 메서드

### class Game

- 숫자야구 게임 클래스
- Computer computer : 게임에 참가한 컴퓨터
- User user : 게임에 참가한 유저
- Game start(User user) : 게임을 시작하는 메서드
  - computer 는 게임을 시작할 때 자동으로 생성됨
- void run() : 게임을 진행하는 메서드
  - 전부 맞춰서 게임이 종료되면 중단하고 리턴
- boolean restart() : 게임을 새로 시작하는 메서드
  - 입력된 문자열이 숫자가 아니라면 IllegalArgumentException 던져야 함
  - 입력된 숫자가 1, 2가 아니라면 IllegalArgumentException 던져야 함

### class Status

- 숫자야구 게임의 현 상태에 해당하는 클래스
- int strike : 스트라이크 개수
- int ball : 볼 개수
- String toString() : 힌트를 문자열로 반환
  - strike == 0 && ball == 0 : 낫싱
  - string > 0 || ball > 0 : 볼, 스트라이크 개수를 표시
    - ex) 1볼 1스트라이크, 2볼, 3스트라이크 등
- boolean correct() : 정답을 맞춘 상태인지 여부를 반환
  - strike == 3이면 true, 아니면 false

### class Application

- 숫자야구 게임을 실행하는 main 메서드가 있는 클래스
- 게임에 참여할 유저 객체 User user 를 만듦
- 종료할 때까지 다음을 무한 반복
  - 새 게임 생성 : Game.start(user)
  - 게임 진행 : game.run()
  - 게임 재시작 : game.restart()
    - 재시작을 그만둔다는 입력이 들어오면 반복문 종료
