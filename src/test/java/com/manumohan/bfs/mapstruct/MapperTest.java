package com.manumohan.bfs.mapstruct;

import com.manumohan.bfs.mapstruct.mapper.CakeMapper;
import com.manumohan.bfs.mapstruct.model.Cake;
import com.manumohan.bfs.mapstruct.model.Topping;
import com.manumohan.bfs.mapstruct.util.CakeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith( SpringRunner.class )
@SpringBootTest
public class MapperTest
{
	@Autowired
	private CakeMapper cakeMapper;

	@Test
	public void givenUpdatesToSource_whenUpdateHasFieldsNotInSource_thenCorrect()
	{
		Cake source = CakeUtil.createCake("123", "SourceName", "0.5", "donut", null);
		Cake update = CakeUtil.createCake("1235", "UpdateName", "0.5", "donut", "Delicacy", "234", "Regular");

		cakeMapper.updateCake(source, update);

		assertEquals(update.getId(), source.getId());
		assertEquals(update.getName(), source.getName());
		assertEquals(update.getPpu(), source.getPpu());
		assertEquals(update.getGenre(), source.getGenre());
		assertEquals(update.getType(), source.getType());
		assertEquals("234", source.getBatters().getBatter().get(0).getId());
	}

	@Test
	public void givenUpdatesToSource_whenUpdateHasSomeMissingFieldsInSource_thenCorrect()
	{
		Cake source = CakeUtil.createCake("123", "SourceName", "0.5", "donut", null);
		Cake update = CakeUtil.createCake("123", "UpdateName", null, "", "Delicacy", "555", "Chocolate");

		cakeMapper.updateCake(source, update);

		assertEquals(update.getId(), source.getId());
		assertEquals(update.getName(), source.getName());
		assertEquals("0.5", source.getPpu());
		assertEquals(update.getGenre(), source.getGenre());
		assertEquals(update.getType(), source.getType());
		assertEquals("555", source.getBatters().getBatter().get(0).getId());
		assertEquals("Chocolate", source.getBatters().getBatter().get(0).getType());
	}

	@Test
	public void givenUpdatesToSource_whenUpdateHasAdditionalNestedFieldsThanSource_thenCorrect()
	{
		Cake               source         = CakeUtil.createCake("1234", "SourceName", "0.5", "donut", "Delicacy", "222", "Regular");
		Cake               update         = CakeUtil.createCake("1236", "SourceName", "0.5", "donut", "Delicacy", "224", "Chocolate", "222", "Blueberry");
		ArrayList<Topping> sourceToppings = CakeUtil.createToppings("123", "Powdered Sugar");
		source.setTopping(sourceToppings);
		ArrayList<Topping> updateToppings = CakeUtil.createToppings("123", "Powder Sugar", "124", "Maple Syrup");
		update.setTopping(updateToppings);

		cakeMapper.updateCake(source, update);

		assertEquals(update.getId(), source.getId());
		assertEquals(update.getName(), source.getName());
		assertEquals(update.getPpu(), source.getPpu());
		assertEquals(update.getGenre(), source.getGenre());
		assertEquals(update.getType(), source.getType());
		assertEquals(2, source.getTopping().size());
		assertEquals("Powder Sugar", source.getTopping().get(0).getType());
		assertEquals("Maple Syrup", source.getTopping().get(1).getType());
		assertEquals("222", source.getBatters().getBatter().get(0).getId());
		assertEquals("Blueberry", source.getBatters().getBatter().get(0).getType());
		assertEquals("224", source.getBatters().getBatter().get(1).getId());
		assertEquals("Chocolate", source.getBatters().getBatter().get(1).getType());
	}

	@Test
	public void givenUpdatesToSource_whenUpdateHasNestedFieldsNotInSource_thenCorrect()
	{
		Cake               source         = CakeUtil.createCake("1234", "SourceName", "0.5", "donut", "Delicacy");
		Cake               update         = CakeUtil.createCake("1236", "SourceName", "0.5", "donut", "Delicacy", "34", "Chocolate");
		ArrayList<Topping> sourceToppings = CakeUtil.createToppings();
		source.setTopping(sourceToppings);
		ArrayList<Topping> updateToppings = CakeUtil.createToppings("123", "Powder Sugar", "124", "Maple Syrup");
		update.setTopping(updateToppings);

		cakeMapper.updateCake(source, update);

		assertEquals(update.getId(), source.getId());
		assertEquals(update.getName(), source.getName());
		assertEquals(update.getPpu(), source.getPpu());
		assertEquals(update.getGenre(), source.getGenre());
		assertEquals(update.getType(), source.getType());
		assertEquals(2, source.getTopping().size());
		assertEquals("Powder Sugar", source.getTopping().get(0).getType());
		assertEquals("Maple Syrup", source.getTopping().get(1).getType());
		assertEquals("34", source.getBatters().getBatter().get(0).getId());
		assertEquals("Chocolate", source.getBatters().getBatter().get(0).getType());
	}

	@Test
	public void givenUpdatesToSource_whenUpdateHasNoNestedFieldsAsSource_thenCorrect()
	{
		Cake               source         = CakeUtil.createCake("1234", "SourceName", "0.5", "donut", "Delicacy");
		Cake               update         = CakeUtil.createCake("1236", "SourceName", "0.5", "donut", "Delicacy");
		ArrayList<Topping> sourceToppings = CakeUtil.createToppings("123", "Powder Sugar", "124", "Maple Syrup");
		source.setTopping(sourceToppings);
		ArrayList<Topping> updateToppings = CakeUtil.createToppings();
		update.setTopping(updateToppings);

		cakeMapper.updateCake(source, update);

		assertEquals(update.getId(), source.getId());
		assertEquals(update.getName(), source.getName());
		assertEquals(update.getPpu(), source.getPpu());
		assertEquals(update.getGenre(), source.getGenre());
		assertEquals(update.getType(), source.getType());
		assertEquals(2, source.getTopping().size());
		assertEquals("Powder Sugar", source.getTopping().get(0).getType());
		assertEquals("Maple Syrup", source.getTopping().get(1).getType());
	}
}
