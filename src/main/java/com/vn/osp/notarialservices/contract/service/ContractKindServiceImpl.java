
package com.vn.osp.notarialservices.contract.service;

import com.vn.osp.notarialservices.contract.domain.ContractKindBO;
import com.vn.osp.notarialservices.contract.dto.ContractKind;
import com.vn.osp.notarialservices.contract.repository.ContractKindRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by minh on 5/30/2017.
 */
@Component
public class ContractKindServiceImpl implements ContractKindService{
    private static final Logger LOGGER = Logger.getLogger(ContractKindServiceImpl.class);
    private final ContractKindRepository contractKindRepository;
    private final ContractKindConverter contractKindConverter;

    @Autowired
    public ContractKindServiceImpl(final ContractKindRepository contractKindRepository, final ContractKindConverter contractKindConverter) {
        this.contractKindRepository = contractKindRepository;
        this.contractKindConverter = contractKindConverter;
    }

    @Override
    public Optional<Boolean> ContractKindAdd(String id ,String name, Long updateUserId, String updateUserName, String code)
    {
        return contractKindRepository.ContractKindAdd(id,name,updateUserId,updateUserName,code);

    }
    @Override
    public Optional<Boolean> UpdateContractKind(Long id ,String name,  Long updateUserId, String updateUserName,  String contract_kind_code)
    {
        return contractKindRepository.UpdateContractKind(id,name,updateUserId,updateUserName,contract_kind_code);

    }
    @Override
    public Optional<Boolean> deleteContractKind(Long id )
    {
        return contractKindRepository.deleteContractKind(id);

    }
    @Override
    public Optional<List<ContractKind>> findContractKindByFilter(String stringFilter) {

        List<ContractKindBO> listBO = contractKindRepository.findContractKindByFilter(stringFilter).orElse(new ArrayList<ContractKindBO>());
        ArrayList<ContractKind> list = new ArrayList<ContractKind>();
        if (listBO != null && listBO.size() > 0) {
            for (int i = 0; i < listBO.size(); i++) {
                list.add(Optional.ofNullable(listBO.get(i)).map(contractKindConverter::convert).orElse(new ContractKind()));
            }
        }
        return Optional.of(list);
    }
    @Override
    public Optional<BigInteger> countContractKindByFilter(String stringFilter)
    {
        return contractKindRepository.countContractKindByFilter(stringFilter);
    }

    @Override
    public Optional<ContractKind> getContractKindById(String id) {
        return contractKindRepository.getContractKindById(id).map(contractKindConverter::convert);
    }
}

