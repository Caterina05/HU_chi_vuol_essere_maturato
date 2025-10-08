import java.util.LinkedHashMap;
import java.util.Map;

public class APIQuestion {
    public String question;
    public String category;
    public String difficulty;
    public String correct_answer;
    public String[] incorrect_answers;

    public Map<Character, String> answersList = new LinkedHashMap<>();


}
