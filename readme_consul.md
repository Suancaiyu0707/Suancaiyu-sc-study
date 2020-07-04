>>使用consul提供服务

1、dependencyManagement和dependencies区别：
    dependencyManagement：用于父类管理，一般在父pom里，使用它，能够在所有子项目中饮用一个依赖而不用显示的列出版本号。maven会沿着父子层次向上走，直到一个有dependencyManagement元素的项目，然后它就会使用这个dependencyManagement元素中指定的版本号。
    dependencyManagement只是声明，并不引入依赖，因此子项目需要显式的声明需要使用的依赖。如果不在子项目中声明依赖，是不会从父类中继承下来的；只有在子类中写了该依赖项，并且没有指定具体版本号，才会从父项目中继承该版本号，并且version和scope都读取自父pom
    
2、eureka、consul、zookepper区别

组件         语言      CAP      服务健康检查           对外暴露接口  
Eureak      java     AP       支持（有界面）           HTTP
Consul      go       CP       支持（有界面）           HTTP/DNS
Zookeeper   java     CP       支持（无界面）           HTTP