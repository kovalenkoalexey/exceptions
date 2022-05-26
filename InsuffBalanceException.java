public class InsuffBalanceException extends Exception {
    InsuffBalanceException() {
        System.out.println("Внесенной суммы недостаточно. ");
    }
}