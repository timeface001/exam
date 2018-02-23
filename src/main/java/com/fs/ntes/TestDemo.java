package com.fs.ntes;

import com.fs.ntes.domain.ext.RelationsExtMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ExamApplication.class)
public class TestDemo {

    @Autowired
    private RelationsExtMapper relationsExtMapper;

    @Test
    public void paperQuestionTest() {
        List<Integer> list = new ArrayList<>();
        list.add(13);
        list.add(12);
        //relationsExtMapper.updateQuestion(list, 3);
    }

}
