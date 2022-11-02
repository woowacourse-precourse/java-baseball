### 프리코스 2주차 미션 - 숫자야구 🤹‍
### \(@^0^@)/ 필요한 기능 목록

<br>

1️⃣ 랜덤 수 발생
<br>
- [ ] 요구사항에 제시된 라이브러리를 참조해 Random 값을 추출하기
```(java)
camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 
// Random 값 추출
// 숫자 하나가 int 값으로 담김
```

- [ ] 추출한 Random 값 하나 하나를 리스트에 저장하기
```(java)
List<Integer> list = new ArrayList<>() // 이렇게 미리 리스트를 하나 선언
list.add(Randoms.pickNumberInRange(1, 9))
// 1~9까지의 수 중에 하나를 랜덤으로 골라 list에 추가해줌
// for문을 돌려 리스트에 3개의 값을 집어넣음
```

2️⃣ 입력받은 수가 예외의 경우인지 확인
- [ ] 일단 입력값 추출
```(java)
camp.nextstep.edu.missionutils.Console의 readLine()
// 사용자 입력 값 추출
// String으로 받아옴
```
:collision: 이때 IllegalArgumentException을 발생시켜야 하는 경우
- [ ] 3자리 수가 아닐 때
  (ex. 1, 23, 19847)
- [ ] 숫자가 아닌 다른 문자가 들어갈 때
  (ex. "메롱", "$#*")
  
  
3️⃣ 입력받은 수 관리 방법
<br>

:collision: 정상적으로 세자리 수를 입력받은 경우
- [ ] String으로 받아온 숫자를 Integer형 리스트로 변환 + return
```(java)
str.split("") // 문자열을 한자리 수로 쪼개기
Arrays.asList() // 위에서 쪼개진 문자열(배열)을 list로 변환
```

4️⃣ 두 수의 비교를 통한 ball / strike 판별
<br>

:zap: ball은 두 리스트에서 겹치는 수의 개수이고, strike는 그 중 인덱스까지 겹치는 개수!
<br>
:zap: 이때 strike의 개수만큼 ball 개수에서 빼주어야 함
<br>
1. ball 개수를 구한다
```(java)
int ballNumber = list.contains(입력수의 인덱스)
// contain 함수를 통해 겹치는 수의 개수를 찾는다   
```
:collision: 이 때 ballNumber = 0 이면
<br> -> 바로 <em>'낫싱'<em> 을 출력!

2. 생성된 함수에 두 리스트(랜덤수, 입력수)를 인자로 받아와 for문(길이 3)을 실행
<br> 여기서 인덱스 값끼리 같을 때 strike 값에 1씩 더해줌

5️⃣ 결과 출력 (ex. 1볼, 낫싱, 게임 종료 후 재시작/ 완전히 종료)
<br>

:collision: 아직 숫자를 맞추지 못해 힌트를 얻은 경우

(4)번에서 얻은 결과로
```(java)
System.out.println(볼+"볼 "+스트라이크개수+"스트라이크") // 이런식으로 출력
```

:collision: 숫자 맞춘 후
<br>
1. Console의 readline함수를 통해 수를 입력받음
2. 1은 재시작(6번에서 계속), 2는 바로 종료 시켜줌
3. 그 이외의 문자/숫자가 들어오면 IllegalArgumentException 발생!!

6️⃣ 재시작에 의한 게임의 반복 구현
<br>
(5)번에서 readline을 통해 받은 수를 이용!
```(java)
if (1번 받아오면) {
다시 게임을 시작} else if (2번 받아오면) {
바로 종료} else {
IllegalArgumentException 발생}
```