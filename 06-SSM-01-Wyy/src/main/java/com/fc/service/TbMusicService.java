package com.fc.service;

import com.fc.entity.TbMusic;

import java.util.List;

public interface TbMusicService {
    public List<TbMusic> findAll();

    public TbMusic findById(Integer musicId);

    TbMusic nestSong(Integer musicId);

    TbMusic prevSong(Integer musicId);

    List<TbMusic> search(String keyword);
}
