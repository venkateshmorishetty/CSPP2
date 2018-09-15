import java.util.Scanner;

/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Quiz q = new Quiz();
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        for(int i = 0; i < questionCount; i++) {
            String[] arr = s.nextLine().split(":");
            String[] choices = arr[1].split(",");
            Question q =new  Question(arr[0], choices, Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4])); 
            quiz.q_array(q);
        }
        System.out.println("4 are added to the quiz");
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        int[] answers = new int[20];
        String dis="";
        for(int i = 0; i < answerCount; i++) {
            String[] ans = new String[2];
            System.out.println(quiz.q[i].question+""+"("+(i+1)+")");
            for(int j = 0; j < 4; j++) {
                dis += quiz.q[j].choices[j]+"        ";
            }
            System.out.println(dis);
            ans = s.nextLine().split(" ");
            answers[i] = Integer.parseInt(ans[1]);
            dis = "";
        }
        quiz.answers(answers);
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        int s = 0;
        for(int i = 0; i < quiz.size; i++){
            System.out.println(quiz.q[i].question);
            if(quiz.ans[i] == quiz.q[i].answer) {
                System.out.println(" Correct Answer! - Marks Awarded: "+quiz.q[i].score);
                s = s + quiz.q[i].score;
            }
            else {
                System.out.println(" Wrong Answer! - Penalty: "+quiz.q[i].reduction);
                s = s + quiz.q[i].reduction;
            }
        }
        System.out.println("Total Score: "+s);
;
    }
}
class Question{
    String question;
    String[] choices;
    int answer;
    int score;
    int reduction;
    public Question(String q,String[] ch, int a, int s, int re) {
        question = q;
        choices = ch;
        answer = a;
        score = s;
        reduction = re;
    }
}
class Quiz{
    Question[] q = new Question[20];
    int size = 0;
    int[] ans = new int[20];
    int size1 = ans.length;
    public void q_array(Question qu){
        q[size++] = qu;
    }
    public void answers(int[] ans){
        this.ans = ans;
    }
}