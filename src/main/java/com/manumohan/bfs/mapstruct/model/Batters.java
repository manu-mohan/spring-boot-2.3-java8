package com.manumohan.bfs.mapstruct.model;

import java.util.List;
import java.util.Objects;

public class Batters
{
	private List<Batter> batter;

	public List<Batter> getBatter()
	{
		return batter;
	}

	public void setBatter(List<Batter> batter)
	{
		this.batter = batter;
	}

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
		Batters batters = (Batters) o;

		return Objects.equals(batter, batters.batter);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(batter);
	}
}
