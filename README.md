Cricket Matches Assignment
Project Overview
This project fetches cricket match data from an API and provides two key functionalities:

Return the highest score in one innings with the corresponding team name.
Count the number of matches where the combined score exceeds 300.
Example Output
bash
Copy code
Highest Score: 216 and Team Name: Australia [AUS]
Number Of Matches with total 300 Plus Score: 4
API Description
API Endpoint: https://api.cuvora.com/car/partner/cricket-data

The response returns a list of cricket matches, each containing the following fields:

id: Unique Match ID
dateTimeGMT: Match date and time
matchType: Type (e.g., T20, ODI, Test)
status: Match result
ms: Match status
t1: Team 1 name
t2: Team 2 name
t1s: Team 1 score
t2s: Team 2 score
How the Program Works
Input: The program fetches JSON data from the above API.
Output:
The highest score in a single innings and the corresponding team name.
The number of matches where the combined score (team1 score + team2 score) exceeds 300.
Prerequisites
Before running the project, ensure the following software is installed on your machine:

Java Development Kit (JDK) version 8 or higher.
Maven or an IDE such as IntelliJ IDEA that supports Maven projects.
Steps to Run the Project
Clone or Download the Project:

bash
Copy code
git clone https://github.com/your-repo/cricket-matches-assignment.git
Import the Project:

Open the project in your preferred IDE (e.g., IntelliJ IDEA).
Ensure that Maven is installed and configured properly.
Install Dependencies:

Navigate to the pom.xml file and install dependencies via Maven.
Example dependency in pom.xml:

xml
Copy code
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20201115</version>
</dependency>
Run the Main Class:

Find the CricketMatchesAssignment.java file.
Run the main method to start the project.
How to Modify the Code
API Key: Update the API_KEY variable in the code if necessary.
Output Logic: The format and content of the result can be adjusted by modifying the print statements in CricketMatchesAssignment.java.
Error Handling
The project includes basic error handling for:

API accessibility issues.
Invalid or unexpected JSON format.
Ensure you have internet connectivity while running the project, as the data is fetched directly from the provided API.

Helper Methods
fetchCricketData(): This method retrieves cricket match data from the API.
parseScore(String score): This method processes and converts cricket scores from the string format returned by the API into an integer format.
Contributing
Fork this repository.
Create your feature branch: git checkout -b feature-name.
Commit your changes: git commit -m 'Add feature-name'.
Push to the branch: git push origin feature-name.
Open a Pull Request.
License
This project is licensed under the MIT License. See the LICENSE file for more details.

Contact
For any issues or inquiries, feel free to reach out:

Email: shubhamvermaoutstanding@gmail.com
GitHub: https://github.com/Sv26/
pull requests for contributions!

