## JUnit5

---

> 아래 내용 "[StringTest](../src/test/java/study/StringTest.java)" 에서 실습 수행

### 1. 테스트 코드

- 코드의 신뢰성을 높힌다.
- 구현 내용과 변경 내용에 대해 빠르고 쉽게 피드백을 받을 수 있다.



### 2. JUnit

- Kent Beck, Erich Gamma, David Saff, Kris Vasudevan이 만든 매우 심플하고 직관적인 자바 테스팅 프레임워크



### 3. JUnit5 기본 어노테이션

- @Test : 테스트 메소드임을 나타내는 어노테이션. **필수**로 부여되어야 한다.
- @BeforeEach : 각 테스트 메소드 **시작 전**에 실행되어야 하는 메소드에 부여.
- @AfterEach : 각 테스트 메소드 **종료 후**에 실행되어야 하는 메소드에 부여.
- @BeforeAll : **테스트 시작 전 (테스트 메소드 전체 시작 전)**에 실행되어야 하는 메소드에 부여. **static 메소드여야 한다.**
- @AfterAll : **테스트 종료 후 (테스트 메소드 전체 종료 후)**에 실행되어야 하는 메소드에 부여. **static 메소드여야 한다.**
- @Disabled : 실행되지 않아야 하는 테스트 메소드에 부여.



### 4. JUnit 테스트의 TestInfo 매개변수

- JUnit 테스트 메소드는 기본적으로 **TestInfo** 타입의 매개변수를 받을 수 있다. 해당 매개변수에서 활용 가능한 메소드들은 다음과 같다.

| 메소드           | 반환 타입          | 반환 내용                     |
| ---------------- | ------------------ | ----------------------------- |
| getDisplayName() | String             | @DisplayName과 동일한 값      |
| getTags()        | Set< String >      | @Tag 의 배열 값               |
| getTestClass()   | Optional<Class<?>> | 테스트가 수행되고 있는 클래스 |
| getTestMethod()  | Optional<Method>   | 테스트가 수행되고 있는 함수   |

```java
@Test
void exampleTest(TestInfo testInfo) {
  System.out.prinln(testInfo.getDisplayName());
```





### 5. JUnit5 테스트 명 변경

##### <IntelliJ에서 Gradle 프로젝트에는 'Gradle test runner'를 활용하는데, 이는 @DisplayName 관련 작업을 지원하지 않는다. 따라서 'IntelliJ Test Runner'로 변경해야 한다.>

![image-20221103025134665](https://raw.githubusercontent.com/Sehbeom/TyporaImages/images/img/202211030251563.png?token=AMFKK3YSQGYJZR3JOA5LPNLDMKXG4)



##### <@DisplayName("??")>

- Test Results에 나오는 **테스트 클래스와 메소드** 이름을 지정할 수 있는 어노테이션.

```java
@DisplayName("숫자 관련 기능 테스트")
public class numberTest() {
  @Test
  @DisplayName("숫자 카운트 기능 테스트")
  void countNumberTest(){
    ...
```



##### @DisplayNameGeneration(DisplayNameGenerator.??.class)>

- **클래스 혹은 메소드 이름을 변형**시키는 어노테이션.

    - DisplayNameGenerator.**Standard**.class (Default) : 기존 클래스, 메소드 이름을 그대로 활용.

    - DisplayNameGenerator.**Simple**.class : 괄호 제외.

    - DisplayNameGenerator.**ReplaceUnderscores**.class : 언더스코어(_)를 공백으로 변경.

    - DisplayNameGenerator.**IndicativeSentences**.class : 클래스이름 + 구분자(", ") + 메소드이름 으로 바꿈.

```java
@DisplayName("예시 테스트")
public class exampleTest() {
  @Nested
  @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
  class example_Test1() {
    @Test
    void first_example_Test() {
      ...
```



##### @IndicativeSentencesGeneration(separator = "??", generator = "DisplayNameGenerator.??.class)>

- 해당 어노테이션을 통해 구분자를 커스텀할 수 있다. 파라미터는 다음과 같다.

    - separator : 구분자 문자열. (Default : ", ")

    - generator : DisplayNameGenerator.~~.class

```java
@IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
public class exampleTest() {
  ...
```



##### <테스트 이름 적용 순서>

1. @DisplayName
2. @DisplayNameGeneration
3. DisplayNameGenerator.Standard.class





### 6. 반복 테스트

##### <@RepeatedTest(value = ?, name = "??">

(@RepeatedTest는 @Test 를 안붙여도 된다.)

- value : 반복 횟수. **필수 입력**
- name : 반복할 때 나타나는 테스트 이름.
    - Default : "repetition" + 현재 반복 횟수 + "of" + 총 반복 횟수

- name 파라미터에 RepeatedTest.~~ 로 표시되는 이름을 설정할 수 있으며, 옵션은 다음과 같다.

| 변수                          | 타입   | 내용                                                         |
| ----------------------------- | ------ | ------------------------------------------------------------ |
| DISPLAY_NAME_PLACEHOLDER      | String | @DisplayName 값                                              |
| SHORT_DISPLAY_NAME            | String | 반복할 때 표시되는 테스트 이름<br />== @RepeatedTest 의 name 파라미터 값 |
| LONG_DISPLAY_NAME             | String | DISPLAY_NAME_PLACEHOLDER + " :: " + SHORT_DISPLAY_NAME       |
| TOTAL_REPETITIONS_PLACEHOLDER | String | 총 반복 횟수                                                 |
| CURRENT_REPETION_PLACEHOLDER  | String | 현재 반복 횟수                                               |

```java
@RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
void repeatedTest() {
  ...
```



- TestInfo 처럼 RepetitionInfo 타입의 매개변수를 받을 수 있다. 해당 매개변수에서 활용할 수 있는 메소드는 다음과 같다.

| 메소드                 | 반환 타입 | 내용           |
| ---------------------- | --------- | -------------- |
| getCurrentRepetition() | int       | 현재 반복 횟수 |
| getTotalRepetition()   | int       | 총 반복 횟수   |

```java
@RepeatedTest(value = 5, name = RepeatedTest.LONG_DISPLAY_NAME)
void repeatedTest(RepeatedInfo repeatedInfo) {
  System.out.println(repeatedInfo.getCurrentRepetition() + " / " + getTotalRepetition());
}
```



### 7. 매개변수 삽입

##### <@ParameterizedTest>

- 매개변수(파라미터)를 넣어서 테스트를 수행할 수 있다.

- 해당 어노테이션은 단독으로는 사용할 수 없다. 어떤 파라미터를 넣어줄 건지에 대해 지정해주어야 한다.

    - @ValueSource : 어노테이션의 매개변수에 특정 타입의 배열에 값을 넣어 넘겨주면, 해당 값들이 하나씩 테스트 메소드의 매개변수에 들어간다.

        - 지원 타입 : short[], byte[], int[], long[], float[], double[], char[], boolean[], String[], Class<?>[]
        - 타입 이름 뒤에 s를 붙여 어노테이션의 파라미터로 전달한다.

      ```java
      @ParameterizedTest
      @ValueSource(ints = {1, 2, 3})
      void exampleTest(int value) {
        System.out.println(value);
      }
      ```

    - @NullSource : 메소드 매개변수에 null을 넣어준다. 메소드 매개변수가 primitive type으로 설정되어 있으면 안된다.

    - @EmptySource : 메소드 매개변수에 빈 값 객체를 넣어준다.

    - @NullAndEmptySource : @NullSource와 @EmptySource를 합친 것.

    - @EnumSource : Enum에 정의된 상수들에 대해 테스트할 수 있다.

    - 그 외 @MethodSource, @CvsSource, @CvsFileSource, @ArgumentSource가 있으며, 필요할 시 찾아보면 좋을 것 같다.



### 8. 테스트 인스턴스

- 기본적으로 JUnit은 메소드 단위로 테스트 인스턴스가 생성된다.
    - 즉, 테스트 메소드들은 각각 독립적으로 수행되며, 서로에게 영향을 주지 않는다.
    - 단위 테스트에 유리하다.
- 만약 메소드 단위가 아닌, 클래스 단위로 테스트 인스턴스가 수행되길 바랄 경우, **@TestInstance** 어노테이션을 활용할 수 있다.

##### <@TestInstance(value)>

- value 매개변수는 다음과 같다.
    - LifeCycle value
        - PER_METHOD : 메소드 단위 (Default)
        - PER_CLASS : 클래스 단위
- 만약 PER_CLASS로 설정해두고, 메소드 실행 순서를 설정하고 싶을 경우, 다음 키워드에 대해 구글링 해보면 된다.
    - @TestMethodOrder 어노테이션 : 메소드 실행 순서 설정하는 어노테이션
    - implements MethodOrder : 순서 정렬 기준 커스텀