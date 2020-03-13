https://blog.csdn.net/qq_34874784/article/details/104846923

1.动态插入

@Data
@Entity
@DynamicInsert
@Table(name = "cpu_dynamics_information")
@EntityListeners(AuditingEntityListener.class)
public class CpuDynamicsInformation extends CommonEntity implements Serializable {

  private static final long serialVersionUID = -662804563658253624L;

  // cpu动态属性
  private Integer cpuCore;
  // cpu用户使用率
  private Double cpuUseRate;
  // cpu系统使用率
  private Double cpuSysRate;
  // cpu等待率
  private Double cpuWaitRate;
  // cpu空闲率
  private Double cpuIdleRate;
  // cpu总的使用率
  private Double cpuCombineRate;

  private Long serverId;
}
关键注解：

@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
2.重写save（修改）：

@SuppressWarnings(value = "all")
public class JpaRepositoryReBuild<T, ID> extends SimpleJpaRepository<T, ID> {

  private final JpaEntityInformation<T, ?> entityInformation;
  private final EntityManager em;

  @Autowired
  public JpaRepositoryReBuild(
      JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityInformation = entityInformation;
    this.em = entityManager;
  }

  /** 通用save方法 ：新增/选择性更新 */
  @Override
  @Transactional
  public <S extends T> S save(S entity) {

    // 获取ID
    ID entityId = (ID) this.entityInformation.getId(entity);
    T managedEntity;
    T mergedEntity;
    if (entityId == null) {
      em.persist(entity);
      mergedEntity = entity;
    } else {
      managedEntity = this.findById(entityId).get();
      if (managedEntity == null) {
        em.persist(entity);
        mergedEntity = entity;
      } else {
        BeanUtils.copyProperties(entity, managedEntity, getNullProperties(entity));
        em.merge(managedEntity);
        mergedEntity = managedEntity;
      }
    }
    return entity;
  }

  /** 获取对象的空属性 */
  private static String[] getNullProperties(Object src) {
    // 1.获取Bean
    BeanWrapper srcBean = new BeanWrapperImpl(src);
    // 2.获取Bean的属性描述
    PropertyDescriptor[] pds = srcBean.getPropertyDescriptors();
    // 3.获取Bean的空属性
    Set<String> properties = new HashSet<>();
    for (PropertyDescriptor propertyDescriptor : pds) {
      String propertyName = propertyDescriptor.getName();
      Object propertyValue = srcBean.getPropertyValue(propertyName);
      if (StringUtils.isEmpty(propertyValue)) {
        srcBean.setPropertyValue(propertyName, null);
        properties.add(propertyName);
      }
    }
    return properties.toArray(new String[0]);
  }
}
3.启动类

@EnableJpaAuditing
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableJpaRepositories(
    value = {"com.fooww.research.repository", "com.fooww.research.shiro.repository"},
    repositoryBaseClass = JpaRepositoryReBuild.class)
public class MonitorServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(MonitorServerApplication.class, args);
  }
}
关键注释：

EnableJpaRepositories 扫描的repository包
repositoryBaseClass 重写的save类
EnableJpaAuditing 使@EntityListeners(AuditingEntityListener.class) 生效