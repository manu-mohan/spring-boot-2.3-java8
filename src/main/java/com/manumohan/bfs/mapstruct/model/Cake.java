package com.manumohan.bfs.mapstruct.model;

import java.util.List;
import java.util.Objects;

public class Cake
{
	private String        id;
	private String        type;
	private String        name;
	private String        ppu;
	private Batters       batters;
	private List<Topping> topping;
	private String        genre;
//	private Details       details;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPpu()
	{
		return ppu;
	}

	public void setPpu(String ppu)
	{
		this.ppu = ppu;
	}

	public Batters getBatters()
	{
		return batters;
	}

	public void setBatters(Batters batters)
	{
		this.batters = batters;
	}

	public List<Topping> getTopping()
	{
		return topping;
	}

	public void setTopping(List<Topping> topping)
	{
		this.topping = topping;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

//	public Details getDetails()
//	{
//		return details;
//	}
//
//	public void setDetails(Details details)
//	{
//		this.details = details;
//	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		Cake cake = (Cake) o;

		return id == cake.id;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}
}
