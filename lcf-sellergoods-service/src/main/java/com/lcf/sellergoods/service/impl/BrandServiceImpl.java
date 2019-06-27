package com.lcf.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcf.mapper.BrandMapper;
import com.lcf.model.Brand;
import com.lcf.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author:lcf
 * @Date:2019/6/25 14:52
 */
@Service(interfaceClass = BrandService.class)
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    public PageInfo<Brand> getAll(int pageNum, int pageSize) {
        //执行分页
        PageHelper.startPage(pageNum, pageSize);
        //集合查询
        List<Brand> all = brandMapper.selectAll();

        //封装分页对象
        PageInfo<Brand> pageInfo = new PageInfo<Brand>(all);
        return pageInfo;
    }

    public int add(Brand brand) {
        return brandMapper.insertSelective(brand);
    }

    public int modify(Brand brand) {
        return 0;
    }

}
