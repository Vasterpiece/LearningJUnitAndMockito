package exercises9chapter;

public class Transaction {
    private long id;
    private String state;
    private boolean retryAllowed;
    private String message;
    private String billingId;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
