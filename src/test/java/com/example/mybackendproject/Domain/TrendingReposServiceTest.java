package com.example.mybackendproject.Domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TrendingReposServiceTest {

    private GithubClient client = mock(GithubClient.class);
    private TrendingReposMapper trendingReposMapper = mock(TrendingReposMapper.class);
    private TrendingReposService trendingReposService = new TrendingReposService(client, trendingReposMapper);

    @Test
    void mapLanguagesTrendingReposDTO_WhenGithubRequestSucceed_ThenMapResponseToLanguagesTrendingReposDTO() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(3800, null,null,null,null,null,null,null,false,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null, "AutoIt",null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null));
        TrendingReposDTO trendingReposDTO = new TrendingReposDTO(21, false, items);
        when(client.getTrendingReposDTO()).thenReturn(trendingReposDTO);
        List<Integer> id = new ArrayList<>();
        id.add(3800);
        List<LanguageTrendingReposDTO> languageTrendingReposDTOS = new ArrayList<>();
        languageTrendingReposDTOS.add(new LanguageTrendingReposDTO("AutoIt", 1, id));
        LanguagesTrendingReposDTO languagesTrendingReposDTOExpected = new LanguagesTrendingReposDTO(languageTrendingReposDTOS);
        when(trendingReposMapper.map(trendingReposDTO)).thenReturn(languagesTrendingReposDTOExpected);
        LanguagesTrendingReposDTO languagesTrendingReposDTOActual = trendingReposService.mapLanguagesTrendingReposDTO();
        assertEquals(languagesTrendingReposDTOExpected.languageTrendingReposDTOS.get(0).repos, languagesTrendingReposDTOActual.languageTrendingReposDTOS.get(0).repos);
    }
}