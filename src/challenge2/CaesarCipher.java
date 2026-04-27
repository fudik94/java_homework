package challenge2;

public class CaesarCipher {

    public static String encrypt(String text, int shift) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + shift) % 26 + base);
            }

            result += ch;
        }

        return result;
    }

    public static String encrypt(String text) {
        return encrypt(text, 3);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("Hello", 5));
        System.out.println(encrypt("Hello"));
    }
}