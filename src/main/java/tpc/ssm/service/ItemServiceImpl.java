package tpc.ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpc.ssm.mapper.ItemMapper;
import tpc.ssm.po.Item;
import tpc.ssm.po.ItemExample;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryItemList() {
        //使用逆向工程
        ItemExample example = new ItemExample();
        //ItemExample.Criteria criteria = example.createCriteria();
        //criteria.andIdEqualTo(1);
        return itemMapper.selectByExample(example);
    }

    @Override
    public Item queryItemById(Integer id) {
        return id == null ? null : itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateByPrimaryKeySelective(item);
    }
}
