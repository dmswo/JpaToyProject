package study.toyProject.common;

public enum ResultCodeStatus {
    OK(200, "OK"),
    SERVER_ERROR(500, "서버오류");

    private final int value;
    private final String reasonPhrase;


    ResultCodeStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return value;
    }

    public String reasonPhrase() {
        return reasonPhrase;
    }
}
