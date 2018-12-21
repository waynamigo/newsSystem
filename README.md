# 软件复用课程设计

## 创建数据库
```
yum install mysql mysql-server mysql-devel
create user newsadmin;
create database newsbase;
grant all privileges on newsbase.* to newsadmin@localhost identified by'password';
```
* 数据库用户名，密码在application.yml文件中配置

## 服务器环境
```bash
yum install java-1.8.0-openjdk-devel
安装maven到usr/local/apache-maven
export MAVEN_HOME=/usr/local/apache-maven
export PATH=${MAVEN_HOME}/bin:$PATH
服务器端Could not find or load main class org.apache.maven.wrapper.MavenWrapperMain
错误解决：mvn io.takari:maven:wrapper
```
* 环境变量别写错
## mysql服务没启动的错误，很奇妙
```
/etc/rc.d/init.d/mysqld status 

/etc/init.d/mysqld start
```
## 创建项目文件夹

```
mkdir /classdesign
chmod 754 /classdesign
```
## 运行项目
```

nohup java -jar newsSystem.jar > springbootinfo.out 2>&1  &
或
nohup ./mvnw spring-boot:run > springbootinfo.out 2>&1  &
```
