package me.zhengjie.yuangan.test;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Component  //注册bean到容器中
@Data
@Validated  //数据校验
public class Dog {
    @Email(message="邮箱格式错误")
    private String name;
    private Integer age;

}
