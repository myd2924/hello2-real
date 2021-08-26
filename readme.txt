项目模块化
1、新建springboot项目
2、选中项目，新建module
3、配置各个pom文件的依赖关系
4、删掉无用的mvn文件【随心】

/*****************************/
5、Axon Framework实践
5.1-简单来讲，对数据库的修改操作，UI层只管发送各种命令(Command)，触发事件(Event)，
然后由EventHandler去异步处理，最终写入master DB，对于数据库的查询，则查询slave DB
（注：这里的master db, slave db只是一个逻辑上的区分，可以是真正的主-从库，也可以都是一个库）。
这样的架构，很容易实现读写分离，也易于大型项目的扩展。
5.2-command是业务，event是状态转移；commandBus 命令总线分发  eventBus 事件总线分发

6、orika  beanMapper实践
