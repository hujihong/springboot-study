package com.boot.study.validator;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/***
 * @null           验证对象是否为空

 @notnull     验证对象是否为非空

 @asserttrue       验证 boolean 对象是否为 true

 @assertfalse      验证 boolean 对象是否为 false

 @min           验证 number 和 string 对象是否大等于指定的值

 @max           验证 number 和 string 对象是否小等于指定的值

 @decimalmin    验证 number 和 string 对象是否大等于指定的值，小数存在精度

 @decimalmax    验证 number 和 string 对象是否小等于指定的值，小数存在精度

 @size           验证对象（array,collection,map,string）长度是否在给定的范围之内

 @digits       验证 number 和 string 的构成是否合法

 @past           验证 date 和 calendar 对象是否在当前时间之前

 @future       验证 date 和 calendar 对象是否在当前时间之后

 @pattern     验证 string 对象是否符合正则表达式的规则

 @Email     验证邮箱



 实际例子：
 @size (min=3, max=20, message="用户名长度只能在3-20之间")
 @size (min=6, max=20, message="密码长度只能在6-20之间")
 @pattern (regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\\.[a-za-z]{2,4}", message="邮件格式错误")
 @Length(min = 5, max = 20, message = "用户名长度必须位于5到20之间")

 @Email(message = "比如输入正确的邮箱")

 @NotNull(message = "用户名称不能为空")
 @Max(value = 100, message = "年龄不能大于100岁")
 @Min(value= 18 ,message= "必须年满18岁！" )
 @AssertTrue(message = "bln4 must is true")

 @AssertFalse(message = "blnf must is falase")
 @DecimalMax(value="100",message="decim最大值是100")
 DecimalMin(value="100",message="decim最小值是100")
 @NotNull(message = "身份证不能为空")
 @Pattern(regexp="^(\\d{18,18}|\\d{15,15}|(\\d{17,17}[x|X]))$", message="身份证格式错误")

 */
public class ValidatorDemo {

    private long id;

    @NotEmpty(message="姓名不能为空")
    private String name;

    @NotEmpty(message="密码不能为空")
    @Length(min=6,message="密码长度不能小于6位")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
