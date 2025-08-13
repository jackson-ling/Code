package domain;

/**
 * ClassName: DiningTable
 * Package: domain
 * Description:
 *
 * @author jacksonling
 * @version 1.0
 * @Date 2025-08-06 16:17
 */
public class DiningTable {
    private Integer id;
    private String state;
    private String orderName;
    private String orderTel;

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    // 根据显示要求，重写 toString() 方法调整输出格式
    @Override
    public String toString() {
        return id + "\t\t\t" + state;
    }
}
