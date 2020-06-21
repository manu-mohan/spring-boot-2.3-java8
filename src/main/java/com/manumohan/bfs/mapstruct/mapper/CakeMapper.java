package com.manumohan.bfs.mapstruct.mapper;

import com.manumohan.bfs.mapstruct.model.Batters;
import com.manumohan.bfs.mapstruct.model.Cake;
import com.manumohan.bfs.mapstruct.model.Details;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

// https://stackoverflow.com/questions/53938338/how-recursively-update-nested-objects-from-one-object-by-another-use-mapstruct-o
// https://mapstruct.org/documentation/stable/reference/html/#updating-bean-instances
// https://stackabuse.com/guide-to-mapstruct-in-java-advanced-mapping-library/#mappingchildentities
@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
	nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
	collectionMappingStrategy = CollectionMappingStrategy.SETTER_PREFERRED,
	uses = {ToppingMapper.class, BatterMapper.class},
	unmappedTargetPolicy = ReportingPolicy.ERROR,
	injectionStrategy = InjectionStrategy.CONSTRUCTOR,
	componentModel = "spring")
public interface CakeMapper
{
	void updateCake(@MappingTarget Cake source, Cake update);

//	void updateTopping(@MappingTarget List<Topping> source, List<Topping> update);

	void updateBatters(@MappingTarget Batters source, Batters update);

//	void updateBatter(@MappingTarget List<Batter> source, List<Batter> update);

//	default Details mapDetails(Details update)
//	{
//		Details details = new Details();
//
//		return details;
//	}
}
