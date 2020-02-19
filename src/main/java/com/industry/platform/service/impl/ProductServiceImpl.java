package com.industry.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.industry.platform.dao.generator.IndbProductDetailMapper;
import com.industry.platform.dao.generator.IndbPropertyMapper;
import com.industry.platform.dao.generator.SysMenuMapper;
import com.industry.platform.dto.generator.*;
import com.industry.platform.service.ProductService;
import com.industry.platform.utils.CollectionUtils;
import com.industry.platform.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private IndbProductDetailMapper indbProductDetailMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private IndbPropertyMapper indbPropertyMapper;

    @Override
    public List<IndbProductDetail> getIndexProduct() {
        IndbProductDetailExample example = new IndbProductDetailExample();
        IndbProductDetailExample.Criteria criteria = example.createCriteria();
        criteria.andIsTopEqualTo(1);
        criteria.andIsUsedEqualTo(1);
        example.setOrderByClause("sort");
        List<IndbProductDetail> indbProductDetailList = indbProductDetailMapper.selectByExample(example);
        return indbProductDetailList;
    }

    @Override
    public PageInfo<IndbProductDetail> getProductList(Integer menuId,PageInfo<IndbProductDetail> pageResult) {
        IndbProductDetailExample example = new IndbProductDetailExample();
        example.setOrderByClause("sort");
        IndbProductDetailExample.Criteria criteria = example.createCriteria();
        criteria.andIsUsedEqualTo(1);
        if(menuId!=null && menuId!=0){
            criteria.andTagIdEqualTo(menuId);
        }
        PageHelper.startPage(pageResult.getPageNum(),pageResult.getPageSize(),true);
        List<IndbProductDetail> indbProductDetailList = indbProductDetailMapper.selectByExample(example);
        pageResult = new PageInfo<>(indbProductDetailList);
        return pageResult;
    }

    @Override
    public List<IndbProductDetail> getProductByTag(Integer tagId) {
        IndbProductDetailExample example = new IndbProductDetailExample();
        IndbProductDetailExample.Criteria criteria = example.createCriteria();
        criteria.andTagIdEqualTo(tagId);
        criteria.andIsUsedEqualTo(1);
        example.setOrderByClause("sort");

        List<IndbProductDetail> indbProductDetailList = indbProductDetailMapper.selectByExample(example);
        return indbProductDetailList;
    }

    @Override
    public IndbProductDetail getProductDetail(Integer id) {
        return indbProductDetailMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysMenu> getMenuList() {
        IndbPropertyExample propertyExample = new IndbPropertyExample();
        IndbPropertyExample.Criteria criteria1 = propertyExample.createCriteria();
        criteria1.andNameEqualTo("productMenu");
        List<IndbProperty> indbProperty = indbPropertyMapper.selectByExample(propertyExample);
        if(CollectionUtils.isNotEmpty(indbProperty)) {
            SysMenuExample sysMenuExample = new SysMenuExample();
            SysMenuExample.Criteria criteria = sysMenuExample.createCriteria();
            criteria.andMenuNameLike(indbProperty.get(0).getContent());
            List<SysMenu> sysMenuParentList = sysMenuMapper.selectByExample(sysMenuExample);
            if(CollectionUtils.isNotEmpty(sysMenuParentList)){
                Integer parentId = sysMenuParentList.get(0).getMenuId();
                SysMenuExample sysMenuExample2 = new SysMenuExample();
                SysMenuExample.Criteria criteria2 = sysMenuExample2.createCriteria();
                criteria2.andParentIdEqualTo(parentId);
                List<SysMenu> sysMenuList = sysMenuMapper.selectByExample(sysMenuExample2);
                return sysMenuList;
            }
        }
        return null;
    }

    @Override
    public SysMenu getMenuById(Integer tagId) {
        SysMenu menu = null;
        if(tagId!=null && tagId!=0){
            menu = sysMenuMapper.selectByPrimaryKey(tagId);
        }
        return menu;
    }

    @Override
    public PageInfo<IndbProductDetail> getProductByName(PageInfo<IndbProductDetail> pageResult,String name) {
        IndbProductDetailExample example = new IndbProductDetailExample();
        example.setOrderByClause("sort");
        IndbProductDetailExample.Criteria criteria = example.createCriteria();
        criteria.andIsUsedEqualTo(1);
        criteria.andNameLike("%"+name+"%");
        PageHelper.startPage(pageResult.getPageNum(),pageResult.getPageSize(),true);
        List<IndbProductDetail> indbProductDetailList = indbProductDetailMapper.selectByExample(example);
        pageResult = new PageInfo<>(indbProductDetailList);
        return pageResult;
    }


}
