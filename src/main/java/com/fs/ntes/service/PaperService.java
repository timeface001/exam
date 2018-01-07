package com.fs.ntes.service;

import com.fs.ntes.domain.Paper;

import java.util.List;

public interface PaperService {

    int save(Paper paper);

    List<Paper> selectList(Long uid);

}
