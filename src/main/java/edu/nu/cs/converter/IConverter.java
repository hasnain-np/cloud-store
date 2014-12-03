package edu.nu.cs.converter;

import edu.nu.cs.model.entity.IEntityBean;
import edu.nu.cs.value.objects.IValueObject;

/**
 * Created by Hasnain on 12/1/2014.
 */
public interface IConverter {
    public IValueObject convertToValueObject(IEntityBean entity);
    public IEntityBean convertToEntityBean(IValueObject vo);
}
