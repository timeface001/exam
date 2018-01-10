package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Paper;
import com.fs.ntes.domain.ext.PaperExtMapper;
import com.fs.ntes.dto.PageRequest;
import com.fs.ntes.service.PaperService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperExtMapper paperExtMapper;

    @Override
    public int save(Paper paper) {
        int i;
        if (Objects.nonNull(paper.getId())) {
            i = paperExtMapper.updateByPrimaryKeySelective(paper);
        } else {
            i = paperExtMapper.insertSelective(paper);
        }
        return i;
    }

    @Override
    public Page<Paper> selectList(Long uid, PageRequest page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return paperExtMapper.selectListByUid(uid);
    }
}
