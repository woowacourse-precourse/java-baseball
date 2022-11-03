## AssertJ

---

> 아래 내용 "[StringTest](../src/test/java/study/StringTest.java)" 에서 실습 수행

### 1. AssertJ

- Assertion을 제공하는 자바 라이브러리.

- 에러 메세지와 테스트 코드의 가독성을 높일 수 있다.

- 주로 다음과 같이 assertThat()과 isEqualTo() 메소드를 활용해 테스트를 수행한다.

  ```java
  assertThat(actual).isEqualTo(expected);
  ```

    - actual : 실제 값. 실제 기능에서 반환한 값
    - expected : 기대 값. 기능에서 반환되어야 하는 값. (정답?)

- assertThat() 메소드는 다양한 체이닝 메소드 형태로 구현될 수 있으며, 이는 가독성을 매우 높여줄 수 있다.

  ```java
  assertThat(actual).isEqualTo(expected);
  ```

    - assert that 'actual' is equal to 'expected'?

  ```java
  assertThat("Woowa Tech Course")
              .isNotNull()
              .startsWith("Woowa")
              .contains("Tech")
              .endsWith("Course");
  ```

    - assert that 'actual'
    - is not null? / starts with "Woowa"? / contains "Tech"? / ends with "Course"?



### 2. 다양한 메소드들

##### <isEqualTo(), isNotEqualTo()>

- 가장 기본적으로 활용되는 메소드.
- **동일성**을 비교한다.



##### <usingRecursiveComparison()>

- 동일성 비교가 아닌, **동등성 비교**를 하고 싶은 경우 활용한다.

    - 동일성 : 두 객체가 완전히 '동일'한 경우. 사실상 하나로 봐도 무방하다. 주소 값도 동일하다.
    - 동등성 : 두 객체가 '같은 정보를 갖고 있는' 경우. 주소 값이 달라도 내용만 같으면 두 객체는 동등하다.

  ```java
  ExampleClass ec1 = new ExampleClass("ex");
  ExampleClass ec2 = new ExampleClass("ex");
  
  assertThat(ec1).isEqualTo(ec2); // fail. 동일성을 비교하므로.
  assertThat(ec1).usingRecursiveComparison(ec2); // success. 동등성을 비교하므로.
  ```



#### <Iterable, Array 관련>

- 컬렉션, 배열, 문자열 등에 해당.

##### <contains()>

- 특정 요소가 포함되어 있는지 확인한다.

##### <isEmpty() / isNotEmpty()>

- 비었는지 여부를 확인한다.

##### <startsWith() / endsWith()>

- 특정 요소로 시작하거나 끝나는지 여부를 확인한다.



#### <Character 관련>

##### <isUnicode()>

- 유니코드 테이블에 있는지 여부를 확인한다.

##### <isLowerCase(), isUpperCase()>

- 소문자, 대문자 여부를 확인한다.



#### <크기 비교(char도 해당)>

##### <isGreaterThan(), isGreaterThanOrEqualTo(), isLessThan(), isLessThanOrEqualTo()>

- 차례대로 초과, 이상, 미만, 이하 이다.



#### <Map 관련>

##### <containsKey/Value(), doesNotContainKey/Value()>

- key와 value에 대해 각각 포함 여부를 확인할 수 있다. (1개씩)

##### <containsKeys/Values(), doesNotContainKeys/Values()>

- key와 value에 대해 각각 포함 여부를 확인할 수 있다. (여러개)

##### <contains(), containsEntry()>

- entry : key-value 쌍
- contains() : 여러개의 entry들을 포함하고 있는지 확인한다.
- containsEntry() : 하나의 entry를 포함하고 있는지 확인한다.



#### <예외처리 관련>

- 다음은 예외처리 사항에 대한 테스트를 수행해 볼 수 있는 다양한 방법들이다.
- 다음과 같이 용어를 설정한다.
    - 예외처리포함메소드 : 예외처리 기능에 대해 테스트 해야 하는 메소드.
    - 예외클래스 : IndexOutOfBoundsException.class, ~~~Exception.class 와 같은 Exception 클래스 정보.
    - 예외메세지 : 예외 클래스 생성자 파라미터로 전해지는 예외 메세지.



##### <예외처리 테스트 기본>

- 기본적인 예외 처리 테스트 방법에는 다음 3가지가 있다.
    - **assertThatThrownBy()**
    - **assertThatExceptionOfType()**
    - **Throwable + assertThat()**



- **assertThatThrownBy()**

  ```java
  assertThatThrownBy(() -> {
    예외처리포함메소드;
  }).isInstanceOf(예외클래스)
    .hasMessage(예외메세지)
    
  // ======
    
  assertThatThrownBy(() -> {
    List<String> list = Arrays.asList("String one", "String two");
    list.get(2); // 인덱스 범위 초과 예외 발생
  }).isInstanceOf(IndexOutOfBoundsException.class) // 인덱스 범위 초과 예외 Exception의 클래스 정보
    .hasMessage("Index: 2, Size: 2"); // 예외 메세지 정보
  ```

    - 예외처리포함메소드에서 예외가 발생했을 때, **던져지는 예외 클래스가 'isInstanceOf()'로 전달**되며, **예외 메세지가 'hasMessageContaining()'으로 전달**된다.
    - 직관적으로 읽어봐도 이해하기 쉽다.
        - assert That ThrownBy 예외처리포함메소드 is instance of 예외클래스
        - assert That ThrownBy 예외처리포함메소드 has message containing 예외메세지

- **assertThatExceptionOfType()**

  ```java
  assertThatExceptionOfType(예외클래스)
    .isThrownBy(() -> {
      예외처리포함메소드;
    }).hasMessage(예외메세지);
  
  // ======
  
  assertThatExceptionOfType(IndexOutOfBoundsException.class)
    .isThrownBy(() -> {
      List<String> list = Arrays.asList("String one", "String two");
      list.get(2);
    }).hasMessage("Index: 2, Size: 2");
  ```

    - 본 방법은 예외클래스 종류를 먼저 보여주는 것이다.
        - assertThatThrownBy는 메소드를 먼저, assertThatExceptionOfType은 예외 클래스를 먼저.

- **Throwable + assertThat()**

  ```java
  Throwable thrown = catchThrowalbe(() -> {
    예외처리포함메소드;
  });
  
  assertThat(thrown)
    .isInstanceOf(예외클래스)
    .hasMessageContaining(예외메세지)
  
  // ======
  
  Throwable thrown = catchThrowable(() -> {
    ExampleClass.exampleMethod();
  });
  
  assertThat(thrown)
    .isInstanceOf(ArithmeticException.class)
    .hasMessageContaining("/ by zero");
  ```

    - 예외처리포함메소드에서부터 던져지는 예외 객체를 **'Throwable' 객체에 담아 테스트를 수행**할 수 있다.

- **예외처리 관련 체이닝 메소드**

    - **hasMessage("예외메세지")** : 파라미터로 전달된 예외메세지가 actual로 인해 던져진 예외메세지와 동일한지 확인한다.

    - **hasMessageStartingWith("??")** : actual 예외메세지가 특정 문자열로 시작하는지 확인한다.

    - **hasMessageEndingWith("??")** : actual 예외메세지가 특정 문자열로 끝나는지 확인한다.

    - **hasMessageContaining("??")** : actual 예외메세지에 특정 문자열이 포함되는지 확인한다.

    - **hasMessageMatching("정규표현식")** : actual 예외메세지가 파라미터로 전달된 정규표현식에 부합하는지 확인한다.

      ```java
      assertThat(thrown).isInstanceOf(IOException.class).hasMessageMatching("Index: \\d+, Size: \\d+")
      ```

    - **hasCauseInstanceOf(예외클래스)** : actual 예외 인스턴스가 파라미터로 전달된 예외 클래스의 인스턴스인지 확인한다.

    - **hasStackTraceContaining("stack trace 내용")** : actual 예외의 stack trace 내용에 파라미터로 전달된 문자열이 포함되는지 확인한다.



##### <RuntimeException 관련>

- 다음 메소드들을 활용하여 RuntimeException에 대한 예외처리 테스트를 수행할 수 있다.
    - **assertThatIOException()**
    - **assertThatIllegalArgumentException()**
    - **assertThatIllegalStateException()**
    - **assertThatNullPointerException()**

```java
assertThatIOException().isThrownBy(() -> {
  예외처리포함메소드;
});
```
