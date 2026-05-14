package challenge4;

public class GeneratePassword {

    public static String generatePassword(int length) {
        if (length < 8) length = 8;

        String numbers = "0123456789";
        String lower   = "abcdefghijklmnopqrstuvwxyz";
        String upper   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+";
        String allChars = numbers + lower + upper + special;

        char[] password = new char[length];

        // guarantee at least one of each type
        password[0] = numbers.charAt((int) (Math.random() * numbers.length()));
        password[1] = lower.charAt((int) (Math.random() * lower.length()));
        password[2] = upper.charAt((int) (Math.random() * upper.length()));
        password[3] = special.charAt((int) (Math.random() * special.length()));

        // fill remaining positions
        for (int i = 4; i < length; i++) {
            password[i] = allChars.charAt((int) (Math.random() * allChars.length()));
        }

        // shuffle so required chars aren't always at the start
        for (int i = length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            char temp = password[i];
            password[i] = password[j];
            password[j] = temp;
        }

        return new String(password);
    }

    public static void main(String[] args) {
        System.out.println(generatePassword(10));
        System.out.println(generatePassword(5));  // min 8
        System.out.println(generatePassword(12));
    }
}
