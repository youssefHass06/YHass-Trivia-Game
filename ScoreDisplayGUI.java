
//imports to use in code
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.*;
import static java.lang.System.*;

public class ScoreDisplayGUI extends JFrame implements ActionListener { // start of score display class
  // declaring variables
  JPanel endGame;
  JButton mainMenue, myStats;
  JLabel totalScore, player;
   //declaring and initializing colours to use
  Color orange = new Color(0, 145, 173);
  Color pistacio = new Color(134, 205, 130);
  Color mint = new Color(138, 233, 193);

  public ScoreDisplayGUI() { //start of score display method

    setTitle("Trivia Game");
    setBounds(0, 0, 600, 400);

    //initializing panel
    endGame = new JPanel();
    endGame.setBounds(0, 0, 600, 400);
    endGame.setBackground(orange);
    endGame.setLayout(null);
    this.add(endGame);

    //initializing Jabales that will display the score out off 2000 and the username
    totalScore = new JLabel(TriviaGame.getScore() + " / 2000", SwingConstants.CENTER);
    totalScore.setFont(new Font("Serif Bold Italic", Font.PLAIN, 30));
    totalScore.setBounds(0, 195, 600, 30);
    endGame.add(totalScore);

    player = new JLabel(TriviaGame.getUserName() + "'s score:", SwingConstants.CENTER);
    player.setFont(new Font("Serif Bold Italic", Font.PLAIN, 30));
    player.setBounds(0, 140, 600, 30);
    endGame.add(player);

    //initializing buttons
    mainMenue = new JButton("Back to Menue");
    mainMenue.setBounds(150, 250, 140, 30);
    mainMenue.addActionListener(this);
    endGame.add(mainMenue);

    myStats = new JButton("My Stats");
    myStats.setBounds(310, 250, 140, 30);
    myStats.addActionListener(this);
    endGame.add(myStats);

    setVisible(true); //sets everything above as visable in the UI to the user
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == mainMenue) { //if mainMenu was clicked th e score display will be disposed and the mainmenu will open up
      dispose();
      new MainMenueGUI();
    }
    if (e.getSource() == myStats) { //if myStats was clicked score Display will be disposed and the PersonalStats will open
      dispose();
      new PersonalStatsGUI();
    }
  }
}