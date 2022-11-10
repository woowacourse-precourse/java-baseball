# Java Convention
참고하고자하는 convention을 발췌해서 정리했습니다.

## 3 소스파일의 구조
- ### 3.4 Class 정의
  
  - 클래스 멤버들간의 순서는 정답은 없다. 하지만 `논리적인 순서`를 가지는 것이 중요하다.
  - Overload 메소드들은 뭉쳐 놓는다.

## 4 포맷
- ### 4.1 중괄호
  - 중괄호 `{}`는 if / else / do / while 문에 내용이 없거나 한 줄이어도 반드시 포함한다.
  - 빈 블록은 개행해도, 개행하지 않아도 괜찮다. 하지만 멀티 블록(try/catch 구문 등)은 개행해야 한다.
- ### 4.2 블록 들여쓰기
  - 들여쓰기는 +4 스페이스
- ### 4.4 열 제한
  - Java 코드의 열 제한은 120자입니다.
  
- ### 4.8 변수 선언
  - 반드시 시작 부분에 변수가 선언되는 것은 아니다. 처음 사용되는 부분 가까이에 선언한다.
  - 클래스와 멤버의 modifiers는 다음과 같은 순서로 작성하는 것이 권장된다. 
    
  public protected private abstract default static final transient volatile synchronized native strictfp  


## 5 네이밍
- ### 5.2 클래스 이름
- 클래스 이름은 UpperCamelCase로 작성
- 명사( Character ) 혹은 명사구( ImmutableList )로 이름 짓는다. 형용사나 형용사구도 허용 ( Readable ) 
- ### 5.3 메소드 이름
- 메소드 이름은 lowerCamelCase로 작성

출처 : <a href = "https://google.github.io/styleguide/javaguide.html"> Google Java Style Guide</a> / <a href = "https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java"> woowacourse-docs</a>