package cashregister;

public class FakePurchase extends Purchase {
    private Item[] items;
    private String result=new String();
    public FakePurchase(Item[] items) {
        super(items);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String asString() {

        setResult("TEST");
        return result;
    }


}
