import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final HttpClient client = HttpClient.newHttpClient();

    public String fetchQuestions(int amount, String difficulty, String type) {
        //https://opentdb.com/api.php?amount=5&difficulty=easy&type=multiple
        String url = "https://opentdb.com/api.php?amount=" + amount + "&difficulty=" + difficulty + "&type=" + type;

        HttpRequest request = HttpRequest.newBuilder()
                .header("Content-Type", "application/json")
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            return "Error: " + e.getMessage();
        }

        Gson gson = new Gson();
        APIResponse apiResponse = gson.fromJson(response.body(), APIResponse.class);

        if(apiResponse.response_code != 0){
            System.out.println("Errore: " + apiResponse.response_code);
            return "Errore: " + apiResponse.response_code;
        }

        for (APIQuestion question : apiResponse.results) {
            System.out.println(question.question);
            System.out.println(question.correct_answer + "\n");
        }

        return response.body();
    }
}
