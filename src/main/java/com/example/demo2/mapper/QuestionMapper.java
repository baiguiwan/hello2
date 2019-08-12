package com.example.demo2.mapper;

import com.example.demo2.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title,question,gmt_create,gmt_modified,creator) values (#{title},#{question},#{gmtCreate},#{gmtModified},#{creator})")
    public void create(Question question);

    @Select("select * from question")
    List<Question> list();
}
