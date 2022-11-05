## 기능 구현 목록

### class Numbers

- 숫자야구의 답 또는 추측하는 숫자 3자리를 담고 있는 불변 클래스
- List<Integer> numbers : 숫자 3자리에 해당됨
- boolean validation() : 올바른 입력인지 체크하는 함수
  - 길이가 3인지 체크
  - 각 자릿수가 1에서 9 사이인지 체크
  - 각 자릿수가 모두 다른지 체크
- int get(int i) : 리스트 numbers 의 i번째 원소를 반환하는 함수
- int indexOf(int i) : 리스트 numbers 에서 i의 위치를 반환하는 함수
  - i가 리스트에 없다면 -1 반환 

### class Computer

- 숫자야구의 컴퓨터 역할
- Numbers answer : 답 3자리에 해당됨, 변경할 수 없는 상수
- Computer generateAnswer() : 숫자 야구의 올바른 답을 생성하는 함수
  - 숫자를 중복해서 뽑지 않도록 구현한다
- int strike(Numbers guess) : 스트라이크 개수를 계산하는 함수
- int ball(Numbers guess) : 볼 개수를 계산하는 함수

### class User

- 숫자야구에서 정답을 맞추는 사람 역할
- Numbers guess : 추측한 답 3자리에 해당됨, 변경 가능함
- void guess() : 추측한 답을 입력받는 함수
  - 입력된 문자열이 숫자가 아니라면 IllegalArgumentException 던져야 함
  - validation 통과하지 못하면 IllegalArgumentException 던져야 함

### class View

- 숫자야구 진행 상황을 띄우는 역할
- Computer computer : 게임에 참가한 컴퓨터
- User user : 게임에 참가한 유저
- void start() : 게임을 시작하는 함수
- String hint(int strike, int ball) : 힌트를 제공하는 함수
- boolean restart() : 게임을 새로 시작하는 함수
  - 입력된 문자열이 한자리 숫자가 아니라면 IllegalArgumentException 던져야 함
  - 입력된 숫자가 1, 2가 아니라면 IllegalArgumentException 던져야 함
