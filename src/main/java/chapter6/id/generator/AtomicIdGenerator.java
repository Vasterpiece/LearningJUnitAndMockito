package chapter6.id.generator;

public class AtomicIdGenerator implements IdGenerator {
    private static Long nextId = System.currentTimeMillis();
    public Long nextId() {
        return nextId++;
    }
}

