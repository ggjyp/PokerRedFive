/**
 * Created by Administrator on 2016/10/3.
 */
public class Card implements Comparable<Card>{
    public String color;
    public String num;

    public Card(String color, String num){
        this.color = color;
        this.num = num;
    }

    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public String getNum() {
        return num;
    }


    public void setNum(String num) {
        this.num = num;
    }

    public Integer ColorToInt(String color){
        if (color.equals("大王"))
            return 6;
        if (color.equals("小王"))
            return 5;
        if (color.equals("黑桃"))
            return 4;
        if (color.equals("红桃"))
            return 3;
        if (color.equals("草花"))
            return 2;
        if (color.equals("方片"))
            return 1;
        return 0;
    }

    public Integer NumToInt(String num){
        if (num.equals("A"))
            return 14;
        if (num.equals("K"))
            return 13;
        if (num.equals("Q"))
            return 12;
        if (num.equals("J"))
            return 11;
        else
            return Integer.valueOf(num.trim());
    }



    @Override public int compareTo(Card o) {
        int result = ColorToInt(this.color) - ColorToInt(o.color);
        if (result != 0)
            return result;
        else {
            result = NumToInt(this.num) - NumToInt(o.num);
            return result;
        }

    }
}
