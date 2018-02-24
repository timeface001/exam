package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.mapper.RelationsMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationsExtMapper extends RelationsMapper {

    int paperQuestionRelation(@Param("questionIds") List<Integer> questionIds, @Param("paperId") Integer paperId, @Param("pointId") Integer pointId);

    int paperItemRelation(@Param("itemIds") List<Integer> itemIds, @Param("paperId") Integer paperId);

    int paperPointRelation(@Param("pointIds") List<Integer> pointIds, @Param("paperId") Integer paperId);

    int delRelations(@Param("initialId") Integer initialId, @Param("referId") Integer referId, @Param("referType") Integer referType);

    List<Integer> selectQuestionIdsByPaperIdAndPointId(@Param("paperId") Integer paperId, @Param("pointId") Integer pointId);

    Integer countPointSelect(@Param("paperId") Integer paperId, @Param("pointId") Integer pointId);
}
