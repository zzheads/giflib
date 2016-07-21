package com.zzheads.giflib.data;

import com.zzheads.giflib.model.Category;

import java.util.*;

public class CategoryRepository {
    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1,"funny"),
            new Category(2,"sad"),
            new Category(3,"silly"),
            new Category(4,"stupid"),
            new Category(5,"crazy")
    );

    public static String getCategoryName (int id) {
        for (int i=0;i<ALL_CATEGORIES.size();i++) {
            if (ALL_CATEGORIES.get(i).getId() == id) return ALL_CATEGORIES.get(i).getName();
        }
        return "Category not found";
    }

    public static Category getCategory (int id) {
        for (int i=0;i<ALL_CATEGORIES.size();i++) {
            if (ALL_CATEGORIES.get(i).getId() == id) return ALL_CATEGORIES.get(i);
        }
        return null;
    }
}
