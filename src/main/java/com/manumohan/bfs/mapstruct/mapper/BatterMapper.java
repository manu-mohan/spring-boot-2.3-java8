package com.manumohan.bfs.mapstruct.mapper;

import com.manumohan.bfs.mapstruct.model.Batter;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
	collectionMappingStrategy = CollectionMappingStrategy.SETTER_PREFERRED,
	unmappedTargetPolicy = ReportingPolicy.ERROR,
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	componentModel = "spring")
public abstract class BatterMapper
{
	void updateBatter(@MappingTarget List<Batter> sourceList, List<Batter> updateList)
	{
		for (Batter updatedBatter : updateList)
		{
			if (sourceList.contains(updatedBatter))
			{
				sourceList.set(sourceList.indexOf(updatedBatter), updatedBatter);
			}
			else
			{
				sourceList.add(updatedBatter);
			}
		}
	}
}
