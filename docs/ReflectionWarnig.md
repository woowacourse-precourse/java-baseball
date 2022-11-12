# reflective access 경고문이 뜨는 이유

## 자바 reflection 이해하기
1. reflective 접근이 뭐임?<br>
   reflective access operations

2. 자바 relfection 개념 및 사용이유<br>
    - 개념 : <br>자바 reflection은 힙 영역에 로드된 Class 타입의 객체를 통해, 원하는 클래스의 인스턴스를 생성할 수 있도록 지원하고,<br>
      인스턴스의 필드와 메소드를 접근 제어자와 상관 없이 사용할 수 있도록 지원하는 API.
      JVM의 클래스 로더에서 클래스 파일에 대한 로딩을 완료한 후, <br>
      해당 클래스의 정보를 담은 Class 타입의 객체를 생성하여 메모리의 힙 영역에 저장해 둔 것을 의미한다.
      <br>new 키워드를 통해 만드는 객체와는 다른 것임을 유의해라.
    - 사용 이유 : <br>리플렉션 API를 통해 런타임 중, 클래스 정보에 접근하여 클래스를 원하는 대로 조작할 수 있다.
      <br>규모가 작은 콘솔 단계에서는 개발자가 충분히 컴파일 시점에 프로그램에서 사용될 객체와 의존 관계를 모두 파악할 수 있다.
      <br>하지만 프레임워크와 같이 큰 규모의 개발 단계에서는 수많은 객체와 의존 관계를 파악하기 어렵다.
      <br>이때 리플렉션을 사용하면 동적으로 클래스를 만들어서 의존 관계를 맺어줄 수 있다.
      <br>
      참고 : https://steady-coding.tistory.com/609


3. 리플렉션이란?<br>
   인스턴스로 클래스의 정보를 분석하기 위한 기법   <br>   <br>

4. 자바 reflection 패키지 <br>
    - Class 클래스 : 클래스에 대한 정보를 얻기 위한 클래스
        - Field getDeclaredField(String name): name과 동일한 이름으로 정의된 변수를 Field 클래스 타입으로 리턴한다.
        - get() 메소드에 가져오고자 하는 객체의 인스턴스(new Book())를 인자로 던져주면 값을 반환함.

    - Field 클래스 : 클래스에 있는 변수들의 정보를 제공하기 위한 클래스
        -  생성자가 존재하지 않으므로
        - Class 클래스의 getField() 메소드나 getDeclaredFields() 메소드를 써야함.

5. setAccesible() 메서드<BR>:
   필드나 메서드의 접근제어 지시자에 의한 제어를 변경한다.<BR>
   private 인스턴스 변수나 메서드는 해당 클래스의 외부에서는 접근할 수 없다.
   <BR><BR>
---

## 경고문 발생이유 알아내기!!!!
<p>
발생이유 : reflection api를 사용하는 라이브러리(패키지)에 의해 jdk에 허용되지 않은 접근이 생겼기 때문

Console 클래스를 이용해 입력 받기를 반복해서.
- Console 클래스는, 리플렉션 기법을 활용해서, private인 Scanner의 sourceClosed에 직접 접근함.
    - Scanner.class 객체로 부터, sourceClosed라는 변수 가져옴. (변수를 Field 클래스 타입으로 리턴)
    - setAccesible(true) 메서드를 통해서, reflect를 통한 private한 필드 혹은 메서드에 접근할 수 있도록 허용한다.
    - field.getBoolean() 메서드를 통해서, static 또는 인스턴스 boolean 필드의 값을 취득합니다.<br>
      ->쓰는 이유:  sourceClosed 변수 값이 boolean이니까.
    - 즉, 자바의 reflection 기능을 통해 스캐너를 생성한다.
</p>

##  해결법!!!!!!!!!

1. 불법 reflective 접근을 허용하기<br>
   스크립트에 —illegal-access=permit 를 전달(pass).<br>
   = 컴파일 할 때 위와 같은 옵션을 주기<br>
   = Run/Debug Configurations에서
   VM options에 illegal-access=permit 옵션을 주기<br>
   참고 문서) How to fix “an illegal reflective access operation has occurred”<br>
   https://linuxpip.org/an-illegal-reflective-access-operation-has-occurred/
   <br><br>
2. 접근을 명시적으로 구체화하기<br>
   Java의 –add-opens 매개변수를 사용하여 명시적으로 반사 액세스를 지정
   <br><br>
3. 반복을 안 하면 됨