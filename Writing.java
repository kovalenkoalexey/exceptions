import java.io.*;

public class Writing {
    public void writeToFile(int price, int cash, int change) {
        String message;
        String payInfo = "Стоимость покупки: " + price + " руб. " +
                "Внесенная сумма: " + cash + " руб. " +
                "Сдача: " + change + " руб. " +
                "Спасибо за покупку!";
        char buffer[] = new char[payInfo.length()];
        payInfo.getChars(0, payInfo.length(), buffer, 0);
        File payInfoFile = new File("D:\\Кассовый чек.txt");
        try (FileWriter writer = new FileWriter(payInfoFile)) {
            writer.write(buffer);
            message = "Вы можете получить свой кассовый чек в директории " + payInfoFile.getPath() + ".";
        } catch (IOException e) {
            message = "Произошла ошибка ввода - вывода.\n" +
                    "Сведения о покупке не сохранены в кассовом чеке.";
        }
        System.out.println(message);
    }
}