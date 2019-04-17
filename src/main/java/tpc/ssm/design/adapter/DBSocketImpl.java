package tpc.ssm.design.adapter;

public class DBSocketImpl implements DBSocket{
    @Override
    public void charge(){
        System.out.println("使用两孔插孔充电");
    }
}
