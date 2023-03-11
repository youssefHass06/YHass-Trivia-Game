
//imports to use in code
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.*;
import static java.lang.System.*;

public class MainMenueGUI extends JFrame implements ActionListener {// start of mainmenueclass
  // declaring variabels
  JPanel mainScreen;
  public boolean isActive;
  JButton play, leaderBoards, viewStats, logIn, signUp;
  JTextField inputName, inputPassword;
  JLabel userName, password, trivia;
  static JLabel welcome;

  // declaring and initializing colour I will be using
  Color orange = new Color(0, 145, 173);

  // start of main menu method
  public MainMenueGUI() {
    setTitle("Trivia Game");
    setBounds(0, 0, 600, 400);

    // initializing main screen
    mainScreen = new JPanel();
    mainScreen.setBounds(0, 0, 600, 400);
    mainScreen.setBackground(orange);
    mainScreen.setLayout(null);
    this.add(mainScreen);

    // initializing labels
    trivia = new JLabel("Welcome to Trivia");
    trivia.setFont(new Font("Serif Bold Italic", Font.PLAIN, 20));
    trivia.setBounds(200, 20, 300, 30);
    mainScreen.add(trivia);

    welcome = new JLabel("",SwingConstants.CENTER);
    welcome.setFont(new Font("Serif Bold Italic", Font.PLAIN, 20));
    welcome.setBounds(15, 250, 575, 30);
    mainScreen.add(welcome);

    userName = new JLabel("Enter Username:");
    userName.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName.setBounds(69, 60, 250, 30);
    mainScreen.add(userName);

    password = new JLabel("Enter Password:");
    password.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    password.setBounds(69, 90, 250, 30);
    mainScreen.add(password);

    // initializing text fields
    inputName = new JTextField("");
    inputName.setFont(new Font("Serif Bold Italic", Font.PLAIN, 16));
    inputName.setBounds(220, 64, 300, 25);
    mainScreen.add(inputName);

    inputPassword = new JTextField("");
    inputPassword.setFont(new Font("Serif Bold Italic", Font.PLAIN, 16));
    inputPassword.setBounds(220, 94, 300, 25);
    mainScreen.add(inputPassword);

    // initializing buttons

    logIn = new JButton("Log in Here");
    logIn.setBounds(110, 130, 150, 30);
    logIn.addActionListener(this);
    mainScreen.add(logIn);

    signUp = new JButton("Create Account");
    signUp.setBounds(325, 130, 150, 30);
    signUp.addActionListener(this);
    mainScreen.add(signUp);

    setVisible(true); // makes everying above visable on the ui

    play = new JButton("PLAY");
    play.setBounds(69, 170, 100, 30);
    play.addActionListener(this);
    mainScreen.add(play);

    leaderBoards = new JButton("Leader Boards");
    leaderBoards.setBounds(195, 170, 200, 30);
    leaderBoards.addActionListener(this);
    mainScreen.add(leaderBoards);

    viewStats = new JButton("My Stats");
    viewStats.setBounds(420, 170, 100, 30);
    viewStats.addActionListener(this);
    mainScreen.add(viewStats);

    play.setVisible(false);
        viewStats.setVisible(false);
        leaderBoards.setVisible(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  @Override
  public void actionPerformed(ActionEvent e) { //
    if (e.getSource() == play) { // if the play button is clicked then the mainmenu screen will close and the
                                 // questionsGUI will start
      dispose();
      new CategorySelectionGUI();
    }
    if (e.getSource() == signUp) {//if signup button was clicked
      //declares and initializes the two variables one for the pass word and one for the username in order to be able to convert them to a string in order to set the username and password in the TriviaGame class 
      String pass = inputPassword.getText(); 
      String user = inputName.getText();
      TriviaGame.setPassword(pass); 
      TriviaGame.setUserName(user);
      //passes through the check existing user in the trivia game to see if there was previously a user with that name
      if(TriviaGame.checkExistingUser(user)<1){
        play.setVisible(true);
        viewStats.setVisible(true);
        leaderBoards.setVisible(true);
        welcome.setText("Hello nice to see you "+ TriviaGame.getUserName());
      }
      else{
        play.setVisible(false);
        viewStats.setVisible(false);
        leaderBoards.setVisible(false);
      }
    }
    if (e.getSource() == leaderBoards) { //if leaderboard button was clicked leaderboard gui opens
      new LeaderBoardsGUI();
    }

    if (e.getSource() == viewStats) { //if view starts was clicked the personal stats gui opens up
      TriviaGame.sortMyStats(0);
      new PersonalStatsGUI();
    }
    if (e.getSource() == logIn) {//if login button was clicked declares and initializes the two variables one for the pass word and one for the username in order to be able to convert them to a string in order to set the username and password in the TriviaGame class passes through the checkLoginInfo in the trivia game to see if there was previously a user with that name and if the password matches

      String pass = inputPassword.getText();
      String user = inputName.getText();

      TriviaGame.setPassword(pass);
      TriviaGame.setUserName(user);
      String checkName = TriviaGame.checkLoginInfo(user, pass);
      if(checkName.equals("Welcome Back "+TriviaGame.getUserName())){
      play.setVisible(true);
        viewStats.setVisible(true);
        leaderBoards.setVisible(true);
    }
      else{
        play.setVisible(false);
        viewStats.setVisible(false);
        leaderBoards.setVisible(false);
      }
      welcome.setText(TriviaGame.checkLoginInfo(user, pass));
    }
  }
} //end of MainMenuClass
