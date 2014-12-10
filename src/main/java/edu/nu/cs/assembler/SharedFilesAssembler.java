package edu.nu.cs.assembler;

import edu.nu.cs.model.entity.IEntityBean;
import edu.nu.cs.model.entity.SharedFiles;
import edu.nu.cs.model.entity.User;
import edu.nu.cs.value.objects.IValueObject;
import edu.nu.cs.value.objects.SharedFilesVO;
import edu.nu.cs.value.objects.UserVO;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Shared Files Object Assembler
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */
public class SharedFilesAssembler implements IAssembler {
    private static SharedFilesAssembler instance;

    private SharedFilesAssembler() {
    }

    public static SharedFilesAssembler getInstance() {
        if (instance == null) {
            synchronized (SharedFilesAssembler.class) {
                if (instance == null) {
                    instance = new SharedFilesAssembler();
                }
            }
        }
        return instance;
    }


    public IValueObject convertToValueObject(IEntityBean entity) {

        SharedFilesVO vo = null;

        if (entity != null) {
            SharedFiles fileEntity = (SharedFiles) entity;
            vo = new SharedFilesVO();

            vo.setHash(fileEntity.getHash());
            vo.setUser(fileEntity.getUser());
            vo.setExpiry(fileEntity.getExpiry());
            vo.setFilename(fileEntity.getFilename());


        }
        return vo;
    }

    public IEntityBean convertToEntityBean(IValueObject vo) {
        SharedFiles entity = null;

        if (vo != null) {
            SharedFilesVO sharedFileVO = (SharedFilesVO) vo;
            entity = new SharedFiles();

            entity.setHash(sharedFileVO.getHash());
            entity.setUser(sharedFileVO.getUser());
            entity.setExpiry(sharedFileVO.getExpiry());
            entity.setFilename(sharedFileVO.getFilename());
        }
        return entity;
    }
}
