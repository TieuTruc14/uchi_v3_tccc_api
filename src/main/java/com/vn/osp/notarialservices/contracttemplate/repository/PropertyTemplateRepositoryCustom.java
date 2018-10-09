package com.vn.osp.notarialservices.contracttemplate.repository;

import com.vn.osp.notarialservices.contracttemplate.domain.PropertyTemplateBO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 8/5/2017.
 */
public interface PropertyTemplateRepositoryCustom {
    @Transactional
    Optional<List<PropertyTemplateBO>> list();
    @Transactional
    Optional<List<PropertyTemplateBO>> listItemPage(int offset, int number);
    Optional<List<PropertyTemplateBO>> listItemPageByType(String type, int offset, int number);
    @Transactional
    Optional<List<PropertyTemplateBO>> getByType(String type);
    @Transactional
    Optional<List<PropertyTemplateBO>> getByName(String type);
    @Transactional
    Optional<List<PropertyTemplateBO>> getByCode(String code);
    Optional<Long> countByType(String type);
    Optional<Long> total();
    @Transactional
    Optional<PropertyTemplateBO> getById(int id);
    @Transactional
    Optional<Boolean> add(PropertyTemplateBO item);
    @Transactional
    Optional<Boolean> update(PropertyTemplateBO item);
    @Transactional
    Boolean deleteItem(int id);

}
