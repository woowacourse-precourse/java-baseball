
#기능목록

1. 인텔리제이 한글깨짐 설정
 - IntelliJ Settings 메뉴호출
 - Edior-> File Encofings로 이동
 - Globas Encoding: UTF-8
 - Project Encoding: UTF-8
 - Defalut encoding for properties files: UTF-8
 - (체크) Transparent native-to-ascil convention
 - 이후 인텔리제이 재시작
 - 1차 실패
 - <<구글 검색>>
  - Help - Edit Custum VM options
  - -Dfile.encoding=UTF-8  <== 추가입력
  - 인텔리제이 재시작
  - 성공
2. String 매개변수를 List(Integer)로 전환하기
3. (리팩토링) input 값을 클래스로 만들기 
4.  computer 숫자와 player 숫자를 비교하는 check() 메소드 만들기
5.  computer 숫자와 player 숫자를 비교하는 strike()메소드 만들기
6.  computer 숫자와 player 숫자를 판정하는 referee() 메소드 만들기
7.  경기 재시작 여부 playAgain() 만들기
8.  만들어진 메소드 조합해서 main()에 반영하기
9.  예외 작성 반영하기
10. 함수 테스트 작성하기