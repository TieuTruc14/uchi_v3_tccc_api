package com.vn.osp.notarialservices.utils;


/**
 * <P>Constants</P>
 *
 * @author  Nguyen Thanh Hai
 * @version $Revision: 20437 $
 */
public class Constants {

    /** Filter Kind */
    public enum FilterKind {
        /** Full */
        FULL
        /** Left */
        , LEFT
        /** Middle */
        , MIDDLE

        ;


        public Integer getValue() {
            switch (this) {
            case FULL:
                return 0;
            case LEFT:
                return 1;
            case MIDDLE:
                return 2;
            default:
                return null;
            }
        }


        public static FilterKind changeValue(Integer value) {
            if (value == null) {
                return null;
            }
            switch (value) {
            case 0:
                return FULL;
            case 1:
                return LEFT;
            case 2:
                return MIDDLE;
            default:
                return null;
            }
        }
    };

    public static  final String SESSION_ACTION = "action";
    public static final int ROW_PER_PAGE = 20;
    /** Authority Code */
    public static final String AUTHORITY_CONTRACT		= "01";
    public static final String AUTHORITY_PREVENT_DATA	= "02";
    public static final String AUTHORITY_BANK_REPORT	= "03";
    public static final String AUTHORITY_ADMIN 			= "04";
    public static final String AUTHORITY_ANNOUNCEMENT   = "05";
        
    /*Role*/
    public static final String CAN_BO_TIEP_NHAN   = "06";
    public static final String CONG_CHUNG_VIEN   = "07";
    public static final String LANH_DAO     = "08";
    public static final String REPORT     = "09";
    
    public static final String VAN_THU      = "010";
    public static final String OTHER        = "99";

    //Loai tai san
    public static final String NHA_DAT = "01";
    public static final String OTO_XEMAY = "02";
    public static final String TAI_SAN_KHAC = "99";
    
    /**Type Prevent */
    public static final int TIEP_NHAN = 1;
    public static final int DA_TRINH = 2;
    public static final int CHUA_XU_LY = 3;
    public static final int DA_DUYET = 4;
    public static final int KHONG_DUYET = 5;
    public static final Boolean GIAI_TOA = true;

    /** Notary Office Type */
    public static final Byte OFFICE_TYPE_JUSTICE	= 1;
    public static final Byte OFFICE_TYPE_NOTARY		= 2;
    public static final Byte OFFICE_TYPE_ORTHER		= 3;

    /** Common Integer */
    public static final int LENGTH_STRING_LIMIT = 100;
    public static final int LENGTH_OUTPUT_LIMIT = 200;

    /** Common String */
    public static final String DOT3 = "...";
    public static final String ENTER = "\n";
    public static final String SPACE = " ";
    public static final String COLON = ":";
    public static final String MASK = "\"";
    public static final String PLUS = "\\+";
    public static final String MINUS = "\\-";
    public static final String SEMI_COLON = ";";
    public static final String UNIT_SEPARATOR = "_";
    public static final String PERCENT = "%";
    public static final String VERTICAL_LINE = "|";
    public static final String SHARP = "#";
    public static final String BULLET = "-";
    
    /** Execute data key */
    public static final String PREVENT_ENTRY_KEY = "PREVENT_ENTRY";
    public static final String PREVENT_UPDATE_KEY = "PREVENT_UPDATE";
    public static final String PREVENT_DELETE_KEY = "PREVENT_DELETE";
    public static final String PREVENT_RELEASE_KEY = "PREVENT_RELEASE";
    public static final String PREVENT_SUBMIT_LEADER = "SUBMIT_LEADER";
    public static final String PREVENT_APPROVE = "APPROVE";
    public static final String PREVENT_DIVISION = "DIVISION";
    public static final String PREVENT_SUBMIT_APPROVE = "SUBMIT_APPROVE";

    /** Synchronize data key */
    public static final Byte SYNCHRONIZE_TYPE_PREVENT = 1;
    public static final Byte SYNCHRONIZE_TYPE_HISTORY = 2;
    public static final Byte SYNCHRONIZE_TYPE_ANNOUNCEMENT = 3;

    public static final Byte SYNCHRONIZE_ACTION_REGIST = 1;
    public static final Byte SYNCHRONIZE_ACTION_EDIT = 2;
    public static final Byte SYNCHRONIZE_ACTION_DELETE = 3;
    public static final Byte SYNCHRONIZE_ACTION_RELEASE = 4;

    // 3 loai quyen: quan tri HT, chuc nang, bao cao
    public static final int AUTHORITY_TYPE_SYSTEM_MANAGER = 1;
    public static final int AUTHORITY_TYPE_FUNCION = 2;
    public static final int AUTHORITY_TYPE_REPORT = 3;

    //gia tri thap phan cua role
    public static final int AUTHORITY_XEM = 64;
    public static final int AUTHORITY_THEM = 32;
    public static final int AUTHORITY_SUA = 16;
    public static final int AUTHORITY_XOA = 8;
    public static final int AUTHORITY_TIMKIEM = 4;
    public static final int AUTHORITY_IN = 2;
    public static final int AUTHORITY_BACKUP = 1;

    // max size file upload
    public static final long MAX_SIZE_FILE_UPLOAD = 20971520;

    //access history type
    public static  final int LOGIN = 0;
    public static  final int LOGOUT = 1;

    //backup
    public static final String CONFIG_BACKUP_DATABASE_FOLDER = "system_backup_database_folder";
    public static final String CHECK_BACKUP_DATABASE = "backup_check";
    public static final String CONFIG_MYSQL_DUMP_FOLDER = "system_mysql_mysqldump_folder";
    public static final String CONFIG_TIME_BACKUP = "time_bacup";
    public static final String CONFIG_DATE_BACKUP = "date_backup";
    public static final String FILE_NAME_BACKUP = "backupnow.bat";
    public static final String FILE_NAME_RESTORE = "restore.bat";

    public static final String STP_API_LINK = "http://localhost:8081/api";
    public static final String VPCC_API_LINK = "http://localhost:8082/api";

    //contract kind
    public static final int LCV_QSDD = 1;
    public static final int LCV_TAI_SAN_KHAC = 2;
    public static final int LCV_THUC_HIEN_NGHIA_VU_DAN_SU = 3;
    public static final int LCV_GIAO_DICH_THUA_KE = 4;
    public static final int LCV_LOAI_CONG_VIEC_KHAC = 5;

    //contract kind code
    public static final String LCV_QSDD_CODE = "1";
    public static final String LCV_TAI_SAN_KHAC_CODE = "2";
    public static final String LCV_THUC_HIEN_NGHIA_VU_DAN_SU_CODE = "3";
    public static final String LCV_GIAO_DICH_THUA_KE_CODE = "4";
    public static final String LCV_LOAI_CONG_VIEC_KHAC_CODE = "5";

    //Dong bo hop dong
    public static final int CREATE_CONTRACT = 1;
    public static final int UPDATE_CONTRACT = 2;
    public static final int DELETE_CONTRACT = 3;
    public static final int CANCEL_CONTRACT = 4;
    public static final int FREE_CONTRACT = 5;

}
