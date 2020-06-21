package com.manumohan.bfs.mapstruct;

import com.manumohan.bfs.mapstruct.mapper.CakeMapper;
import com.manumohan.bfs.mapstruct.model.Cake;
import com.manumohan.bfs.mapstruct.model.Topping;
import com.manumohan.bfs.mapstruct.util.CakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MainController
{
	private final CakeMapper cakeMapper;

	public MainController(CakeMapper cakeMapper)
	{
		this.cakeMapper = cakeMapper;
	}

	@GetMapping("/test")
	public Cake getCake()
	{
		Cake               source         = CakeUtil.createCake("1234", "SourceName", "0.5", "donut", null, "456", "Chocolate", "457", "Blueberry");
		Cake               update         = CakeUtil.createCake("1236", "UpdatedName", "0.5", null, "Delicacy", "456", "Regular");
		ArrayList<Topping> sourceToppings = CakeUtil.createToppings("123", "Powdered Sugar");
		source.setTopping(sourceToppings);
		ArrayList<Topping> updateToppings = CakeUtil.createToppings("123", "Maple Syrup", "125", "Powder Sugar");
		update.setTopping(updateToppings);

		cakeMapper.updateCake(source, update);

		return source;
	}
}
