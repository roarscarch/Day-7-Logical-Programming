class Fibonacci {

    public static void fib(int n) {
        int a=0,b=1,c;
        System.out.println(a);
        for(int i=0;i<n;i++){
            c=a+b;
            a=b;
            b=c;
            System.out.println(c);
        }
    }
    public static void main(String args[]){
        int n=10;
        fib(n);
    }
}