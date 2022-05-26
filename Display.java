import java.util.InputMismatchException;
import java.util.Scanner;

public class Display {
    public void output() {
        Scanner scan = new Scanner(System.in);
        int price = 0;
        int cash = 0;
        int change = 0;
        System.out.println("Введите общую сумму Вашей покупки: ");
        try {
            try {
                price = scan.nextInt();
            } catch (InputMismatchException e) {
                throw new InputMismatchException("Ввод некорректных значений.");
            }
        }
        catch(InputMismatchException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("Введены некорректные значения при вводе стоимости покупки.");
            output();
        }
        System.out.println("Введите внесенную Вами сумму оплаты: ");
        try {
            cash = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка! Введены некорректные значения при вводе суммы оплаты.");
            e.printStackTrace();
            output();
        }
        try {
            Calculator calculator = new Calculator();
            change = calculator.calculate(price, cash);
        } catch (InsuffBalanceException e) {
            System.out.println("Недостаточно средств для оплаты.");
           System.exit(0);
        }
        System.out.println("Ваша сдача: " + change + " руб.");
        Writing writing = new Writing();
        writing.writeToFile(price, cash, change);
        System.exit(0);
    }

    public static void main(String[] args) {
        Display display = new Display();
            display.output();
    }
}