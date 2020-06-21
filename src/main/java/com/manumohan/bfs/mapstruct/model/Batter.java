package com.manumohan.bfs.mapstruct.model;

import java.util.Objects;

public class Batter
{
	private String id;
	private String type;

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
		Batter batter = (Batter) o;

		return id.equals(batter.id);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(id);
	}
}
