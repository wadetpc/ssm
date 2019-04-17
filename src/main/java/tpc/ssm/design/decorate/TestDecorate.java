package tpc.ssm.design.decorate;

import org.junit.Test;

public class TestDecorate {
    @Test
    public void call(){
        Iphone iphone= new IphoneDecorate(new Iphone6());
        iphone.call();
    }
}
