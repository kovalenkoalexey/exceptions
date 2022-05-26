public class Calculator {
    public int calculate(int price, int cash) throws InsuffBalanceException {
        if (price > cash)
            throw new InsuffBalanceException();
        return cash - price;
    }
}