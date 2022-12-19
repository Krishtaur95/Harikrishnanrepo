package org.abstraction;

public class College implements University1 {

	@Override
	public void ug() {
		System.out.println("mechanical engineer");
	}

	@Override
	public void pg() {
		System.out.println("human resource");
	}
	public static void main(String[] args) {
		College c= new College();
		c.ug();
		c.pg();
	}
}
