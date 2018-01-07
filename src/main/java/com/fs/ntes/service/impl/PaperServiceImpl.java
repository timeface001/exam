package com.fs.ntes.service.impl;

import com.fs.ntes.domain.Paper;
import com.fs.ntes.domain.ext.PaperExtMapper;
import com.fs.ntes.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public List<Paper> selectList(Long uid) {
        return paperExtMapper.selectListByUid(uid);
    }
}
