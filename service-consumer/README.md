服务消费者：

使用Ribbon + RestTemplate实现服务的调用

对于服务的消费的三种实现方式,代码中皆有说明：

方法一：DiscoveryClient：通过元数据获取服务的信息

方法二：LoadBalancerClient：Ribbon的负载均衡器

方法三：@LoadBalanced：通过注解开启Ribbon的负载均衡器