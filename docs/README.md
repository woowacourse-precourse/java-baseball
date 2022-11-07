###기본 요구 사항  정리 
##라이브러리 - Randoms, Console API
-.함수(메서드)를 직접 구현하기 전에 Java API에서 제공하는 기능인지 검색을 먼저 해본다. 제공하지 않을 경우 직접 구현.
-camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용한다.
-Random값 추출 : camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
-사용자가 입력하는 값 : camp.nextstep.edu.missionutils.Console의 readLine()을 활용

##기능
-배열 대신 Java Collection 자료구조(List,Set,Map 등)을 사용한다 _다양한API사용가능
-사용자가 잘못된 값을 입력한 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야한다
-프로그램 종료시 System.exit()를 호출하지 않는다.
-indent depth는 2까지만 허용(함수(또는 메서드)가 한 가지 일만 하도록  최대한 작게 만들어 분리하라)
-JUnit5와 AssertJ를 이용하여 정리한 기능 목록이 정상 작동함을 테스트 코드로 확인할 것 


### 구현 로직 생각하기
-게임 시작 문구 출력 > Application.java에서 시작한다.
-컴퓨터(상대방) : 랜덤 3개의 숫자 선택 (컴퓨터,상대방) > Uitls > RandomUtils
-게임플레이어  : 입력 _ 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 
-컴퓨터(상대방) : 자신과 게임플레이어의 숫자를 비교하여 볼, 스트라이크를 갯수.숫자로 표시 (없으면 낫싱)
-숫자의 위치.값이 같은지 파악해야한다.
-두개의 값이 같을 때까지 무한 반복 
-두개의 값이 같을 때 새로 시작 (1)or 게임 종료(2)  ->System.exit()를쓰지않는다.

### 구현 기능 목록 
-Application.java : 게임시작하기 

--1~9'까지 '서로다른' 랜덤한 숫자를 생성하여 3자리를 만든다
-Utils >RandomUtils >pickNumberInRange()이용

--입력(게임플레이어,사용자)
-3자리 숫자를 입력.
-3자리 이외의 숫자를 입력할 경우엔 'IllegalArgumentException'발생시키고 애플리케이션 종료한다.
-하나의 게임 안에서 정답을 맞출 때까지 반복. 
-게임이 한 번 끝나면  또다른 게임을 새로 시작(1)or 게임종료(2).
-1,2 이외의 숫자를 입력할 경우엔 'IllegalArgumentException'을 발생시키고 애플리케이션 종료한다.

--출력(컴퓨터,상대방)
-'숫자를 입력해주세요' 문자열 출력
-입력에 대한 힌트를 출력_스트라이크,볼,낫싱
-게임플레이어가 3자리 수를 다 맞추면 게임을 종료시키고 1 or 2를 묻는 문자열을 출력한다.