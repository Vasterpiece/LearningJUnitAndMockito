package chapter6;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Collection;

public class Request {
    public Collection<Task> getTasks() {
        return new ArrayList<Task>();
    }
}
