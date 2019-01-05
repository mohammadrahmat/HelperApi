package models;

public class ServiceResult {

    private boolean hasException;
    private String exceptionMessage;

    public ServiceResult(boolean flag, String message) {
        hasException = flag;
        exceptionMessage = message;
    }

    public boolean getExceptionStatus() {
        return hasException;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionStatus(boolean flag) {
        hasException = flag;
    }

    public void setExceptionMessage(String message) {
        if (!hasException) {
            exceptionMessage = message;
        }
    }
}
