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

    public boolean Fibonacci(){ //nu cred ca mere bine
        int a = 0, b = 1;
        while (a + b <= x2) {
            int c = a + b;
            if (b == x1 && c == x2) {
                return true;
            }
            a = b;
            b = c;
        }
        return false;
    }

    public int cmmmc(){
        return(x1 * x2) / findCMMDRecursiv(x1,x2);
    }

    public int findCMMDRecursiv(int x1, int x2){
        if(x2 == 0){
            return x1;
        }
        else{
          return findCMMDRecursiv(x2, x1 % x2);
        }
    }

    public boolean sumaCifreEgala(){
        int aux1 = x1;
        int aux2 = x2;
        int sum1 = 0;
        int sum2 = 0;

        while(aux1 != 0){
            sum1 += aux1 % 10;
            aux1 /= 10;
        }
        while(aux2 != 0){
            sum2 += aux2 % 10;
            aux2 /= 10;
        }
        return sum1 == sum2;
    }

    public boolean validareCifrePare(){
        return sumaCifrePare(x1) == sumaCifrePare(x2);
    }
    public int sumaCifrePare(int x){
        int counter = 0;
        while(x != 0){
            if(x % 10 % 2 == 0)
                counter++;
            x /= 10;
        }
        return counter;
    }
}
