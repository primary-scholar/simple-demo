### 在spring的包扫描过程中 spring 只会给予当前包路径 扫描当前包及其自包中的类；如使用AnnotationConfigApplicationContext.scan(a.b.c) 则spring只会扫描a/b/c 包以下的类 (包含当前包)

### 在spring 的多model 服务中 只有 上下有依赖的 model 才会被扫描；
### 如 spring-model-serverA-->spring-model-service-->spring-model-dao 如果在 spring-model-serverA中指定了扫描的包名 则只有在此依赖链上的包才会被扫描；不在当前链上的 同名包下的类 不会被加载；