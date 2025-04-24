package com.coderscampus.assignment9.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @GetMapping("/gluten-free")
// The “gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true
    @GetMapping("/vegan")
// The “vegan” endpoint will only return a subset of the full Collection where vegan is true
    @GetMapping("/vegan-and-gluten-free")
// The “vegan-and-gluten-free” endpoint will only return a subset of the full Collection where glutenFree is true and
// vegan is true
    @GetMapping("/vegetarian")
// The “vegetarian” endpoint will only return a subset of the full Collection where vegetarian is true
    @GetMapping("/all-recipes")
// The “all-recipes” endpoint will not filter the data at all and should return the full Collection.


}
