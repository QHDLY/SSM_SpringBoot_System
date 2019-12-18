package cn.liuy.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

//配置类
//创建动态代理类

@Configuration
@MapperScan("cn.liuy.mapper")
public class SpringConfig {
	
}
