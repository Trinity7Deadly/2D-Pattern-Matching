package pattern;
// Kaelan, Graehm, Fionn, Julian

public class BruteForceMatcher implements Matcher {

    // Find pattern match
    public int[] match(int[][] pattern, int[][] text) {
        int pL = pattern.length ;
        int tL = text.length ;

        // Iterate through all options
        for (int i = 0; i <= tL - pL; i++) {
            for (int j = 0; j <= tL - pL; j++) {
                // Check if for match
                if (bruteForce(pattern, text, i, j)) {
                    return new int[]{i, j} ; // Return match position
                }
            }
        }

        return null ; // No match found
    }

    // Brute force comparison
    private boolean bruteForce(int[][] pattern, int[][] text, int i, int j) {
        int pL = pattern.length ;

        // Run through elements
        for (int a = 0; a < pL; a++) {
            for (int b = 0; b < pL; b++) {
                // Compare each element
                if (pattern[a][b] != text[a + i][b + j]) {
                    return false ; // If not a match
                }
            }
        }
        return true ; // If all match
    }
}
