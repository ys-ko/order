package mall.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import mall.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "/order",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Order order(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody Order order
    ) throws Exception {
        System.out.println("##### /order/order  called #####");
        order.order();
        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/order cancel",
        method = RequestMethod.GET,
        produces = "application/json;charset=UTF-8"
    )
    public Order orderCancel(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody Order order
    ) throws Exception {
        System.out.println("##### /order/orderCancel  called #####");
        order.orderCancel();
        orderRepository.save(order);
        return order;
    }
    // keep
}
