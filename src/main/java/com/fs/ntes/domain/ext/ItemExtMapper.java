package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.Member;
import com.fs.ntes.domain.mapper.ItemMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemExtMapper extends ItemMapper {
     List<Item> selectList(@Param("member") Member member);

     void updatePointCount(@Param("id") Integer itemId,@Param("count") int i);

    void updateQuestionCount(@Param("id") Integer itemId, @Param("count") int count);
}
