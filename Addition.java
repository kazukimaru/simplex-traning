public class Addition {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
	if(a < 18.5){
	System.out.println("痩せすぎ");
	}else if(18.5 < a && a < 25){
		System.out.println("標準");
	}else if(25< a && a < 30){
		System.out.println("太り気味");
	}else if(a >= 30){
		System.out.println("太り過ぎ");
	}
    }
}

