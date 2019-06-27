package com.lcf.sellergoods.service;

import com.github.pagehelper.PageInfo;
import com.lcf.model.Brand;


/**
*@Author:lcf
*@Date:2019/6/25 14:47
*/
public interface BrandService {
    PageInfo<Brand> getAll(int pageNum,int pageSize);

    int add(Brand brand);

    int modify(Brand brand);
}
