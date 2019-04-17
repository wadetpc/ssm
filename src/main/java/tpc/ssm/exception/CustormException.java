package tpc.ssm.exception;

/**
 * 自定义编译时异常
 */
public class CustormException extends Exception {

    private String msg;

    public CustormException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
