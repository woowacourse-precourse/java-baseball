Refactor: "정답 생성 방식 변경 및 저장 "

정답을 저장하는 String형 변수 answer는 서로 다른 값을 생성하기 위해서 String 값을 
for문 통해 구분하는 메소드를 사용. 이러한 메소드를 자료구조 Set로 중복을 제거 가능
BaseBall 클래스의 볼과 스트라이크 점수를 계산하는 point 메소드에서 String 형 변수
사용보다는 List를 사용하는 것이 가독성이 향상될 것이라고 판단  
String 형 변수 answer를 자료구조 List형으로 변경