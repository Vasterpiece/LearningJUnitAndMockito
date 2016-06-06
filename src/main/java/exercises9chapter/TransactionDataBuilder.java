package exercises9chapter;

public class TransactionDataBuilder {
    private String state;
    public TransactionDataBuilder processingTransaction(){
        state = "PROCESSING!";
        return this;
    }

    public TransactionDataBuilder cancelledTransaction(){
        state = "CANCELLED!";
        return this;
    }

    public TransactionDataBuilder transactionWithError(){
        state = "ERROR!";
        return this;
    }

    public TransactionDataBuilder successfulTransaction(){
        state = "OK!";
        return this;
    }

    public Transaction build(){
        Transaction transaction = new Transaction();
        transaction.setState(state);
        return transaction;
    }
}
