
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

3. 컴퓨터 숫자와 내 숫자를 비교하는 check() 메소드 만들기