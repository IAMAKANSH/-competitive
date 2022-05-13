package freelancer;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Boolean result = checkHistory(str);
        System.out.println("Result is " + result);
    }

    private static Boolean checkHistory(String str) {
        if (str == null) {
            return false;
        }
        int k = 2;
        int accidentCount = 0;
        Boolean consecutiveTicket = false;
        for (int i = 0; i < str.length(); i++) {
            char accident = str.charAt(i);
            if ((i + k) < str.length()) {
                if (str.charAt(i) == 'T' && str.charAt(i + 1) == 'T' && str.charAt(i + 2) == 'T') {
                    consecutiveTicket = true;
                }
            }
            if (accident == 'A') {
                accidentCount++;
            }

        }
        if (accidentCount < 2 && !consecutiveTicket) {
            return true;
        }
        return false;
    }
}
