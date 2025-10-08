import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ApiClient api = new ApiClient();

        System.out.println("Inserisci il numero di domande da prendere: ");
        int amount = scanner.nextInt();
        System.out.println(api.fetchQuestions(amount, "easy", "multiple"));
    }
}