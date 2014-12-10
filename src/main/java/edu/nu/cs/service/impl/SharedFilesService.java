package edu.nu.cs.service.impl;

import edu.nu.cs.assembler.SharedFilesAssembler;
import edu.nu.cs.assembler.UserAssembler;
import edu.nu.cs.model.entity.SharedFiles;
import edu.nu.cs.model.repo.SharedFilesRepository;
import edu.nu.cs.service.interfaces.ISharedFilesService;
import edu.nu.cs.service.util.ServiceConstants;
import edu.nu.cs.value.objects.SharedFilesVO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Shared Files Service
 *
 * @author Ayaz Ali Qureshi
 * @version 1.0
 */
@Repository(value = ServiceConstants.SHARED_FILES_SERVICE)
@Transactional(readOnly = true)
public class SharedFilesService implements ISharedFilesService {

    @Resource
    SharedFilesRepository sharedFilesRepository;

    public SharedFilesVO findByHash(SharedFilesVO sharedFilesVO) {
        SharedFiles sharedFiles = sharedFilesRepository.findByHash(sharedFilesVO.getHash());

        return (SharedFilesVO) SharedFilesAssembler.getInstance().convertToValueObject(sharedFiles);
    }

    @Transactional
    public SharedFilesVO save(SharedFilesVO sharedFilesVO) {
        SharedFiles entity = (SharedFiles) SharedFilesAssembler.getInstance().convertToEntityBean(sharedFilesVO);
        entity = sharedFilesRepository.save(entity);

        return (SharedFilesVO) SharedFilesAssembler.getInstance().convertToValueObject(entity);
    }

}
