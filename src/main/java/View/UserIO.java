package View;

public interface UserIO {

    void print(String msg);

    double readDouble(String prompt);
    double readDoublePositive(String prompt);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    String readString(String prompt);
}
