# 숫자 야구 기능 목록

## 게임 시작
### Start 메소드
- 시작문구 출력하기
- Generate_Answer 메소드 호출하기
- Input 메소드 호출하기

## 정답 만들기
### Generate_Answer 메소드
- Answer_Numbers 리스트(전역변수) 만들기
- Answer_Numbers 리스트에 서로다른 난수 넣기
- 다음 게임을 위해 호출할때마다 Answer_Numbers 리스트 비우기

## 숫자 입력
### Input 메소드
- Console.readLine()으로 입력 받기
- 입력 숫자를 각 자리수로 나눠 Input_numbers 리스트에 넣기
- Strike_or_Ball_Judge 메소드 호출하기
- 입력값을 try-catch로 감싸서 조건에 맞지 않은 입력을 IllegalArgumentException 발생시키기

## 스트라이크 볼 판정
### Strike_or_Ball_Judge 메소드
- Strike_or_Ball 해시맵 만들기
- 입력 리스트와 정답 리스트 비교하여 Strike, Ball 개수 맵에 넣기

## 최종 판정
### Final_Judge 메소드
- 각 판정별 알맞은 문구 출력
- 3스트라이크의 경우 End 메소드 호출
- 나머지는 Input 메소드 호출

## 게임 종료 및 재게임
### End 메소드
- 종료문구 출력
- Console.readLine()으로 입력 받기
- 입력 값에 따라 재게임, 게임종료, IllegalArgumentException로 나누기
