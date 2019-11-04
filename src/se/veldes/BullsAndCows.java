package se.veldes;

public class BullsAndCows {

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("11", "10"));
    }

    public String getHint(String secret, String guess) {

        int[] freq = new int[10]; // Assumes only digits

        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        char[] noMatch = new char[guessChars.length];

        for (int i = 0; i < secretChars.length; i++) {
            freq[secretChars[i] - 48]++;
        }

        int bC = 0;
        int cC = 0;

        for (int i = 0; i < guessChars.length; i++) {
            if (secretChars[i] == guessChars[i]) {
                bC++;
                freq[guessChars[i] - 48]--;
            } else {
                noMatch[i] = guessChars[i];
            }
        }

        for (int i = 0; i < noMatch.length; i++) {
            if (noMatch[i] > 0 && freq[noMatch[i] - 48] > 0) {
                cC++;
                freq[noMatch[i] - 48]--;
            }
        }


        StringBuilder sb = new StringBuilder();
        return sb.append(bC).append("A").append(cC).append("B").toString();

    }
}
