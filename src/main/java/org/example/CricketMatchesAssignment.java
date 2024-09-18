import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class CricketMatchesAssignment {

    // API URL and API key
    private static final String API_URL = "https://api.cuvora.com/car/partner/cricket-data";
    private static final String API_KEY = "test-creds@2320";

    public static void main(String[] args) {
        try {
            // Fetch match data from the API
            String jsonResponse = fetchCricketData();

            // Print the raw response to check its structure
            System.out.println("Response from API: " + jsonResponse);

            // Initialize variables for tracking results
            int highestScore = 0;
            String highestScoringTeam = "";
            int matchesWithTotal300Plus = 0;

            // Parse the JSON response
            JSONObject jsonResponseObject = new JSONObject(jsonResponse);
            JSONArray matches = jsonResponseObject.getJSONArray("data");  // Correct field is "data"

            // Loop through each match
            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);

                // Get scores of both teams
                String t1 = match.getString("t1");
                String t2 = match.getString("t2");
                String t1s = match.optString("t1s", "0"); // Team 1 score
                String t2s = match.optString("t2s", "0"); // Team 2 score

                // Parse scores
                int scoreT1 = parseScore(t1s);
                int scoreT2 = parseScore(t2s);

                // Find highest score and corresponding team
                if (scoreT1 > highestScore) {
                    highestScore = scoreT1;
                    highestScoringTeam = t1;
                }
                if (scoreT2 > highestScore) {
                    highestScore = scoreT2;
                    highestScoringTeam = t2;
                }

                // Count matches where total score exceeds 300
                if (scoreT1 + scoreT2 > 300) {
                    matchesWithTotal300Plus++;
                }
            }

            // Print the results
            System.out.println("Highest Score: " + highestScore + " and Team Name: " + highestScoringTeam);
            System.out.println("Number Of Matches with total 300 Plus Score: " + matchesWithTotal300Plus);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch cricket match data from API
    private static String fetchCricketData() throws Exception {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("apiKey", API_KEY);

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();

        return content.toString();
    }

    // Parse cricket score, handling edge cases like missing data or "NA"
    private static int parseScore(String score) {
        if (score == null || score.isEmpty() || score.equals("NA")) {
            return 0;
        }
        String[] parts = score.split("/");
        try {
            return Integer.parseInt(parts[0]); // Return only the runs part before the wicket
        } catch (NumberFormatException e) {
            return 0; // Return 0 if the score is not parsable
        }
    }
}
