package P2;

public class PerecheNumere {
    private int x1;
    private int x2;

    public PerecheNumere() {
    }

    public PerecheNumere(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                '}';
    }

    public boolean Fibonacci(){
        if(Math.abs(x1 - x2) != 1){
            return false;
        }
        int a = Math.min(x1,x2);
        int b = Math.max(x1,x2);

        int fib1= 0;
        int fib2= 1;

        while(fib2 < b){
            int next = fib1 + fib2;
            fib1 = fib2;
            fib2 = next;

            if(fib2 == b){
                return fib1 == a;
            }
        }
        return false;
    }
}
