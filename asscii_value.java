import java.io.*;
class Geeks {
    public static void main(String[] args) {
        byte[] nameBytes = {
            66, 104, 117, 119, 97, 110 
        };
        String name = new String(nameBytes);
        System.out.println("Name from byte array: " + name);
        byte[] emailBytes = {
            66, 104, 117, 119, 97, 110, 46,
            107, 117, 109, 97, 114, 46,
            99, 115, 50, 56, 64,
            105, 105, 108, 109, 46,
            101, 100, 117
        };
        String email = new String(emailBytes);
        System.out.println("Email from byte array: " + email);
    }
}
