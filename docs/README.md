# 기능 구현 목록

### 서로 다른 수로 이루어진 3자리의 난수 생성
1 ~ 9 사이 서로 다른 난수 생성 → 길이 3만큼의 list 만들어줌
배열에 넣음 만약 생성한 난수가 배열에 없을 경우 push해서 넣어줌


- JavaScript로 구현
```js
const computer = [];

while (computer.length < 3) {
  const getRandomNumber = () => Math.floor(Math.random() * (9 - 1) + 1);
  const newNumber = getRandomNumber();

  if (computer.includes(newNumber)) {
    continue;
  }
  computer.push(newNumber);
}

```

- 테스트 코드
1. 길이가 3
2. 중복된 값이 있는지


### 유저가 제대로 값을 넣었는지 확인 (예외 처리)
1. 3자리 수인가
2. 동일한 숫자가 들어갔는가 (서로 다른 3개의 글자)
3. 숫자 외 다른 문자가 들어갔는가
4. 0을 제외한 1 ~ 9 사이 숫자인가

regex로 처리하면 될듯
`[1-9]`이 3번 반복 되었는가 → [1-9]{3}


[정규표현식 — 반복찾기. 정규표현식의 가장 핵심 기능이라고 생각되는 부분이다. | by Lee MunHaeng | Medium](https://medium.com/@iamreadytocommit/%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9D-%EB%B0%98%EB%B3%B5%EC%B0%BE%EA%B8%B0-106dcd92f8e8)
[Pattern (Java Platform SE 7 )](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)

Pattern p = Pattern.compile("a*b");
Matcher m = p.matcher("aaaaab");
boolean b = m.matches();



### 스트라이크/볼/낫싱 판별
1. 맵으로 저장
- 같은 수가 같은 자리 → 스트라이크
- 같은 수가 다른 자리 → 볼
- 같은 수가 하나도 없을 경우 → 낫싱

userInput: int → arrayList 로 바꿈


2. 출력

3. 맞출 경우 true → 재시작 함수 반환
4. 틀릴 경우 HashMap 초기화 및 함수 계속 실행

- JavaScript 로 구현
```js
const getResult = (input) => {
  const result = new Map();
  const inputNumbers = [...input.toString()].map(Number);

  for (let i = 0; i < 3; i++) {
    const targetChar = inputNumbers[i];
    const compareCharIndex = computer.indexOf(targetChar);

    if (i === compareCharIndex && compareCharIndex !== -1) {
      result.set("스트라이크", (result.get("스트라이크") || 0) + 1);
    } else if (i !== compareCharIndex && compareCharIndex !== -1) {
      result.set("볼", (result.get("볼") || 0) + 1);
    } else if (compareCharIndex === -1) {
      result.set("낫싱", (result.get("낫싱") || 0) + 1);
    }
  }

  if (result.get("낫싱") === 3) {
    return "낫싱";
  }

  answer = "";
  for (const [key, value] of result) {
    if (key === "스트라이크" && value === 3) {
      return `${value} ${key}` + "\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }

    if (key && key !== "낫싱") {
      answer += `${value}${key} `;
    }
  }
  return answer;
};
```

자바에서는 해시맵 값 넣는 메서드를 따로 분리해줘야함
저장순서 보장 안됨 → 해결해야함 (ListHashMap 써서 순서대로 초기값 세팅해주면 될듯)

→ 해결: 순서대로 StringBuilder써서 append 해줌

[방법 1]
맵으로 저장한 후 리턴함
for문 하나씩 돌려서

결과를 저장하는 HashMap 저장하기
`key`: { strike, ball, nothing } String
`Value`: Integer


인덱스로 찾아서 같으면 스트라이크 아니면 볼 값으로 유지하는 값 반환, -1 일 경우 낫싱 추가
낫싱 value = 3이면 낫싱 반환


[방법 2]
int 형 볼갯수, 스트라이크 갯수 변수 2개 선언하고
비교해서 그냥 숫자 상승시키고
둘다 0 일때 낫싱 출력

방법 1이 해시테이블 key value로 처리하는게 더 unmutable하고 나은듯


⇨ 스트라이크 value 값이 3일 경우 게임 종료 리턴

#### 스트라이크 value = 3이면 종료하는 메서드 추가하기



* 이때 Java는 indexOf함수.. String만 값이 존재하지 않을 경우 -1 반환함 (그 외는 오류 던짐)

- [x] 테스트 코드 짜기





### 게임 진행
#### 1. 유저로부터 값 받아오기
- 유저가 입력한 값을 검증
  잘못된 값일 경우 `IllegalArgumentException`을 발생시키고 종료.
- 게임을 새로 시작하려면 1, 종료하려면 2를 선택

#### 2. 게임 종료 후 재시작 여부 묻기
while 문 사용,  `1`: 게임 진행 `2`: 게임 종료

#### 3. 게임 중 값을 입력 받아 값을 출력하는 함수
```
숫자를 입력해주세요 : 145
```

- 만약 잘못된 값을 입력했을 경우
```
잘못된 값을 입력했습니다! 1~9 값을 가진 중복되지 않은 3자리 숫자를 입력해주세요.
```
를 출력하고 `IllegalArgumentException`을 발생시키고 종료.

#### 4. 게임을 진행하는 함수
while문 사용, `isRightAnswer()` → 값을 맞추지 못했을 경우 false 반환, 계속 게임 진행


- 테스트코드 짜는 법
  [[Java] 단위테스트: System.out.println() 과 Scanner.in 이 들어간 코드를 어떻게 테스트할까?](https://choichumji.tistory.com/118)
  [JUnit - How to test user command line Input in Java?](https://www.logicbig.com/how-to/junit/java-test-user-command-line-input.html)


### 메인 어플리케이션에서 함수 실행
while 문 사용, 재시작 여부를 확인하고 게임 재시작/종료 결정

# 내가 이 문제를 해결하기 위해 알아야 할 것
> - [x] 클린코드 짜는 법에 대해서 더 자세히 알아보기
> - [x] 객체 지향을 지키면서 코드를 짜는 법에 대해서 더 자세히 알아보기
> - [x] 하드코딩 하지 않는 법에 대해서 알아보기 (반성: 제대로 적용 못한듯)
> - [x] 자바 문법에 더 익숙해지기
> - [x] 자바 컨벤션을 지키면서 코딩하기
> - [x] 테스트 코드 짜는 법에 대해 이해하기 (다음 주차에는 TDD와 병행해서 코드 써보기)
> - [x] 터미널 입출력하는 법에 대해 알기
> - [x] 터미널 입출력 모킹 테스트 코드 짜는 법 알기