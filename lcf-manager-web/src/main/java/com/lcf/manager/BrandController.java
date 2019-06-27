package com.lcf.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.lcf.model.Brand;
import com.lcf.sellergoods.service.BrandService;
import com.lcf.utils.Result;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:lcf
 * @Date:2019/6/25 15:31
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Result modify(@RequestBody Brand brand) {
        try {
            //根据ID修改品牌信息
            int mcount = brandService.modify(brand);
            if (mcount > 0) {
                return new Result(true, "品牌修改成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "品牌修改失败");
    }

    @RequestMapping(value = "/list")
    public PageInfo<Brand> list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        return brandService.getAll(pageNum, size);
    }
    /*@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Brand> list() {
        return brandService.getAll();
    }*/


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@RequestBody Brand brand) {
        try {
            int acount = brandService.add(brand);
            if (acount > 0) {
                return new Result(true, "增加品牌成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Result(false, "增加品牌失败");
    }


    /*@RequestMapping(value = "/add",method = RequestMethod.POST)
    public Map<String,Object> add(@RequestBody Brand brand){
        Map<String,Object> dataMap = new HashMap<String, Object>();

        try {
            int acount = brandService.add(brand);

            if (acount>0){
                dataMap.put("success", true);
                dataMap.put("message", "增加品牌成功");
            }
        } catch(Exception e) {
            e.printStackTrace();
            dataMap.put("success",false);
            dataMap.put("message","增加品牌失败");
        }
        return dataMap;
    }*/
}
