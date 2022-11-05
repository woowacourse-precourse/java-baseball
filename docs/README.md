### 프리코스 2주차 미션 - 숫자야구 🤹‍

### \(@^0^@)/ 흐름 및 클래스 설정
:sparkles: 숫자 야구 게임!
<br>
1. 랜덤 숫자 설정 기능 (중복 제거)
<br>
-> 게임에서 중요한 입력 요소이므로 기능 분리 :o:
<br>
2. 입력 숫자 설정 기능
<br>
-> 게임에서 중요한 입력 요소이므로 기능 분리 :o:
<br>
3. 입력 숫자 예외 처리
<br>
-> 입력 숫자 클래스 안에 (or 따로 예외처리 클래스로) :o:
<br>
4. (랜덤, 입력 숫자 이용한) 볼/스트라이크 계산
<br>
-> 답을 맞추기 위해 힌트를 제공하는 중요한 로직이므로 기능 분리 :o:
<br>
5. 결과 출력
<br>
6. (1) 게임 종료 -> 1(다시) 또는 2(종료) 입력
   <br> (2) 게임 재시작 -> 2~6 과정을 다시 거침!
<br>
-> 게임이 반복되는 로직을 하나의 클래스로 분리 :o:

<br>
:sparkles: 클래스

- game 디렉토리
1. Game (실질적인 게임을 진행하는 클래스)
2. EnterNumber (입력받은 수를 관리하는 클래스)
3. RandomNumber (컴퓨터에 랜덤으로 생성되는 수를 관리하는 클래스)
- ballAndStrike 디렉토리
1. Count (볼/스트라이크 개수 관리하는 클래스)
2. Hint (볼/스트라이크 출력, 즉 힌트를 출력해주는 클래스)


### \(@^0^@)/ 필요한 기능 목록

<br>

1️⃣ 랜덤 수 발생
<br>
- [x] 요구사항에 제시된 라이브러리를 참조해 Random 값을 추출하기
```(java)
camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange() 
// Random 값 추출
// 숫자 하나가 int 값으로 담김
// 이때 중복값이 들어가지 않도록 해야 함
```

- [x] 추출한 Random 값 하나 하나를 리스트에 저장하기
```(java)
List<Integer> list = new ArrayList<>() // 이렇게 미리 리스트를 하나 선언
list.add(Randoms.pickNumberInRange(1, 9))
// 1~9까지의 수 중에 하나를 랜덤으로 골라 list에 추가해줌
// for문을 돌려 리스트에 3개의 값을 집어넣음
```

2️⃣ 입력받은 수가 예외의 경우인지 확인
- [x] 일단 입력값 추출
```(java)
camp.nextstep.edu.missionutils.Console의 readLine()
// 사용자 입력 값 추출
// String으로 받아옴
```
:collision: 이때 IllegalArgumentException을 발생시켜야 하는 경우
- [x] 3자리 수가 아닐 때
  (ex. 1, 23, 19847)
- [x] 숫자가 아닌 다른 문자가 들어갈 때
  (ex. "메롱", "$#*")
- [x] 중복 수가 존재할 때
  
  
3️⃣ 입력받은 수 관리 방법
<br>

:collision: 정상적으로 세자리 수를 입력받은 경우
- [x] String으로 받아온 숫자를 Integer형 리스트로 변환 + return
```(java)
Character.getNumericValue(문자열.인덱스 안의 값) 
// 문자열 인덱스 하나의 char 값을 integer로 바꿔 리스트에 넣어줌  
```

4️⃣ 두 수의 비교를 통한 ball / strike 판별
<br>

:zap: ball은 두 리스트에서 겹치는 수의 개수이고, strike는 그 중 인덱스까지 겹치는 개수!
<br>
:zap: 이때 strike의 개수만큼 ball 개수에서 빼주어야 함
<br>
:zap: 두 개의 결과값은 리스트로 저장해 다음 단계에서 쓰이도록 한다
<br>
- [x] ball 개수를 구한다
```(java)
if(list.contains(입력수의 인덱스))
// for문을 이용해 contain 함수를 통해 랜덤 숫자에 포함되는 인덱스의 개수를 찾는다   
```
:collision: 이 때 ballNumber = 0 이면
- [x] <em>'낫싱'<em> 을 출력!

- [x] 생성된 함수에 두 리스트(랜덤수, 입력수)를 인자로 받아와 for문(길이 3)을 실행
<br> 여기서 인덱스 값끼리 같을 때 strike 값에 1씩 더해줌, ball 개수는 빼줌

5️⃣ 결과 출력 (ex. 1볼, 낫싱, 게임 종료 후 재시작/ 완전히 종료)
<br>

:collision: 아직 숫자를 맞추지 못해 힌트를 얻은 경우

- [x] (4)번에서 얻은 결과로 출력
```(java)
String announce~~ = "";
announce += 볼개수 + "볼"; // 이런식으로 문자열에 더해주어
System.out.println(announce~~) // 출력
```

:collision: 숫자 맞춘 후
<br>
- [x] 아래의 과정 수행
1. Console의 readline함수를 통해 수를 입력받음
2. 1은 재시작(6번에서 계속), 2는 경우에 포함시키지 않아 그대로 종료되도록함
3. 1, 2 이외의 문자/숫자가 들어오면 IllegalArgumentException 발생!!

6️⃣ 재시작에 의한 게임의 반복 구현
<br>
- [x] (5)번에서 readline을 통해 받은 수를 이용!
```(java)
if (1번 받아오면) {
다시 게임을 시작
} 
if (1번도 2번도 x) {
IllegalArgumentException 발생
}
```

### \(@^0^@)/ 기능 구현 순서
application 클래스에 함수 작성 -> 관련 테스트 실시 -> (필요시 리팩토링) -> 클래스 분리 -> 리팩토링

<br>

### \(@^0^@)/ 리팩토링 시 집중해서 읽어야 하는 부분
1. 변수명을 더 직관적으로 지을 수 있나 고민해보기
2. 함수 길이를 줄이면서 더 가독성/효율성 있는 코드를 작성할 수 있나 생각해보기
3. 구현이 어려웠던 기능 중 자바 라이브러리에 존재하는 기능이 있나 살펴보기

<br>

### \(@^0^@)/ 커밋 컨벤션
1. feat: 함수의 기능 구현
2. fix: 기능 수정(무언가 오류 발생했을 시에)
3. refactor: 변수명 수정, ..
4. docs: 리드미 수정
5. test: 테스트 코드 작성