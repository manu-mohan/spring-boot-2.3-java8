package com.manumohan.bfs.mapstruct.mapper;

import com.manumohan.bfs.mapstruct.model.Topping;
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
public abstract class ToppingMapper
{
	void updateTopping(List<Topping> updateList, @MappingTarget List<Topping> sourceList)
	{
		for (Topping updatedTopping : updateList)
		{
			if (!sourceList.contains(updatedTopping))
			{
				sourceList.add(updatedTopping);
			}
			else
			{
				sourceList.set(sourceList.indexOf(updatedTopping), updatedTopping);
			}
		}
	}
}
