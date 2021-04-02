package com.turing.sb6.service.imp;

import com.turing.sb6.entity.User;
import com.turing.sb6.entity.UserExample;
import com.turing.sb6.mapper.UserMapper;
import com.turing.sb6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper um;

    @Override
    public User loginUser(User user) {
        UserExample ue=new UserExample();
        UserExample.Criteria criteria = ue.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        criteria.andPassWordEqualTo(user.getPassWord());
        List<User> users = um.selectByExample(ue);
        if(users!=null&&users.size()==1){
           return  users.get(0);
        }else{
            return null;
        }
    }
}
