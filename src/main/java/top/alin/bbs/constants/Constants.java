package top.alin.bbs.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

public class Constants {
    // 默认查询页
    public final static String DEFAULT_PAGE = "1";

    // 默认每页记录数
    public final static String DEFAULT_PAGE_SIZE = "10";
}
