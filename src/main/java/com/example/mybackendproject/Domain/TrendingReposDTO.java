package com.example.mybackendproject.Domain;

import java.util.List;

public class TrendingReposDTO {
    public final Integer total_count;
    public final Boolean incomplete_results;
    public final List<Item> items;

    public TrendingReposDTO(Integer total_count, Boolean incomplete_results, List<Item> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }
}
