package com.cornelius.mapper;

import com.cornelius.bean.User;

/**
 * @Author: wujiapeng
 * @Description:
 * @Date: created in 23:23 2018/4/9
 */
public interface UserMapper {

    User selectById(Integer id);

}
