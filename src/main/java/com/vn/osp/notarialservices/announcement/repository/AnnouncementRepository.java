package com.vn.osp.notarialservices.announcement.repository;

/**
 * Created by minh on 11/7/2016.
 */

import com.vn.osp.notarialservices.announcement.domain.AnnouncementBo;
import com.vn.osp.notarialservices.common.repository.BaseRepository;

public interface AnnouncementRepository extends BaseRepository<AnnouncementBo, Long>, AnnouncementRepositoryCustom {

}
