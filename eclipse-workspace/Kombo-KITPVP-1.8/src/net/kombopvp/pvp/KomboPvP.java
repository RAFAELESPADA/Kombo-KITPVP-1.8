	        
		
		ItemStack Resultado = new ItemStack(Material.MUSHROOM_SOUP, 1);
		ItemMeta Cactos = Resultado.getItemMeta();
		Resultado.setItemMeta(Cactos);

		ShapelessRecipe CraftCactos = new ShapelessRecipe(Resultado);
		CraftCactos.addIngredient(1, Material.CACTUS);
		CraftCactos.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCactos);
		ItemMeta Cocoa = Resultado.getItemMeta();
		Resultado.setItemMeta(Cocoa);
		
		ShapelessRecipe CraftCactos2 = new ShapelessRecipe(Resultado);
		CraftCactos2.addIngredient(1, Material.PUMPKIN_SEEDS);
		CraftCactos2.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCactos2);
		ItemMeta Cocoa2 = Resultado.getItemMeta();
		Resultado.setItemMeta(Cocoa2);

		ShapelessRecipe CraftCocoa = new ShapelessRecipe(Resultado);
		CraftCocoa.addIngredient(1, Material.INK_SACK, 3);
		CraftCocoa.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftCocoa);
		ItemMeta Flores = Resultado.getItemMeta();
		Resultado.setItemMeta(Flores);
ScoreboardBuilder.init();
		ShapelessRecipe CraftFlores = new ShapelessRecipe(Resultado);
		CraftFlores.addIngredient(1, Material.YELLOW_FLOWER);
		CraftFlores.addIngredient(1, Material.RED_ROSE);
		CraftFlores.addIngredient(1, Material.BOWL);
		Bukkit.getServer().addRecipe(CraftFlores);
