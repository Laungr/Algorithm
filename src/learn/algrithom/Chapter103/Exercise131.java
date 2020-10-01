package learn.algrithom.Chapter103;

public class Exercise131 {

    public static void main(String[] args) {
        FixedCapacityStack<String> stack = new FixedCapacityStack<>(1);
        stack.push("s");
        stack.push("a");
        System.out.println("stack满了 "+stack.isFull());

    }

    public static class FixedCapacityStack<T>{
        private T[] a;
        private int N;//长度


        public FixedCapacityStack(int cap) {
            //a = new T[cap];//创建泛型数组在Java中不被允许
            a = (T[]) new Object[cap];//类型转换
        }

        public boolean isEmpty(){
            return N==0;
        }

        public int size(){
            return N;
        }

        public void push(T t){
            a[N++] = t;
        }
        public T pop(){
            return a[--N];
        }

        public boolean isFull(){
            return a.length == N;

        }

        public T peek(){
            return a[N];
        }

    }

}
