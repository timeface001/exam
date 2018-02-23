package com.fs.ntes.service;

import com.fs.ntes.domain.Paper;
import com.fs.ntes.dto.PageRequest;
import com.github.pagehelper.Page;

public interface PaperService {

    int save(Paper paper);

    Page<Paper> selectList(Long uid, PageRequest page);

    Paper selectOneById(Integer paperId);

}
