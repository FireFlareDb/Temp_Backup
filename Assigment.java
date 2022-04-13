import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Scanner;

class Utils {
    public static int input(String prompt) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        int res = sc.nextInt();
        return res;
    }

    public static String sinput(String prompt) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String res = sc.next();
        return res;
    }
    
    public static String reverseString(String string) {
        StringBuilder str = new StringBuilder();
        str.append(string);
        return str.reverse().toString();
    }

    public static int reverseInt(int number) {
        int reverse = 0;
        while (number != 0) {
            int reminder = number % 10;
            reverse = reverse * 10 + reminder;
            number /= 10;
        }
        return reverse;
    }

    public static int lastDigit(int number) {
        return number % 10;
    }

    public static int firstDigit(int number) {
        return Integer.parseInt(Integer.toString(number).substring(0, 1));
    }

    public static int secondLastDigit(int number) {
        return number % 100 / 10;
    }
    
    public static String replaceIndex(String string, int index, char character) {
        StringBuilder sb = new StringBuilder();
        sb.append(string).setCharAt(index, character);
        return sb.toString();
    }

    public static int[] numberToIntArray(int num) {
        String number = Integer.toString(num);
        char[] charArray = number.toCharArray();
        int[] intArray = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i] - '0';
        }
        return intArray;
    }

    public static int[] filterEquation(int range, int reminder) {
        int equation;
        int indexer = 0;
        int[] intArray = new int[range];
        
        for (int i = 0; i < range; i++) {
            equation = (i / 10) % 2;
            if (equation == reminder) {
                intArray[indexer] = i;
                indexer++;
            }
        }
        // elimaniting zreos from intArray
        int[] newArray = new int[indexer];
        for (int i = 0; i < indexer; i++) {
            newArray[i] = intArray[i];
        }
        return newArray;
    }

    public static int removeDigitAtIndex(int number, int index) {
        String numStr = Integer.toString(number);
        String div1 = numStr.substring(0, index);
        String div2 = numStr.substring(index);
        String last = div2.substring(div2.length() - 1);
        return Integer.parseInt(div1 + last);
    }

    public static int[] adjacentIntArray(int number) {
        String numStr = Integer.toString(number);
        int[] intArray = new int[numStr.length() - 1];
        int startIndex = 0;
        int endIndex = 2;
        for (int i = 0; i < numStr.length() - 1; i++) {
            int res = Integer.parseInt(numStr.substring(startIndex, endIndex));
            intArray[i] = res;
            startIndex++;
            endIndex++;
        }
        return intArray;
    }

    public static int maxFromIntArray(int[] intArray) {
        int max = 0;
        for (int element: intArray) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static boolean isPrime(int number) {
        if (number <= 1 || number % 2 == 0) {
            return false;
        }

        int maxDiv = (int) Math.floor(Math.sqrt(number));
    
        for (int i = 3; i < maxDiv + 1; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    
}

class Part_1 extends Utils{
    public void rectArea() {
        int width = input("Width: ");
        int breadth = input("Breadth: ");
        System.out.printf("Area Of Rect With %d With And %d Breadth: %d\n", width, breadth, width * breadth);
    }

    public void powEqu() {
        int a = input("A: ");
        int b = input("B: ");
        System.out.printf("%d * %d + %d * %d * %d = %d\n", a, a, b, b, b , a * a + b * b * b);
    }
    
    public void qudEqu() {
        int a = input("A: ");
        int b = input("B: ");
        int c = input("C: ");
        int x = input("X: ");
        System.out.printf("%d * (%d * %d) + %d * %d + %d = %d\n", a, x, x, b, x, c, a * (x * x) + b * x + c);
    }

    public void delLastTwoDigits() {
        String n = sinput("Number: ");
        System.out.println("New Number: " + n.substring(0, n.length() - 2));
    }
    
    public void reverseValues() {
        int n = input("Number: ");
        String lastThreeValues = Integer.toString(n % 1000);
        int revInt = Integer.parseInt(reverseString(lastThreeValues));
        System.out.print(n - Integer.parseInt(lastThreeValues) + revInt);
    }

    public void sqrSecondLast() {
        int num = 1234;
        int squaredSecondLast = (num % 100 / 10) * 2;
        
        String strNum = Integer.toString(num);
        String firstHalf = strNum.substring(0, strNum.length() - 2);
        String secondHalf = Integer.toString(squaredSecondLast);
        String thirdHalf = strNum.substring(strNum.length() - 1);
        System.out.println("Second Last Squared Number: " + firstHalf + secondHalf + thirdHalf);
    }

    public void exchangeProduct() {
        int a = input("A: ");
        int b = input("B: ");
        char aEndsWith = (char) (lastDigit(a) + '0');
        char bEndsWith = (char) (lastDigit(b) + '0');

        String aStr = Integer.toString(a);
        String bStr = Integer.toString(b);

        aStr = replaceIndex(aStr, aStr.length() - 1, bEndsWith);
        bStr = replaceIndex(bStr, bStr.length() - 1, aEndsWith);
        
        a = Integer.parseInt(aStr);
        b = Integer.parseInt(bStr);
        
        System.out.printf("%d x %d = %d\n", a, b, a * b);
    }
}

class Part_2 extends Utils { 

    public void even() {
        int upperBound = 20;
        int lowerBound = 70;

        for (int i = upperBound; i <= lowerBound; i++)
            if (i % 2 == 0) { System.out.println(i); }
    }

    public void findEvenOdd() {
        System.out.println("----- Evens -----");
        for (int i = 20; i <= 40; i++)
            if (i % 2 == 0) { System.out.println(i); }
        System.out.println("----- Odds -----");
        for (int i = 50; i <= 80; i++)
        if (i % 2 != 0) { System.out.println(i); }
    }

    public void threeMultiples() {
        int range = 30;
        int multipleOf = 3;
        for (int i = 0; i < range + 1; i++)
            if (lastDigit(i) % multipleOf == 0) { System.out.println(i); }
    }

    public void lastDigitCheck() {
        int upperBound = 8;
        int lowerBound = 5;
        int range = 30;
        for (int i = 0; i < range + 1; i++)
            if (lastDigit(i) >= lowerBound && lastDigit(i) <= upperBound)
                System.out.println(i);        
    }

    public void digitsSumCheck() {
        int sum = 0;
        int range = 70;
        int multipleOf = 7;
        for (int i = 0; i < range + 1; i++) {
            sum = Arrays.stream(numberToIntArray(i)).sum();
            if (sum == multipleOf) { System.out.println(i); };
            sum = 0;
        }
    }
    
    public void filterEqu() {
        int range = input("Range: ");
        int[] arrayOfEqu = filterEquation(range, 1);
        for (int element : arrayOfEqu) {
            System.out.println(element);
        }
    }

    public void firstDigitFilterEqu() {
        int range = input("Range: ");
        int[] arrayOfEqu = filterEquation(range, 1);
        for (int element : arrayOfEqu) {
            if (firstDigit(element) % 3 == 1) {
                System.out.println(element);
            }
        }
    }

    public void filterEquEvenOdd() {
        int range = input("Range: ");
        int[] arrayOfEqu = filterEquation(range, 0);
        System.out.println("----- Odds -----");
        for (int element : arrayOfEqu) {
            if (element % 2 != 0) {
                System.out.println(element);
            }
        }
        
        arrayOfEqu = filterEquation(range, 1);
        System.out.println("----- Evens -----");
        for (int element : arrayOfEqu) {
            if (element % 2 == 0) {
                System.out.println(element);
            }
        }
    }
}

class Part_3 extends Utils {
    public void nSum() {
        int n = input("Number Of Inputs: ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += input("");
        }
        System.out.println("Sum: " + sum);
    }

    public void lastDigitSum() {
        int n = input("Number Of Inputs: ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += lastDigit(input(""));
        }
        System.out.println("Sum: " + sum);
    }

    public void secondLastSum() {
        int n = input("Number Of Inputs: ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += secondLastDigit(input(""));
        }
        System.out.println("Sum: " + sum);
    }

    public void sumAfterDeletion() {
        int n = input("Number: ");
        int nLen = String.valueOf(n).length();
        System.out.println("Result: " + removeDigitAtIndex(n, nLen - 2));
    }

    public void evenWeightedSum() {
        int n = input("Number Of Input: ");
        int counter = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
           int num = input("");
           if (num % 2 == 0) {
                sum += num * counter;
                counter++;
           }
        }
        System.out.println(sum);
    }

    public void consecProgress() {
        int n = input("Number Of Inputs: ");
        int firstInput = input("");
        int sum = 0;
        for (int index = 0; index < n - 1; index++) {
            int secondLoopInput = input("");
            sum += firstInput * secondLoopInput;
            firstInput = secondLoopInput;
        }
        System.out.print("\n" + sum);
    }
    
    public void catchEvenSum() {
        int n = input("Number Of Inputs: ");
        boolean flag = false;
        int sum = 0;
        int num;
        
        for (int i = 0; i < n; i++) {
            num = input("");
            if (num % 2 == 0) { flag = true; }
            if (flag) { sum += num; }
        }
        System.out.println("Sum: " + sum);
    }

    public void consecSum() {
        int n = input("Number: ");
        int sum = 0;
        for (int element : adjacentIntArray(n)) {
            sum += element;
        }
        System.out.println("Sum: " + sum);
    }

    public void consecReverseSum() {
        int n = input("Number: ");
        int sum = 0;
        for (int element : adjacentIntArray(n)) {
            sum += reverseInt(element);
        }
        System.out.println("Sum: " + sum);
    }
}

class Part_4 extends Utils {
    public void maxFromArray() {
        int noElement = input("Number Of Elements To Input: ");        
        int[] array = new int[noElement];
        for (int i = 0; i < noElement; i++) {
            int num = input("");
            array[i] = num;
        }
        int max = maxFromIntArray(array);
        System.out.println("\nMax Element In Array: " + max);
    }

    public void noMaxSumOfArray() {
        int noElement = input("Number Of Elements To Input: ");        
        int[] array = new int[noElement];
        int sum = 0;
        int max;

        for (int i = 0; i < noElement; i++) {
            int num = input("");
            array[i] = num;
        }
        
        max = maxFromIntArray(array);
        for (int element : array) {
            if (element != max) {
                sum += element;                
            }
        }
        System.out.println("Sum Of Elements Except Max Number: " + sum);
    }

    public void maxSumOfDigits() {
        int noElement = input("Number Of Elements To Input: ");        
        int[] array = new int[noElement];

        for (int i = 0; i < noElement; i++) {
            int num = input("");
            array[i] = num;
        }

        int maxDigitsSum = 0;
        int maxElement = 0;
        for (int element : array) {
            int sumOfDigits = IntStream.of(numberToIntArray(element)).sum();
            if (sumOfDigits > maxDigitsSum) {
                maxDigitsSum = sumOfDigits;
                maxElement = element;
            }
        }
        System.out.println("Element With Maximum Sum Of Digits: " + maxElement);
    }

    public void deleteMaximumDigit() {
        int num = input("Number: ");        
        int[] numArray = numberToIntArray(num);
        int numArrayMax = maxFromIntArray(numberToIntArray(num));

        for (int i : numArray) {
            if (i != numArrayMax)
                System.out.print(i);
        }
    }

}

class Part_5 extends Utils {
    public void sumFirstDigits() {
        int n = input("Number Of Inputs: ");
        int sum = 0;
        int number;
        System.out.println("Enter Numbers Down \n");
        for (int i = 0; i < n; i++) {
            number = firstDigit(input(""));
            sum += number;
        }
        System.out.println("Sum:" + sum);
    }

    public void sumFirstDigitsWithCheck() {
        int n = input("Number Of Inputs: ");
        int sum = 0;
        int number;
        System.out.println("Enter Numbers Down \n");
        for (int i = 0; i < n; i++) {
            number = input("");
            if (1 == firstDigit(number)) {
                sum += number;
            }
        }
        System.out.println("Sum:" + sum);
    }


    public void reverseSum() {
        int n = input("Number Of Inputs: ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int number = reverseInt(input(""));
            sum += number;
        }
        System.out.println("Sum Of Reversed Inputs: " + sum);
    }
    
    public void countPrimes() {
        int n = input("Number Of Inputs: ");
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean isPrime = isPrime(input(""));
            if (isPrime) {
                count++;
            }
        }
        System.out.println("Total Number Of Primes: " + count);
    }
    
    public void sumPrimes() {
        int n = input("Number Of Inputs: ");
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int number = input("");
            boolean isPrime = isPrime(number);
            if (isPrime) {
                sum += number;
            }
        }
        System.out.println("Sum Of Prime Numbers: " + sum);
    }
    
    public void maxPrime() {
        int n = input("Number Of Inputs: ");
        int max = 0;
        for (int i = 0; i < n; i++) {
            int number = input("");
            boolean isPrime = isPrime(number);
            if (isPrime && number > max) {
                max = number;
            }
        }
        System.out.println("Max Prime: " + max);
    }

    public void factorialFirstDigit() {
        int n = input("Number: ");
        int factorial = 1;
        while (n >= 2) {
            factorial *= n;
            n--;
        }
        System.out.println("Factorial: " + factorial);
        System.out.println("Factorial First Digit: " + firstDigit(factorial));
    }
}

public class Assigment {
    public static void main(String[] args) {
        // Part_1 p1 = new Part_1();
        // p1.rectArea();
        // p1.powEqu();
        // p1.qudEqu();
        // p1.delLastTwoDigits();
        // p1.reverseValues();
        // p1.sqrSecondLast();
        // p1.exchangeProduct();

        // -------------------------
        
        // Part_2 p2 = new Part_2();
        // p2.even();
        // p2.findEvenOdd();
        // p2.threeMultiples();
        // p2.lastDigitCheck();
        // p2.digitsSumCheck();
        // p2.filterEqu();
        // p2.firstDigitFilterEqu();
        // p2.filterEquEvenOdd();

        // -------------------------
        
        // Part_3 p3 = new Part_3();
        // p3.nSum();
        // p3.lastDigitSum();
        // p3.secondLastSum();
        // p3.sumAfterDeletion();
        // p3.evenWeightedSum();
        // p3.consecProgress();
        // p3.catchEvenSum();
        // p3.consecSum();
        // p3.consecReverseSum();
        
        // -------------------------

        // Part_4 p4 = new Part_4();
        // p4.maxFromArray();
        // p4.noMaxSumOfArray();
        // p4.maxSumOfDigits();
        // p4.deleteMaximumDigit();
        // p4.deleteMaximumDigit();   // Also Works For Many Max Digits

        // -------------------------

        Part_5 p5 = new Part_5();
        // p5.sumFirstDigits();
        // p5.sumFirstDigitsWithCheck();
        // p5.reverseSum();
        // p5.countPrimes();
        // p5.sumPrimes();
        // p5.maxPrime();
        // p5.factorialFirstDigit();
    }
}