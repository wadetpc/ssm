package tpc.ssm.design.decorate;

/**
 * 装饰类
 */
public class IphoneDecorate implements Iphone {
    private Iphone iphone;

    public IphoneDecorate(Iphone iphone) {
        this.iphone = iphone;
    }

    @Override
    public void call() {
        System.out.println("装饰");
        iphone.call();
    }
}
