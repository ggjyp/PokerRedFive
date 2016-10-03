import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/3.
 */
public class Player {
    public int id;
    public String name;
    //使用List存储Card，方便排序
    public List<Card> cards;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        cards = new ArrayList<Card>();
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
