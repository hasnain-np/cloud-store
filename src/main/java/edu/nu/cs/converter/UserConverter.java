package edu.nu.cs.converter;

import edu.nu.cs.model.entity.IEntityBean;
import edu.nu.cs.model.entity.User;
import edu.nu.cs.value.objects.IValueObject;
import edu.nu.cs.value.objects.UserVO;

/**
 * Created by Hasnain on 12/1/2014.
 */
public class UserConverter implements IConverter{
    private static UserConverter instance;
    private UserConverter(){}

    public static UserConverter getInstance(){
        if(instance==null){
            synchronized (UserConverter.class){
                if(instance==null){
                    instance = new UserConverter();
                }
            }
        }
        return instance;
    }


    public IValueObject convertToValueObject(IEntityBean entity){
        UserVO vo = null;

        if(entity!=null){
            User userEntity = (User)entity;
            vo = new UserVO();

            vo.setUserID(userEntity.getUserID());
            vo.setUserName(userEntity.getUserName());
            vo.setPassword(userEntity.getPassword());
        }
        return vo;
    }

    public IEntityBean convertToEntityBean(IValueObject vo){
        User entity = null;

        if(vo != null){
            UserVO userVO = (UserVO)vo;
            entity = new User();

            entity.setUserID(userVO.getUserID());
            entity.setUserName(userVO.getUserName());
            entity.setPassword(userVO.getPassword());
        }
        return entity;
    }
}
