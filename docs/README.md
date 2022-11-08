# 기능 목록

### generateRandomNumbers 메소드

상대방(컴퓨터)의 수를 생성하는 메소드이고 Randoms API를 이용해서 구현한다.

반환값은 길이가 3인 String 자료형을 반환한다.

### validateUserNumbers 메소드

Console API을 통해 서로 다른 3자리의 수를 입력받은 문자열이 올바른 입력인지 검증하는 메소드이다.

이때 잘못된 값이라고 확인되면 IllegalArgumentException을 throw한다.

### getResult 메소드

상대방의 수와 플레이어가 입력한 수를 주어진 조건에 따라 비교해서,

문제에서 요구하는 출력 결과에 해당하는 문자열을 반환한다.

### manageGame 메소드

위의 메소드들을 이용해서 게임을 진행하며,

정답을 맞춘 후에 게임을 계속해서 할 것인지를 boolean 자료형으로 반환한다.

이때 잘못된 값이 입력될 때 IllegalArgumentException을 throw한다.
