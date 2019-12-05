package cn.liuy.test;

import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.liuy.App;
import cn.liuy.dao.UserCrudRespository;
import cn.liuy.dao.UserDaoRepository;
import cn.liuy.dao.UserFindByNameRepository;
import cn.liuy.dao.UserJpaRepository;
import cn.liuy.dao.UserJpaSpecificationExecutor;
import cn.liuy.dao.UserPagingAndSortingRepository;
import cn.liuy.dao.UserQuery;
import cn.liuy.pojo.Principal;
import cn.liuy.pojo.Subordinate;
import cn.liuy.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={App.class})
public class JpaTest {

	@Autowired
	private UserDaoRepository userDaoRepository;
	
	@Autowired
	private UserFindByNameRepository userFindByNameRepository;
	
	@Autowired
	private UserQuery userQuery;
	
	@Autowired
	private UserCrudRespository userCrudRespository;
	
	@Autowired
	private UserPagingAndSortingRepository userPagingAndSortingRepository;
	
	@Autowired
	private UserJpaSpecificationExecutor userJpaSpecificationExecutor;
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Test
	public void saveUser()
	{
		User user=new User();
		user.setName("母亲");
		user.setAge(36);
		user.setAddress("河南省开封市");
		this.userDaoRepository.save(user);
	}
	
	@Test
	public void findByName()
	{
		List<User> users=this.userFindByNameRepository.findByName("liuy");
		for(User user : users)
		{
			System.out.println(user);
		}
	}
	
	@Test
	public void findByNameAndAge()
	{
		List<User> users=this.userFindByNameRepository.findByNameAndAge("妻子",17);
		for(User user : users)
		{
			System.out.println(user);
		}
	}
	
	@Test
	public void findByNameLike()
	{
		List<User> users=this.userFindByNameRepository.findByNameLike("母%");
		for(User user : users)
		{
			System.out.println(user);
		}
	}
	
	@Test
	public void queryByNameHQL()
	{
		List<User> users=this.userQuery.queryByNameHQL("liuy");
		for(User user : users)
		{
			System.out.println(user);
		}
	}
	
	@Test
	public void queryByNameSQL()
	{
		List<User> users=this.userQuery.queryByNameSQL("liuy");
		for(User user : users)
		{
			System.out.println(user);
		}
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void updateByIdName()
	{
		this.userQuery.updateByIdName("谦和滴洋洋",1);
	}
	
	@Test
	public void saveUserCrudRespository()
	{
		User user = new User();
		user.setName("刘明明");
		user.setAge(17);
		user.setAddress("河南省开封市顺河回族区");
		this.userCrudRespository.save(user);
	}
	
	@Test
	public void deleteUserCrudRespository()
	{
		this.userCrudRespository.delete(7);
	}
	
	@Test
	public void findOneCrudRespository()
	{
		User user = this.userCrudRespository.findOne(1);
		System.out.println(user);
	}
	
	@Test
	public void updateUserCrudRespository()
	{
		User user=new User();
		user.setId(6);
		user.setName("刘明小屁");
		user.setAge(17);
		user.setAddress("河南省开封市顺河回族区");
		this.userCrudRespository.save(user);
	}
	
	@Test
	public void pagingAndSortingRespositorySort()
	{
		Order order = new Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		List<User> users = (List<User>) this.userPagingAndSortingRepository.findAll(sort);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void pagingAndSortingRepositoryPage()
	{
		Pageable pageable=new PageRequest(0, 2);
		Page<User> page=this.userPagingAndSortingRepository.findAll(pageable);
		System.out.println("总条数为:"+page.getTotalElements());
		System.out.println("总页数为:"+page.getTotalPages());
		List<User> users = page.getContent();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void pageingAndSortingRepositorySortAndPage()
	{
		Sort sort = new Sort(new Order(Direction.DESC,"id"));
		Pageable pageable = new PageRequest(2, 2, sort);
		Page<User> page = this.userPagingAndSortingRepository.findAll(pageable);
		System.out.println("总条数为:"+page.getTotalElements());
		System.out.println("总页数为:"+page.getTotalPages());
		List<User> users = page.getContent();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void JPARespositorySort()
	{
		Order order = new Order(Direction.DESC, "id");
		Sort sort = new Sort(order);
		List<User> users = this.userDaoRepository.findAll(sort);
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void OneToManyJpaRepository()
	{
		//创建一个主公
		Principal principal = new Principal();
		
		principal.setPrin_name("孙策");
		principal.setPrin_power("吴");
		
		
		
		//创建若干个属下
		Subordinate subordinate=new Subordinate();
		
		subordinate.setSub_name("周瑜");
		subordinate.setSub_effect(98);
		
		//关联
		principal.getSubordinates().add(subordinate);
		subordinate.setPrincipal(principal);
		
		
		//保存到数据库中
		this.userJpaRepository.save(subordinate);
	}
	
	@Test
	public void selectJpaRepository()
	{
		Subordinate subordinate = this.userJpaRepository.findOne(1);
		System.out.println(subordinate);
		Principal principal = subordinate.getPrincipal();
		System.out.println(principal);
	}
	
	@Test
	public void JpaSpecificationExecutorSelect()
	{
		Specification<User> spec = new Specification<User>() {
			
			@Override
			public Predicate toPredicate(Root<User> arg0, CriteriaQuery<?> arg1, CriteriaBuilder arg2) {
				// where name = 谦和滴洋洋 and age = 19
				//Predicate封装了单个条件语句
				List<Predicate> list = new ArrayList<Predicate>();
				Predicate p1 = arg2.equal(arg0.get("name"),"谦和滴洋洋");
				Predicate p2 = arg2.equal(arg0.get("age"),19);
				list.add(p1);
				list.add(p2);
				Predicate[] predicates = new Predicate[list.size()];
				return arg2.and(list.toArray(predicates));
			}
		};
		List<User> users = this.userJpaSpecificationExecutor.findAll(spec);
		System.out.println(users);
	}
	
}
