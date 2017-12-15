package com.fs.ntes.domain.ext;

import com.fs.ntes.domain.Item;
import com.fs.ntes.domain.ItemPoint;
import com.fs.ntes.domain.mapper.ItemMapper;

import java.util.List;
import java.util.Map;

public interface ItemPointExtMapper extends ItemMapper {
    List<ItemPoint> selectList(Map<String, Object> map);

    ItemPoint save(Item item);
}
