package com.vn.osp.notarialservices.utils;

import java.io.File;
import java.io.FileFilter;
import java.util.Calendar;

/**
 *
 * File Utility
 *
 * @author GiangVT
 * @version $Revision: 18978 $
 */
public class FileUtil {

    private static final String SUFFIX = ".dat";

    /**
     *
     * Create new file
     *
     * @author GiangVT
     * @param directory
     *            for file directory
     * @param prefix
     *            for file prefix
     * @return file created or null if process exception
     * @throws Exception
     *             for exception
     */
    public static File createNewFile(String directory, String prefix) throws Exception {
        File dirs = new File(directory);
        if (!dirs.exists()) {
            dirs.mkdirs();
        }
        File file = File.createTempFile(prefix, SUFFIX, dirs);
        return file;
    }
    
    /**
     * Delete over 10 days log files
     */
    public static void deleteLogFile() {
    	File logFolder = new File("/home/npo/web/log");
        if (!logFolder.exists()) {
            return;
        }
        
        FileFilter ff = new FileFilter() {
			

			public boolean accept(File f) {
				//Loc file qua 10 ngay
				if (Calendar.getInstance().getTimeInMillis() - f.lastModified() > 864000000) {
					return true;
				} else {
					return false;
				}
			}
		};
        
        File[] logFiles = logFolder.listFiles(ff);
        
        for (File file : logFiles) {
        	file.delete();
		}
    }
}
