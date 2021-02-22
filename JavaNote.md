### :book: Java Note

- Write Once, Run Anywhere

- JVM
  - java 를 javac로 컴파일하고 나온 Hello.class(바이트코드 or 바이너리코드) 를 실행시킨다
  - 플랫폼(OS)에 의존적이다.
- JRE
  - JAVA Runtime Environment로 자바 실행환경
  - 라이브러리들과 JVM을 포함
- JDK
  - 자바 개발도구
  - JRE와 개발을 위해 필요한 도구(javac, java) 등을 포함
- 즉, JVM < JRE < JDK

- 환경 변수 JAVA_HOME

  - bin을 포함하고 있는 상위 폴더

- CLI compile 방법

  - javac -d . HelloWorld.java
    - 패키지 이름대로 디렉토리 생성됨 ( com.ssafy 이면 /com/ssafy 파일 생성 )
  - 실행
    - java com.ssafy.HelloWorld

- Type이란 ? : Machine 의 Memory Allocation & Management
- Primitive Type : 미리 정해진 크기의 메모리 사이즈
  - boolean / byte short int long / float double / char
  - 큰 Type에서 작은 Type으로 변환시 Casting 필요
  - 작은 Type 에서 큰 Type은 자동 형변환
  - 정수형은 실수형으로 자동 형변환 (10.0)
  - Copy by value
- Reference Type : 미리 정해질수 없는 데이터, Heap에 생성

  - Copy by reference
  - String만 예외로 유일하게 Primitive Type처럼 사용

- final 예약어

  - 상수로 지정해서 값을 수정하면 Error

- Shift 연산

  - Arithmetic Shift (Sign bit 고려) >>
    - 1 << 2 : 1을 2번 left shift
    - -16 >> 2 : -16을 2번 right shift ( 왼쪽에는 Sign bit인 1로 채워짐 )
  - Logical Shift ( Sign bit 고려 x 무조건 0으로 채움) >>>

- Random 함수

  - Math.random()

    - 0이상 1미만 소수를 생성
    - 1~6 의 랜덤 수를 생성하려면
      - (int)(Math.random() \* 6) + 1

  - java.util.Random
    - java.util.Random generator = new java.util.Random();
    - generator.nextInt(6) + 1

- OOP 객체지향

  - APIE
    - Abstraction 추상성
    - Polymorphism 다형성
    - Inheritance 상속성
    - Encapsulation 캡슐화

- 메소드 Method

  - 생성자 : 리턴 없는 메소드, 메소드 중 가장 먼저 한번 호출 ( new 키워드에 의해 )
  - static이 붙으면 객체 생성을 하지않아도 사용가능한 메소드

  ***

- 배열

- char 숫자를 Int로 바꾸는 방법

  - char c = '5'
  - c - '0' =⇒ int로 5

- 입력받기
  - Scanner sc = new Scanner(System.in)
  - sc.nextLine() : 한줄 읽어옴
  - sc.nextInt(): 공백 전까지의 정수를 읽어옴
  - sc.nextDouble(): 공백전까지의 실수를 읽어옴
  - sc.next(): 공백전까지의 String을 읽어옴
    - 공백으로 구분된 char 읽기 : sc.next().charAt(0)

---

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

- 자바 메모리 구조

- Getter와 Setter를 사용해야하는 이유
  - 처리 로직이 변경되는 경우 그에 쉽게 대응할 수 있다

---

- Polymorphism
  - 부타자생 : 부모 타입으로 자식을 생성
  - 부타자참 : 부모 타입으로 자식을 참조
  - 부메자호: 부모 메소드로 자식을 호출 (Overriding)
  - A가 부모이고 B가 자식일때
    - A a = new B();
      - 자식을 부모의 타입으로 생성할 수 있음
      - 이때 같은 메소드가 자식에게도 있다면 그 메소드를 호출할시 자식의 메소드가 호출 됨

---

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

  ***

  - 다형성

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

    -

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

  ***

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

  - 객체를 Sort 하면 HashCode로 정렬되므로 의미가 없다
    - Sort 하는 기준을 잡아야 함

---

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

---

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

  - Thread 구현

    - Runnable interface 구현

    ```java
    public class CoronaRunnable implements Runnable {
      int num;

      public CoronaRunnable(int num) {
        this.num = num;
      }

      @Override
      public void run() {

        System.out.println("#" + num + " is Started");
        for( int i=0; i<10000; i++ ) {
          int j = i*100;
        }
        System.out.println(num);
      }
    }
    ```

    ```java
    public class CoronaThreadTest {

      public static void main(String[] args) {
        for( int t=0; t<1000; t++ ) {

          CoronaRunnable cr = new CoronaRunnable(t);
          Thread thread = new Thread(cr); // Runnable을 구현한 클래스로 Thread 생성
          thread.start(); // Thread 시작

        }
      }
    }
    ```

    - Thread 상속

    ```java
    public class CoronaThread extends Thread {
      int num;

      public CoronaThread(int num) {
        this.num = num;
      }

      @Override
      public void run() {

        System.out.println("#" + num + " is Started");
        for( int i=0; i< 10000; i++ ) {
          int j = i*100;
        }
        System.out.println(num);
      }
    }
    ```

    ```java
    public class CoronaThreadTest {

      public static void main(String[] args) {
        for( int t=0; t<1000; t++ ) {

          CoronaThread thread = new CoronaThread(t);
          thread.start(); // Thread 생성 필요없이 바로 시작

        }
      }
    }
    ```

    - myThread.setPriority(10);
      - 우선순위를 임의로 지정할수 있다
      - 순서가 뒤죽박죽 나오지않고 정해진 우선순위대로 실행이 된다.
    - Thread.sleep(1000);
      - 쓰레드를 1초 ( 1000ms) 동안 중지했다가 다시 실행된다.
      - InterruptException 을 catch해야한다.
    - myThread.join()
      - myThread가 종료될때까지 대기한다.
      - InterruptException 을 catch해야한다.

  - interrupt()
    - 대기풀에 있던 Thread를 깨워서 다시 Runnable 상태로 만든다.
  - yield()

    - Running 중인 쓰레드가 스스로 Runnable 상태로 가서 다른 Thread들에게 자원을 양보한다.

  - Thread 동기화 (Synchronized)

    - 지금 Thread가 공유 자원을 사용할 때 다른 Thread가 이 공유자원에 접근하지 못하게 제한해야함.
    - 동기화 방법 2가지

      - Job을 수행하는 Method 자체를 synchronized 로 만든다
        - Method 수행 전체가 방해받지 않느 단위로 만들어지기 때문에 수행하는 동안 Lock을 얻고 끝나면 Lock을 반납한다.
      - 특정 Block을 synchonized로 만든다.

        ```java
        @Override
          public void run() {

            synchronized(cell) {
              if( cell.power < 500 ) {
                try {
                  Thread.sleep(500);
                }catch(InterruptedException e) {
                  e.printStackTrace();
                }
                cell.power = cell.power + 100;
              }

              System.out.println(cell.power);
            }
          }
        ```

      - DeadLock

        - 여러 Thread가 서로 공유 자원에대한 Lock을 반납할때 까지 기다려서 움직이지 않는 상태

      - wait() - notify() - notifyAll()
        - wait()
          - 수행중에 잠시 Job을 수행할 수 없으면 wait() 으로 **Lock을 반납후** 대기 풀로 돌아갈 수 있다.
        - notify(), notifyAll()
          - 다른 Thread가 공유 자원에 대한 작업을 완료하면 다른 Thread에게 이 자원이 준비되었음을 알림
          - 대기 풀에 있던 Thread는 notify()되면 다시 Runnable 상태로 감
          - notify() 는 한개의 Thread, notifyAll() 은 모든 Thread에게 알림
