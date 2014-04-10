package framework;

public class RequestCount {

    private final long count;

    protected RequestCount(final long value) {
        count = value;
    }

    public long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "req-" + Long.toString(count);
    }

}
