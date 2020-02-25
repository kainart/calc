package calc;

import java.util.Scanner;

public class Main {
    public static int ar = 0;
    public static void main(String[] args) {

        String nCh1 = null;
        String nCh2 = null;
        String opCh = null;
        int n1, n2, ar1, ar2 = 0;
        boolean op = false;

        Scanner in = new Scanner(System.in);
        String get = in.nextLine();
        in.close();

        char[] chars = get.toCharArray();

        for (int i=0;i<chars.length;i++) {
            if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                nCh1 = get.substring(0, i);
                opCh = get.substring(i, i + 1);
                nCh2 = get.substring(i + 1, chars.length);
                op = true;
                break;
            }
        }

        if (op==true) {
            n1 = nums(nCh1);
            ar1 = ar;
            n2 = nums(nCh2);
            ar2 = ar;
                if (ar1==0 & ar2==0) {
                    System.out.println(operation(opCh, n1, n2));
                }
                else if (ar1==1 & ar2==1) {
                    int rimX = operation(opCh, n1, n2)/10;
                    int rimI = operation(opCh, n1, n2)%10;
                    String rim = convR(rimX, "X", "L", "C") + convR (rimI, "I", "V", "X");
                    System.out.println(rim);
                }
                else if (ar1 == 2 || ar2 == 2) {
                    System.out.println("Неверный ввод");
                }
                else System.out.println("Числа в разных системах счисления");
        }
        else System.out.println("Нет оператора");
    }

    private static int nums(String nCh) {
        int num = 0;
        switch(nCh) {
            case "1" : num = 1; ar = 0; break;
            case "2": num = 2; ar = 0; break;
            case "3": num = 3; ar = 0; break;
            case "4": num = 4; ar = 0; break;
            case "5": num = 5; ar = 0; break;
            case "6": num = 6; ar = 0; break;
            case "7": num = 7; ar = 0; break;
            case "8": num = 8; ar = 0; break;
            case "9": num = 9; ar = 0; break;
            case "10": num = 10; ar = 0; break;
            case "I" : num = 1; ar = 1; break;
            case "II": num = 2; ar = 1; break;
            case "III": num = 3; ar = 1; break;
            case "IV": num = 4; ar = 1; break;
            case "V": num = 5; ar = 1; break;
            case "VI": num = 6; ar = 1; break;
            case "VII": num = 7; ar = 1; break;
            case "VIII": num = 8; ar = 1; break;
            case "IX": num = 9; ar = 1; break;
            case "X": num = 10; ar = 1; break;
            default: ar = 2;
        }
        return num;
    }

    private static int operation(String opCh, int n1, int n2) {
        int res = 0;
        switch(opCh) {
            case "+": res = n1+n2; break;
            case "-": res = n1-n2; break;
            case "*": res = n1*n2; break;
            case "/": res = n1/n2; break;
        }
        return res;
    }

    private static String convR(int rimC, String x1, String x2, String x3) {
        String rimS="";
        switch (rimC) {
            case 4: rimS += x1 + x2; break;
            case 9: rimS += x1 + x3; break;
            case 10: rimS = x3; break;
            default:
                if (rimC > 0 & rimC < 4) {
                    for (int i = 0; i < rimC; i++) {
                        rimS += x1;
                    }
                }
                if (rimC > 4 & rimC < 9) {
                    rimS += x2;
                    for (int i = 5; i < rimC; i++) {
                        rimS += x1;
                    }
                }
        }
        return rimS;
    }
}
