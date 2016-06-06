package chapter6.id.generator;

public class SystemIdGenerator implements IdGenerator {
    public Long nextId() {
        return System.currentTimeMillis();
    }
}