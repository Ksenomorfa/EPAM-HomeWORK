package module5.t2;

public class NotSuchValueException extends Throwable {
    String value;

    public NotSuchValueException(String detail) {
        this.value = detail;
    }

    @Override
    public String toString() {
        return "NotSuchValueException{" + "value='" + value + '\'' + '}';
    }
}
