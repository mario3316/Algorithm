# Algorithm

---

### TODO

- 프로그래머스 1단계, 2단계, 3단계
- BOJ 2564 풀기

---

### Study Flow

- **_Implementation_**
- Greedy
- BFS/DFS
- DP
- Hash

---

### 문제 풀이

- Programmers

  - Lv.1

- BOJ

  - ~~2564 경비원~~
  - ~~17478 재귀함수가뭔가요~~

- SW Expert
  - ~~1289 원재의 메모리 복구하기~~

---

### 새롭게 익힌 사실

- 2021/01/19 JAVA

  - ArrayList<Integer> my_list = new ArrayList<Integer>();
    (Wrapper 클래스로 선언)

    - my_list.add(8) : 삽입
    - my_list.remove(7) : 삭제
    - my_list.clear() : 전체 삭제
    - my_list.size() : 크기 구하기
    - 반복문 for(Integer : my_list) 로 반복
    - Iterator iter = my_list.iterator();
      while(iter.hasNext()) 로 반복

  - 문자열을 숫자로 변환

    - Integer.parseInt(myString)

  - 배열 Sort
    - Arrays.sort(arr) : 오름차순 정렬
    - Arrays.sort(arr, Collections.reverseOrder()) : 내림차순 정렬

- 2021/01/20

  - System.currentTimeMills()

    - 1970.1.1부터 경과한 시간을 밀리초로 반환

  - 배열 API

    - Arrays.toString(arr) : 배열을 스트링형태로 바꿔줌
    - 깊은 복사
      - int[] new_arr = arr.clone();
      - System.arraycopy(src, srcPos, dst, dstPos, length);

  - 4방, 8방 탐색

    - 4방 // 상 부터 시계 방향
      - int[] dr = {-1, 0, 1, 0}
      - int[] dc = { 0, 1, 0, -1}
    - 8방 // 상 부터 시계 방향
      - int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }
      - int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 }

  - 자바 코딩테스트 입력받을 때

    1. Scanner

       - Scanner sc = new Scanner(System.in);
       - T = sc.nextInt();
       - for문 안에서 String line = sc.next(); String[] bc = line.split(" ");

    2. BufferedReader

    - BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    - StringTokenizer st = null;
    - T = Integer.parseInt(br.readLine());
    - for문 안에서 st = new StringTokenizer(br.readLine());
    - 한 문장에 여러 정수 입력받을때
      - num[i] = Integer.parseInt(st.nextToken());
      - 정수 개수 모를때
        - for(int i=0; st.hasMoreTokens(); i++)

- 2021/01/21

  - String에 대해서

    - String 끼리 비교할때는 == 이 아닌 equals 로 비교할것 ( Reference Type )
      - String s1 = "hello";
      - String s2 = "hello";
      - String s3 = new String("hello");
      - s1 == s2 : true // s1과 s2는 같은 "hello" 주소를 참조함
      - s2 == s3 : false // new로 생성된 hello는 무조건 따로 Allocation
      - s2.equals(s3) : true // String의 내용만을 비교하려면 equals 사용
    - String + 다른타입은 모두 String이 됨
    - String을 char로 바꾸는 메소드 : charAt( )
    - String을 char [] 로 바꾸는 메소드 toCharArray( )
    - String Concat
      - - 이용
      - String Builder 이용
        - StringBuilder sb = new StringBuilder("");
        - String[] strArray = {"hello", ", " , "world"};
        - sb.setLength(0);
        - for( String s: strArray)
          - sb.append(s);

  - Encapsulation

    - private ( private < default < public )
    - package
    - Interface
      - 정의만 해놓은 껍데기
      - Implements로 구현함

  - Inheritance

    - 자식이 생성될때 부모가 생성됨(heap)
      - super()를 이용해서 부모의 생성자도 호출됨
    - 자식의 설계도가 올라가려면 부모가 먼저 올라가야 함
    - 생성된 주소는 부모의 주소 (heap)
    - 설계도에 공개된 메소드만 사용할 수 있다

  - Object 4개 메소드 ( Object class는 자동으로 상속 )

    - hashCode( ) : 두 객체가 같은 객체인지 확인 ( hashCode로 비교 )
    - toString( ): 객체의 값들을 문자열로 만들어 return
    - equals( ) : 내용이 같아도 hash code가 달라서 모든 reference type은 false가 기본인데 String만 예외
    - getClass( ) : 객체가 참조하고 있는 class를 return
    - 위 4개 Method는 Overriding할 수 있음

  - Getter와 Setter를 사용해야하는 이유

    - 처리 로직이 변경되는 경우 그에 쉽게 대응할 수 있다

  - Java 문자열 정렬

    - String을 String[] strArr = str.split("") 으로 잘라서 배열로 만듬
    - Arrays.sort(strArr) 로 정렬
    - String.join("", strArr)로 합치기

  - Java 배열 내림차순 정렬
    - Arrays.sort(array, Collections.reverseOrder());

- 2021/01/22

  - Polymorphism

    - 부타자생 : 부모 타입으로 자식을 생성
    - 부타자참 : 부모 타입으로 자식을 참조
    - 부메자호: 부모 메소드로 자식을 호출 (Overriding)
    - A가 부모이고 B가 자식일때
      - A a = new B();
        - 자식을 부모의 타입으로 생성할 수 있음
        - 이때 같은 메소드가 자식에게도 있다면 그 메소드를 호출할시 자식의 메소드가 호출 됨

  - 2021/01/24

    - char Array to String

      - String str = new String(charArray);
      - StringBuilder sb = new StringBuilder();
        for(char ch: charArray)
        sb.append(ch);
        String str = sb.toString();

    - char 대문자 / 소문자
      - Character.toUpperCase('a');
      - Character.toLowerCase('A');
      - 혹은 아스키코드 97 - 65 차이를 이용해 변환

  - 2021/01/25

    - default vs protected

      - default
        - 동일 패키지에서 접근 가능
        - 자식 클래스에서 접근 불가능
      - protected
        - 동일 패키지에서 접근 가능
        - 자식 클래스에서 접근 가능 ( 상속 o )
      - 하위 클래스에서 직접 접근하려면 protected나 public으로 선언해야 함

    - this / super

      - 자식 클래스에서 this를 썼는데 해당 변수가 없으면 부모 클래스의 멤버에서 찾는다
      - 하지만 부모 멤버를 올바르게 접근하는 것은 super 키워드

    - 모든 Class 들은 기본적으로 java.lang.Object를 상속받는다 (extends Object 생략)
    - this() 는 이미 있는 생성자를 의미

    - Singletone

      - 생성자를 private으로 선언
      - 자기 객체를 private static으로 선언한 후 public static getInstance 메소드로 이 객체를 반환

      ```
      private static BookManager manager = new BookManager();

      private BookManager() {
        super();
        books = new Book[MAX_SIZE];
      }

      public static BookManager getInstance() {
        return manager;
      }
      ```

    - Char 대/소문자 확인

      - Character.isUpperCase(c);
      - Character.isLowerCase(c);
      - return type : boolean

    - Char을 null로 초기화 하려면 Char c = 0;
      - Char c = null / Char c = '' 불가능

  - 2021/01/26

    - 다형성 Polymorphism

      - Type과 Method로 크게 나누어서 생각할 수 있음
      - Method는 Overloading 과 Overriding으로 나뉨

        - Overloading : name이 같아도 parameter가 다름
        - Overriding : 부모 Class 의 메소드를 자식 Class에서 재정의함

      - 부모의 Type으로 자식 Type의 객체를 Reference 할 수 있다.
      - Phone p = new Samsung( );

        - p.toString(); // 부모 타입으로 자식을 생성하면 자식에서 Overriding한 메소드만 호출 가능
        - p.showInfo( ); // 자식에만 있는 멤버 변수나 메소드는 접근 불가능

          → 재정의 (Overriding) 된 자식에 대해서만 부모 타입으로 변수를 선언하고 자식의 재정의된 메소드를 호출할 수 있다.

          Object x = new Corona();

          → Object 는 호출 범위

          → Corona는 호출 대상

          → 즉, Object가 같고있는 것에 한해서만 Corona에서 호출

      - Overloading 한 메소드는 서로 다른 메소드가 됨

        - C의 a는 A의 a와 서로 다른 메소드
        - C의 b는 B의 b와 서로 다른 메소드

        → Overloading 된것은 아예 다른 메소드로 생각

      - Overriding 관계

        - D의 b 는 B의 b 를 Overriding
        - E의 b 는 D 의 b를 Overriding

        → Overriding을 하지 않으면? 기본적으로 상속받아 가지고 있는 메소드

      - @Overriding Annotation

        - 특정 Method를 재정의 하겠다고 컴파일러에게 명시하는 것
        - 만약 부모 클래스에 해당 Method가 없으면 Compile 오류

    - Interface

      - Method의 추상화
      - 어떤 Class에 기능적인 요소를 추가하고 싶을때 사용
      - 선언부만 기술하고 구현부는 없음
      - default method : 구현하지 않아도 바로 사용할수 있는 메소
      - Method의 access modifier 를 생략하면 기본적으로 public이 된다
      - Interface에서 변수를 선언하면 public static final 로 상수를 선언한것과 같다.

    - 추상 Class

      - abstract keyword
      - 추상 method가 하나라도 있으면 추상 Class
      - 추상 클래스더라도 반드시 추상 Method가 있는것은 아님 ( 없을 수도 있는데 이 때 abstract class 의 용도는 상속 강요 )
      - 모든 Method가 abstract이면 Interface와 같다

    - 추상 Method

      - Body가 없는 Method
      - public void say(){ } ⇒ public abstract void say( )

    - Adapter

      - 인터페이스가 많아서 직접 모두 구현하는 부담을 덜기위해 추상 Class로 중간 단계를 구현
      - Adapter에서는 Interface에서 구현하고자 하는 메소드를 구현하고 구현 안하는 메소드는 abstract로 남겨둠
      - 원래 Interface를 Implement 해야하는 클래스에서 이 Adapter를 상속받아 사용

    - instanceof

      - 참조될수 있는 Type인지 확인하고 결과를 boolean으로 return 함

    - Inner Class

      - 클래스 내부에 생성한 클래스
      - 멤버 변수의 하나 처럼 클래스를 정의할 수 있다
      - 클래스 내부에서 new로 생성하고 사용

    - Anonymous Class

      - 이름이 없이 만들어지는 inner Class
      - 이름이 없으므로 재사용되지 않고 한번만 사용됨

      af.setFolder(new Folder() {

      @Override
      public void fold() {
      System.out.println("Anonymous-fold");
      }

      @Override
      public void open() {
      System.out.println("Anonymous-open");
      }

      });

    - final class

      - 자식을 더이상 생성하지 못함

    - static Block

      - 처음 Instance가 만들어질때(Heap에 올라갈 때) 단 한번만 실행되는 코드

    - contains( )
      - 특정 문자열을 포함하는지 판별
      - book.contains(title)
      - return type : boolean

  - 2021/01/27

    - Collection

      - 자료를 구조적으로 정리한 Interface
      - Set, List, Map
        - Set : 집합 (중복 불가능), 순서가 없고 중복이 없는 자료구조
          - HashSet, TreeSet
          - Tree Set만 사전으로 정렬됨
      - List: 순서가 있는 자료 구조
        - Array List
        - Linked List ( Queue )

    - Final
      - Final Class : 상속 불가능
      - Final Method : Overriding 불가능

  - 2021/01/28

    - Generic < >

      - Type을 Dynamic하게 지정할 수 있는 방법을 제공
      - 모든 타입들을 전부 코드를 만드는 시점(.java 파일 생성) 에 다 받아들일수 있는 일반화된 타입

      ```
      public class GenericContainer<T> {
      private T obj;

      public GenericContainer(){}

      public T getObj() { return obj; }

      public void setObj(T t) { obj = t; }

      }
      ```

    - Collections API

      - List (순서 o 중복 o)
        - LinkedList
        - Stack
        - ArrayList
      - Set (순서 x 중복x)
        - HashSet
        - TreeSet
      - Queue (순서 o 중복 o)
        - LinkedList
        - PriorityQueue
      - Map (Key-Value 쌍, 순서 x, Key중복x, Value중복 o)
        - HashTable
        - HashMap
        - TreeMap

    - iterator

      - Collection을 순회하기 위한 interface
      - hasNext() : 다음이 있으면 true, 없으면 false
      - next(): 다음 요소를 return

        Iterator<Patient> itr = patientList.iterator();
        while(itr.hasNext()){
        Patient p = itr.next();
        System.out.println(p);
        }

    - PriorityQueue

      - 정렬을 하는 기준인 Comparable Interface를 구현해야 함

        - CompareTo( ) : 우선순위 비교 메소드
        - public Class Corona implements Comparable<Corona>
        - @Override

          public int compareTo(Corona c) {

          return this.spreadSpeed - c.spreadSpeed;

          }

        - Comparable Interface를 상속받은 다음에 compareTo 메소드를 오버라이딩 해야 함
        - offer() : 요소 추가
        - poll(): 맨 앞 요소를 뽑아서 반환 ( Queue에서는 제거 됨)
        - peek(): 맨 앞 요소를 반환 ( Queue에는 남아있음 )

    - Comparable<T>

      - Priority queue에 사용하는 비교 인터페이스
      - 클래스 내부에 compareTo() 함수를 구현한다

    - Comparator<T>

      - compare( ) 함수 구현

        ```
        public int compare(int p1, int p2) {
          if (p1 > p2) {
            return 1; // 1은 뒤집음 (즉, 큰게 뒤로 (오름차순))
          } else if (p1 < p2) {
            return -1; // -1이면 그대로
          } else
            return 0;
        }
        ```

      - ArrayList 정렬하기 (feat. Anonymous Class)

        - Collections.sort( list, new Comparator<Integer>( ) {

          public int compare(int p1, int p2) {

          return p1 - p2; // 반대로 하면 내림차순

          }

          }

    - Error vs Exception

      - Error : System Level , StackOverflowError

        코드나 환경적인 문제

      - Exception : App level, IOException

    - Exception

      - RuntimeException : 실행시 발생되므로 예측할수 없음
        - ex ) NullPointer, ArrayIndexOutOfBounds
      - Other Exceptions : 예측 가능하므로 코드 작성시 처리
        - ex) IOException, SQLException

    - Exception 처리

      - try-catch-finally
        - try : Exception이 발생할수 있는 코드
        - catch(A e) : Exception 발생시 실행하는 코드
        - finally : Exception이 발생하든 안하든 반드시 실행되는 코드
      - throws
        - 나를 호출한 메소드에서 처리하도록 책임을 피함
      - try-catch-throw
        - 나도 처리하고 호출한 곳에서도 처리하고

    - 배열 List로 변환

      - List<Integer> list = Arrays.asList(arr);

    - List 거꾸로 뒤집기
      - Collections.reverse(list);

  - 2021/01/29

    - String 객체 vs String 리터럴

      - String 객체
        - String str = new String("hello");
        - 객체로 생성하면 Heap 영역에 생성됨
      - String 리터럴
        - String str = "hello";
        - 리터럴로 생성하면 String Constance Pool 영역에 생성됨
        - String str2 = "hello";
          str == str3 : true
        - 문자열이 같은 String 리터럴은 서로 같다 ( 둘다 같은 pool을 참조함)

    - Collections

      - Set / List
        - add 로 추가
          - add(a) : 맨뒤에 추가
          - add(0,b) : 0번째에 추가후 나머지를 뒤로 밀음
          - set(0,c) : 0번째에 덮어쓰기
          - remove(인덱스), remove(객체) : 요소 제거
          - get(인덱스): i번째 요소 확인
      - Map
        - put(key,value) : 추가
        - get(key) : key에 해당하는 value 확인
        - remove(key) : key value 삭제

    - ArrayList to Array
      - ArrayList<Integer> list = new ArrayList<>();
      - int[] arr = list.toArray();

  - 2021/01/31
    - char -> int
      - Character.getNumericValue('1');
