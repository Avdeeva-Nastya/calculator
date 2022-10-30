import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b.



public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        
        System.out.println(calc());

    }

    public static String calc() throws IOException {
        String result = "";


        System.out.println("Выберите действие: \n1. Арифметические действия с Арабскими цифрами" +
                "\n2. Арифметические действия с Римскими цифрами");

        String choose = scanner.next();

        switch (choose) {
            case "1":
                System.out.println("Введите выражение. Например 2+2");

                String[] numbers = new String[3];
                for (int i = 0; i < numbers.length; i++)
                {
                    numbers[i] = scanner.next();
                }
                result = arabic(numbers);
                break;
            case "2":
                System.out.println("Введите первое число");
                String num1 = scanner.next();
                System.out.println("Введите второе число");
                String num2 = scanner.next();
                result = roman(num1, num2);
                break;
        }

            return result;
    }

    public static String arabic(String[] characterArray) throws IOException {
        String result = null;

        int[] num = new int[3];
        num[0] = Integer.parseInt(characterArray[0]);
        num[1] = Integer.parseInt(characterArray[2]);

        if (num[0] > 10 || num[1] > 10 || num[0] < 0 || num[1] < 0 ){
            try {
                throw new IOException();
            }
            catch (IOException e){
                System.out.println("Число больше 10 или меньше 0 ");
            }
        }



        switch (characterArray[1]) {
            case "+":
                result = String.valueOf(num[0] + num[1]);
                break;
            case "-":
                result = String.valueOf(num[0] - num[1]);
                break;
            case "*":
                result = String.valueOf(num[0] * num[1]);
                break;
            case "/":
                result = String.valueOf(num[0] / num[1]);
                break;
        }
        return result;
    }

    public static String roman(String num1, String num2) throws IOException {
        String result = null;
        int res = 0;
        int romanNum1 = arabicToRoman(num1);
        int romanNum2 = arabicToRoman(num2);


        System.out.println("Введите арифметическое действие");
        String operation = scanner.next();

        switch (operation){
            case "+":
                res = romanNum1 + romanNum2;
                break;
            case "-":
                res = romanNum1 - romanNum2;
                break;
            case "*":
                res = romanNum1 * romanNum2;
                break;
            case "/":
                res = romanNum1 / romanNum2;
                break;
        }
        if (res <= 0) {
            try {
                throw new IOException();
            }
            catch (IOException e){
                System.out.println("Римское число не может быть меньше млм ровно 0");
            }
        }
        return  result;
    }

    public static int arabicToRoman(String num) throws IOException {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);


        int result = 0;

        int res = 0;
        int prev = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int curr = map.get(num.charAt(i));
            if (curr < prev)
                res -= curr;
            else
                res += curr;
            prev = curr;

        }


        if (res > 10 ||  res < 0  ){
            try {
                throw new IOException();
            }
            catch (IOException e){
                System.out.println("Число больше 10 или меньше 0 ");
            }
        }
        result = res;
        return  result;
    }

}

