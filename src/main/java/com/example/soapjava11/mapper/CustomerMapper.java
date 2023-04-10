package com.example.soapjava11.mapper;

import com.example.soapjava11.loaneligibility.CustomerRequest;
import com.example.soapjava11.loaneligibility.DrinkDTO;
import com.example.soapjava11.loaneligibility.FoodDTO;
import com.example.soapjava11.model.CustomerModel;
import com.example.soapjava11.model.DrinkModel;
import com.example.soapjava11.model.FoodModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import java.math.BigDecimal;

public class CustomerMapper {

    public static CustomerModel toModel(CustomerRequest request) {
        ModelMapper modelMapper = setConfiguracoes(new ModelMapper());
        return modelMapper.map(request, CustomerModel.class);

    }

    private static ModelMapper setConfiguracoes(ModelMapper modelMapper) {

        TypeMap<CustomerRequest, CustomerModel> propertyMapper = modelMapper
                .createTypeMap(CustomerRequest.class, CustomerModel.class);

        //Mapping fields with different names to CustomerModel;
        propertyMapper.addMappings(
                mapper -> mapper.map(src -> src.getFoodDTO(), CustomerModel::setFoods));

        //Mapping fields with different names to FoodModel;
        TypeMap<FoodDTO, FoodModel> propertyMapper2 = modelMapper.createTypeMap(FoodDTO.class, FoodModel.class);
        propertyMapper2.addMappings(mapper -> {
            mapper.map(foodDTO -> foodDTO.getFoodName(), FoodModel::setName);
            mapper.map(foodDTO -> new BigDecimal(foodDTO.getPrice()), FoodModel::setPrice);
        });

        //Mapping field with different type to DrinkModel;
        TypeMap<DrinkDTO, DrinkModel> propertyMapperDrink = modelMapper.createTypeMap(DrinkDTO.class, DrinkModel.class);
        propertyMapperDrink.addMappings(mapper ->
                mapper.map(drinkDTO -> new BigDecimal(drinkDTO.getPrice()), DrinkModel::setPrice)
        );

        return modelMapper;
    }
}
