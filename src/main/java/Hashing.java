import java.util.ArrayList;
import java.util.List;

public class Hashing {

    public static List<String> search(String source, String pattern) {
        List<String> found = new ArrayList<>();

        if (source.length() < pattern.length()) {
            found.add("Такой подстроки точно нет!");
            return found;
        }

        int pattern_hash = calculateHash(pattern);
        int asterisk_position = pattern.indexOf('*');
        int window_hash = 0;

        for (int start = 0; start < (source.length() - pattern.length() + 1); start++) {
            if (start == 0) {
                window_hash = calculateHash(source.substring(start, start + pattern.length()));
                window_hash -= source.charAt(asterisk_position);
            } else {
                window_hash -= source.charAt(start - 1);
                window_hash += source.charAt(start + pattern.length() - 1);
                window_hash += source.charAt(start + asterisk_position - 1);
                window_hash -= source.charAt(start + asterisk_position);
            }

            if (window_hash == pattern_hash) {
                boolean isMatch = true;
                for (int i = 0; i < pattern.length(); i++) {
                    if (pattern.charAt(i) != '*' && source.charAt(start + i) != pattern.charAt(i)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    found.add(String.valueOf(start));
                }
            }
        }
        return found;
    }

    public static int calculateHash(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                continue;
            }
            hash += str.charAt(i);
        }
        return hash;
    }
}
