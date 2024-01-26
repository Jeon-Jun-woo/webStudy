package com.sist.temp;

import java.lang.reflect.Method;

class A{
	public void aaa()
	{
		System.out.println("A:aaa() Call....");
	}
	public void bbb()
	{
		System.out.println("A:bbb() Call....");
	}
	public void ccc()
	{
		System.out.println("A:ccc() Call....");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*A a=new A();
		a.aaa();
		a.bbb();
		a.ccc();*/
		try
		{
			//A a=new A();
			Class clsName=Class.forName("com.sist.temp.A");
			Object obj=clsName.getDeclaredConstructor().newInstance();//클래스안에 생선된 생성자 가져오기
			/*A a=(A)obj;
			a.aaa();
			a.bbb();
			a.ccc(); */
			Method[] methods=clsName.getDeclaredMethods(); //메소드 가져와라 정리된거 메소드 전체
			for(Method m:methods)
			{
				m.invoke(obj, null);
			}
		}catch(Exception ex) {}
	}

}
