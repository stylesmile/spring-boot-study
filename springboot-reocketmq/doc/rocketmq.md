##需要的环境变量
ROCKETMQ_HOME="D:\rocketmq"
NAMESRV_ADDR="localhost:9876"
JAVA_HOME=

###启动 NameServer
.\bin\mqnamesrv.cmd
###启动 Broker
.\bin\mqbroker.cmd -n localhost:9876 autoCreateTopicEnable=true


##win10文档
##创建topic
./mqadmin.cmd updatetopic -n mq服务器所在地址 -c 进群组名 -t topic名字
cmd mqadmin.cmd updatetopic -n 192.168.3.118:9876 -c AdpMqCluster -t topic_topic
cmd mqadmin.cmd updatetopic -n 192.168.3.118:9876 -c AdpMqCluster -t test_topic

进群组名 rocketmq/conf/2m-noslave/broker-b.properties 的 brokerClusterName
./mqadmin.cmd updatetopic -n localhost:9876 -c DefaultCluster -t test_topic


命令：sh mqadmin updatetopic -n mq服务器所在地址 -c 进群组名 -t topic名字
##修改topic
sh mqadmin updatetopic -n 192.168.3.118:9876 -c AdpMqCluster -t topic_topic

发送消息
tools.cmd  org.apache.rocketmq.example.quickstart.Producer
消费消息
tools.cmd  org.apache.rocketmq.example.quickstart.Consumer

