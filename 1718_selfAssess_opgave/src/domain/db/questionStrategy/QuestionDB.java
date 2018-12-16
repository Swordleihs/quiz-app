package domain.db.questionStrategy;
import domain.model.Question;
import javafx.collections.ObservableList;
import java.util.ArrayList;

public class QuestionDB extends QuestionContext {
    private ObservableList<Question> questions;

    public QuestionDB(String property) {
        this.fill(property);
    }

    private void fill(String property) {
        System.out.println("Input type: " + property);
        if(property.equals("txt")){
            this.setQuestionReader(new QuestionReaderTxt());
            this.questions = this.performRead();
        }else if(property.equals("excel")){
            this.setQuestionReader(new QuestionReaderExcel());
            this.questions = this.performRead();
        }
    }

    public void updateFile(){
        this.setQuestionWriter(new QuestionWriterTxt());
        this.performWrite(this.questions);
    }

    @Override
    public String toString() {
        String res = "";
        for (Question q : questions) {
            res += "\n=======================" +
                    "\nQuestion: " + q.getQuestion() +
                    "\nPoints: " + q.getPoints() +
                    "\nFeedBack: " + q.getFeedback() +
                    "\nStatements: " + q.printStatements() +
                    "\nCategory: " + q.getCategory();
        }
        return res;
    }

    public ArrayList<Question> getAll() {
        return new ArrayList<>(questions);
    }

    public ObservableList<Question> getAllObservable() {
        return this.questions;
    }

    public void addQuestion(String qu, String fe, String[] st, String ca, int po) {
        questions.add(new Question(qu, fe, st, ca, po));
    }

    public void replace(Question ogQuestion, Question newQuestion){
        int i = this.questions.indexOf(ogQuestion);
        this.questions.set(i, newQuestion);
    }
}
