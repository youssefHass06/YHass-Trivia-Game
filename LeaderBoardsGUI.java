//imports to use in code
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.*;
import static java.lang.System.*;

public class LeaderBoardsGUI extends JFrame implements ActionListener { //start of leaderboards class

  //declaring variables in that will be used in the code
  JPanel position, userNameDisplay, scoreDisplay;
  JButton mainMenue;
  JLabel userName1, userName2, userName3, userName4, userName5, userName6, userName7, userName8, userName9, userName10,
      score1, score2, score3, score4, score5, score6, score7, score8, score9, score10, place1, place2, place3, place4,
      place5, place6, place7, place8, place9, place10;
//declaring and initializing colours being used in the code
  Color orange = new Color(0, 145, 173);
  Color pistacio = new Color(134, 205, 130);
  Color mint = new Color(138, 233, 193);

  
  public LeaderBoardsGUI() { //start of leaderboard gui creating the UI for the leaderboards.

    int size = 0;
    setTitle("Trivia Game");
    setBounds(0, 0, 300, 400);

    //create a panel for the position
    position = new JPanel();
    position.setBounds(0, 0, 50, 450);
    position.setBackground(mint);
    position.setLayout(null);
    this.add(position);
    //creating a panel for the usernames
    userNameDisplay = new JPanel();
    userNameDisplay.setBounds(50, 0, 200, 450);
    userNameDisplay.setBackground(mint);
    userNameDisplay.setLayout(null);
    this.add(userNameDisplay);
    //creating a panel for the score displays
    scoreDisplay = new JPanel();
    scoreDisplay.setBounds(250, 0, 400, 450);
    scoreDisplay.setBackground(mint);
    scoreDisplay.setLayout(null);
    this.add(scoreDisplay);
    //initializing positions variables for positions 1-10
    place1 = new JLabel("1.");
    place1.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place1.setBounds(15, 10, 20, 30);
    position.add(place1);

    place2 = new JLabel("2.");
    place2.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place2.setBounds(15, 50, 20, 30);
    position.add(place2);

    place3 = new JLabel("3.");
    place3.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place3.setBounds(15, 90, 20, 30);
    position.add(place3);

    place4 = new JLabel("4.");
    place4.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place4.setBounds(15, 130, 20, 30);
    position.add(place4);

    place5 = new JLabel("5.");
    place5.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place5.setBounds(15, 170, 20, 30);
    position.add(place5);

    place6 = new JLabel("6.");
    place6.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place6.setBounds(15, 210, 20, 30);
    position.add(place6);

    place7 = new JLabel("7.");
    place7.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place7.setBounds(15, 250, 20, 30);
    position.add(place7);

    place8 = new JLabel("8.");
    place8.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place8.setBounds(15, 290, 20, 30);
    position.add(place8);

    place9 = new JLabel("9.");
    place9.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place9.setBounds(15, 330, 20, 30);
    position.add(place9);

    place10 = new JLabel("10.");
    place10.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place10.setBounds(10, 370, 30, 30);
    position.add(place10);
    //initializing usernames variables from 1-10 by calling on the sorting array method from TriviaGame class and displays the element at index 0-9
    userName1 = new JLabel(TriviaGame.sortingArray(0));
    userName1.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName1.setBounds(10, 10, 200, 30);
    userNameDisplay.add(userName1);

    userName2 = new JLabel(TriviaGame.sortingArray(1));
    userName2.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName2.setBounds(10, 50, 200, 30);
    userNameDisplay.add(userName2);

    userName3 = new JLabel(TriviaGame.sortingArray(2));
    userName3.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName3.setBounds(10, 90, 200, 30);
    userNameDisplay.add(userName3);

    userName4 = new JLabel(TriviaGame.sortingArray(3));
    userName4.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName4.setBounds(10, 130, 200, 30);
    userNameDisplay.add(userName4);

    userName5 = new JLabel(TriviaGame.sortingArray(4));
    userName5.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName5.setBounds(10, 170, 200, 30);
    userNameDisplay.add(userName5);

    userName6 = new JLabel(TriviaGame.sortingArray(5));
    userName6.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName6.setBounds(10, 210, 200, 30);
    userNameDisplay.add(userName6);

    userName7 = new JLabel(TriviaGame.sortingArray(6));
    userName7.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName7.setBounds(10, 250, 200, 30);
    userNameDisplay.add(userName7);

    userName8 = new JLabel(TriviaGame.sortingArray(7));
    userName8.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName8.setBounds(10, 290, 200, 30);
    userNameDisplay.add(userName8);

    userName9 = new JLabel(TriviaGame.sortingArray(8));
    userName9.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName9.setBounds(10, 330, 200, 30);
    userNameDisplay.add(userName9);

    userName10 = new JLabel(TriviaGame.sortingArray(9));
    userName10.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName10.setBounds(10, 370, 200, 30);
    userNameDisplay.add(userName10);
//initializing score variables from 1-10 by calling on the sortingScore method from TriviaGame class and displays the element at index 0-9
    score1 = new JLabel(TriviaGame.sortingScore(0));
    score1.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score1.setBounds(250, 10, 150, 30);
    scoreDisplay.add(score1);
    

    score2 = new JLabel(TriviaGame.sortingScore(1));
    score2.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score2.setBounds(250, 50, 100, 30);
    scoreDisplay.add(score2);
    

    score3 = new JLabel(TriviaGame.sortingScore(2));
    score3.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score3.setBounds(250, 90, 100, 30);
    scoreDisplay.add(score3);

    score4 = new JLabel(TriviaGame.sortingScore(3));
    score4.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score4.setBounds(250, 130, 100, 30);
    scoreDisplay.add(score4);

    score5 = new JLabel(TriviaGame.sortingScore(4));
    score5.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score5.setBounds(250, 170, 100, 30);
    scoreDisplay.add(score5);

    score6 = new JLabel(TriviaGame.sortingScore(5));
    score6.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score6.setBounds(250, 210, 100, 30);
    scoreDisplay.add(score6);

    score7 = new JLabel(TriviaGame.sortingScore(6));
    score7.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score7.setBounds(250, 250, 100, 30);
    scoreDisplay.add(score7);

    score8 = new JLabel(TriviaGame.sortingScore(7));
    score8.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score8.setBounds(250, 290, 100, 30);
    scoreDisplay.add(score8);

    score9 = new JLabel(TriviaGame.sortingScore(8));
    score9.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score9.setBounds(250, 330, 100, 30);
    scoreDisplay.add(score9);

    score10 = new JLabel(TriviaGame.sortingScore(9));
    score10.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    score10.setBounds(250, 370, 100, 30);
    scoreDisplay.add(score10);
    setVisible(true);

  }//end of leaderboard method

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}//end of class