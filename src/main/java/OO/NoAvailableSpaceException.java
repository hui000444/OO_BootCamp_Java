package OO;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class NoAvailableSpaceException extends Exception {
    @Override
    public String getMessage() {
        return "No Available Space!";
    }
}
