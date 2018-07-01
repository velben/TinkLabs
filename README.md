##描述
该项目使用了MVVM架构和Kotlin编写，功能模块位于feature包下

## 测试方法
* 工具类方法使用Junit测试
* View层使用android instrumentation和 espresso进行集成和功能测试
* 核心逻辑使用mockito测试，因为Mockito简单易用，可以在测试过程中直接mock对象来替代真实对象从而可以完全解耦测试接口
* 数据层使用Robolectric （ 因为依赖于Android SDK中的类 ）进行集成测试和单元测试
