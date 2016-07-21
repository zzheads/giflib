package com.zzheads.giflib.data;

import com.zzheads.giflib.model.Category;
import com.zzheads.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", LocalDate.of(2015,2,13), "Chris Ramacciotti", false, 1),
            new Gif("ben-and-mike", LocalDate.of(2015,10,30), "Ben Jakuben", true, 1),
            new Gif("book-dominos", LocalDate.of(2015,9,15), "Craig Dennis", false, 2),
            new Gif("compiler-bot", LocalDate.of(2015,2,13), "Ada Lovelace", true, 4),
            new Gif("cowboy-coder", LocalDate.of(2015,2,13), "Grace Hopper", false, 1),
            new Gif("infinite-andrew", LocalDate.of(2015,8,23), "Marissa Mayer", true, 2)
    );

    public Gif findByName (String name) {
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> findByCategory (int categoryId) {
        ArrayList<Gif> result = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.getCategoryId() == categoryId) {
                result.add(gif);
            }
        }
        return result;
    }

    public List<Gif> findFavorites () {
        ArrayList<Gif> result = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.isFavorite()) {
                result.add(gif);
            }
        }
        return result;
    }

    public List<Category> getAllCategories () {
        ArrayList<Category> result = new ArrayList<>();
        Set<Category> hs = new HashSet<>();
        for (int i=0;i<ALL_GIFS.size();i++) {
            if (ALL_GIFS.get(i).getCategoryId() != 0) result.add(CategoryRepository.getCategory(ALL_GIFS.get(i).getCategoryId()));
        }
        hs.addAll(result);
        result.clear();
        result.addAll(hs);
        return result;
    }

    public List<Gif> getAllGifs () {
        return ALL_GIFS;
    }

}
