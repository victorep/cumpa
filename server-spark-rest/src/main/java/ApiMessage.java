public class ApiMessage {
    private String message;
    private int error;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public ApiMessage(String message, int error) {
        this.message = message;
        this.error = error;
    }

    public ApiMessage(String message) {
        this.message = message;
    }
}
