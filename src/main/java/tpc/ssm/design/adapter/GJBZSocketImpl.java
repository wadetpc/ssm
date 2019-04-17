package tpc.ssm.design.adapter;

public class GJBZSocketImpl implements DBSocket{
    @Override
    public void charge(){
        System.out.println("使用两孔插孔充电");
    }
}
