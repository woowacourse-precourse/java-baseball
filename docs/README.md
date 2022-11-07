### 목표
"레거시 애플리케이션 리팩토링 하기"

### 기능 목록
1. [시작 입력]야구게임을 위해 숫자를 부여, 입력하는 기능
- 컴퓨터 : 라이브러리를 사용해 랜덤으로 숫자 부여 후 자료구조(리스트)에 저장 ✅
- 사용자 : 라이브러리를 사용해 숫자로 변환 후 자료구조(리스트)에 저장 ✅
- **예외처리**
    1. 3자리의 숫자를 입력하였는가 ✅
    2. 중복되는 숫자를 입력하였는가 ✅
    3. 빈칸이 입력되었는가 ✅ (4번 예외사항에서 숫자만 포함되므로 자연스럽게 처리됨)
    4. 숫자가 아닌 다른 문자가 입력되었는가 ✅
    5. 0이 포함되어있는가 ✅ (4번 예외사항에서 0도 포함안되게 처리됨)

2. [실행 결과]야구게임 결과를 알려주는 기능
- 기능 : 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 
그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리 ✅

3. [끝 입력]야구게임 재시작을 물어보는 기능
- 사용자 : 숫자를 입력해 야구게임 재시작을 결정함 ✅
- **예외처리**
  1. 제한 된 숫자 외의 숫자가 입력되었는가 ✅

### 코드 수정 과정
1. [레거시 코드 작성]
- 두 개의 ArrayList 를 두고 ArrayList 의 메소드인 contains 를 통해 코드를 작성하였는데, 먼저 하나하나 비교하며 위치가 일치하면 strike 개수를 증가
시켜주고 해당 위치의 인덱스에 해당하는 참/거짓 배열의 값을 바꾸어주었습니다. 그리고 computer 가 user 의 숫자를 contains 하는지 확인 후 ball 개수를 증가
시켜주고 답을 리턴해주었습니다.

-> 이과정은 불필요한 코드가 많이 만들어져야 했으며 한 눈에 보기에도 지저분하고 효율적이지 않은 코드라고 판단하였습니다. 그래서 ArrayList 의 다른 메소드를 사용해
코드를 작성하기로 하고 indexOf(val) 라는 메소드를 발견하였습니다. 값을 제공하면 해당 값의 첫번째 인덱스를 반환하는 메소드입니다.

- indexOf(val) 메소드를 사용하여 차례대로 반복문을 실행해서 나온 값이 ArrayList 의 index 와 같은 값이라면 strike, index 와 다르지만 0보다 크면
존재한다는 뜻이므로 ball 을 카운트해주었습니다. index 가 0보다 작으면 존재하지 않는다는 뜻이므로 아무런 조치를 취하지 않습니다. 
strike 와 ball 은 크기가 2인 배열을 선언하여 표현하였습니다.

2. [메소드 분리]
- 기능별로 메소드를 쪼개어 리팩토링을 진행하였습니다. 들여쓰기를 최대 2까지 유지하고, 함수별로 하나의 기능을 가지고있을수 있게
분리하였습니다. 

3. [클래스 분리]
- 다양하게 분리되어진 메소드를 도대체 어떻게 분리해야 할까 고민을 했습니다. 사실 사용자와 컴퓨터밖에 없지않나
라는 생각을 가지고 사용자와 컴퓨터, 그리고 게임애플리케이션의 3가지의 클래스로 분리할 생각을 했습니다. 
이렇게 클래스를 분리하고 생각해보니 사용자와 컴퓨터 둘다 숫자를 직접 입력하거나 랜덤으로 숫자를 입력받아 관리하는 
공통적인 부분이 있지 않나? 라는 생각이 들었습니다. 그래서 두가지 즉, 숫자와 게임애플리케이션 클래스로 분리했습니다.

4. [정규표현식]
- 입력을 주고받을 때 예외사항을 고려하여 한번에 체크하는 방법으로 코드를 구현하였는데, 정규표현식을 사용하면 
더 용이하게 예외사항을 처리할 수 있을것 같다는 생각이 들어 정규표현식을 학습하여 적용하였습니다.

String pattern = "^[1-2]$"; -> 숫자 1~2에 해당하는 것이 입력되었는가 ?
String pattern = "^[1-9]{3}$"; -> 숫자 1~9에 해당하고 길이가 3인 것이 입력되었는가 ?

5. [알수 없는 오류]
야구게임을 실행하고 보면..
~~~
WARNING: An illegal reflective access operation has occurred  
WARNING: Illegal reflective access by camp.nextstep.edu.missionutils.Console
(file:/Users/kimtaekang/.gradle/caches/modules-2/files-2.1/com.github.woowacourse-projects/mission-utils/1.0.0/dad5230ec970560465a42a1cade24166e6a424f4/mission-utils-1.0.0.jar) to field java.util.Scanner.sourceClosed  
WARNING: Please consider reporting this to the maintainers of camp.nextstep.edu.missionutils.Console  
WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations  
WARNING: All illegal access operations will be denied in a future release
~~~
가 발생합니다. 오류가 왜 발생하는지 궁금해서 구글링을 해보았습니다. 그랬더니, 자바 9 이상의 모듈 시스템 제한에서는
자바의 핵심 클래스에 대한 접근 제어를 사실상 막도록 제어하고 있다고 합니다. 자바 8을 쓸 경우 이런 오류는 더이상 발생한다고 하지
않는다고 합니다. 
마지막 경고문인 "G: All illegal access operations will be denied in a future release" 에 따르면
향후 릴리스에서 해결될 것으로 보입니다. :D

