# 숫자 야구 게임

## 기능 목록

- [ ] 1부터 9까지의 서로 다른 임의의 수 3개를 생성한다. - NumberGenerator#createRandomNumbers()
- [ ] 컴퓨터의 수(3자리)와 플레이어의 수(3자리)를 비교할 수 있다. - Refree#compare()
  - [ ] 몇 개의 숫자가 같은지를 알 수 있다. - Judgement#correctCount()
  - [ ] 특정 자리에 특정 숫자가 있는지 알 수 있다. - Judgement#hasPlace()
     - [ ] 같은 수가 다른 자리에 있으면 볼이다.
     - [ ] 같은 수가 같은 자리에 있으면 스트라이크이다.
     - [ ] 같은 수가 전혀 없으면 낫싱이다.