package dao;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IUserImplDAO i = new IUserImplDAO();
		i.getUser("hala", "omad");
		System.out.print(i.login("hala", "omad"));
	}

}
