# 주의 사항
***
[자바 스타일 가이드 링크](https://github.com/JunHoPark93/google-java-styleguide)
<br>❗꼭 기억해야 할 것 기록하기️❗
> 빈 블럭들: {}괄호 안에 문자가 없거나 줄바꿈이라면 열자마자 끝날 수 있음. 하지만 멀티 블럭 구문에서는 할 수 없음!<br>
> 블럭 들여쓰기: +4 스페이스 <br>
> 열 제한: 100 <br>
> 클래스 이름은 UpperCamelCase이다. <br>
> 함수 이름은 lowerCamelCase이다.<br>
> indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다 <br>
> 3항 연산자 사용 X<br>
> 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.<br>

### ❗ JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
***테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.***

### ❗라이브러리
* camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
```Java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```
***
### Commit Message Convention
* [제공 링크의 번역본 참고](https://velog.io/@outstandingboy/Git-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%8B%9C%EC%A7%80-%EA%B7%9C%EC%95%BD-%EC%A0%95%EB%A6%AC-the-AngularJS-commit-conventions)
***
# 기능 목록
***
1. 1 ~ 9 까지 랜덤으로 임의의 수 3개를 선택하는 메서드 추가
> camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
2. 사용자 값을 입력하는 메서드 추가
> camp.nextstep.edu.missionutils.Console의 readLine()을 활용
3. 잘못된 값을 입력했을 때 예외처리하는 메서드 추가(정규식 활용)
> 1. 숫자가 입력되지 않는다면 예외처리 -> IllegalArgumentException
> 2. 입력된 숫자 길이가 3이 아니라면 예외처리 -> IllegalArgumentException
> 3. 서로 다른 숫자들이 아니라면 예외처리 -> IllegalArgumentException
4. 스트라이크 or 볼 or 낫싱을 판단하는 메서드 추가
> 1. 숫자와 위치가 같다면 strike 개수 + 1
> 2. 숫자는 존재하는데 위치가 다르다면 ball 개수 + 1
> 3. 일치하는 숫자가 하나라도 존재하지 않는다면 낫싱
5. 게임을 새로 시작할지, 종료할지 선택하는 메서드 추가
> 1. 게임 중이 아니라면, 1 or 2를 입력받도록 해서 새로 시작하는지, 종료하는지 실행시키는 메서드 추가
> 2. 1 또는 2 숫자가 아니라면 예외처리 -> IllegalArgumentException
6. 사용자의 입력에 따른 결과를 출력하는 메서드 추가
> strike 개수, ball개수에 따라 출력하는 메서드 생성
***
```Java
class Computer { // 컴퓨터 클래스
  private List<Integer> numbers;
  private static final int MAX_SIZE = 3;
  
  public Computer(){}
  public makeRandomNumbers(){}
  public getNumbers(){}
}

class Player { // 플레이어 클래스
  private List<Integer> numbers;
  
  public Player(){}
  public inputNumbers(){}
  public inputGameStatusData(){}
  public decideNumbers(){}
  public getNumbers(){}
}

class Judge { // 게임 진행자 클래스
  
  public Judge(){}
  public decideGameStatus(){}
  public getPlayerNumbers(){}
  public getComputerNumbers(){}
  public compareBalls(){}
}

class CheckException { // 예외 처리 클래스
    private static final int MAX_SIZE = 3;
    public static final int RESTART = 1;
    public static final int EXIT = 2;
    
    public validateConsistsOfNumber(){}
    public validateNumberLength(){}
    public validateOverlap(){}
    public validateGameStatusData(){}
}

class Application {
    public static void main(String[] args){}
    public static void printMessage(){}
    public static void decideResult(){}
}
```
***
# 📝 기능 분석 변경 사항
* Player라는 클래스가 하는 일만 메서드로 등록하기 -> 하나의 클래스에서의 기능이 너무 많으면 유지보수가 
힘들다는 것을 이해했다.
* CheckException 클래스를 통해서 예외 사항을 체크하는 메서드를 Player에서 분리하여 추가