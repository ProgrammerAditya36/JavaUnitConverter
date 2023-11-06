package converterExceptions;
public class InputException extends Exception{
    int from;
    int to;
    InputException(int from, int to){
        this.from= from;
        this.to=to;
    }
    public String toString(){
        return "Invalid input. Enter input ranging from "+from+" to "+to;
    }
}
