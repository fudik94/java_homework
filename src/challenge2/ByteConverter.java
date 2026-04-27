package challenge2;

public class ByteConverter {

    public static void printBytes(long bytes) {

        double kb = bytes / 1024.0;
        double mb = kb / 1024.0;
        double gb = mb / 1024.0;
        double tb = gb / 1024.0;

        System.out.println(bytes + " bytes = " +
                kb + " KB, " +
                mb + " MB, " +
                gb + " GB, " +
                tb + " TB");
    }

    public static void main(String[] args) {
        printBytes(1024);
        printBytes(1048576);
    }
}