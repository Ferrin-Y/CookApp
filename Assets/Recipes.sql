-- MySQL script to populate recipe database with 25 recipes and their ingredients
-- This script assumes the tables have already been created based on the JPA entity definitions

-- Insert Ingredients (100+ diverse ingredients)
INSERT INTO ingredient (name) VALUES
-- Proteins
('Chicken Breast'), ('Ground Beef'), ('Salmon Fillet'), ('Tofu'), ('Shrimp'), ('Pork Shoulder'), 
('Lamb Chops'), ('Turkey Breast'), ('Tempeh'), ('Seitan'), ('Bacon'), ('Tuna'), ('Eggs'), 
('Lentils'), ('Chickpeas'), ('Black Beans'), ('Kidney Beans'), ('Ground Turkey'), ('Duck Breast'),
('Ribeye Steak'), ('Cod Fillet'), ('Scallops'),

-- Vegetables
('Onion'), ('Garlic'), ('Bell Pepper'), ('Carrot'), ('Celery'), ('Spinach'), ('Kale'), ('Broccoli'),
('Cauliflower'), ('Zucchini'), ('Eggplant'), ('Tomato'), ('Cucumber'), ('Sweet Potato'), ('Potato'),
('Mushrooms'), ('Cabbage'), ('Brussels Sprouts'), ('Corn'), ('Peas'), ('Asparagus'), ('Lettuce'),
('Arugula'), ('Radish'), ('Beets'), ('Bok Choy'), ('Green Beans'), ('Leek'), ('Shallot'), ('Olives'),

-- Fruits
('Lemon'), ('Lime'), ('Orange'), ('Apple'), ('Banana'), ('Strawberry'), ('Blueberry'), ('Raspberry'),
('Mango'), ('Pineapple'), ('Avocado'), ('Coconut'), ('Cherry'), ('Peach'), ('Pear'), ('Plum'),
('Watermelon'), ('Pomegranate'), ('Kiwi'), ('Grapefruit'),

-- Grains, Beans, Nuts & Starches
('Rice'), ('Quinoa'), ('Pasta'), ('Bread'), ('Tortilla'), ('Couscous'), ('Bulgur'), ('Barley'),
('Farro'), ('Oats'), ('Polenta'), ('Breadcrumbs'), ('Flour'), ('Cornmeal'), ('Panko'), ('Walnuts'), ('Beans'),

-- Dairy & Alternatives
('Milk'), ('Heavy Cream'), ('Butter'), ('Yogurt'), ('Sour Cream'), ('Parmesan Cheese'), 
('Cheddar Cheese'), ('Mozzarella'), ('Feta Cheese'), ('Goat Cheese'), ('Cream Cheese'),
('Ricotta'), ('Almond Milk'), ('Coconut Milk'), ('Oat Milk'),

-- Herbs & Spices
('Basil'), ('Cilantro'), ('Parsley'), ('Thyme'), ('Rosemary'), ('Oregano'), ('Cumin'), 
('Paprika'), ('Turmeric'), ('Cinnamon'), ('Nutmeg'), ('Cardamom'), ('Bay Leaf'), ('Vanilla'),
('Mint'), ('Dill'), ('Sage'), ('Coriander'), ('Ginger'), ('Chili Powder'), ('Curry Powder'), ('Star Anise'), ('Cloves'), ('Kaffir Lime Leaves'),

-- Oils, Vinegars & Condiments
('Olive Oil'), ('Vegetable Oil'), ('Sesame Oil'), ('Coconut Oil'), ('Balsamic Vinegar'), ('Rice Vinegar'),
('Soy Sauce'), ('Fish Sauce'), ('Sriracha'), ('Hot Sauce'), ('Ketchup'), ('Mayonnaise'),
('Mustard'), ('Honey'), ('Maple Syrup'), ('Tahini'), ('Peanut Butter'), ('Worcestershire Sauce'), ('Dijon Mustard'),

-- Pantry
('Chocolate Chips'), ('Brown Sugar'), ('Granulated Sugar'), ('Croutons');

-- Insert recipes
INSERT INTO recipes (name, instructions, cooking_time, cuisine, vegetarian, vegan, gluten_free)
VALUES 
-- Recipe 1: Spaghetti Bolognese
('Spaghetti Bolognese', 
'1. Heat olive oil in a large pot over medium heat. Add onions, carrots, and celery, and sauté until softened, about 5 minutes.
2. Add ground beef and cook until browned, breaking it apart with a wooden spoon.
3. Add garlic and cook until fragrant, about 1 minute.
4. Pour in red wine and simmer until reduced by half.
5. Add crushed tomatoes, tomato paste, bay leaves, and herbs. Season with salt and pepper.
6. Reduce heat to low and simmer for at least 30 minutes, preferably 1-2 hours, stirring occasionally.
7. Meanwhile, cook pasta according to package instructions.
8. Serve sauce over pasta and garnish with grated Parmesan cheese and fresh basil.',
60, 'Italian', FALSE, FALSE, FALSE),

-- Recipe 2: Vegetable Stir Fry
('Vegetable Stir Fry',
'1. Prepare all vegetables by washing and chopping into bite-sized pieces.
2. Heat vegetable oil in a wok or large frying pan over high heat.
3. Add garlic and ginger, stir for 30 seconds until fragrant.
4. Add harder vegetables first (carrots, broccoli), stir-fry for 2 minutes.
5. Add bell peppers, mushrooms, and snow peas, continue to stir-fry for 2-3 minutes.
6. Pour in stir-fry sauce, reduce heat to medium, and toss vegetables until coated.
7. Add green onions and sesame seeds.
8. Serve immediately over rice or noodles.',
25, 'Asian', TRUE, TRUE, TRUE),

-- Recipe 3: Chicken Tikka Masala
('Chicken Tikka Masala',
'1. Marinate chicken pieces in yogurt, lemon juice, and spices for at least 1 hour, preferably overnight.
2. Thread chicken onto skewers and grill or broil until charred and cooked through.
3. In a large pan, heat oil and sauté onions until golden brown.
4. Add garlic and ginger, cook for 1 minute until fragrant.
5. Add tomato paste, garam masala, paprika, and cumin. Cook for 1-2 minutes.
6. Add crushed tomatoes and simmer for 10 minutes.
7. Stir in heavy cream and cooked chicken pieces.
8. Simmer for another 10 minutes until sauce thickens.
9. Garnish with fresh cilantro and serve with rice or naan.',
45, 'Indian', FALSE, FALSE, TRUE),

-- Recipe 4: Classic Caesar Salad
('Classic Caesar Salad',
'1. Prepare the dressing by whisking together garlic, anchovy paste, lemon juice, Dijon mustard, Worcestershire sauce, and egg yolk.
2. Slowly drizzle in olive oil while continuing to whisk until emulsified.
3. Add Parmesan cheese and black pepper to the dressing.
4. Tear or chop romaine lettuce into bite-sized pieces and place in a large bowl.
5. Toss lettuce with dressing until evenly coated.
6. Top with croutons, additional Parmesan cheese, and fresh black pepper.
7. Serve immediately.',
15, 'American', TRUE, FALSE, FALSE),

-- Recipe 5: Mushroom Risotto
('Mushroom Risotto',
'1. In a large pot, heat vegetable broth and keep at a simmer.
2. In another pot, heat olive oil and butter over medium heat.
3. Add onions and cook until translucent, about 3-4 minutes.
4. Add mushrooms and cook until they release their moisture and begin to brown.
5. Add garlic and thyme, cook for another minute.
6. Add Arborio rice and stir to coat with oil and butter for 1-2 minutes.
7. Pour in white wine and simmer until absorbed.
8. Begin adding hot broth, one ladle at a time, stirring frequently and allowing each addition to be absorbed before adding more.
9. Continue this process for about 18-20 minutes, until rice is creamy and al dente.
10. Remove from heat, stir in Parmesan cheese and remaining butter.
11. Season with salt and pepper, and garnish with fresh parsley.',
35, 'Italian', TRUE, FALSE, TRUE),

-- Recipe 6: Fish Tacos
('Fish Tacos',
'1. Prepare the marinade by mixing lime juice, olive oil, garlic, chili powder, cumin, and salt.
2. Marinate fish fillets for 15-20 minutes.
3. Make the slaw by combining shredded cabbage, cilantro, lime juice, and salt.
4. Prepare the crema by mixing sour cream, lime zest, lime juice, and hot sauce.
5. Heat a grill or skillet over medium-high heat. Cook fish for 3-4 minutes per side until flaky.
6. Warm tortillas on the grill or in a dry pan.
7. Assemble tacos with fish, slaw, avocado slices, and a drizzle of crema.
8. Serve with lime wedges on the side.',
30, 'Mexican', FALSE, FALSE, FALSE),

-- Recipe 7: Vegan Chickpea Curry
('Vegan Chickpea Curry',
'1. Heat coconut oil in a large pot over medium heat.
2. Add onions and cook until softened, about 5 minutes.
3. Add garlic, ginger, and curry spices. Cook for 1-2 minutes until fragrant.
4. Add diced tomatoes and cook for 5 minutes until slightly broken down.
5. Add coconut milk and chickpeas. Bring to a simmer.
6. Cook for 15-20 minutes, allowing flavors to meld.
7. Stir in spinach and cook until wilted.
8. Season with salt and lime juice.
9. Garnish with fresh cilantro and serve with rice or naan.',
30, 'Indian', TRUE, TRUE, TRUE),

-- Recipe 8: Beef Bourguignon
('Beef Bourguignon',
'1. Preheat oven to 325°F (165°C).
2. In a large Dutch oven, cook bacon until crispy. Remove and set aside.
3. Brown beef cubes in batches in the bacon fat. Set aside with bacon.
4. In the same pot, sauté onions and carrots until softened.
5. Add garlic and cook for 1 minute.
6. Return beef and bacon to the pot. Add red wine, beef broth, tomato paste, and herbs.
7. Bring to a simmer, then cover and transfer to the oven.
8. Cook for 2-3 hours until beef is very tender.
9. In a separate pan, sauté mushrooms in butter until browned.
10. Add mushrooms to the stew for the last 30 minutes of cooking.
11. Serve hot, garnished with fresh parsley.',
180, 'French', FALSE, FALSE, TRUE),

-- Recipe 9: Quinoa Buddha Bowl
('Quinoa Buddha Bowl',
'1. Cook quinoa according to package instructions.
2. Roast sweet potatoes, broccoli, and chickpeas with olive oil, salt, and spices at 400°F for 25-30 minutes.
3. Prepare dressing by whisking together tahini, lemon juice, garlic, maple syrup, and water.
4. Assemble bowls with quinoa as the base, arranged with roasted vegetables, chickpeas, avocado slices, and fresh greens.
5. Drizzle with tahini dressing and sprinkle with seeds.
6. Serve immediately or store components separately for meal prep.',
40, 'Mediterranean', TRUE, TRUE, TRUE),

-- Recipe 10: Lemon Garlic Roast Chicken
('Lemon Garlic Roast Chicken',
'1. Preheat oven to 425°F (220°C).
2. In a small bowl, mix softened butter with minced garlic, lemon zest, chopped herbs, salt, and pepper.
3. Pat chicken dry with paper towels.
4. Loosen skin on chicken breast and thighs, and spread butter mixture underneath.
5. Stuff cavity with lemon halves, garlic cloves, and herb sprigs.
6. Tie legs together with kitchen twine and tuck wing tips under the body.
7. Place chicken in a roasting pan, breast side up.
8. Roast for 50-60 minutes, or until internal temperature reaches 165°F (74°C).
9. Let rest for 10-15 minutes before carving.
10. Serve with pan juices.',
70, 'French', FALSE, FALSE, TRUE),

-- Recipe 11: Shrimp Scampi
('Shrimp Scampi',
'1. Cook linguine according to package instructions. Reserve 1/2 cup pasta water.
2. In a large skillet, heat olive oil over medium-high heat.
3. Add shrimp and cook for 1-2 minutes per side until pink and opaque. Remove from pan.
4. Reduce heat to medium-low. Add butter, garlic, and red pepper flakes. Cook for 1 minute.
5. Add white wine and lemon juice. Simmer for 2-3 minutes.
6. Return shrimp to the pan and add cooked pasta, parsley, and lemon zest.
7. Toss everything together, adding pasta water as needed for desired consistency.
8. Season with salt and pepper.
9. Serve immediately with grated Parmesan cheese.',
25, 'Italian', FALSE, FALSE, FALSE),

-- Recipe 12: Thai Green Curry
('Thai Green Curry',
'1. In a large pot or wok, heat coconut oil over medium heat.
2. Add green curry paste and cook for 1 minute until fragrant.
3. Add sliced chicken and cook until no longer pink on the outside.
4. Pour in coconut milk and bring to a gentle simmer.
5. Add fish sauce, palm sugar, and lime leaves.
6. Simmer for 10 minutes, then add vegetables (bell peppers, bamboo shoots, eggplant).
7. Cook for another 5-7 minutes until vegetables are tender and chicken is cooked through.
8. Stir in Thai basil leaves.
9. Serve hot with jasmine rice.',
35, 'Thai', FALSE, FALSE, TRUE),

-- Recipe 13: Chocolate Chip Cookies
('Chocolate Chip Cookies',
'1. Preheat oven to 375°F (190°C). Line baking sheets with parchment paper.
2. In a medium bowl, whisk together flour, baking soda, and salt.
3. In a large bowl, beat butter and sugars until creamy.
4. Beat in eggs one at a time, then vanilla extract.
5. Gradually mix in the dry ingredients until just combined.
6. Fold in chocolate chips.
7. Drop rounded tablespoons of dough onto prepared baking sheets.
8. Bake for 9-11 minutes, until edges are golden but centers are still soft.
9. Cool on baking sheets for 2 minutes, then transfer to wire racks to cool completely.',
25, 'American', TRUE, FALSE, FALSE),

-- Recipe 14: Ratatouille
('Ratatouille',
'1. Preheat oven to 375°F (190°C).
2. In a large oven-safe skillet or dutch oven, heat olive oil over medium heat.
3. Add onions and cook until translucent, about 5 minutes.
4. Add bell peppers and cook for another 5 minutes.
5. Add garlic, tomato paste, and herbs. Cook for 1 minute.
6. Pour in canned tomatoes and simmer for 5 minutes.
7. Arrange sliced vegetables (eggplant, zucchini, tomatoes) in a circular pattern on top of the sauce.
8. Brush with olive oil and sprinkle with salt and herbs.
9. Cover with foil and bake for 30 minutes.
10. Remove foil and bake for another 15-20 minutes until vegetables are tender.
11. Garnish with fresh basil before serving.',
75, 'French', TRUE, TRUE, TRUE),

-- Recipe 15: Beef and Broccoli Stir Fry
('Beef and Broccoli Stir Fry',
'1. Slice beef thinly against the grain and marinate in soy sauce, rice wine, and cornstarch for 20 minutes.
2. Mix sauce ingredients: soy sauce, oyster sauce, beef broth, brown sugar, and cornstarch.
3. Heat vegetable oil in a wok over high heat.
4. Add beef in a single layer and cook without stirring for 1 minute, then stir-fry until no longer pink.
5. Remove beef from wok and set aside.
6. In the same wok, add broccoli and stir-fry for 30 seconds.
7. Add garlic and ginger, stir for 15 seconds.
8. Pour in 1/4 cup water, cover and steam for 2 minutes until broccoli is tender-crisp.
9. Return beef to the wok and add sauce. Stir until sauce thickens.
10. Serve immediately over rice.',
25, 'Chinese', FALSE, FALSE, FALSE),

-- Recipe 16: Black Bean Burgers
('Black Bean Burgers',
'1. Drain and rinse black beans. Pat dry with paper towels.
2. In a food processor, pulse oats until finely ground.
3. Add half the black beans, onion, garlic, and spices. Pulse to combine.
4. Transfer mixture to a bowl and add remaining whole black beans.
5. Stir in breadcrumbs, egg, and hot sauce. Mix well.
6. Form into 4-6 patties and refrigerate for 30 minutes.
7. Heat oil in a skillet over medium heat.
8. Cook patties for 4-5 minutes per side until browned and heated through.
9. Serve on buns with your favorite toppings.',
40, 'American', TRUE, FALSE, FALSE),

-- Recipe 17: Paella
('Paella',
'1. Heat olive oil in a large paella pan over medium-high heat.
2. Add chicken pieces and cook until browned. Remove and set aside.
3. In the same pan, sauté onions and bell peppers until softened.
4. Add garlic, paprika, and saffron. Cook for 1 minute.
5. Stir in rice, coating with oil and spices.
6. Pour in chicken broth and tomatoes. Return chicken to the pan.
7. Bring to a boil, then reduce heat and simmer for 10 minutes.
8. Arrange shrimp, mussels, and peas on top of the rice.
9. Continue cooking without stirring until rice is tender and liquid is absorbed.
10. Remove from heat, cover with a cloth, and let rest for 5 minutes.
11. Garnish with lemon wedges and parsley before serving.',
45, 'Spanish', FALSE, FALSE, FALSE),

-- Recipe 18: Butternut Squash Soup
('Butternut Squash Soup',
'1. Preheat oven to 400°F (200°C).
2. Toss butternut squash cubes with olive oil, salt, and pepper.
3. Roast for 25-30 minutes until tender and caramelized.
4. In a large pot, sauté onions and garlic in butter until softened.
5. Add roasted squash, vegetable broth, and herbs.
6. Bring to a simmer and cook for 10 minutes.
7. Remove from heat and purée with an immersion blender until smooth.
8. Stir in cream and adjust seasoning.
9. Serve hot, garnished with pepitas and a swirl of cream.',
50, 'American', TRUE, FALSE, TRUE),

-- Recipe 19: Greek Salad
('Greek Salad',
'1. In a large bowl, combine chopped cucumbers, tomatoes, bell peppers, red onion, and kalamata olives.
2. In a small bowl, whisk together olive oil, red wine vinegar, lemon juice, garlic, oregano, salt, and pepper.
3. Pour dressing over vegetables and toss gently.
4. Top with cubed feta cheese and sprinkle with additional oregano.
5. Serve immediately or refrigerate for up to 2 hours before serving.',
15, 'Greek', TRUE, FALSE, TRUE),

-- Recipe 20: Beef Tacos
('Beef Tacos',
'1. Heat olive oil in a large skillet over medium-high heat.
2. Add onions and cook until softened, about 5 minutes.
3. Add ground beef and cook until browned, breaking it apart with a wooden spoon.
4. Stir in garlic, chili powder, cumin, paprika, oregano, salt, and pepper. Cook for 1 minute.
5. Add tomato sauce and bring to a simmer. Cook for 5 minutes until slightly thickened.
6. Warm taco shells in the oven according to package instructions.
7. Fill shells with beef mixture and top with lettuce, tomatoes, cheese, and sour cream.
8. Serve with lime wedges and hot sauce.',
25, 'Mexican', FALSE, FALSE, FALSE),

-- Recipe 21: Banana Bread
('Banana Bread',
'1. Preheat oven to 350°F (175°C). Grease a 9x5 inch loaf pan.
2. In a medium bowl, whisk together flour, baking soda, and salt.
3. In a large bowl, cream together butter and sugar until light and fluffy.
4. Beat in eggs one at a time, then stir in mashed bananas and vanilla.
5. Gradually add dry ingredients to the banana mixture until just combined.
6. Fold in walnuts if using.
7. Pour batter into prepared pan.
8. Bake for 60-65 minutes, or until a toothpick inserted into the center comes out clean.
9. Let bread cool in pan for 10 minutes, then remove to a wire rack to cool completely.',
70, 'American', TRUE, FALSE, FALSE),

-- Recipe 22: Pho Bo (Vietnamese Beef Noodle Soup)
('Pho Bo',
'1. In a large pot, char onions and ginger over an open flame or under a broiler.
2. Add beef bones, charred vegetables, and spices to a large pot with water.
3. Bring to a boil, then reduce heat and simmer for at least 3 hours, skimming occasionally.
4. Strain broth and return to a clean pot. Season with fish sauce and sugar.
5. Cook rice noodles according to package instructions.
6. Arrange noodles in bowls and top with thinly sliced raw beef.
7. Ladle hot broth over beef to cook it.
8. Serve with bean sprouts, herbs, lime wedges, and chili slices on the side.',
210, 'Vietnamese', FALSE, FALSE, TRUE),

-- Recipe 23: Caprese Salad
('Caprese Salad',
'1. Slice tomatoes and mozzarella into 1/4-inch thick slices.
2. Arrange tomato and mozzarella slices alternately on a serving platter.
3. Tuck fresh basil leaves between the slices.
4. Drizzle with olive oil.
5. Season with salt and freshly ground black pepper.
6. Optionally, drizzle with balsamic glaze.
7. Serve immediately at room temperature.',
10, 'Italian', TRUE, FALSE, TRUE),

-- Recipe 24: Beef Stroganoff
('Beef Stroganoff',
'1. Cut beef into thin strips.
2. Season beef with salt and pepper.
3. Heat oil in a large skillet over high heat. Brown beef quickly in batches. Set aside.
4. In the same pan, melt butter and sauté mushrooms until golden.
5. Add onions and cook until translucent.
6. Add garlic and thyme, cook for 1 minute.
7. Stir in flour and cook for 1 minute.
8. Gradually whisk in beef broth, then add Worcestershire sauce and Dijon mustard.
9. Bring to a simmer and cook until sauce thickens slightly.
10. Reduce heat and stir in sour cream.
11. Return beef to the pan and heat through without boiling.
12. Serve over egg noodles, garnished with parsley.',
35, 'Russian', FALSE, FALSE, FALSE),

-- Recipe 25: Apple Crisp
('Apple Crisp',
'1. Preheat oven to 375°F (190°C).
2. Peel, core, and slice apples into a greased 9x13 inch baking dish.
3. In a medium bowl, mix together sugar, flour, and cinnamon. Sprinkle over apples.
4. Pour water evenly over all.
5. In another bowl, mix together oats, flour, brown sugar, baking powder, baking soda, and melted butter until crumbly.
6. Sprinkle topping evenly over apples.
7. Bake for 35-40 minutes, until topping is golden and apples are tender.
8. Serve warm with vanilla ice cream.',
50, 'American', TRUE, FALSE, FALSE);

-- Insert quantities for recipes
-- Recipe 1: Spaghetti Bolognese
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Ground Beef'), '1', 'pound', 1),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'medium', 1),
((SELECT id FROM ingredient WHERE name = 'Carrot'), '2', 'medium', 1),
((SELECT id FROM ingredient WHERE name = 'Celery'), '2', 'stalks', 1),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '3', 'cloves', 1),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '28', 'oz can crushed', 1),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '2', 'tablespoons', 1),
((SELECT id FROM ingredient WHERE name = 'Pasta'), '1', 'pound', 1),
((SELECT id FROM ingredient WHERE name = 'Parmesan Cheese'), '1/4', 'cup grated', 1),
((SELECT id FROM ingredient WHERE name = 'Basil'), '2', 'tablespoons chopped', 1),
((SELECT id FROM ingredient WHERE name = 'Bay Leaf'), '2', '', 1),
((SELECT id FROM ingredient WHERE name = 'Oregano'), '1', 'teaspoon dried', 1);

-- Recipe 2: Vegetable Stir Fry
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Broccoli'), '2', 'cups', 2),
((SELECT id FROM ingredient WHERE name = 'Carrot'), '2', 'medium', 2),
((SELECT id FROM ingredient WHERE name = 'Bell Pepper'), '1', 'large', 2),
((SELECT id FROM ingredient WHERE name = 'Mushrooms'), '8', 'oz', 2),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '2', 'cloves', 2),
((SELECT id FROM ingredient WHERE name = 'Ginger'), '1', 'tablespoon minced', 2),
((SELECT id FROM ingredient WHERE name = 'Soy Sauce'), '3', 'tablespoons', 2),
((SELECT id FROM ingredient WHERE name = 'Vegetable Oil'), '2', 'tablespoons', 2),
((SELECT id FROM ingredient WHERE name = 'Rice'), '2', 'cups cooked', 2),
((SELECT id FROM ingredient WHERE name = 'Sesame Oil'), '1', 'teaspoon', 2);

-- Recipe 3: Chicken Tikka Masala
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Chicken Breast'), '2', 'pounds', 3),
((SELECT id FROM ingredient WHERE name = 'Yogurt'), '1', 'cup', 3),
((SELECT id FROM ingredient WHERE name = 'Lemon'), '1', '', 3),
((SELECT id FROM ingredient WHERE name = 'Onion'), '2', 'large', 3),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '4', 'cloves', 3),
((SELECT id FROM ingredient WHERE name = 'Ginger'), '2', 'tablespoons grated', 3),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '28', 'oz can crushed', 3),
((SELECT id FROM ingredient WHERE name = 'Heavy Cream'), '1', 'cup', 3),
((SELECT id FROM ingredient WHERE name = 'Vegetable Oil'), '3', 'tablespoons', 3),
((SELECT id FROM ingredient WHERE name = 'Cumin'), '2', 'teaspoons', 3),
((SELECT id FROM ingredient WHERE name = 'Paprika'), '2', 'teaspoons', 3),
((SELECT id FROM ingredient WHERE name = 'Turmeric'), '1', 'teaspoon', 3),
((SELECT id FROM ingredient WHERE name = 'Cilantro'), '1/4', 'cup chopped', 3),
((SELECT id FROM ingredient WHERE name = 'Rice'), '3', 'cups cooked', 3);

-- Recipe 4: Classic Caesar Salad
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Lettuce'), '2', 'heads romaine', 4),
((SELECT id FROM ingredient WHERE name = 'Parmesan Cheese'), '1/2', 'cup grated', 4),
((SELECT id FROM ingredient WHERE name = 'Eggs'), '1', 'yolk', 4),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '2', 'cloves', 4),
((SELECT id FROM ingredient WHERE name = 'Lemon'), '1', '', 4),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '1/2', 'cup', 4),
((SELECT id FROM ingredient WHERE name = 'Worcestershire Sauce'), '1', 'teaspoon', 4),
((SELECT id FROM ingredient WHERE name = 'Dijon Mustard'), '1', 'teaspoon', 4),
((SELECT id FROM ingredient WHERE name = 'Croutons'), '2', 'cups', 4);

-- Recipe 5: Mushroom Risotto
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Rice'), '1 1/2', 'cups arborio', 5),
((SELECT id FROM ingredient WHERE name = 'Mushrooms'), '8', 'oz', 5),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'medium', 5),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '2', 'cloves', 5),
((SELECT id FROM ingredient WHERE name = 'Thyme'), '1', 'tablespoon fresh', 5),
((SELECT id FROM ingredient WHERE name = 'Parmesan Cheese'), '1/2', 'cup grated', 5),
((SELECT id FROM ingredient WHERE name = 'Butter'), '4', 'tablespoons', 5),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '2', 'tablespoons', 5),
((SELECT id FROM ingredient WHERE name = 'Parsley'), '2', 'tablespoons chopped', 5);

-- Recipe 6: Fish Tacos
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Cod Fillet'), '1', 'pound', 6),
((SELECT id FROM ingredient WHERE name = 'Lime'), '2', '', 6),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '2', 'tablespoons', 6),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '2', 'cloves', 6),
((SELECT id FROM ingredient WHERE name = 'Cumin'), '1', 'teaspoon', 6),
((SELECT id FROM ingredient WHERE name = 'Chili Powder'), '1', 'teaspoon', 6),
((SELECT id FROM ingredient WHERE name = 'Cabbage'), '2', 'cups shredded', 6),
((SELECT id FROM ingredient WHERE name = 'Cilantro'), '1/4', 'cup chopped', 6),
((SELECT id FROM ingredient WHERE name = 'Avocado'), '1', 'sliced', 6),
((SELECT id FROM ingredient WHERE name = 'Sour Cream'), '1/2', 'cup', 6),
((SELECT id FROM ingredient WHERE name = 'Tortilla'), '8', 'small corn', 6);

-- Recipe 7: Vegan Chickpea Curry
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Chickpeas'), '2', 'cans (15oz each)', 7),
((SELECT id FROM ingredient WHERE name = 'Coconut Milk'), '1', 'can (14oz)', 7),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'large', 7),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '3', 'cloves', 7),
((SELECT id FROM ingredient WHERE name = 'Ginger'), '1', 'tablespoon grated', 7),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '1', 'can (14oz) diced', 7),
((SELECT id FROM ingredient WHERE name = 'Spinach'), '2', 'cups', 7),
((SELECT id FROM ingredient WHERE name = 'Lime'), '1', '', 7),
((SELECT id FROM ingredient WHERE name = 'Coconut Oil'), '2', 'tablespoons', 7),
((SELECT id FROM ingredient WHERE name = 'Curry Powder'), '2', 'tablespoons', 7),
((SELECT id FROM ingredient WHERE name = 'Turmeric'), '1', 'teaspoon', 7),
((SELECT id FROM ingredient WHERE name = 'Cumin'), '1', 'teaspoon', 7),
((SELECT id FROM ingredient WHERE name = 'Cilantro'), '1/4', 'cup chopped', 7),
((SELECT id FROM ingredient WHERE name = 'Rice'), '3', 'cups cooked', 7);

-- Recipe 8: Beef Bourguignon
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Ribeye Steak'), '3', 'pounds cubed', 8),
((SELECT id FROM ingredient WHERE name = 'Bacon'), '6', 'ounces diced', 8),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'large', 8),
((SELECT id FROM ingredient WHERE name = 'Carrot'), '2', 'large', 8),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '4', 'cloves', 8),
((SELECT id FROM ingredient WHERE name = 'Mushrooms'), '1', 'pound', 8),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '2', 'tablespoons paste', 8),
((SELECT id FROM ingredient WHERE name = 'Thyme'), '2', 'sprigs', 8),
((SELECT id FROM ingredient WHERE name = 'Bay Leaf'), '2', '', 8),
((SELECT id FROM ingredient WHERE name = 'Butter'), '3', 'tablespoons', 8),
((SELECT id FROM ingredient WHERE name = 'Flour'), '3', 'tablespoons', 8),
((SELECT id FROM ingredient WHERE name = 'Parsley'), '2', 'tablespoons chopped', 8);

-- Recipe 9: Quinoa Buddha Bowl
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Quinoa'), '1', 'cup', 9),
((SELECT id FROM ingredient WHERE name = 'Sweet Potato'), '2', 'medium', 9),
((SELECT id FROM ingredient WHERE name = 'Broccoli'), '2', 'cups florets', 9),
((SELECT id FROM ingredient WHERE name = 'Chickpeas'), '1', 'can (15oz)', 9),
((SELECT id FROM ingredient WHERE name = 'Avocado'), '1', '', 9),
((SELECT id FROM ingredient WHERE name = 'Spinach'), '2', 'cups', 9),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '3', 'tablespoons', 9),
((SELECT id FROM ingredient WHERE name = 'Tahini'), '1/4', 'cup', 9),
((SELECT id FROM ingredient WHERE name = 'Lemon'), '1', '', 9),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '1', 'clove', 9),
((SELECT id FROM ingredient WHERE name = 'Maple Syrup'), '1', 'tablespoon', 9),
((SELECT id FROM ingredient WHERE name = 'Cumin'), '1', 'teaspoon', 9),
((SELECT id FROM ingredient WHERE name = 'Paprika'), '1', 'teaspoon', 9);

-- Recipe 10: Lemon Garlic Roast Chicken
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Chicken Breast'), '1', '4-pound whole chicken', 10),
((SELECT id FROM ingredient WHERE name = 'Lemon'), '2', '', 10),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '1', 'whole head', 10),
((SELECT id FROM ingredient WHERE name = 'Butter'), '4', 'tablespoons softened', 10),
((SELECT id FROM ingredient WHERE name = 'Thyme'), '4', 'sprigs', 10),
((SELECT id FROM ingredient WHERE name = 'Rosemary'), '2', 'sprigs', 10),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '2', 'tablespoons', 10),
((SELECT id FROM ingredient WHERE name = 'Parsley'), '2', 'tablespoons chopped', 10);

-- Recipe 11: Shrimp Scampi
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Shrimp'), '1', 'pound', 11),
((SELECT id FROM ingredient WHERE name = 'Pasta'), '8', 'oz linguine', 11),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '4', 'cloves', 11),
((SELECT id FROM ingredient WHERE name = 'Butter'), '4', 'tablespoons', 11),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '2', 'tablespoons', 11),
((SELECT id FROM ingredient WHERE name = 'Lemon'), '1', '', 11),
((SELECT id FROM ingredient WHERE name = 'Parsley'), '2', 'tablespoons chopped', 11),
((SELECT id FROM ingredient WHERE name = 'Parmesan Cheese'), '1/4', 'cup grated', 11),
((SELECT id FROM ingredient WHERE name = 'Chili Powder'), '1/4', 'teaspoon red pepper flakes', 11);

-- Recipe 12: Thai Green Curry
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Chicken Breast'), '1', 'pound sliced', 12),
((SELECT id FROM ingredient WHERE name = 'Coconut Milk'), '2', 'cans (14oz each)', 12),
((SELECT id FROM ingredient WHERE name = 'Bell Pepper'), '1', 'sliced', 12),
((SELECT id FROM ingredient WHERE name = 'Eggplant'), '1', 'small diced', 12),
((SELECT id FROM ingredient WHERE name = 'Basil'), '1/2', 'cup Thai basil leaves', 12),
((SELECT id FROM ingredient WHERE name = 'Kaffir Lime Leaves'), '2', 'leaves', 12),
((SELECT id FROM ingredient WHERE name = 'Fish Sauce'), '2', 'tablespoons', 12),
((SELECT id FROM ingredient WHERE name = 'Coconut Oil'), '2', 'tablespoons', 12),
((SELECT id FROM ingredient WHERE name = 'Curry Powder'), '3', 'tablespoons green curry paste', 12),
((SELECT id FROM ingredient WHERE name = 'Honey'), '1', 'tablespoon', 12),
((SELECT id FROM ingredient WHERE name = 'Rice'), '3', 'cups cooked jasmine', 12);

-- Recipe 13: Chocolate Chip Cookies
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Flour'), '2 1/4', 'cups', 13),
((SELECT id FROM ingredient WHERE name = 'Butter'), '1', 'cup softened', 13),
((SELECT id FROM ingredient WHERE name = 'Eggs'), '2', 'large', 13),
((SELECT id FROM ingredient WHERE name = 'Vanilla'), '1', 'teaspoon', 13),
((SELECT id FROM ingredient WHERE name = 'Chocolate Chips'), '2', 'cups', 13),
((SELECT id FROM ingredient WHERE name = 'Brown Sugar'), '3/4', 'cup', 13),
((SELECT id FROM ingredient WHERE name = 'Granulated Sugar'), '3/4', 'cup', 13);

-- Recipe 14: Ratatouille
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Eggplant'), '1', 'medium', 14),
((SELECT id FROM ingredient WHERE name = 'Zucchini'), '2', 'medium', 14),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '3', 'medium', 14),
((SELECT id FROM ingredient WHERE name = 'Bell Pepper'), '1', 'medium', 14),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'large', 14),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '4', 'cloves', 14),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '1', 'can (14oz) crushed', 14),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '1/4', 'cup', 14),
((SELECT id FROM ingredient WHERE name = 'Thyme'), '2', 'sprigs', 14),
((SELECT id FROM ingredient WHERE name = 'Rosemary'), '1', 'sprig', 14),
((SELECT id FROM ingredient WHERE name = 'Basil'), '1/4', 'cup fresh leaves', 14);

-- Recipe 15: Beef and Broccoli Stir Fry
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Ribeye Steak'), '1', 'pound thinly sliced', 15),
((SELECT id FROM ingredient WHERE name = 'Broccoli'), '4', 'cups florets', 15),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '3', 'cloves', 15),
((SELECT id FROM ingredient WHERE name = 'Ginger'), '1', 'tablespoon minced', 15),
((SELECT id FROM ingredient WHERE name = 'Soy Sauce'), '1/4', 'cup', 15),
((SELECT id FROM ingredient WHERE name = 'Vegetable Oil'), '2', 'tablespoons', 15),
((SELECT id FROM ingredient WHERE name = 'Sesame Oil'), '1', 'teaspoon', 15),
((SELECT id FROM ingredient WHERE name = 'Rice'), '3', 'cups cooked', 15),
((SELECT id FROM ingredient WHERE name = 'Rice Vinegar'), '1', 'tablespoon', 15),
((SELECT id FROM ingredient WHERE name = 'Honey'), '1', 'tablespoon', 15),
((SELECT id FROM ingredient WHERE name = 'Flour'), '1', 'tablespoon cornstarch', 15);

-- Recipe 16: Black Bean Burgers
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Black Beans'), '2', 'cans (15oz each)', 16),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1/2', 'cup diced', 16),
((SELECT id FROM ingredient WHERE name = 'Bell Pepper'), '1/2', 'cup diced', 16),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '2', 'cloves', 16),
((SELECT id FROM ingredient WHERE name = 'Eggs'), '1', 'large', 16),
((SELECT id FROM ingredient WHERE name = 'Oats'), '1/2', 'cup', 16),
((SELECT id FROM ingredient WHERE name = 'Breadcrumbs'), '1/2', 'cup', 16),
((SELECT id FROM ingredient WHERE name = 'Cumin'), '1', 'teaspoon', 16),
((SELECT id FROM ingredient WHERE name = 'Chili Powder'), '1', 'teaspoon', 16),
((SELECT id FROM ingredient WHERE name = 'Sriracha'), '1', 'tablespoon', 16),
((SELECT id FROM ingredient WHERE name = 'Vegetable Oil'), '2', 'tablespoons', 16);

-- Recipe 17: Paella
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Rice'), '2', 'cups short grain', 17),
((SELECT id FROM ingredient WHERE name = 'Chicken Breast'), '1', 'pound cut into pieces', 17),
((SELECT id FROM ingredient WHERE name = 'Shrimp'), '1/2', 'pound', 17),
((SELECT id FROM ingredient WHERE name = 'Scallops'), '1/2', 'pound', 17),
((SELECT id FROM ingredient WHERE name = 'Bell Pepper'), '1', 'large', 17),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'medium', 17),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '4', 'cloves', 17),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '1', 'large diced', 17),
((SELECT id FROM ingredient WHERE name = 'Peas'), '1', 'cup', 17),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '1/4', 'cup', 17),
((SELECT id FROM ingredient WHERE name = 'Paprika'), '1', 'tablespoon', 17),
((SELECT id FROM ingredient WHERE name = 'Thyme'), '1', 'teaspoon dried', 17),
((SELECT id FROM ingredient WHERE name = 'Lemon'), '1', 'cut into wedges', 17),
((SELECT id FROM ingredient WHERE name = 'Parsley'), '2', 'tablespoons chopped', 17);

-- Recipe 18: Butternut Squash Soup
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Sweet Potato'), '2', 'pounds butternut squash', 18),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'large', 18),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '3', 'cloves', 18),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '2', 'tablespoons', 18),
((SELECT id FROM ingredient WHERE name = 'Butter'), '2', 'tablespoons', 18),
((SELECT id FROM ingredient WHERE name = 'Thyme'), '1', 'teaspoon dried', 18),
((SELECT id FROM ingredient WHERE name = 'Heavy Cream'), '1/2', 'cup', 18),
((SELECT id FROM ingredient WHERE name = 'Maple Syrup'), '1', 'tablespoon', 18);

-- Recipe 19: Greek Salad
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Cucumber'), '1', 'large', 19),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '3', 'medium', 19),
((SELECT id FROM ingredient WHERE name = 'Bell Pepper'), '1', 'green', 19),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1/2', 'red', 19),
((SELECT id FROM ingredient WHERE name = 'Feta Cheese'), '1/2', 'cup cubed', 19),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '1/4', 'cup', 19),
((SELECT id FROM ingredient WHERE name = 'Lemon'), '1/2', 'juiced', 19),
((SELECT id FROM ingredient WHERE name = 'Oregano'), '1', 'teaspoon dried', 19),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '1', 'clove', 19),
((SELECT id FROM ingredient WHERE name = 'Olives'), '1/2', 'cup kalamata', 19);

-- Recipe 20: Beef Tacos
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Ground Beef'), '1', 'pound', 20),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'medium', 20),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '2', 'cloves', 20),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '1', 'cup sauce', 20),
((SELECT id FROM ingredient WHERE name = 'Cumin'), '1', 'tablespoon', 20),
((SELECT id FROM ingredient WHERE name = 'Chili Powder'), '1', 'tablespoon', 20),
((SELECT id FROM ingredient WHERE name = 'Paprika'), '1', 'teaspoon', 20),
((SELECT id FROM ingredient WHERE name = 'Oregano'), '1', 'teaspoon dried', 20),
((SELECT id FROM ingredient WHERE name = 'Tortilla'), '12', 'small', 20),
((SELECT id FROM ingredient WHERE name = 'Lettuce'), '2', 'cups shredded', 20),
((SELECT id FROM ingredient WHERE name = 'Tomato'), '2', 'diced', 20),
((SELECT id FROM ingredient WHERE name = 'Cheddar Cheese'), '1', 'cup shredded', 20),
((SELECT id FROM ingredient WHERE name = 'Sour Cream'), '1/2', 'cup', 20),
((SELECT id FROM ingredient WHERE name = 'Lime'), '2', 'cut into wedges', 20);

-- Recipe 21: Banana Bread
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Banana'), '3', 'ripe mashed', 21),
((SELECT id FROM ingredient WHERE name = 'Flour'), '2', 'cups', 21),
((SELECT id FROM ingredient WHERE name = 'Butter'), '1/2', 'cup softened', 21),
((SELECT id FROM ingredient WHERE name = 'Eggs'), '2', 'large', 21),
((SELECT id FROM ingredient WHERE name = 'Granulated Sugar'), '1', 'cup', 21),
((SELECT id FROM ingredient WHERE name = 'Vanilla'), '1', 'teaspoon', 21),
((SELECT id FROM ingredient WHERE name = 'Cinnamon'), '1', 'teaspoon', 21),
((SELECT id FROM ingredient WHERE name = 'Walnuts'), '1/2', 'cup', 21);

-- Recipe 22: Pho Bo
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Ribeye Steak'), '1', 'pound thinly sliced', 22),
((SELECT id FROM ingredient WHERE name = 'Onion'), '2', 'large', 22),
((SELECT id FROM ingredient WHERE name = 'Ginger'), '1', '4-inch piece', 22),
((SELECT id FROM ingredient WHERE name = 'Cinnamon'), '1', 'stick', 22),
((SELECT id FROM ingredient WHERE name = 'Star Anise'), '3', 'whole', 22),
((SELECT id FROM ingredient WHERE name = 'Cloves'), '3', 'whole', 22),
((SELECT id FROM ingredient WHERE name = 'Coriander'), '1', 'tablespoon seeds', 22),
((SELECT id FROM ingredient WHERE name = 'Fish Sauce'), '2', 'tablespoons', 22),
((SELECT id FROM ingredient WHERE name = 'Rice'), '1', 'pound rice noodles', 22),
((SELECT id FROM ingredient WHERE name = 'Basil'), '1', 'cup Thai basil leaves', 22),
((SELECT id FROM ingredient WHERE name = 'Cilantro'), '1/2', 'cup', 22),
((SELECT id FROM ingredient WHERE name = 'Lime'), '2', 'cut into wedges', 22),
((SELECT id FROM ingredient WHERE name = 'Beans'), '2', 'cups sprouts', 22);

-- Recipe 23: Caprese Salad
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Tomato'), '4', 'large', 23),
((SELECT id FROM ingredient WHERE name = 'Mozzarella'), '16', 'oz fresh', 23),
((SELECT id FROM ingredient WHERE name = 'Basil'), '1', 'bunch fresh leaves', 23),
((SELECT id FROM ingredient WHERE name = 'Olive Oil'), '3', 'tablespoons', 23),
((SELECT id FROM ingredient WHERE name = 'Balsamic Vinegar'), '2', 'tablespoons', 23);

-- Recipe 24: Beef Stroganoff
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Ribeye Steak'), '1 1/2', 'pounds', 24),
((SELECT id FROM ingredient WHERE name = 'Mushrooms'), '1', 'pound', 24),
((SELECT id FROM ingredient WHERE name = 'Onion'), '1', 'large', 24),
((SELECT id FROM ingredient WHERE name = 'Garlic'), '3', 'cloves', 24),
((SELECT id FROM ingredient WHERE name = 'Butter'), '3', 'tablespoons', 24),
((SELECT id FROM ingredient WHERE name = 'Flour'), '2', 'tablespoons', 24),
((SELECT id FROM ingredient WHERE name = 'Sour Cream'), '1', 'cup', 24),
((SELECT id FROM ingredient WHERE name = 'Dijon Mustard'), '1', 'tablespoon', 24),
((SELECT id FROM ingredient WHERE name = 'Worcestershire Sauce'), '2', 'teaspoons', 24),
((SELECT id FROM ingredient WHERE name = 'Thyme'), '1', 'teaspoon dried', 24),
((SELECT id FROM ingredient WHERE name = 'Pasta'), '12', 'oz egg noodles', 24),
((SELECT id FROM ingredient WHERE name = 'Parsley'), '2', 'tablespoons chopped', 24);

-- Recipe 25: Apple Crisp
INSERT INTO quantity (ingredient_id, amount, unit, recipe_id) VALUES
((SELECT id FROM ingredient WHERE name = 'Apple'), '6', 'large', 25),
((SELECT id FROM ingredient WHERE name = 'Granulated Sugar'), '1/2', 'cup', 25),
((SELECT id FROM ingredient WHERE name = 'Flour'), '1', 'cup', 25),
((SELECT id FROM ingredient WHERE name = 'Cinnamon'), '1', 'teaspoon', 25),
((SELECT id FROM ingredient WHERE name = 'Oats'), '1', 'cup', 25),
((SELECT id FROM ingredient WHERE name = 'Butter'), '1/2', 'cup melted', 25),
((SELECT id FROM ingredient WHERE name = 'Brown Sugar'), '3/4', 'cup', 25),
((SELECT id FROM ingredient WHERE name = 'Vanilla'), '1', 'teaspoon', 25);

-- Add constraint to prevent future NULL values
ALTER TABLE quantity MODIFY COLUMN ingredient_id BIGINT NOT NULL;