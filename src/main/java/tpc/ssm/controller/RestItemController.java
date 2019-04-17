package tpc.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tpc.ssm.po.Item;
import tpc.ssm.service.ItemService;

@RestController
public class RestItemController {
    @Autowired
    private ItemService service;

    @RequestMapping(value = "queryItemByIdWithRest", produces = "application/json;charset=utf-8")
    public Item queryItemById() {
        Item item = service.queryItemById(1);
        return item;
    }

    @RequestMapping(value = "queryString", produces = "application/json;charset=utf-8",method = RequestMethod.GET)
    public String queryString() {
        return "唐培超";
    }

}
