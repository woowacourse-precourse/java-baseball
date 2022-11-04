## 🙇 이번 미션에서 연습해야 할 사항들 (번호는 중요도가 아님)
1. TDD로 구현하기 -> 예외사항을 테스트코드로 작성해서 구조적인 코딩을 하고 버그를 줄이자!<br>
2. Collection framework 잘 활용하기 -> 자바에서 제공하는 기능인지 확인하자! -> 코드의 가독성을 높이자<br>
3. Stream문법 도전하기 -> 코드의 가독성을 높이자<br>
4. Commit 일관성, 기능별, 규칙적 -> 의미있는 커밋 메시지 + 기능별 커밋하는 습관을 들이자<br>
5. 처음부터 클린코드 짜려고 노력 : 클린코드는 배려심!, 코드를 읽는 상대방을 어떻게 하면 배려할 수 있는지 고민<br>
   : 구현계획짜기 -> 테스트기반코딩, 객체지향적 코딩<br>
6. 코드 리팩토링 -> 5번과 동일<br>
7. 주어진 요구사항이 전부가 아니다! 현업에서는 어떠한 요구도, 예외도 나올 수 있다!<br>
   -> 숙지하면서 있어야겠다 싶은 것들은 추가해서 구현하자<br>
8. git에 필요 없는 목록은 .gitignore리스트에 추가 ex) .class파일, .idea폴더 등등<br>
9. 기능별로 git의 branch를 만들어서 merge를 해보자(형상관리는 이러라고 있는거지...!)<br>
10. 의미없는 주석 금지!!(무지성 주석 ㄴㄴ -> 코드를 통해 의도를 드러내려 하자! -> 일단 주석 달지 말아봐...)<br>
11. git 관련 추가학습자료 공부하고 정리하자(노오오력해라)<br>

## 📝 기능 목록
### 🧐 Abstract
1. welcome메시지를 출력한다 : "숫자 야구 게임을 시작합니다."<br>
   <br>
2. ComputerPlayer 클래스를 만든다.<br>
   1-1. Randoms의 pickNumberInRange()를 이용해 Random Number를 1개 받는다. 범위는 1~9 사이<br>
   1-2. 이때 입력 받은 수에 예외사항이 없을 때까지 다시 입력 받는다.(첫번째 랜덤추출 제외)<br>
   1-3. (1-1, 1-2)를 총 3번 입력 받고 마무리 한다.<br>
   <br>
3. UserPlayer 클래스를 만든다.<br>
   2-1. 숫자를 입력 받는다. -> Console의 readline()을 활용.<br>
   2-2. 이때 입력 받은 수를 하나씩 확인하면서 예외사항이 있는지 확인<br>
   -> 예외사항이 있다면 IllegalArgumentException 발생 후 종료<br>
   <br>
4. BaseballGame 클래스를 만든다.<br>
   3-1. computerPlayer클래스와 UserPlayer클래스로 생성된 두 객체를<br>
   BaseballGame 클래스로 만들어진 객체에 입력한다.<br>
   3-2. 게임의 규칙에 따라 검증하는 과정을 거친다.<br>
   3-3. 검증시, 답을 입력하지 못한 경우 스트라이크, 볼, 낫싱을 출력하고 과정을 반복한다.<br>
   3-4. 검증시, 답을 맞췄다면 맞췄다고 메시지를 표시하고 게임종료 메시지를 출력한다.<br>
   3-5. 게임을 새로 시작할 지, 아니면 완전히 종료할 지, 입력을 받는다.<br>
   3-6. 1을 입력 받았다면 게임을 처음부터 재시작한다. 2를 입력 받았다면 게임을 완전히 종료한다.<br>
   <br>

### 🔎 details for implemetation
- PlayerComputer Class <br><br>
private static int getRandomNumber()<br>
기능 : 1~9 사이의 무작위 랜덤 숫자 하나를 반환한다.<br>
<br>
private boolean isQualifiedNumber(HashMap<Integer, Integer> digits)<br>
기능 : random Number 세자리가 제대로 만들어졌는지 확인한다.<br>


