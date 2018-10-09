package com.vn.osp.notarialservices.utils;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by tieut on 9/20/2017.
 */
public class UploadForm {
    MultipartFile[] files;

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }
}
