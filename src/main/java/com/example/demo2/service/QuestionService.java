package com.example.demo2.service;

import com.example.demo2.dto.QuestionDTO;
import com.example.demo2.mapper.QuestionMapper;
import com.example.demo2.mapper.UserMapper;
import com.example.demo2.model.Question;
import com.example.demo2.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for(Question question:questions){
            User user=userMapper.findById(question.getCreator());
            QuestionDTO questionDTO=new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }

    public User findByToken(String token) {
        return userMapper.findByToken(token);
    }
}
