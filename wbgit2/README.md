使用Spring+Spring MVC重构   2021/10/8



下载信息在本地网页填写

http://localhost:8080/Multithreaded_Download/student

![image-20211101115330936](D:\mygit\wbgit2\下载信息填写.png)

三个信息为文件名，下载链接，保存路径



下载过程信息打印在控制台

![image-20211101115449828](D:\mygit\wbgit2\打印下载过程信息.png)





添加mybatis框架，

使用Log4j生成日志

使用druid连接池连接mysql数据库，增加down数据库存放下载信息  ，

使用maven管理依赖并重构了项目结构，

使用mybatis-generator代码生成插件

实现CRUD,但还没有写对应的前端界面，没有与下载功能结合使用，写了测试代码测试CRUD功能

可以使用导入的tomcat7插件启动，也可以打包部署到tomcat启动

 2021/11/7



![image-20211107102859711](D:\mygit\wbgit2\项目结构.png)
