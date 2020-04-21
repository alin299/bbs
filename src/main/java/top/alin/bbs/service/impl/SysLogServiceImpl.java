package top.alin.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.alin.bbs.entity.Comment;
import top.alin.bbs.entity.SysLog;
import top.alin.bbs.mapper.SysLogMapper;
import top.alin.bbs.mapper.SysLogMapper;
import top.alin.bbs.service.SysLogService;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int save(SysLog sysLog) {
        return sysLogMapper.insert(sysLog);
    }

    @Override
    public int update(SysLog sysLog) {
        return sysLogMapper.updateById(sysLog);
    }

    @Override
    public int delete(Integer id) {
        return sysLogMapper.deleteById(id);
    }


}
