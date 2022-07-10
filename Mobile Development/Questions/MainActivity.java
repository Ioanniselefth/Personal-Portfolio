public class MainActivity {

    // Add generateRandomNumber() here
      public int generateRandomNumber(int max){
        double rand = Math.random();
        rand *= max;
        int value = (int) rand; 
        return value;
      }
    // Add getGameOverMessage() here
      public String getGameOverMessage(int totalCorrect, int totalQuestions){
        if (totalCorrect == totalQuestions){
          return "You got all 6 right! You won!";
        }
        return "You got "+totalCorrect+" right out of 6. Better luck next time!";
      }
    }