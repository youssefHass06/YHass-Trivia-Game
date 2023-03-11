
//imports to use in code
import java.io.*;
import static java.lang.System.*;

public class TriviaGame { // start of triviaGame class

  // declaring variables
  private static String user;
  private static String password;
  private static int scoreTracker = 0;
  static int[] num = new int[20];
  static int numShuffles = 5;
  static String[] newQuestions = new String[4];
  static String[] questions = { "<html>Which Avenger is the only one who could calm the Hulk down?</html>",
      "<html>What is Hawkeye’s real name?</html>", "<html>Which original Avenger was not in the first few movies?",
      "<html>What was Superman’s birth name?</html>", "<html>What is the name of Batman’s butler?</html>",
      "<html>What was the name of the actor who played Jack Dawson in Titanic?</html>",
      "<html>What is the name of the song that Queen Elsa sings as she builds her ice castle in the movie Frozen?</html>",
      "<html>Who played Wolverine?</html>", "<html>Who is Green Lantern’s nemesis?</html>",
      "<html>Which actor appeared in films “Face Off” and “Ghost Rider”?</html>",
      "<html> What was the first feature-length animated movie ever released?</html>",
      "<html>For which 1964 musical blockbuster did Julie Andrews win the Academy Award for Best Actress?</html>",
      "<html>Which movie was incorrectly announced as the winner of Best Picture at the 2017 Academy Awards, during the greatest Oscars flub of all time?</html>",
      "<html>What animated classic was the first film of the late-twentieth-century [Disney Renaissance?]</html>",
      "<html>Who wrote the screenplay for Rocky?</html>",
      "<html>What is the highest-grossing movie of all time when not taking inflation into account?</html>",
      "<html>What is the highest-grossing war movie of all time and Clint Eastwood's highest-grossing movie ever?</html>",
      "<html>What was the first pandemic era movie to gross over $1 billion at the box office?</html>",
      "<html>What is the name of Riley's imaginary friend in Inside Out?</html>",
      "<html>What was the first marvel movie ever made?</html>" };
  static String[] answers = { "Black Widow", "Clint Barton", "The Wasp", "Kal-El", "Alfred", "Leonardo DiCaprio",
      "Let It Go", "Hugh Jackman", "Sinestro", "Nicholas Cage", "Snow White and the Seven Dwarfs", "Mary Poppins",
      "La La Land", "The Little Mermaid", "Sylvester Stallone", "Avatar", "American Sniper", "Spider-Man: No Way Home",
      "Bing Bong", "Iron Man" };

  static String[] carQuestions = {"<html>Who is often credited with creating the world’s first car?</html>","<html>Which company owns Bugatti, Lamborghini, Audi, Porsche, and Ducati?</html>","<html>Which auto brand was the first to offer seat belts?</html>","<html>What is the best-selling car of all time?</html>","<html>What country consumes the most gas every year?</html>","<html>Who was the first person to patent the first successful windshield wiper?</html>","<html>What car was the first to be mass-produced?</html>","<html>“The Ultimate Driving Machine” is the slogan for which car company?</html>","<html>Who invented the intermittent windshield wiper that is still used on vehicles today?</html>","<html>What was the original color for all Ferrari models?</html>","<html>Who was a driver for Alpha Romeo before founding his own company?</html>","<html>What does Volkswagen mean?","<html>What is the best-selling electric car in history?</html>","<html>Which iconic car has appeared in seven Bond films, making its debut in the 1964 Goldfinger?</html>","<html>Which is the famous car that was designed to compete with the Ford Mustang?</html>","<html>Who designed the Volkswagen Beetle?</html>","<html>Which iconic car manufacturer also made airplane engines?</html>","<html>Which race car is known as the widow maker?</html>","<html>What was the name given to the orange 1969 Dodge Charger in the television series The Dukes of Hazzard?</html>", "<html>What was the most stolen car in America in 2022?</html>"};

 static  String[] carAnswers = {"<html>Karl Benz</html>","<html>Volkswagen</html>","<html>Nash Motors</html>","<html>Toyota Corolla</html>","<html>The United States</html>","<html>Mary Anderson</html>","<html>Ford Model T</html>","<html>BMW</html>","<html>Robert Kearns</html>","<html>Red</html>","<html>Enzo Ferrari</html>","<html>The ‘people’s car</html>","<html>The Tesla Model 3</html>","<html>Aston Martin DB5</html>","<html>Chevrolet Camaro</html>","<html>Ferdinand Porsche</html>","<html>Rolls Royce</html>","<html>Porsche 917</html>","<html>General Lee</html>", "<html>Ford pickup</html>"};

  static String[] sportsQuestions = {"<html>What’s the diameter of a basketball hoop in inches?<html>","<html>What do you call it when a bowler makes three strikes in a row?<html>","<html>What’s the national sport of Canada?<html>","<html>What team is worth the most amount of money”<html>","<html>In the 1971 Olympics, Nadia Comaneci was the first gymnast to score a perfect score. What country was she representing?<html>","<html>What country has competed the most times in the Summer Olympics yet hasn’t won any kind of medal?<html>","<html>In what game is “love” a score?<html>","<html>How many sports were included in the 2008 Summer Olympics?<html>","<html>A sporting event is held every year on Memorial Day. What is it?<html>","<html>What is the record for red cards given in a single soccer game?<html>","<html>What is the only country to have played in every single soccer World Cup?<html>","<html>What retired basketball player tried out for the Chicago White Sox in 1994?<html>","<html>Who was the first British player to win league titles in four countries?<html>","<html>What team owns the longest winning streak in NBA history?<html>","<html>What type of race is the Tour de France?<html>","<html>Name the Sportsman of the century, declared in 1999 by both the prestigious US magazine Sports Illustrated and the BBC?<html>","<html>Which basketball player was Michael Jordan nicknamed after when he was in high school?<html>","<html>Who is the youngest ever world heavyweight boxing champion?<html>","<html>The Olympics are held every how many years?<html>","<html>How many medals did China win at the Beijing Olympics?<html>"};

  static String[] sportsAnswers = {"<html>18<html>","<html>Turkey<html>","<html>Lacrosse<html>","<html>Dallas Cowboys<html>","<html>Romania<html>","<html>Liechtenstein<html>","<html>Tennis<html>","<html>28<html>","<html>Indianapolis 500<html>","<html>36<html>","<html>Brazil<html>","<html>Michael Jordan<html>","<html>David Beckham<html>","<html>Los Angeles Lakers<html>","<html>Bicycle<html>","<html>Muhammad Ali<html>","<html>Magic Johnson<html>","<html>Mike Tyson<html>","<html>4<html>","<html>100<html>"};

  //creating getter and setter methods
  public TriviaGame(String u, String p) {

    user = u;
    password = p;
  }

  public static void setUserName(String u) {
    user = u;
  }

  public static void setPassword(String p) {
    password = p;
  }

  public static String getUserName() {
    return user;
  }

  public static String getPassword() {
    return password;
  }

  public static void setScore(int s) {
    scoreTracker = s;
  }

  public static int getScore() {
    return scoreTracker;
  }
//this method takes in a string and reads through the text file called UserInfo in order to determin igf the username was already used or not. If it was found it will return a number
  public static int checkExistingUser(String s) {
    int counter = 0;
    int number = 0;
    boolean isValid = false;
    try {
      FileReader fr = new FileReader("UserInfo.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) { // if something was read
        if (line.substring(0, line.indexOf(',')).equals(getUserName())) {
          number++;
          break;
        } else {
          line = br.readLine();
        }

      }
      inputData(number);
      br.close();
    } catch (IOException e) {
      System.out.println("Error in File writing");

    }
    return number;

  }
//this input data method takes in a number, and based off that number the data will either be input into a text file or not
  public static void inputData(int n) {
    if (n > 0) {
      System.out.print("already taken");
      MainMenueGUI.welcome.setText("Username Already Taken");
    } else {

      try {
        FileWriter fw = new FileWriter("UserInfo.txt", true);

        PrintWriter fileOut = new PrintWriter(fw);
        fileOut.print("\n" + TriviaGame.getUserName() + "," + TriviaGame.getPassword());
        fileOut.close();

      } catch (IOException x) {
        out.println("File reading/Writing error!");
      }
    }
  }
//game generator checks the value of the getQuestionsSelector in the Questions GUI and determines wich array is used for the questions
  public static void gameGenerator() {//answers
    newQuestions = questions;
    if(QuestionsGUI.getQuestionSelector()==1){
      newQuestions = carQuestions;
    }
    if(QuestionsGUI.getQuestionSelector()==2){
      newQuestions = sportsQuestions;
    }
    for (int i = 0; i < num.length; i++) {
      num[i] = i;
    }
    
    for (int n = 0; n < numShuffles; n++) {
      for (int i = 0; i < num.length; i++) {
        int numSwap = (int) (Math.random() * (20 - 1) + 1);
        int store = num[numSwap];
        num[numSwap] = num[i];
        num[i] = store;
      }
    }

  }
//the input score method will input the score of the player into the inputScore file
  public static void inputScore() {
    try {
      FileWriter fw = new FileWriter("InputScore.txt", true);

      PrintWriter fileOut = new PrintWriter(fw);

      fileOut.print("\n" + TriviaGame.getUserName() + "," + TriviaGame.getScore());
      fileOut.close();

    } catch (IOException x) {
      out.println("File reading/Writing error!");
    }
  }
//this method compares the string that if put in to the answer and if they match the score will increase by 100
  public static void checkAnswer(String c) {
    String answerToCompare = answers[num[QuestionsGUI.counter - 1]];
    if(QuestionsGUI.getQuestionSelector() ==1){
      answerToCompare = carAnswers[num[QuestionsGUI.counter - 1]];
    }
    if(QuestionsGUI.getQuestionSelector() ==2){
      answerToCompare = sportsAnswers[num[QuestionsGUI.counter - 1]];
    }
    if (answerToCompare == c) {
      scoreTracker += 100;
    }
    (QuestionsGUI.score).setText(toString(scoreTracker));
  }

  public static String toString(int n) {
    return "" + scoreTracker;
  }
//this method puts each line in a seperate element and sorts through them then returns the username at the index of the int that was passed through
  public static String sortingArray(int n) {

    int arraySize = 0;
    try {
      FileReader fr = new FileReader("InputScore.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) { // if something was read
        arraySize++;
        line = br.readLine();
      }
      br.close();
      // sortStats(arraySize);
    } catch (IOException x) {
      System.out.println("Error in File writing");

    }

    String[] userArray = new String[arraySize];
    int[] userScore = new int[arraySize];

    int i = 0;
    try {
      FileReader fr = new FileReader("InputScore.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) { // if something was read
        int userLength = line.indexOf(',');
        int userScores = line.indexOf(',') + 1;
        int ending = line.length();
        String score = line.substring(userScores, ending);
        userArray[i] = line.substring(0, userLength);
        userScore[i] = Integer.parseInt(score);
        line = br.readLine();
        i++;
      }
      br.close();
      // sortStats(arraySize);
    } catch (IOException x) {
      System.out.println("Error In File Writing");

    }
    int l = userArray.length;
    for (int k = 0; k < l - 1; k++) {
      for (int j = 0; j < l - k - 1; j++) {
        if (userScore[j] < userScore[j + 1]) {
          // swap arr[j+1] and arr[j]
          int tempScore = userScore[j];
          userScore[j] = userScore[j + 1];
          userScore[j + 1] = tempScore;

          String tempUser = userArray[j];
          userArray[j] = userArray[j + 1];
          userArray[j + 1] = tempUser;

        }

      }
    }
    return userArray[n];
  }
//this method puts each line in a seperate element and sorts through them then returns the score at the index of the int that was passed through
  public static String sortingScore(int n) {

    int arraySize = 0;
    try {
      FileReader fr = new FileReader("InputScore.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) { // if something was read
        arraySize++;
        line = br.readLine();
      }
      br.close();
      // sortStats(arraySize);
    } catch (IOException x) {
      System.out.println("Error in File writing");

    }

    String[] userArray = new String[arraySize];
    int[] userScore = new int[arraySize];

    int i = 0;
    try {
      FileReader fr = new FileReader("InputScore.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) { // if something was read
        int userLength = line.indexOf(',');
        int userScores = line.indexOf(',') + 1;
        int ending = line.length();
        String score = line.substring(userScores, ending);
        userArray[i] = line.substring(0, userLength);
        userScore[i] = Integer.parseInt(score);
        line = br.readLine();
        i++;
      }
      br.close();
      // sortStats(arraySize);
    } catch (IOException x) {
      System.out.println("Error In File Writing");

    }
    int l = userArray.length;
    for (int k = 0; k < l - 1; k++) {
      for (int j = 0; j < l - k - 1; j++) {
        if (userScore[j] < userScore[j + 1]) {
          // swap arr[j+1] and arr[j]
          int tempScore = userScore[j];
          userScore[j] = userScore[j + 1];
          userScore[j + 1] = tempScore;

          String tempUser = userArray[j];
          userArray[j] = userArray[j + 1];
          userArray[j + 1] = tempUser;

        }

      }
    }
    return "" + userScore[n];
  }
//this mehod checks if the user name and the password enetered match the ones in the database
  public static String checkLoginInfo(String u, String p) {

    int counter = 0;
    int number = 0;
    boolean isValid = false;
    int passwordCheck;
    try {
      FileReader fr = new FileReader("UserInfo.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) { // if something was read
        passwordCheck = line.indexOf(',');
        if (line.substring(0, line.indexOf(',')).equals(getUserName())
            && line.substring(passwordCheck + 1, line.length()).equals(getPassword())) {
          number++;
          break;
        }
          line = br.readLine();

      }
      br.close();
    } catch (IOException e) {
      System.out.println("Error in File writing");

    }

    if (number == 1) {
      return "Welcome Back " + getUserName();
    } else {
      return "User Name or Password is incorrect or does not exist";
    }
  }
//this method puts each line in a seperate element of an array if it belongs to the specified username and sorts through them then returns the score  at the index of the int that was passed through
  public static String sortMyStats(int n) {

    int arraySize = 0;
    try {
      FileReader fr = new FileReader("InputScore.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) { // if something was read
        if (line.substring(0, line.indexOf(',')).equals(getUserName())) {
          arraySize++;
        }
        line = br.readLine();
      }
        
        br.close();
        // sortStats(arraySize);
      }
     catch (IOException x) {
      System.out.println("Error in File writing");

    }

    int[] userScore = new int[arraySize];

    int i = 0;
    try {
      FileReader fr = new FileReader("InputScore.txt");
      BufferedReader br = new BufferedReader(fr);
      String line = br.readLine();
      while (line != null) { // if something was read
        if (line.substring(0, line.indexOf(',')).equals(getUserName())) {
          int userScores = line.indexOf(',') + 1;
          int ending = line.length();
          String score = line.substring(userScores, ending);
          userScore[i] = Integer.parseInt(score);
          i++;
          line = br.readLine();
        }
        else{
          line = br.readLine();
        }
      }
      br.close();
      // sortStats(arraySize);
    } catch (IOException x) {
      System.out.println("Error In File Writing");

    }
    int l = userScore.length;
    for (int k = 0; k < l - 1; k++) {
      for (int j = 0; j < l - k - 1; j++) {
        if (userScore[j] < userScore[j + 1]) {
          // swap arr[j+1] and arr[j]
          int tempScore = userScore[j];
          userScore[j] = userScore[j + 1];
          userScore[j + 1] = tempScore;
        }

      }
    }
    PersonalStatsGUI.setTimesPlayed(userScore.length);
    int[] topStats = new int[5];
    for (int k = 0; k < 5; k++) {
      if (k < l) {
        topStats[k] = userScore[k];
        
      } else {
        topStats[k] = 0;
      }
    }
    return "" + topStats[n];
  }
}