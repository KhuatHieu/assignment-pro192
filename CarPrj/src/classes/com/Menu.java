package classes.com;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu<E> {

    public Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public void clearBuffer() {
        scanner = new Scanner(System.in);
    }

    public boolean isEmpty(String input) {
        return input.equals("");
    }

    public boolean isContainSpace(String input) {
        return input.contains(" ");
    }

    public boolean isInt(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDouble(String input) {
        for (char c : input.toCharArray()) {
            if (c == '.')
                continue;
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public int getInt() {
        clearBuffer();

        String num;
        do {
            num = scanner.nextLine();
            if (isEmpty(num)) {
                System.out.println("This field must not be empty! Please retype");
            } else if (isContainSpace(num)) {
                System.out.println("Must not contains space! Please retype");
            } else if (!isInt(num)) {
                System.out.println(num + " is not a number! Please retype");
            }
        } while (isEmpty(num) || isContainSpace(num) || !isInt(num));
        return Integer.parseInt(num);
    }

    public int getInt(String message) {
        System.out.print(message);
        return getInt();
    }

    public double getDouble() {
        clearBuffer();

        String num;
        do {
            num = scanner.nextLine();
            if (isEmpty(num)) {
                System.out.println("This field must not be empty! Please retype");
            } else if (isContainSpace(num)) {
                System.out.println("Must not contains space! Please retype");
            } else if (!isDouble(num)) {
                System.out.println(num + " is not a number! Please retype");
            }
        } while (isEmpty(num) || isContainSpace(num) || !isDouble(num));
        return Double.parseDouble(num);
    }

    public double getDouble(String message) {
        System.out.print(message);
        return getDouble();
    }

    public String getString() {
        clearBuffer();
        String out;
        
        do {
            out = scanner.nextLine();
            if (isEmpty(out)) {
                System.out.println("This field must not be blank! Please retype");
            }
        } while (isEmpty(out));

        return out;
    }

    public String getString(String message) {
        System.out.print(message);
        return getString();
    }

    public String getStringWoSpace() {
        clearBuffer();
        String out;
        do {
            out = scanner.nextLine();
            if (isEmpty(out)) {
                System.out.println("This field must not be blank! Please retype");
            }
            else if (isContainSpace(out)) {
                System.out.println("Must not contains space! Please retype");
            }
        } while (isEmpty(out) || isContainSpace(out));
        return out;
    }

    public String getStringWoSpace(String message) {
        System.out.print(message);
        return getStringWoSpace();
    }

    public int int_getChoice(ArrayList<E> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + " " + options.get(i));
        }
        int response = scanner.nextInt();
        return response;
    }

    public E ref_getChoice(ArrayList<E> options) {
        int response;
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > options.size());
        return options.get(response - 1);
    }

}
