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


### 스트라이크/볼/낫싱 판별
- 같은 수가 같은 자리 → 스트라이크
- 같은 수가 다른 자리 → 볼
- 같은 수가 하나도 없을 경우 → 낫싱




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




결과 판단해주는 로직


[방법 1]
맵으로 저장한 후 리턴함
for문 하나씩 돌려서
map으로 ball, strike 값 저장

만약에 맞춰야 할 값 713
input 123
[1, 2, 3]으로 바꿈

인덱스로 찾아서 같으면 스트라이크 아니면 볼 값으로 유지하는 값 반환, -1

for i = 0 // target 1
→ indexof: 1  ( i = 0 과 1 은 같지 않으므로 볼 반환)

i = 1 // target 2
→ indexOf: = -1 (낫싱 반환)

i = 2 // target 3
→ indexof: 2 (i = 2와 index 2는 같으므로 스트라이크 반환)

결과를 저장하는 HashMap 저장하기
{ strike, ball }



[방법 2]
int 형 볼갯수, 스트라이크 갯수 변수 2개 선언하고
비교해서 그냥 숫자 상승시키고
둘다 0 일때 낫싱 출력

방법 1이 해시테이블 key value로 처리하는게 더 unmutable하고 나은듯


- 테스트 코드 짜기


#### ⇨ 스트라이크 value 값이 3일 경우 게임 종료 리턴


### 유저가 제대로 값을 넣었는지 확인 (예외 처리)
1. 3자리 수인가
2. 동일한 숫자가 들어갔는가 (서로 다른 3개의 글자)
3. 숫자 외 다른 문자가 들어갔는가
4. 0을 제외한 1 ~ 9 사이 숫자인가

regex로 처리하면 될듯
`[1-9]`

잘못된 값일 경우 `IllegalArgumentException`을 발생시키고 종료한다.

### 유저로부터 숫자 입력 받기


### 게임 종료 후 재시작 여부 묻기
게임을 새로 시작하려면 1, 종료하려면 2를 선택
- 그 외 번호, 숫자가 아닌 문자를 입력하게 되면 입력 재요청


내가 이 문제를 해결하기 위해 알아야 할 것
> - [ ] 클린코드 짜는 법에 대해서 더 자세히 알아보기
> - [ ] 객체 지향을 지키면서 코드를 짜는 법에 대해서 더 자세히 알아보기
> - [ ] 하드코딩 하지 않는 법에 대해서 알아보기
> - [ ] 자바 문법에 더 익숙해지기
> - [ ] 자바 컨벤션을 지키면서 코딩하기
