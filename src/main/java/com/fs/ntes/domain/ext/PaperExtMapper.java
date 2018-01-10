package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Paper;
import com.fs.ntes.domain.mapper.PaperMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperExtMapper extends PaperMapper {
    Page<Paper> selectListByUid(@Param("uid") Long uid);
}
