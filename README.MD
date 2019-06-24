# 在odps平台下面将IP转化为地区，
用 spark 的udf实现，java语言


## todo
- ~~添加国家、省份、城市~~
- 目前用正则做，测试到的bug有，不能跨级（如缺失省级，直接到市级），结果的正确性依赖于输入，没对省市区做校验。


## ref
解析IP模块copy的[jarod/qqwry-java](https://github.com/jarod/qqwry-java.git)

