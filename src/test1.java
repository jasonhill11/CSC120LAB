public class test1 {

    private static final int MAX_MARK = 13;

    public static void main (String[] args){
        int question;
        boolean pass;
        double fear;

        question = 5;
        fear = 7.3;
        pass = (question / MAX_MARK > 0) || (fear + MAX_MARK) < question + MAX_MARK % question;

        fear = question-- * fear;
        question += 13/5;

    }
}
