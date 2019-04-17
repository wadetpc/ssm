package tpc.ssm.design.adapter;

public class GBSocketImpl implements GBSocket{
    @Override
    public void charge(){
        System.out.println("使用三眼插孔充电");
    }
}
