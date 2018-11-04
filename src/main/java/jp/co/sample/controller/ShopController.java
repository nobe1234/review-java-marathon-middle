package jp.co.sample.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Shop;
import jp.co.sample.form.ShopForm;
import jp.co.sample.repository.ShopRepository;

@Controller
@Transactional
@RequestMapping("/shop")
public class ShopController {

	@Autowired
	private ShopRepository repository;

	@ModelAttribute
	public ShopForm setupShop() {
		return new ShopForm();
	}

	@RequestMapping("/index")
	public String index(Model model) {
		Map<Integer, String> genderMap = new LinkedHashMap<>();
		genderMap.put(0, "Man");
		genderMap.put(1, "Woman");
		
		model.addAttribute("genderMap",genderMap);
		
		
		Map<String, String> colorMap = new LinkedHashMap<>();
		colorMap.put("赤", "赤");
		colorMap.put("青", "青");
		colorMap.put("黄", "黄");
		colorMap.put("白", "白");
		
		model.addAttribute("colorMap",colorMap);
		
		return "/shop/selectClothes";
	}

	@RequestMapping("/viewClothes")
	public String viewSelectClothesByColorAndGender(Model model,ShopForm form) {
		List<Shop> shopList = repository.findByColorAndGender(form.getColor(), form.getGender());
		
		model.addAttribute("shopList", shopList);
		return index(model);
	}

}
