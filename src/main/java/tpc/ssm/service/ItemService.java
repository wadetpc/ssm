package tpc.ssm.service;

import tpc.ssm.po.Item;

import java.util.List;

public interface ItemService {
    List<Item> queryItemList();

    Item queryItemById(Integer id);
}
