package com.vn.osp.notarialservices.contracttemplate.repository;

import com.vn.osp.notarialservices.contracttemplate.domain.PrivyTemplateBO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by TienManh on 8/11/2017.
 */
public interface PrivyTemplateRepositoryCustom {
    @Transactional
    Optional<List<PrivyTemplateBO>> list();
    @Transactional
    Optional<List<PrivyTemplateBO>> listItemPage(int offset, int number);
    Optional<List<PrivyTemplateBO>> listItemPageByType(String type, int offset, int number);
    @Transactional
    Optional<List<PrivyTemplateBO>> getByType(String type);
    @Transactional
    Optional<List<PrivyTemplateBO>> getByName(String type);
    @Transactional
    Optional<List<PrivyTemplateBO>> getByCode(String code);

    Optional<Long> countByType(String type);
    Optional<Long> total();
    @Transactional
    Optional<PrivyTemplateBO> getById(int id);
    @Transactional
    Optional<Boolean> add(PrivyTemplateBO item);
    @Transactional
    Optional<Boolean> update(PrivyTemplateBO item);
    @Transactional
    Boolean deleteItem(int id);
}
