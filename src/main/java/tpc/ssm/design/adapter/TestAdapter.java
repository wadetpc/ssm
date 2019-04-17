package tpc.ssm.design.adapter;

import org.junit.Test;

/**
 * 将不同类型的对象可以通过适配模式在一起工作
 */
public class TestAdapter {
    @Test
    public void test(){
        SocketAdapter socket = new SocketAdapter(new GBSocketImpl());
        socket.charge();
    }
}
