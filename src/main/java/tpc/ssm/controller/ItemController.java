package tpc.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tpc.ssm.po.Item;
import tpc.ssm.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 实现HttpRequestHandler接口，Controller接口，还有注解
 * 注解：类上加上@Controller
 * 类上或方法上加上@RequestMapping
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService service;

    //RequestMapping此时填写url
    //ModelAndView:model表示的是数据模型，view表示最终展示的用户视图
    @RequestMapping("queryItem")
    public ModelAndView queryItem() {
        //查询数据库，用静态数据
        List<Item> itemList = service.queryItemList();
        ModelAndView modelAndView = new ModelAndView();
        //设置数据模型,相当于request的setAttribute方法,实际上，底层确实也是转成了request
        modelAndView.addObject("itemList", itemList);
        //设置视图
        modelAndView.setViewName("item/item-list");
        return modelAndView;
    }

    @RequestMapping("queryItemStr")
    public String queryItem(HttpServletRequest request, Model model) {
        //查询数据库，用静态数据
        List<Item> itemList = service.queryItemList();
        //使用request api
        request.setAttribute("itemList",itemList);
        request.setAttribute("id",1);
        //使用Model接口
        //model.addAttribute("itemList", itemList);
        System.out.println("item/item-list");
        //return "item/item-list";
       // return "redirect:testRedirect";
        return "forward:testForward";
    }

    /**
     * 请求重定向
     */
    @RequestMapping("testRedirect")
    public String testRedirect(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        System.out.println(id);
        return "";
    }

    /**
     * 请求转发
     */
    @RequestMapping("testForward")
    public String testForward(HttpServletRequest request) {
        Integer id = (Integer) request.getAttribute("id");
        System.out.println(id);
        return "";
    }


    @RequestMapping("queryItemById")
    public @ResponseBody Item queryItemById() {
        Item item = service.queryItemById(1);
        return item;
    }
}
