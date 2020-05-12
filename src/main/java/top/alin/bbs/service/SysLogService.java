package top.alin.bbs.service;

import top.alin.bbs.entity.SysLog;

public interface SysLogService {
    int save(SysLog sysLog);

    int update(SysLog sysLog);

    int delete(Integer id);

}
