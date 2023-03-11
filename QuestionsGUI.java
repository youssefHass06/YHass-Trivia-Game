
//imports to use in code
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuestionsGUI extends JFrame implements ActionListener { // start of QuestionsGUI class

  // declaring the variables I will be using
  JButton answerA, answerB, answerC, answerD, startButton;
  JLabel timer, question;
  static JLabel score;
  JPanel top, bottom;
  static int counter;
  // declaring and initializing the colours I will use in the code
  Color lightRed = new Color(154, 225, 157);
  Color white = new Color(255, 255, 255);
  Color black = new Color(0, 0, 0);

  private static int questionSelector;

  public QuestionsGUI() { // start of Questions GUI method
    setTitle("Trivia Game");
    setBounds(0, 0, 600, 400);

    // initializing the top panel
    top = new JPanel();
    top.setBounds(0, 0, 600, 50);
    top.setBackground(white);
    top.setLayout(null);
    this.add(top);

    // initializing the bottom panel
    bottom = new JPanel();
    bottom.setBounds(0, 50, 600, 350);
    bottom.setBackground(lightRed);
    bottom.setLayout(null);
    this.add(bottom);

    // initializing the buttons
    answerA = new JButton("");
    answerA.setBounds(50, 200, 200, 50);
    answerA.addActionListener(this);
    bottom.add(answerA);

    answerB = new JButton("");
    answerB.setBounds(300, 200, 200, 50);
    answerB.addActionListener(this);
    bottom.add(answerB);

    answerC = new JButton("");
    answerC.setBounds(50, 275, 200, 50);
    answerC.addActionListener(this);
    bottom.add(answerC);

    answerD = new JButton("");
    answerD.setBounds(300, 275, 200, 50);
    answerD.addActionListener(this);
    bottom.add(answerD);

    startButton = new JButton("Press to Start");
    startButton.setBounds(50, 332, 200, 40);
    startButton.addActionListener(this);
    bottom.add(startButton);

    // initialing the labels
    question = new JLabel("Question 1");
    question.setFont(new Font("Sans Serif", Font.PLAIN, 16));
    question.setBounds(50, 105, 500, 50);
    bottom.add(question);

    timer = new JLabel(TriviaGame.getUserName());
    timer.setFont(new Font("Sans Serif", Font.PLAIN, 25));
    timer.setBounds(10, 10, 150, 30);
    top.add(timer);

    score = new JLabel("0");
    score.setFont(new Font("Sans Serif", Font.PLAIN, 25));
    score.setBounds(450, 10, 150, 30);
    top.add(score);

    setVisible(true); // sets everything able to visable on the UI to the user
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    answerA.setVisible(false);
    answerB.setVisible(false);
    answerC.setVisible(false);
    answerD.setVisible(false);
  } // end of Questions method

  public static int getQuestionSelector(){
    return questionSelector;
  }
  public static void setQuestionSelector(int n){
    questionSelector = n;
  }
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == startButton) { // if the start button was pressed the gameGenerator will be called from the
                                        // TriviaGame classand the start button will disapear and counter resets to 0
                                        // and the score resets to 0
      answerA.setVisible(true);
      answerB.setVisible(true);
      answerC.setVisible(true);
      answerD.setVisible(true);
      TriviaGame.gameGenerator();
      startButton.setVisible(false);
      counter = 0;
      TriviaGame.setScore(0);
      
      nextQuestion();
    }

    if (e.getSource() == answerA) { // if the answerA button was pressed the text is converted into a string in
                                    // order to be abel to be passed through the compareAnswer method in the
                                    // TriviaGame class then the nextQuestion method is called
      String compareAnswerA = answerA.getText();
      TriviaGame.checkAnswer(compareAnswerA);
      nextQuestion();
    }
    if (e.getSource() == answerB) {// if the answerB button was pressed the text is converted into a string in
                                   // order to be abel to be passed through the compareAnswer method in the
                                   // TriviaGame class then the nextQuestion method is called
      String compareAnswerB = answerB.getText();
      TriviaGame.checkAnswer(compareAnswerB);
      nextQuestion();
    }
    if (e.getSource() == answerC) {// if the answerC button was pressed the text is converted into a string in
                                   // order to be abel to be passed through the compareAnswer method in the
                                   // TriviaGame class then the nextQuestion method is called
      String compareAnswerC = answerC.getText();
      TriviaGame.checkAnswer(compareAnswerC);
      nextQuestion();
    }
    if (e.getSource() == answerD) {// if the answerD button was pressed the text is converted into a string in
                                   // order to be abel to be passed through the compareAnswer method in the
                                   // TriviaGame class then the nextQuestion method is called
      String compareAnswerD = answerD.getText();
      TriviaGame.checkAnswer(compareAnswerD);
      nextQuestion();
    }
  }
//answer
  public void nextQuestion() { // start of next question method
    //declaring variables and initializing the new question
    int filler;
  
    String newQuestion = TriviaGame.questions[TriviaGame.num[counter]];
    if(getQuestionSelector() == 1){
      newQuestion = TriviaGame.carQuestions[TriviaGame.num[counter]];
    }
    if(getQuestionSelector() == 2){
      newQuestion = TriviaGame.sportsQuestions[TriviaGame.num[counter]];
    }
    //Question label is set to the new question
    question.setText(newQuestion);
    int[] randomizeOrder = new int[4];
    randomizeOrder[0] = TriviaGame.num[counter];
    //this for loop fills up the randomize order int with the remaining 3 spaces the first one is manually set to ensure the answer is always in the opetions, the second for loop inside makes sure the answers are not repeated by check the previous numbers in the array and comparing it to the current one
    for (int i = 1; i < 4; i++) {
      filler = (int) (Math.random() * (20 - 1) + 1);
      for (int k = i - 1; k >= 0; k--) {
        while (filler == randomizeOrder[k]) {
          randomizeOrder[0] = TriviaGame.num[counter];
          filler = (int) (Math.random() * (20 - 1) + 1);
        }
      }
      randomizeOrder[i] = filler;
    }
    
    for (int i = 1; i < randomizeOrder.length; i++) {
      for (int j = 0; j < randomizeOrder.length - 1; j++) {
        if (j == i) {
          j++;
        } else {
          while (randomizeOrder[i] == randomizeOrder[j]) {
            randomizeOrder[i] = (int) (Math.random() * (20 - 1) + 1);
          }
        }

      }
    }

    // this for loop swaps the places of the array to make sure the answer is not always in the same box
    for (int n = 0; n < 3; n++) {
      for (int i = 0; i < randomizeOrder.length; i++) {
        int numSwap = (int) (Math.random() * (4 - 1) + 1);
        int store = randomizeOrder[numSwap];
        randomizeOrder[numSwap] = randomizeOrder[i];
        randomizeOrder[i] = store;
      }
    }
    //each answer button is initialized to a specific index of the answer array
    if(getQuestionSelector()==1){
    answerA.setText(TriviaGame.carAnswers[randomizeOrder[0]]);
    answerB.setText(TriviaGame.carAnswers[randomizeOrder[1]]);
    answerC.setText(TriviaGame.carAnswers[randomizeOrder[2]]);
    answerD.setText(TriviaGame.carAnswers[randomizeOrder[3]]);
    }
      if(getQuestionSelector()==2){
    answerA.setText(TriviaGame.sportsAnswers[randomizeOrder[0]]);
    answerB.setText(TriviaGame.sportsAnswers[randomizeOrder[1]]);
    answerC.setText(TriviaGame.sportsAnswers[randomizeOrder[2]]);
    answerD.setText(TriviaGame.sportsAnswers[randomizeOrder[3]]);
    }
    if(getQuestionSelector() == 0){
    answerA.setText(TriviaGame.answers[randomizeOrder[0]]);
    answerB.setText(TriviaGame.answers[randomizeOrder[1]]);
    answerC.setText(TriviaGame.answers[randomizeOrder[2]]);
    answerD.setText(TriviaGame.answers[randomizeOrder[3]]);
    }
    //counter will keep track of the number of answers clicked to ensure it stays within the bounds if it reaches 20 the inputScore method will be called the questionsgui will be disposed of and the scoredisplaygui will open up
    counter++;
    if (counter > 19) {
      counter = 0;
      TriviaGame.inputScore();
      dispose();
      new ScoreDisplayGUI();
    }

  } //end of next question method
} // end of Questions class
