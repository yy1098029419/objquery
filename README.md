# objquery
蚂蚁金服试题
题目：
用Java实现一个类似SQL查询的服务，参数模型自己设计：
 入参：
  - 类比某张表内全量数据
  - 过滤条件，支持多个，与/或
  - 排序，支持多个，以及升序倒序
  - 分组，支持多个
  - 最大返回结果数
 返回：
  - 查询结果


服务实现类为：com.alipay.objquery.service.impl.ObjectQueryServiceImpl

测试覆盖率以HTML形式存放于testScore文件夹中，可直接访问index.html查看具体细节。

总体覆盖率情况如下<br/>
Overall Coverage Summary<br/>
Package	Class, %	Method, %	Line, %<br/>
all classes	100% (8/ 8)	94.1% (32/ 34)	94.9% (93/ 98)<br/>

Coverage Breakdown<br/>
Package	Class, %	Method, %	Line, %<br/>
com.alipay.objquery.query	100% (6/ 6)	92.6% (25/ 27)	94.2% (65/ 69)<br/>
com.alipay.objquery.query.check	100% (1/ 1)	100% (2/ 2)	100% (5/ 5)<br/>
com.alipay.objquery.service.impl	100% (1/ 1)	100% (5/ 5)	95.8% (23/ 24)
