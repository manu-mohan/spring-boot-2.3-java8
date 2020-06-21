package com.manumohan.bfs.mapstruct.util;

import com.manumohan.bfs.mapstruct.model.Batter;
import com.manumohan.bfs.mapstruct.model.Batters;
import com.manumohan.bfs.mapstruct.model.Cake;
import com.manumohan.bfs.mapstruct.model.Topping;

import java.util.ArrayList;
import java.util.List;

public class CakeUtil
{
	public static Cake createCake(String id, String name, String ppu, String type, String genre, String ...args)
	{
		Cake cake = new Cake();

		cake.setId(id);
		cake.setName(name);
		cake.setPpu(ppu);
		cake.setType(type);
		cake.setGenre(genre);

		Batters batters = new Batters();

		if(args.length > 0)
		{
			List<Batter> batterList = new ArrayList<>();
			batters.setBatter(batterList);

			for (int i = 0; i < args.length; i++)
			{
				Batter batter = new Batter();

				batter.setId(args[i++]);
				batter.setType(args[i]);

				batterList.add(batter);
			}

			cake.setBatters(batters);
		}

		return cake;
	}

	public static ArrayList<Topping> createToppings(String... args)
	{
		ArrayList<Topping> toppings = new ArrayList<>();

		for (int i = 0; i < args.length; i++)
		{
			Topping topping = new Topping();

			topping.setId(args[i++]);
			topping.setType(args[i]);

			toppings.add(topping);
		}

		return toppings;
	}
}
