package tpc.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import tpc.ssm.exception.CustormException;
import tpc.ssm.po.Item;
import tpc.ssm.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 实现HttpRequestHandler接口，Controller接口，还有注解
 * 注解：类上加上@Controller
 * 类上或方法上加上@RequestMapping
 */
@Controller
@RequestMapping(produces = "application/json;charset=utf-8")
public class ItemController {

    @Autowired
    private ItemService service;

    //RequestMapping此时填写url
    //ModelAndView:model表示的是数据模型，view表示最终展示的用户视图
    @RequestMapping("queryItem")
    public ModelAndView queryItem() throws CustormException{
        //查询数据库，用静态数据
        List<Item> itemList = service.queryItemList();
        if (itemList.size()<10) {
            throw new CustormException("自定义异常");
        }
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

    @RequestMapping("findItem")
    @ResponseBody
    public String findItem(@RequestParam("id") int areaId){
        return "接收到的请求参数是："+ areaId;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String[] deleteItem(String[] ids){
        return ids;
    }

    @RequestMapping("queryDate")
    @ResponseBody
    public Date queryDate(Date date){
        return date;
    }

    @RequestMapping(value = "updateItems",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Item updateItems(Integer id, String name, Float price, Item item, MultipartFile pictureFile) throws IOException {
        System.out.println(pictureFile);
        if (pictureFile!=null){
            //指定存储文件的根目录
            String originalFilename = pictureFile.getOriginalFilename();
            if (!StringUtils.isEmpty(originalFilename)){
                //获取扩展名
                String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
                //重新生成一个文件名称
                String newFileName = UUID.randomUUID().toString()+extName;
                //指定存储文件的根目录
                String baseDir = "E:";
                File dirFile = new File(baseDir);
                if (dirFile.exists()){
                    dirFile.mkdirs();
                }
                pictureFile.transferTo(new File(baseDir+newFileName));
                item.setPic(newFileName);
                service.updateItem(item);
            }
            //将上传的文件复制到新的文件中
        }
        return item;
    }

    @RequestMapping("showEdit")
    public String showEdit(Integer id,Model model){
        Item item = service.queryItemById(id);
        model.addAttribute("item",item);
        return "/item/item-edit";
    }

}