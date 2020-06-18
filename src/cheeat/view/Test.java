package cheeat.view;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        View view=new ViewImpl();
        boolean falg=true;
        do {
            view.showMenu();
            int chose=sc.nextInt();
            switch (chose){
                case 1:
                    System.out.println("1.我要订餐");
                    view.orderDish();
                    view.addOrder();
                    break;
                case 2:
                    System.out.println("2.查看订餐");
                    view.orderQuey();
                    break;
                case 3:
                    System.out.println("3.签收订单");
                    view.ordeStatus();
                    break;
                case 4:
                    System.out.println("4.删除订单");
                    view.orderDel();
                    break;
                case 5:
                    System.out.println("5.我要点赞");
                    view.ordeStatus();
                    break;
                case 6:
                    falg=false;
                    default:
            }

        }while (falg);


    }
}
