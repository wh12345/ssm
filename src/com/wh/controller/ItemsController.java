package com.wh.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wh.pojo.Items;
import com.wh.service.ItemsService;
import com.wh.vo.QueryVo;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Resource(name="itemsService")
	private ItemsService itemsService;
	/*@RequestMapping(value="/list",method=RequestMethod.POST)*/
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list() {
		List<Items> list = itemsService.list();
		ModelAndView mv = new ModelAndView();
		mv.addObject("itemList", list);
		mv.setViewName("itemList");
		return mv;
	}
	@RequestMapping("/itemEdit/{id}")
	public  String itemEdit(@PathVariable Integer id,Model model) {
		//String id = request.getParameter("id");
		Items items = itemsService.queryItemsById(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	
	@RequestMapping("/updateitem")
	public String updateitem(Integer id,String name,Float price,String detail,Date createtime) {
		Items items = new Items();
		items.setId(id);
		items.setName(name);
		items.setPrice(price);
		items.setDetail(detail);
		items.setCreatetime(createtime);	 
		itemsService.update(items);
		return "success";
	}
	
	@RequestMapping("/queryitem")
	public String queryitem(QueryVo vo) {
		System.out.println(vo.getItems());
		return "";
	}
	
	@RequestMapping("/deleteItems")
	public String deleteItems(QueryVo vo) {
		System.out.println(vo);
		return "";
	}
	
	@RequestMapping("/deleteItemsList")
	public String deleteItemsList(QueryVo vo) {
		System.out.println(vo);
		return "";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(MultipartFile pictureFile,Items items,Model model) {
		String pictureName =pictureFile.getOriginalFilename();
		String newPictureName =UUID.randomUUID().toString()+pictureName.substring(pictureName.lastIndexOf("."));
		try {
			pictureFile.transferTo(new File("G:\\test\\"+newPictureName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		items.setPic(newPictureName);
		itemsService.update(items);
		model.addAttribute("id", items.getId());
		//转发
		//return "forward:/items/itemEdit.action";
		//重定向使用model也可以把数据转发过，
		return "redirect:/items/itemEdit.action";
	}
	@RequestMapping(value="/sendJson",method=RequestMethod.POST)
	@ResponseBody
	public Items sendJson(@RequestBody Items items) {
		System.out.println(items);
		return items;
	}
}
