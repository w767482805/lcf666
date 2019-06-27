package com.lcf.mapper;

import java.util.List;

import com.lcf.model.Brand;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandMapper extends Mapper<Brand> {

    List<Brand> getAllBrand();
}