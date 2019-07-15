package cashregister;

public class FakePrinter extends Printer {
    private boolean isCalled=false;
    private String message;
    public boolean isCalled() {
        return isCalled;
    }
    public void print(String printThis) {
        isCalled=true;
        this.message=printThis;
    }
    public String printString(){
        return message;
    }
    

}
