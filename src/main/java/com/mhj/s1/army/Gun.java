package com.mhj.s1.army;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Gun {
	
	@Autowired
	private Bullet bullet;
	
	public Gun() {
		// TODO Auto-generated method stub
	}
	
	public Gun(Bullet bullet) {
		this.bullet = bullet;
	}

	public void trigger() {
		this.bullet.sound();
	}
	
}