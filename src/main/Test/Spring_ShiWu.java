import com.edu.ShiWu.entity.Order;
import com.edu.ShiWu.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:Spring-tx.xml")
public class Spring_ShiWu {
    @Autowired
    private OrderService orderService;
    @Test
    public void APIs(){
        Order order = new Order("100007","100001",2,666,new Date(),new Date(),new Date(),"","","","");
        orderService.addOrder(order);
    }

    @Test
    public void Transcation(){
        Order order = new Order("100007","100001",2,666,new Date(),new Date(),new Date(),"","","","");
        orderService.addOrder(order);
    }

    @Test
    public void Filters(){
        Order order = new Order("100010","100001",2,666,new Date(),new Date(),new Date(),"","","","");
        orderService.addOrder(order);
    }

    @Test
    public void Txs(){
        Order order = new Order("100011","100001",2,666,new Date(),new Date(),new Date(),"","","","");
        orderService.addOrder(order);
    }

    @Test
    public void ZhuJie(){
        Order order = new Order("100012","100001",2,666,new Date(),new Date(),new Date(),"","","","");
        orderService.addOrder(order);
    }
}
