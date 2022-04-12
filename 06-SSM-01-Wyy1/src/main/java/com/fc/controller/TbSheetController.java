package com.fc.controller;


import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import com.fc.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sheet")
public class TbSheetController {
    @Autowired
    private TbSheetService tbSheetService;

    @RequestMapping("findAll")
    public List<TbSheet> findAll() {
        return tbSheetService.findAll();
    }

    @RequestMapping("findSongsBySheet")
    public List<TbMusic> findSongsBySheet(String sheetName) {
        return tbSheetService.findSongsBySheet(sheetName);
    }

    @RequestMapping("insertSheet")
    public Map<String, Object> insertSheet(TbSheet sheetName) {
        return tbSheetService.insertSheet(sheetName);
    }
}
