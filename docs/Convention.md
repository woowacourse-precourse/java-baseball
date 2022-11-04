>1주차에는 스스로 찾아서 컨벤션을 작성했기 때문에 2주차부터는 우테코에서 제공한 컨벤션에 맞게 적용하기 위해 추가적으로 작성했습니다. 

# 자바 컨벤션(Java Convention)
참고
- https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java
- https://google.github.io/styleguide/javaguide.html
- https://github.com/JunHoPark93/google-java-styleguide

### 순서와 공간
임포트는 다음과 같은 단계를 따른다:
1. 하나의 블럭안에 static 임포트 포함
2. 하나의 블럭안에 non-static 임포트 포함

만약에 static과 non-static이 둘 다 있다면, 개행을 하고 두 개의 블럭으로 나눈다. 그 이외에는 개행이 있으면 안된다.

### 클래스에는 static 임포트를 하지 않는다.
static 임포트는 static 중처버 클래스에 사용되지 않는다. 그것들은 일반적인 임포트를 사용한다.

### 괄호는 선택사항에서도 쓰인다.
괄호는 if, else, for, do, while 구문에 쓰이는데 몸체가 없거나 한 줄의 구문에도 괄호가 쓰인다.

### 비어있지 않은 블럭: K & R 스타일
괄호는 비어있지 않은 블럭과 block-like construct에서 Kernighan과 Ritchie 스타일(Egyptian brackets)을 따른다.
- 여는 괄호 앞에는 줄 바꿈이 없음
- 여는 괄호 다음에 줄 바꿈
- 닫는 괄호 전에 줄 바꿈
- 닫는 괄호 다음에 줄 바꿈, 그런데 이것은 오직 구문이 끝나거나 메소드, 생성자, 클래스가 끝났을 때 적용된다. 
예를들어 else나 콤마뒤에 나오는 부분은 줄 바꿈을 하지 않는다.

### 열 제한: 120
Java 코드의 열 제한은 120자입니다. "문자"는 유니코드 코드 포인트를 의미합니다.

### 패키지 이름
패키지명은 전부 소문자로 단순히 서로 뭍여서 연속된 단어로 이루어져 있다. (언더스코어 없음) 예를들어 com.example.deepspace같은 형식이다.
com.example.deepSpace혹은com.example.deep_space 는 잘못되었다.

### 클래스 이름
클래스 이름은 UpperCamelCase 이다.

클래스 이름은 전형적으로 명사나 명사 구이다. 예를들어, Character 혹은 ImmutableList 처럼 말이다. 인터페이스의 이름은 명사나 명사구가 될 수 있다.
예를들어 List. 그러나 가끔은 형용사나 형용사구가 대신 쓰이기도 한다 (예를들어 Readable)

테스트 클래스들은 테스트하려는 클래스의 이름이 앞에오고 끝에 Test를 붙여준다. 예를들어 HashTest 혹은 HashIntegrationTest

### 함수 이름
함수 이름은 lowerCamelCase 이다.

함수 이름은 전형적으로 동사 혹은 동사 구이다. 예를들어, sendMessage 나 stop이다.
언더스코어는 JUnit 테스트에서 논리적 컴포넌트를 분리시키기 위해 각각을 lowerCamelCase로 변경시켜 나올수 있다.
하나의 전형적인 패턴은_ 이다. 예를들어 pop_emptyStack. 테스트 메소드를 작성하는 하나의 정확한 방법은 없다.

### 상수 이름
상수는 CONSTANT_CASE를 사용한다: 모두 대문자이고 각 단어는 하나의 언더스코어로 구분하는 형식. 하지만 정확히 상수는 무엇인가?

상수는 static final 필드 인데 그것은 변경될 수 없고 그것들의 메소드는 부작용이 보여서는 안된다.
이것은 원시타입, 문자열 그리고 불변 타입, 불변타입의 불변 컬렉션을 포함한다. 만약 어떤 인스턴스의 상태가 바뀐다면 그것은 상수가아니다.

### 상수가 아닌 필드의 이름
상수가 아닌 필드 이름은 (static 같은) lowerCamelCase로 작성한다.

이러한 이름들은 전형적으로 명사나 명사구이다. 예를들어, computedValues 혹은 index.

### 파라미터 이름
파라미터 이름은 lowerCamelCase 이다.

public 메서드에서 한개의 문자를 가진 파라미터는 피해야 한다.

### 지역변수 이름
지역변수는 lowerCamelCase 이다.

심지어 final 이나 불변, 지역변수는 상수로 간주되어서는 안되고 상수 스타일로 기술해서도 안된다.

### @Override: 항상 사용한다
@Override가 사용가능할 때 이 애노테이션을 붙인다. 이것은 클래스가 슈퍼 클래스의 메서드를 오버라이딩을 하는 것을 나타내기도하고 인터페이스의 메서드를 구현하는 것을 나타낼 수도 있다.

예외: 부모 함수가 @Deprecated가 되면 @Override를 생략할 수 있다.

### 예외 잡기: 생략 하지 말것
아래 명시되있는 것말고 예외를 잡고 아무것도 안하는 것은 거의 있을 수 없다. (전형적인 반응은 로그를 남기는 것 혹은 불가능하다고 간주되면 AssertionError로 다시 던져준다)

정말로 캐치블럭에서 아무것도 하지 않는것이 정당하다면 주석을 남기는것으로 정당화한다.

```java
try {
    int i = Integer.parseInt(response);
    return handleNumericResponse(i);
} catch (NumberFormatException ok) {
    // 숫자가 아니다; 괜찮으니 그냥 넘어간다
}
return handleTextResponse(response);
```

예외: 테스트에서 예외를 잡는 부분은 expected, 혹은 expected로 시작하는 이름을 지으면서 무시할 수 있다. 
다음 예제는 테스트에서 예외가 나오는게 확실한 상황에서 사용되는 대중적인 형식으로 주석이 필요가 없다.

```java
try {
    emptyStack.pop();
    fail();
} catch (NoSuchElementException expected) {
}
```

# 추가 요구사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 test/java/study를 참고하여 학습한 후 테스트를 구현한다.
  라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

# 깃 컨벤션
깃 컨벤션의 경우 저번과 같기 때문에 생략
- https://github.com/parkmuhyeun/java-onboarding/blob/parkmuhyeun/docs/Convention.md#%EA%B9%83-%EC%BB%A8%EB%B2%A4%EC%85%98git-convention