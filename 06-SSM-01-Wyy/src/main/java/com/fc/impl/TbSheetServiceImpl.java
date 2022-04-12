package com.fc.impl;

import com.fc.dao.TbSheetMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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
        int affectedRows = tbSheetMapper.insertSelective(sheetName);
        Map<String, Object> map = new HashMap<>();

        map.put("code",-1);
        map.put("massage","失败了");
        map.put("success",false);

        if (affectedRows >0) {
            map.put("code",200);
            map.put("massage","成功了");
            map.put("success",true);
        }


        return map;
    }
}
