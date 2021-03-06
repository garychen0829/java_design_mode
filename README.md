#  java设计模式-从零开始学
## 迭代器模式
### 作用
`提供一种方法循环访问一个聚合对象中各个元素,而又无需暴漏改对象的内部表示,不同方式来遍历整个整合对象`

### 优点： 
+ 1 它支持以不同的方式遍历一个聚合对象。 
+ 2 迭代器简化了聚合类。 
+ 3 在同一个聚合上可以有多个遍历。 
+ 4 在迭代器模式中，增加新的聚合类和迭代器类都很方便，无须修改原有代码。

### 缺点：
由于迭代器模式将存储数据和遍历数据的职责分离，增加新的聚合类需要对应增加新的迭代器类，类的个数成对增加，这在一定程度上增加了系统的复杂性。

|名字|说明|
| --- | --- |
|Aggregate|表示集合接口|
|Iterator|遍历集合的接口|
|Book|表示书的类|
|BookShelf|表示书架的类|
|BookShelfIterator|遍历书架的类|
|Main|测试程序入口类|
