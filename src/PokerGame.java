import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jyp on 2016/10/3.
 */
public class PokerGame {
    public List<Card> pokerCards;
    public List<Player> players;

    public PokerGame(){
        pokerCards = new ArrayList<Card>();
        players = new ArrayList<Player>();
    }

    //显示扑克牌List
    public void showPokeCards(){
        System.out.print("为：[ ");
        for (Card c : pokerCards) {
            System.out.print(c.color+c.num+" ");
        }
        System.out.println("]");
    }
    //显示玩家List
    public void showPlayers(){
        System.out.print("玩家列表为：[");
        for(Player player: players){
            System.out.print(player.getName()+" ");
        }
        System.out.println("]");
    }
    //显示玩家的手牌
    public void showPlayerCards(Player player){
        System.out.println(player.getName()+"手牌为:");
        Collections.sort(player.cards);
        System.out.print("[");
        for(Card c: player.cards){
            System.out.print(c.getColor()+c.getNum()+" ");
        }
        System.out.print("]");
        System.out.println();
    }
    //显示底牌
    public void showBottonCards(){
        Collections.sort(pokerCards);
        System.out.print("底牌");
        showPokeCards();
    }
    //初始化玩家列表
    public  void initPlayers(){
        System.out.println("初始化玩家…………");
        Player player1 = new Player(1,"玩家1");
        Player player2 = new Player(2,"玩家2");
        Player player3 = new Player(3,"玩家3");
        Player player4 = new Player(4,"玩家4");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        System.out.println("初始化玩家结束…………");
    }

    //初始化两副扑克牌
    public void initCard(){
        System.out.println("初始化扑克牌…………");
        String[] colors = {"黑桃","红桃","草花","方片"};
        String[] nums = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        for(int i = 0; i < 2; i++){
            for (String color : colors) {
                for(String num : nums) {
                    pokerCards.add(new Card(color, num));
                }
            }
            pokerCards.add(new Card("大王","0"));
            pokerCards.add(new Card("小王","0"));
        }
        System.out.println("初始化结束");
        System.out.println("------------创建成功------------");
        this.showPokeCards();
    }
    //对扑克牌进行洗牌
    public void shuffle(){
        System.out.println("进行洗牌");
        Collections.shuffle(pokerCards);
        this.showPokeCards();
    }
    //发牌
    /**
     * 给每位玩家发牌
     * @param num 每位玩家发到的张数
     */
    public void deal(int num){
        System.out.println("开始发牌…………");
        for(int i = 0; i < 4 ; i++){
            Player p = players.get(i);
            for(int j = 0; j < num; j++){
                p.cards.add(pokerCards.get(0));
                pokerCards.remove(0);
            }
        }
        System.out.println("发牌结束");
    }

    public static void main(String[] args){
        PokerGame pokerGame = new PokerGame();
        pokerGame.initCard();
        System.out.println("扑克牌总数为"+pokerGame.pokerCards.size());
        pokerGame.shuffle();
        pokerGame.initPlayers();
        pokerGame.showPlayers();
        //每位玩家发25张牌
        pokerGame.deal(25);
        for(int i = 0; i < 4; i++){
            pokerGame.showPlayerCards(pokerGame.players.get(i));
        }
        pokerGame.showBottonCards();

    }

}
