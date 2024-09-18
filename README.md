
# Cricket Matches Assignment

## Project Overview
This project fetches cricket match data from an API and provides two key features:

- Return the highest score in one innings with the team name.
- Count matches where the combined score exceeds 300.

### Example Output
```sql
Highest Score: 216 and Team Name: Australia [AUS]
Matches with total score > 300: 4
```

## API Description
**API Endpoint**: https://api.cuvora.com/car/partner/cricket-data

The response includes:
- `id`, `dateTimeGMT`, `matchType`, `status`, `t1`, `t2`, `t1s`, `t2s`

## How the Program Works
- Fetches data via API.
- Outputs the highest score and the number of matches with a combined score over 300.

## Prerequisites
- JDK 8 or higher.
- Maven or an IDE like IntelliJ IDEA.

## Running the Project

1. Clone the project:
    ```bash
   https://github.com/Sv26/-Sv26-CricketMatchesAssignment.git
    ```
2. Import into IDE.
3. Install dependencies via `pom.xml`.
4. Run the main method in `CricketMatchesAssignment.java`.

## Modifying the Code
- Update `API_KEY` if needed.
- Adjust print statements for custom output formatting.

## Error Handling
- Handles API accessibility issues and unexpected JSON formats.

## Helper Methods
- `fetchCricketData()`: Fetches cricket data.
- `parseScore(String score)`: Converts scores to integers.

## Contributing
- Fork, create a branch, commit, push, and open a pull request.

## License
Licensed under the MIT License.

## Contact
- Email: shubhamvermaoutstanding@gmail.com
- GitHub: https://github.com/Sv26/
