package com.fc.service.impl;

import com.fc.dao.TbSheetMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TbSheetServiceImpl implements TbSheetService {
    @Autowired
    private TbSheetMapper tbSheetMapper;
    @Override
    public List<TbSheet> findAll() {
        return tbSheetMapper.selectByExample(null);
    }

    @Override
    public List<TbMusic> findSongsBySheet(String sheetName) {

        return tbSheetMapper.findSongsBySheet(sheetName);
    }

    @Override
    public Map<String, Object> insertSheet(TbSheet sheetName) {
        tbSheetMapper.insertSelective(sheetName);
        Map<String, Object> map = new HashMap<>();

        map.put("code",200);
        map.put("success",true);
        map.put("massage","成功");

        return map;
    }
}
