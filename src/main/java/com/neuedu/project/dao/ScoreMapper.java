package com.neuedu.project.dao;

import com.neuedu.project.domain.Score;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScoreMapper {

    void insertScore(Score score);
}
