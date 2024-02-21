import java.util.List;
import java.util.stream.Collectors;

public class StringFilter {

    public List<String> filterByLength(List<String> input, int length) {
        if (input == null || length < 0) {
            throw new IllegalArgumentException("Input list cannot be null and length should be a positive number");
        }

        return input.stream()
                .filter(str -> str != null && str.length() == length)
                .collect(Collectors.toList());
    }
}