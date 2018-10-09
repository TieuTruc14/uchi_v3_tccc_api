package com.vn.osp.notarialservices.contracttemplate.repository;

import com.vn.osp.notarialservices.contract.domain.ContractTemplateBO;
import com.vn.osp.notarialservices.contracttemplate.domain.ContractTempBo;
import com.vn.osp.notarialservices.contracttemplate.dto.ContractTempList;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 7/6/2017.
 */
@Transactional
public interface ContractTempRepositoryCustom {
    /**
     * Method actually triggering a finder but being overridden.
     */
    void findByOverridingMethod();

    /***
     *
     * @param id
     */
    void delete(Integer id);
    Optional<Boolean> addContractTemp(String id ,String name,Long kind_id,Long kind_id_tt08, String code , String description, String file_name,String file_path, Long active_flg, Long relate_object_number,String relate_object_A_display,String relate_object_B_display,String relate_object_C_dispaly, Long period_flag,Long period_req_flag, Long mortage_cancel_func,Long sync_option, Long entry_user_id, String entry_user_name,Long update_user_id, String update_user_name, String kind_html, String office_code, String code_template );
    Optional<List<ContractTempBo>> findContractTempByFilter(String stringFilter);
    Optional<BigInteger> countContractTempByFilter(String stringFilter);
    List<ContractTempList> findContractTempListByFilter(String stringFilter);
    Optional<Boolean> updateContractTemp(String id ,String name,Long kind_id,Long kind_id_tt08, String code , String description, String file_name,String file_path, Long active_flg, Long relate_object_number,String relate_object_A_display,String relate_object_B_display,String relate_object_C_dispaly, Long period_flag,Long period_req_flag, Long mortage_cancel_func,Long sync_option, Long entry_user_id, String entry_user_name,Long update_user_id, String update_user_name, String kind_html, String office_code, String code_template  );
    Optional<Boolean> add(ContractTemplateBO item);
    Optional<Boolean> update(ContractTemplateBO item);
    Optional<Boolean> saveOrUpdates(List<ContractTemplateBO> items);
    Optional<List<ContractTemplateBO>> list();
    Optional<ContractTemplateBO> getById(Long id);
    Optional<List<ContractTemplateBO>> listItemPage(int offset, int number);
    Optional<Long> total();

}
