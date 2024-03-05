import org.apache.commons.codec.binary.Base64;

public class Base64Example {
    public static void main(String[] args) {
        String originalString = "Hello, World!";
        
        // Encoding
        byte[] encodedBytes = Base64.encodeBase64(originalString.getBytes());
        String encodedString = new String(encodedBytes);
        System.out.println("Encoded string: " + encodedString);
        
        // Decoding
        byte[] decodedBytes = Base64.decodeBase64(encodedString.getBytes());
        String decodedString = new String(decodedBytes);
        System.out.println("Decoded string: " + decodedString);
    }
}
