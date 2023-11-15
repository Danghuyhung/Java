package lab05.java_technology.utils;

public class FlashMessage {
    private final String message;
    private final String type;

    public FlashMessage(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }
}
