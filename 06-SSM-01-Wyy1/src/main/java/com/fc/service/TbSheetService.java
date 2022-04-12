package com.fc.service;

import com.fc.entity.TbMusic;
import com.fc.entity.TbSheet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TbSheetService {
    List<TbSheet> findAll();

    List<TbMusic> findSongsBySheet(String sheetName);

    Map<String, Object> insertSheet(TbSheet sheetName);
}
