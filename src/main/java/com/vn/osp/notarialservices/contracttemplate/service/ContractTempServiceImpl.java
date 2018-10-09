package com.vn.osp.notarialservices.contracttemplate.service;

import com.vn.osp.notarialservices.contracttemplate.domain.ContractTempBo;
import com.vn.osp.notarialservices.contracttemplate.dto.ContractTemp;
import com.vn.osp.notarialservices.contracttemplate.dto.ContractTempList;
//import com.vn.osp.notarialservices.contracttemplate.repository.ContractTempRepository;
import com.vn.osp.notarialservices.contracttemplate.repository.ContractTempRepositoryCustom;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 7/6/2017.
 */
@Component
public class ContractTempServiceImpl implements ContractTempService {
    private static final Logger LOGGER = Logger.getLogger(ContractTempServiceImpl.class);
//    private final ContractTempRepository contractTempRepository;
    private final ContractTempRepositoryCustom contractTempRepository;
    private final ContractTempConverter contractTempConverter;

    @Autowired
    public ContractTempServiceImpl(final ContractTempRepositoryCustom contractTempRepository, final ContractTempConverter contractTempConverter) {
        this.contractTempRepository = contractTempRepository;
        this.contractTempConverter = contractTempConverter;
    }
    @Override
    public Optional<Boolean> addContractTemp(String id ,String name,Long kind_id,Long kind_id_tt08, String code , String description, String file_name,String file_path, Long active_flg, Long relate_object_number,String relate_object_A_display,String relate_object_B_display,String relate_object_C_dispaly, Long period_flag,Long period_req_flag, Long mortage_cancel_func,Long sync_option, Long entry_user_id, String entry_user_name,Long update_user_id, String update_user_name, String kind_html, String office_code, String code_template)
    {
        return contractTempRepository.addContractTemp(id,name,kind_id,kind_id_tt08,code,description,file_name,file_path,active_flg,relate_object_number,relate_object_A_display,relate_object_B_display,relate_object_C_dispaly,period_flag,period_req_flag,mortage_cancel_func,sync_option,entry_user_id,entry_user_name,update_user_id,update_user_name,kind_html,office_code,code_template);

    }
    @Override
    public Optional<Boolean> updateContractTemp(String id ,String name,Long kind_id,Long kind_id_tt08, String code , String description, String file_name,String file_path, Long active_flg, Long relate_object_number,String relate_object_A_display,String relate_object_B_display,String relate_object_C_dispaly, Long period_flag,Long period_req_flag, Long mortage_cancel_func,Long sync_option, Long entry_user_id, String entry_user_name,Long update_user_id, String update_user_name, String kind_html, String office_code, String code_template )
    {
        return contractTempRepository.updateContractTemp(id,name,kind_id,kind_id_tt08,code,description,file_name,file_path,active_flg,relate_object_number,relate_object_A_display,relate_object_B_display,relate_object_C_dispaly,period_flag,period_req_flag,mortage_cancel_func,sync_option,entry_user_id,entry_user_name,update_user_id,update_user_name,kind_html,office_code,code_template);

    }
    @Override
    public Optional<List<ContractTemp>> findContractTempByFilter(String stringFilter) {

        List<ContractTempBo> listBO = contractTempRepository.findContractTempByFilter(stringFilter).orElse(new ArrayList<ContractTempBo>());
        ArrayList<ContractTemp> list = new ArrayList<ContractTemp>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).map(contractTempConverter::convert).orElse(new ContractTemp()));
            }
        }
        return Optional.of(list);
    }
    @Override
    public Optional<BigInteger> countContractTempByFilter(String stringFilter)
    {
        return contractTempRepository.countContractTempByFilter(stringFilter);
    }
    @Override
    public List<ContractTempList> findContractTempListByFilter(String stringFilter) {
        return contractTempRepository.findContractTempListByFilter(stringFilter);
    }

}
