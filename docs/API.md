# API 분석

# Console.java

# 관련 메소드

### Scanner()
    private static Scanner scanner;
    
    - 숫자, 문자 등의 기본적인 입력을 받기 위한 클래스

### readLine(), getInstance()
    public static String readLine() {
        return getInstance().nextLine();
    }

    private static Scanner getInstance() {
        if (Objects.isNull(scanner) || isClosed()) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }    
    
    - 기본적인 입력을 받고, getInstance()에서 Scanner가 Null값이거나, 닫혀 있는 경우 새로운 Scanner를 정의한다.

### isClosed()

    private static boolean isClosed() {
        try {
            final Field sourceClosedField = Scanner.class.getDeclaredField("sourceClosed");
            sourceClosedField.setAccessible(true);
            return sourceClosedField.getBoolean(scanner);
        } catch (final Exception e) {
            System.out.println("unable to determine if the scanner is closed.");
        }
        return true;
    }
    
    - getDeclaredField : Field(전역변수, 지역변수) object를 반환
    - sourceClosed : source가 다 끝났는지를 확인하기 위한 변수
    - setAccessible : 접근이 가능하도록 설정

### Console.java 가 사용되는 이유
-> nextLine()만 사용하게 하기위한 목적이라고 생각한다.


# Random.java

### defaultRandom

    private static final Random defaultRandom = ThreadLocalRandom.current();

    - ThreadLocalRandom : 현재 thread에 고립된 random number 생성기
    - current() : 현재 thread의 random number 생성기를 반환함
### pickNumberInList, validateNumbers, pickNumberInRange 

    public static int pickNumberInList(final List<Integer> numbers) {
    validateNumbers(numbers);
    return numbers.get(pickNumberInRange(0, numbers.size() - 1));
    }

    private static void validateNumbers(final List<Integer> numbers) {
    if (numbers.isEmpty()) {
    throw new IllegalArgumentException("numbers cannot be empty.");
    }
    }

    public static int pickNumberInRange(final int startInclusive, final int endInclusive) {
    validateRange(startInclusive, endInclusive);
    return startInclusive + defaultRandom.nextInt(endInclusive - startInclusive + 1);
    }

    private static void validateRange(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (endInclusive == Integer.MAX_VALUE) {
            throw new IllegalArgumentException("endInclusive cannot be greater than Integer.MAX_VALUE.");
        }
        if (endInclusive - startInclusive >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("the input range is too large.");
        }
    }

    - validataNumbers : List가 비어있으면 exception 발생시킴
    - pickNumberInRange : 시작점과 끝점을 설정해 validateRange로 유효한지 확인 후, ThreadLocalRandom으로 난수 생성

### validateRange, validateCount
    - validateRange : 시작점과 끝점을 비교해 (시작점 > 끝점),(끝점 == Integer의 최대값),(끝점과 시작점의 차이가 Integer의 최대값보다 큰 경우) exception 반환
    - validateCount : count가 유효한지, 끝점과 시작점의 차이가 count보다 작은지 확인 후 아니면 exception 발생

### shuffle
    
    public static <T> List<T> shuffle(final List<T> list) {
        final List<T> result = new ArrayList<>(list);
        Collections.shuffle(result);
        return result;
    }
    
    - list에 저장된 값을 섞음


### pickUniqueNumbersInRange
    public static List<Integer> pickUniqueNumbersInRange(
        final int startInclusive,
        final int endInclusive,
        final int count
    ) {
        validateRange(startInclusive, endInclusive);
        validateCount(startInclusive, endInclusive, count);
        final List<Integer> numbers = new ArrayList<>();
        for (int i = startInclusive; i <= endInclusive; i++) {
            numbers.add(i);
        }
        return shuffle(numbers).subList(0, count);
    }

    - validateRange로 시작, 끝 검증
    - validataCount로 count 검증
    - shuffle로 값을 섞고 subList로 List의 0부터 count까지 반환

### Random.java 가 사용되는 이유
-> 이를 통해 random 숫자를 편리하게 뽑을 수 있다.
