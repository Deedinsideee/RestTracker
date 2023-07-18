package com.example.resttracker.Mapper;



import com.example.resttracker.DTO.GenericDTO;
import com.example.resttracker.Model.GenericModel;

import java.util.List;

public interface Mapper<E extends GenericModel,D extends GenericDTO> {

    E toEntity(D dto);

    D toDTO (E entity);

    List<E> toEntities(List<D> dtos);

    List<D> toDTOs(List<E> entities);


}
