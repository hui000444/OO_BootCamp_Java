package OO;

/**
 * Created by ZhangChaohui on 9/19/16.
 */
public class NotFoundCarException extends Exception {
    @Override
    public String getMessage() {
        return "Not Found Car!";
    }
}
