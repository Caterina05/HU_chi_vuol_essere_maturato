public class Main {
    public static void main(String[] args) {
        ApiClient api = new ApiClient();
        System.out.println(api.fetchQuestions(5, "easy", "multiple"));
    }
}