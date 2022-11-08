# 미션 - 숫자 야구

## 프로젝트 구조

+ 각 클래스는 1:1로 매칭되는 테스트 클래스를 가진다. 각 테스트 클래스는 매칭되는 클래스의 단위 테스트를 담당한다.
+ 각 클래스가 어떤 역할을 하는지는 [기능 목록](#기능-목록) 참고.

```bash
+-- src
|.  +-- main\java\baseball
|.      +--Application.java
|.      +--Baseball.java
|.      +--BaseballNumber.java
|.      +--BaseballScoreCalculation.java
|.      +--BaseballScore.java
|.      +--BaseballInput.java
|.      +--BaseballOutput.java
|
|.  +-- test\java\baseball
|.      +--ApplicationTest.java
|.      +--BaseballTest.java
|.      +--BaseballNumberTest.java
|.      +--BaseballScoreCalculationTest.java
|.      +--BaseballScoreTest.java
|.      +--BaseballInputTest.java
|.      +--BaseballOutputTest.java
```

## 용어

**어플리케이션**: 어플리케이션 실행 시, 게임이 자동으로 실행되며, 매 게임이 종료되고 난 후 유저가 재시작/완전히 종료 중 선택함에 따라서 게임이 새로 시작되거나, 어플리케이션이 완전히 종료된다.

**게임**: 매 게임마다 하나의 정답 숫자(컴퓨터가 랜덤으로 선택한 서로 다른 3개의 숫자)가 있으며, 올 스트라이크가 될 때까지 라운드가 반복해서 실행된다. 올 스트라이크라면 게임이 자동으로 종료된다.

**라운드**: 매 라운드마다 유저는 서로 다른 세 개의 숫자를 입력하고, 그 결과가 출력된다.

=> 즉, 사용자가 어플리케이션을 실행하면 그 안에서 게임이 실행되고 각 게임은 여러 개의 라운드로 이루어져 있다. 사용자는 어플리케이션을 종료하기 전까지 여러번 게임을 할 수 있다.

**PlayCode** :  게임을 재시작, 종료를 위해 선택하는 숫자를 PlayCode라고 한다. 이 용어는 소스 코드에서 변수명으로 사용된다.

## 기능 목록

다음은 프로젝트에 속한 클래스와 그 클래스안에 구현된 기능을 정리한 목록이다. 기능 목록이 함수 목록을 의미하는 것은 아님을 주의한다.

- Application: 전체 어플리케이션 실행을 관리하는 클래스이다.
    + 어플리케이션이 실행하면 자동으로 게임을 시작한다.
    + 게임이 끝나면 유저에게 재시작/완전히 종료를 묻는다.
    + 유저가 재시작을 선택하면 새로운 게임을 시작한다.
- Baseball: 매 게임을 관리하는 클래스이다.
    - 게임이 시작되면, 컴퓨터는 3개의 랜덤한 숫자를 뽑는다.
    - 유저가 선택한 수가 올 스트라이크가 될 때까지, 새로운 라운드를 실행한다.
    - 매 라운드마다 유저에게 숫자를 입력받고, 정답 숫자와 비교하여 점수를 계산한다.
    - 점수를 출력한다.
- BaseballNumber: 유저나 컴퓨터가 선택한 숫자 리스트를 관리하는 클래스이다.
    - 숫자들이 1) 룰에서 요구하는 숫자 개수와 일치하는지 2) 룰에서 요구하는 숫자 범위를 벗어나지 않는지 3) 중복은 없는지 체크한다.
    - 숫자 리스트에 특정 숫자가 포함되는지 검사한다.
    - 숫자 리스트에 특정 숫자가 특정 위치에 있는지 검사한다.
    - 숫자 리스트의 특정 위치에 있는 숫자를 가져온다.
    - Randoms클래스를 이용해서 룰에서 요구하는 숫자 개수만큼 랜덤한 숫자를 뽑는다.
- BaseballScoreCalculation: 두 개의 숫자 리스트를 비교해서 야구 게임 결과를 계산하는 클래스이다.
    - 현재 숫자가 스트라이크인지 확인한다.
    - 현재 숫자가 볼인지 확인한다.
    - 숫자 리스트를 반복하면서, 각 숫자가 스트라이크인지 확인하고, 스트라이크가 아니라면 볼인지 확인하여 총 스트라이크와 볼을 계산한다.
- BaseballScore: 숫자 게임 결과(스트라이크 수, 볼 수)를 관리하는 클래스이다.
    - 스트라이크 수와 볼 수를 형식에 맞는 문자열로 변환한다.
    - 올 스트라이크인지 확인한다.
    - 낫싱인지 확인한다.
    - 스트라이크의 개수를 가져온다.
    - 볼 개수를 가져온다.
- BaseballInput: 해당하는 메시지를 출력한 후, 유저의 입력을 받고, 입력을 필요한 타입으로 변환하는 클래스이다.
    - 숫자를 입력하라는 메세지를 출력한 후, 유저가 입력한 숫자를 BaseballNumber 타입으로 변환한다.
    - 재시작/종료 숫자를 입력하라는 메세지를 출력한 후, 유저가 입력한 숫자를 검사한다. 만약, PlayCode에 속하는 숫자가 아니라면 예외를 발생시킨다.
- BaseballOutput :
    - 야구 게임 시작 메세지를 출력한다.
    - 숫자를 입력하라는 메세지를 출력한다.
    - 재시작/종료 숫자를 입력하라는 메세지를 출력한다.

## 주의 사항

+ 게임 룰은 [미션](/README.md)에 따른다.
+ 유저가 유효하지 않은 값을 입력한 경우 원인과 관계없이 모두 IllegalArgumentException을 발생시킨다. 즉, 중복된 값을 입력해도, 숫자가 아닌 값을 입력해도 모두
  IllegalArgumentException이 발생한다.
+ 게임은 중간에 그만 둘 수 없으며, 입력값이 오래동안 입력되지 않아도 임의로 종료하지 않는다.

## 배운 점

### Java

+ 함수는 하나의 역할만 하도록 설계하고, 변수명은 명확하게 작성하는게 좋다.
  **수정 전** `Is_valid()  `
  **수정 후** `IsProperSize()`, `isOutOfRange()`, `hasDuplicate()`등으로 분리하면 함수가 검사하는 항목을 명확하게 드러낼 수 있다.
+ 숫자 리스트를 클래스 타입(BaseballNumber.class)로 관리하고 생성자에서 유효성 검사를 하면, 유저가 선택한 숫자인지, 컴퓨터가 선택한 숫자인지 상관없이 같은 룰을 적용하여 검사할 수 있음.
+ 매직 넘버를 피하고, 상수로 관리하면 유지 보수가 쉬워진다. 숫자 야구 게임의 룰이 변하여 선택하는 숫자의 개수가 늘어나거나, 숫자 범위가 달라져도 상수만 수정해주면 된다.
+ 상수를 한 클래스에서만 사용하는 경우는 클래스 내에 상수로 선언하고, 다른 클래스에서도 참조 가능해야 한다면 Enum 클래스를 따로 생성해서 관리할 수 있다. 예를 들어, 룰에 따른 선택해야 하는 숫자의 개수,
  숫자의 범위 등은 BaseballNumber.class의 유효성 검사에서만 사용되므로 클래스 내부에 상수로 선언한다. 하지만, PlayCode의 경우에는 Application.class와
  BaseballInput.class에서 사용되므로 PlayCode라는 Enum 클래스로 따로 생성한다.
+ 만약 특별히 상태를 가지지 않는 클래스라면 메소드들을 static으로 선언해 객체를 생성하지 않고 메소드를 호출할 수 있도록 한다. ex) BaseballScoreCalculation,
  BaseballOutput, BaseballInput
+ static이라고 무조건 pubilc이어야 되는 건 아니다. 모든 객체가 공통으로 가지는 값이라서 static으로 선언하지만 외부에서는 참조하지 못하고, 클래스 내부에서만 참조 가능하게 하려면 private으로
  선언한다.
+ 싱글톤 패턴 vs static 메소드만 가지는 클래스 차이점은? 싱글톤 패턴과 static 메소드만 가지는 클래스는 둘다 상태를 관리할 필요가 없을때 사용되고, 여러번 인스턴스가 생성되는 것을 방지하여 메모리를
  효율적으로 관리한다는 점에서는 공통적이다. 하지만, static 메소드는 static 메소드만 참조 가능해 활용하기 까다로운 반면, 싱글톤 패턴을 사용하면 자유롭게 인터페이스를 상속받아 구현하기, 다른 클래스의
  메소드를 참조하기 등이 가능하다.
+ 예외가 발생하면 바로 어플리케이션이 종료되도록 처리하고 싶다면, 예외가 발생할 수 있는 메소드를 호출하는 쪽에서 꼭 예외 처리(try-catch or throws)를 해줄 필요가 없다.
+ String, char, int 사이의 변환 메소드
    + String.join("", 문자열 리스트): 리스트를 하나의 스트링으로 합치기.
    + 'a' + 2 = 99: 'a'의 아스키 코드 + 2를 얻기.
    + (char)('a' + 2): 'a' 에서 두 칸 건너뛴 'c'를 얻기
    + Integer.valueOf("66") = 66: 문자열이 표현하는 숫자를 가져오기
    + String.valueOf(66) = "66": 숫자를 문자열로 바꾸기

### 테스트

+ 매 기능을 구현할때마다 단위 테스트를 작성하니, 호출하는 쪽 코드를 구현하지 전에 직접 써보면서 함수를 적절하게 수정할 수 있었다. 매개변수 순서가 좀 더 자연스럽도록 바꾸고, 호출하는 곳에서 참조하거나 수정할
  수 없도록 하고 싶은 필드는 private final로 바꾸는 등 사용하는 쪽의 입장을 고려하면서 짜게 되었다.
+ 의외로 한번에 테스트 통과되는 경우가 별로 없었다. 또 수정하고 난 다음에 예상하지 못한 곳에서 테스트가 실패하는 경우가 많았다. 테스트 코드가 얼마나 중요한지 느낄 수 있었다.
+ private 메소드만 unit test의 대상이다. private으로 설정한 것은 구현상의 디테일로 외부에서 알 필요가 없고, 그러한 디테일이 수정된다고 테스트케이스가 수정될 필요가 없어야 한다. 만약
  private 클래스를 테스트할 필요가 생긴다면 설계가 잘못된 것이 아닌지 살펴보아야 한다.(https://www.baeldung.com/java-unit-test-private-methods)
+ 테스트에서 static 메소드를 조작하는 방법: +
    + camp.nextstep.edu.missionutils.test.Assertion.java 참고
      (1) 조작하고자 하는 static 객체의 Mocked Static 객체를 만들어준다.
      (2) when(): 어떤 경우에 값을 조작할지 정한다.
      (3) thenReturns(): 첫번째로 반환할 값, 그 이후에 호출될때마다 차례로 반환할 값을 지정해준다.
      (4) 실행하고자 했던 테스트를 계속 진행한다.
    + 코드 설명: 테스트에서 Randoms.class의 pickNumberInRange()라는 static 메소드가 처음으로 호출되면 value를 반환한다. 그 이후에 호출될때마다 values의 값을 차례로
      반환한다.

```java
public static void assertRandomNumberInRangeTest(
final Executable executable,
final Integer value,
final Integer...values
        ){
        assertRandomTest(
        ()->Randoms.pickNumberInRange(anyInt(),anyInt()),
        executable,
        value,
        values
        );
        }
private static<T> void assertRandomTest(
final Verification verification,
final Executable executable,
final T value,
final T...values
        ){
        assertTimeoutPreemptively(RANDOM_TEST_TIMEOUT,()->{
        try(final MockedStatic<Randoms> mock=mockStatic(Randoms.class)){
        mock.when(verification).thenReturn(value,Arrays.stream(values).toArray());
        executable.execute();
        }});}
```

+ 입력을 테스트하는 방법: System.in에 테스트 값을 ByteArrayInputStream으로 바꾸어서 설정해준다. 실제 콘솔값을 받는 대신, 테스트 값이 입력된 것처럼 처리된다.

```java
private void command(final String...args){
final byte[]buf=String.join("\n",args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        }

@Test
void 123이_입력된_경우(){
        command('123');
        \\테스트 계속
        }
```

+ 출력을 테스트하는 방법: 각 테스트 케이스 실행 전 표준 출력인 PrintStream대신 OutputStream을 System.out으로 설정해준다. 콘솔에 출력되는 대신 변수에 저장한다.
+ java.io.PrintStream은 java.io.OutputStream을 상속받는다.

```java
private PrintStream standardOut;
private OutputStream captor;

@BeforeEach
protected final void init(){
        standardOut=System.out;
        captor=new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        }

@AfterEach
protected final void printOutput(){
        System.setOut(standardOut);
        System.out.println(output());
        }
```

+ assertEquals은 참조타입의 경우에 id를 비교하므로 객체를 비교할 수 없다. 객체 필드 각각에 대해서 값을 비교해 주어야 한다.
+ 테스트는 실행되는 순서가 정해져있지 않기 때문에 모든 테스트 케이스는 독립적으로 실행될 수 있어야 한다.

### git

+ 만약 변경 사항을 staging area에 올렸는데(add) 이번 커밋에서 분리하고 싶어서 다시 unstage하고 싶다면 -> git reset. untracked로 되는 것이 아니라. 이전 커밋 내용까지는
  커밋된 상태로 변경사항은 working directory에만 저장된 상태가 된다.
+ git에서 scope를 입력하는 이유: 한 번의 수정으로 여러 클래스들이 수정되는 경우가 많은데 이때, 주로 어떤 영역(혹은 도메인)에 관련된 문제를 해결하고자 한 것인지 쉽게 확인 가능하다.
+

### 좀더 고민해 보고 싶은 것

+ [ ] 사용자의 입력을 받아서 적절한 타입으로 변환해주는 것까지를 BaseballInput.class에서 담당하는게 맞을까? 아니면 Input클래스는 입력값을 단순히 전달만 하고 사용하는 클래스에서 변환하는게 맞을까?  