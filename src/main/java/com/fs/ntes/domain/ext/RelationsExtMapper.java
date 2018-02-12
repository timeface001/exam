package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.mapper.RelationsMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationsExtMapper extends RelationsMapper {

    int updateQuestion(@Param("questionIds") List<Integer> questionIds, @Param("paperId") Integer paperId);
}
