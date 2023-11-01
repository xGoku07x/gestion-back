public class GeneralRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String translationKey;

    public GeneralRuntimeException(String message) {
        super(message);
    }

    public GeneralRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public GeneralRuntimeException(String message, String translationKey) {
        super(message);
        this.translationKey = translationKey;
    }

    public String getTranslationKey() {
        return translationKey;
    }
}
