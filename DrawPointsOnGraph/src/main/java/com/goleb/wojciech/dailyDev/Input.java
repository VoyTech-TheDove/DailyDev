package com.goleb.wojciech;

import java.util.Scanner;

public class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getIntFromUser() {
        return getIntFromString(getStringFromUser());
    }

    public static int getIntFromString(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input");
            return 0;
        }
    }

    public static String getStringFromUser() {
        return SCANNER.nextLine();
    }
}
