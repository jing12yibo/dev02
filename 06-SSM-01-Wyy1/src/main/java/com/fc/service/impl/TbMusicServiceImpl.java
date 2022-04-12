package com.fc.service.impl;

import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbMusicServiceImpl implements TbMusicService {
    @Autowired
    private TbMusicMapper tbMusicMapper;

    @Override
    public List<TbMusic> findAll() {
        return tbMusicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(Integer musicId) {
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(Integer musicId) {
        Integer MinId = tbMusicMapper.MinId();

        if (musicId != MinId) {
            musicId--;
        }else {
            musicId = tbMusicMapper.MaxId();
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic nextSong(Integer musicId) {
        Integer MaxId = tbMusicMapper.MaxId();

        if (musicId != MaxId) {
            musicId++;
        }else {
            musicId = tbMusicMapper.MinId();
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample tbMusicExample = new TbMusicExample();

        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();

        criteria.andMusicNameLike("%" + keyword + "%");


        return tbMusicMapper.selectByExample(tbMusicExample);
    }
}
