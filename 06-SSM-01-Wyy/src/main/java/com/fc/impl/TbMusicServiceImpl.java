package com.fc.impl;

import com.fc.dao.TbMusicMapper;
import com.fc.entity.TbMusic;
import com.fc.entity.TbMusicExample;
import com.fc.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class TbMusicServiceImpl implements TbMusicService {

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
    public TbMusic nestSong(Integer musicId) {
        Integer MaxId = tbMusicMapper.findMaxId();

        if (musicId != MaxId) {
            musicId++;
        }else {
            musicId = tbMusicMapper.findMinId();;
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(Integer musicId) {
        Integer MinId = tbMusicMapper.findMinId();

        if (musicId != MinId) {
            musicId--;
        }else {
            musicId = tbMusicMapper.findMaxId();
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample tbMusicExample = new TbMusicExample();

        TbMusicExample.Criteria criteria = tbMusicExample.createCriteria();

        criteria.andMusicNameLike("%" + keyword+ "%");


        return tbMusicMapper.selectByExample(tbMusicExample);
    }

}
