package jp.co.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Hotel;
import jp.co.sample.form.HotelForm;
import jp.co.sample.repository.HotelRepository;

@Controller
@Transactional
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelRepository repository;
	
	@ModelAttribute
	public HotelForm setUpsearch() {
		return new HotelForm();
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "/hotel/viewLowerHotel";
	}
	
	public String viewTest(Model model) {
		return "/hotel/viewLowerHotel";
	}
	
	
	@RequestMapping("/viewLowerHotel")
	public String viewLowerHotel(HotelForm form,Model model) {
		List<Hotel> hotelList = repository.findByLowPrice(form.getPrice());
		model.addAttribute("hotelList", hotelList);
		return viewTest(model);
	}
	
}
