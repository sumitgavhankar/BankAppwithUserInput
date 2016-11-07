package com.capgemini.view;

import com.capgemini.initializer.AppInitializer;

public class MainBankApp{

	public MainBankApp() {
	}
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to the Royal Bank of India");
		AppInitializer appInitializer= new AppInitializer();
		appInitializer.showMenu();
	}


}
