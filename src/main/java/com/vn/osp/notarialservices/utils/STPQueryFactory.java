package com.vn.osp.notarialservices.utils;


import com.vn.osp.notarialservices.transaction.dto.SynchonizeContractKey;
import com.vn.osp.notarialservices.transaction.dto.TransactionProperty;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tranv on 12/20/2016.
 */
public class STPQueryFactory {
    public static String getClientInfo(HttpServletRequest request) {
        String clientInfo = request.getRemoteAddr() + " [" + request.getSession().getId() + "]";
        return clientInfo;
    }


    public static TransactionProperty getTransactionPropertyById(Long tpid) {
        List<TransactionProperty> result = STPAPIUtil.getTransactionPropertyList(Constants.STP_API_LINK+"/search/transaction-detail", String.valueOf(tpid));
        if (result != null) return result.get(0);
        else return null;
    }

    /*
    * author vietmanh
    * date 3/14/2017
    * Ham dem so trang
    * */
    public static int countPage(int total) {
        int rowPerpage = Constants.ROW_PER_PAGE;
        int result = 0;
        result = total / rowPerpage;
        int temp = total % rowPerpage;
        if (temp > 0) {
            result = result + 1;
            return result;
        } else return result;
    }

    public static List<SynchonizeContractKey> synchronizeContract(String data){
        List<SynchonizeContractKey> result = STPAPIUtil.synchronizeContract(Constants.STP_API_LINK+"/transaction/synchronizeContract", data);
        return result;
    }


}
