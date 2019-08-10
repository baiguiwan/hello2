package com.example.demo2.mapper;

import com.example.demo2.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,creator) values (#{title},#{question},#{gmtCreate},#{gmtModified},#{creator})")
    public void create(Question question);
}
