package tpc.ssm.design.adapter;

public class SocketAdapter implements GJBZSocket {

    public Object socket;

    public SocketAdapter(Object socket) {
        this.socket = socket;
    }

    @Override
    public void charge() {
        if (socket instanceof GBSocket){
            ((GBSocket) socket).charge();
        }else if (socket instanceof DBSocket){
            ((DBSocket) socket).charge();
        }
    }
}
