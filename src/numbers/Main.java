package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        int inputNumber;
        System.out.println("Enter a natural number:");
        if (!(input = sc.nextLine()).matches("\\d*") || (inputNumber = Integer.parseInt(input)) < 1) {
            System.out.println("This number is not natural!");
            return;
        }
        checkPropertiesOfNumber(inputNumber);
    }

    public static boolean checkParityOfNumber(int n) {
        boolean parity = (n % 10) % 2 == 0;
        System.out.println("This number is %s.".formatted(parity ? "Even" : "Odd"));
        return parity;
    }

    public static boolean checkBuzzinessOfNumber(int n) {
        boolean lastIs7;
        boolean isDivBy7;
        int lastDig;
        int tempN = n;
        int firstLastDig = n % 10;
        do {
            lastDig = tempN % 10;
            tempN = (tempN / 10) - 2 * lastDig;
        } while (tempN >= 2 * (lastDig));
        lastIs7 = firstLastDig == 7;
        isDivBy7 = tempN % 7 == 0;
        if (isDivBy7 || lastIs7) {
            System.out.println(
                    "It is a Buzz number.\nExplanation:\n%d%s%s%s"
                            .formatted(
                                    n,
                                    isDivBy7 ? " is divisible by 7" : "",
                                    lastIs7 && isDivBy7 ? " and " : ".",
                                    lastIs7 ? "ends with 7." : "."));
        } else {
            System.out.println(
                    "It is not a Buzz number.\nExplanation:\n%d%s"
                            .formatted(
                                    n,
                                    " is neither divisible by 7 nor does it end with 7."));
        }
        return isDivBy7 || lastIs7;
    }

    public static void checkPropertiesOfNumber(int n) {
        checkParityOfNumber(n);
        checkBuzzinessOfNumber(n);
    }
}
