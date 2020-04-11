# SpringBootLearnMook
基于模块demo

1. 第一个spring boot项目
    * 定义用户模型 id name
    * 客户端发送POST,创建用户(Web MVC)
    * 客户端发送GET,获取所有用户(Web Flux)
2. 拆分项目为多模块  
    * 调整父工程类型（\<packaging>）
    * 创建子模块工程（\<module>）
        * 模型层
        * 持久层
        * 表示层
    * 子模块依赖管理（\<dependencyManagement>）
    
