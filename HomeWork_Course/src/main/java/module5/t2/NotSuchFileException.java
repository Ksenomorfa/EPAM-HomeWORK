package module5.t2;

public class NotSuchFileException extends Throwable {
    String file;

    public NotSuchFileException(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "NotSuchFileException{" + "file = '" + file + '\'' + '}';
    }
}
