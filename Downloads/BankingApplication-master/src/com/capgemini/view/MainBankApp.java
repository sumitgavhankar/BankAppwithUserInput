package com.capgemini.view;

import com.capgemini.initializer.AppInitializer;

public class MainBankApp{

	public MainBankApp() {
	}
	public static void main(String[] args) throws Exception {
		AppInitializer appInitializer= new AppInitializer();
		appInitializer.showMenu();
	}


}
