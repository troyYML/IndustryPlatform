package com.industry.platform.dao.generator;

import com.industry.platform.dto.generator.IndbProductTag;
import com.industry.platform.dto.generator.IndbProductTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndbProductTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int countByExample(IndbProductTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int deleteByExample(IndbProductTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int insert(IndbProductTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int insertSelective(IndbProductTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    List<IndbProductTag> selectByExample(IndbProductTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    IndbProductTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int updateByExampleSelective(@Param("record") IndbProductTag record, @Param("example") IndbProductTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int updateByExample(@Param("record") IndbProductTag record, @Param("example") IndbProductTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int updateByPrimaryKeySelective(IndbProductTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table indb_product_tag
     *
     * @mbggenerated Tue Feb 18 21:34:23 CST 2020
     */
    int updateByPrimaryKey(IndbProductTag record);
}