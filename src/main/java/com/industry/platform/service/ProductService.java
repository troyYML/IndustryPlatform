package com.industry.platform.service;

import com.github.pagehelper.PageInfo;
import com.industry.platform.dto.generator.IndbProductDetail;
import com.industry.platform.dto.generator.SysMenu;
import com.industry.platform.utils.PageResult;

import java.util.List;

public interface ProductService {
    public List<IndbProductDetail> getIndexProduct();

    public PageInfo<IndbProductDetail> getProductList(Integer menuId,PageInfo<IndbProductDetail> pageResult);

    public List<IndbProductDetail> getProductByTag(Integer tagId);

    public IndbProductDetail getProductDetail(Integer id);

    public List<SysMenu> getMenuList();

    public SysMenu getMenuById(Integer tagId);

    public PageInfo<IndbProductDetail> getProductByName(PageInfo<IndbProductDetail> pageResult,String name);
}
