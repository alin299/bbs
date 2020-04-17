package top.alin.bbs.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        // TODO 方法过时
        this.setInsertFieldValByName("createTime", date, metaObject);
        this.setInsertFieldValByName("updateTime", date, metaObject);
        this.setInsertFieldValByName("deleted", 0, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName("updateTime", new Date(), metaObject);
    }
}
