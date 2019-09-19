package com.jhly.community.service;

import com.jhly.community.dto.QuestionDTO;
import com.jhly.community.mapper.QuestionMapper;
import com.jhly.community.mapper.UserMapper;
import com.jhly.community.model.Question;
import com.jhly.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:JHLY
 * @Date:2019/9/18
 * @Description:com.jhly.community.service
 * @Version:1.0
 */
@Service
public class QuestionService {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public List<QuestionDTO> list(){
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList =new ArrayList<>();
        for (Question question:questions){
         User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
