//imports to use in code
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.io.*;
import static java.lang.System.*;

public class CategorySelectionGUI extends JFrame implements ActionListener { //start of category selection class

  //declaring variables in that will be used in the code
  JPanel  mainScreen;
  JButton mainMenu, cars, moviesAndTvShows, sports;
  JLabel selection;
//declaring and initializing colours being used in the code
  Color orange = new Color(0, 145, 173);
  Color pistacio = new Color(134, 205, 130);
  Color mint = new Color(138, 233, 193);

  
  public CategorySelectionGUI() { //start of categoryselection gui creating the UI for the leaderboards.

    int size = 0;
    setTitle("Trivia Game");
    setBounds(0, 0, 300, 400);

    //create a panel for the ui
    mainScreen = new JPanel();
    mainScreen.setBounds(0, 0, 300, 400);
    mainScreen.setBackground(orange);
    mainScreen.setLayout(null);
    this.add(mainScreen);

    selection = new JLabel("Choose your category!", SwingConstants.CENTER);
    selection.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    selection.setBounds(0, 75, 300, 30);
    mainScreen.add(selection);
    //initializing buttons of the different categories and to go back to the main menue
    moviesAndTvShows = new JButton("Movies and Actors");
    moviesAndTvShows.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    moviesAndTvShows.setBounds(50, 150, 200, 30);
    moviesAndTvShows.addActionListener(this);
    mainScreen.add(moviesAndTvShows);
    

    cars = new JButton("Cars");
    cars.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    cars.setBounds(50, 200, 200, 30);
    cars.addActionListener(this);
    mainScreen.add(cars);
    

    sports = new JButton("Sports");
    sports.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    sports.setBounds(50, 250, 200, 30);
    sports.addActionListener(this);
    mainScreen.add(sports);

    mainMenu = new JButton("Main Menu");
    mainMenu.setFont(new Font("Serif Bold Italic", Font.BOLD, 16));
    mainMenu.setBounds(50, 300, 200, 30);
    mainMenu.addActionListener(this);
    mainScreen.add(mainMenu);
    
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);


  }//end of leaderboard method

  @Override//for each button clicked the categoryselectiongui will close and open the questions gui and the setQuestionsSelector will be set to a number which will corespond to the questions being displayed
  public void actionPerformed(ActionEvent e) {

    if(e.getSource() == cars){
      dispose();
      QuestionsGUI.setQuestionSelector(1);
      new QuestionsGUI();
      
    }

    if(e.getSource() == sports){
      dispose();
      QuestionsGUI.setQuestionSelector(2);
      new QuestionsGUI();
      
    }

    if(e.getSource() == moviesAndTvShows){
      dispose();
      QuestionsGUI.setQuestionSelector(0);
      new QuestionsGUI();
      
    }

    if(e.getSource() == mainMenu){
      dispose();
      new MainMenueGUI();
      
    }

  }
}//end of class