import com.alipay.objquery.query.Order;
import com.alipay.objquery.query.Query;
import com.alipay.objquery.service.impl.ObjectQueryServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ²âÊÔwhereÌõ¼þ
 */
public class TestOrder {

    @Test
    public void test() {

        List<TestData> data = new ArrayList<>();
        data.add(new TestData(2, "wwww"));
        data.add(new TestData(3, "bbbb"));
        data.add(new TestData(1, "abcd"));
        data.add(new TestData(4, "ebac"));
        data.add(new TestData(6, "bdcq"));
        data.add(new TestData(5, "ccdd"));

        long start = System.currentTimeMillis();

        Order<TestData> order = new Order<>();
        order.add(TestData::getId, Order.OrderType.DESC);

        Query<TestData> query = new Query();
        query.setOrder(order);
        List<TestData> result = new ObjectQueryServiceImpl().query(data, query);

        result.forEach(e -> System.out.println(String.format("id: %s \t name: %s", e.getId(), e.getName())));
        assert result.get(0).getId() == 6 && result.get(5).getId() == 1;
        System.out.println("cost time: " + (System.currentTimeMillis() - start));
    }
}
