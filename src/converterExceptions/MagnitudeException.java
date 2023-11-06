package converterExceptions;
public  class MagnitudeException extends  Exception{
    public String toString(){
        return "Invalid form of magnitude. Enter numerical magnitude in suitable range";
    }
}