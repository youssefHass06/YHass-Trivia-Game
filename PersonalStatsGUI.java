//imports to use in my code
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.*;
import static java.lang.System.*;

public class PersonalStatsGUI extends JFrame implements ActionListener { //start of personalStatsGui class
 //declaring variables
  JPanel position, userNameDisplay, scoreDisplay;
  JButton mainMenue;
  JLabel playerName, userName1, userName2, userName3, userName4, userName5,
      score1, score2, score3, score4, score5, place1, place2, place3, place4, place5, numPlayed, name; 
  static int timesPlayed;
 //declaring and initializing the colours I will be using in my code
  Color orange = new Color(0, 145, 173);
  Color pistacio = new Color(134, 205, 130);
  Color mint = new Color(138, 233, 193);

  public PersonalStatsGUI() { //start of personalStatsGUI method
    
    int size = 0;
    setTitle("Trivia Game");
    setBounds(0, 0, 300, 450);

    //initializing the position panel where the number will be displayed 
    position = new JPanel();
    position.setBounds(0, 0, 50, 450);
    position.setBackground(pistacio);
    position.setLayout(null);
    this.add(position);

    //initializing the usernamedisplay panel 
    userNameDisplay = new JPanel();
    userNameDisplay.setBounds(50, 0, 200, 450);
    userNameDisplay.setBackground(pistacio);
    userNameDisplay.setLayout(null);
    this.add(userNameDisplay);

    //intializing the scoreDisplay panel
    scoreDisplay = new JPanel();
    scoreDisplay.setBounds(250, 0, 50, 450);
    scoreDisplay.setBackground(pistacio);
    scoreDisplay.setLayout(null);
    this.add(scoreDisplay);

    name = new JLabel(TriviaGame.getUserName()+"'s \ntop 5 scores", SwingConstants.CENTER);
    name.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    name.setBounds(0, 50, 200, 30);
    userNameDisplay.add(name);

    numPlayed = new JLabel("<html>You have played a total of "+getTimesPlayed()+" time(s)</html>", SwingConstants.CENTER);
    numPlayed.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    numPlayed.setBounds(0, 325, 200, 30);
    userNameDisplay.add(numPlayed);
    //initialing the play variables from 1-10
    place1 = new JLabel("1.");
    place1.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place1.setBounds(15, 110, 20, 30);
    position.add(place1);

    place2 = new JLabel("2.");
    place2.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place2.setBounds(15, 150, 20, 30);
    position.add(place2);

    place3 = new JLabel("3.");
    place3.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place3.setBounds(15, 190, 20, 30);
    position.add(place3);

    place4 = new JLabel("4.");
    place4.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place4.setBounds(15, 230, 20, 30);
    position.add(place4);

    place5 = new JLabel("5.");
    place5.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    place5.setBounds(15, 270, 20, 30);
    position.add(place5);

    //initializing the score variables from 1-10 by passing it through the sortMyStats method in the TriviaGame class
    userName1 = new JLabel(TriviaGame.sortMyStats(0));
    userName1.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName1.setBounds(10, 110, 200, 30);
    userNameDisplay.add(userName1);

    userName2 = new JLabel(TriviaGame.sortMyStats(1));
    userName2.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName2.setBounds(10, 150, 200, 30);
    userNameDisplay.add(userName2);

    userName3 = new JLabel(TriviaGame.sortMyStats(2));
    userName3.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName3.setBounds(10, 190, 200, 30);
    userNameDisplay.add(userName3);

    userName4 = new JLabel(TriviaGame.sortMyStats(3));
    userName4.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName4.setBounds(10, 230, 200, 30);
    userNameDisplay.add(userName4);

    userName5 = new JLabel(TriviaGame.sortMyStats(4));
    userName5.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    userName5.setBounds(10, 270, 200, 30);
    userNameDisplay.add(userName5);

    //initializing the main menu button
    

    setVisible(true); //sets all above to visable

    
  }//end of personalStatsGUI method

  public static void setTimesPlayed(int n){
      timesPlayed = n;
    }

    public static int getTimesPlayed(){
      return timesPlayed;
    }
 

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == mainMenue){ //if mainMenu button was clicked the my stats screen will delete and the main menu will open up
      dispose();
      new MainMenueGUI();
  }
}
} //end of personalStatsGUI class