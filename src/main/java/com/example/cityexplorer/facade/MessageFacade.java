package com.example.cityexplorer.facade;

import com.example.cityexplorer.model.City;
import com.example.cityexplorer.model.Fact;
import com.example.cityexplorer.model.Place;
import com.example.cityexplorer.service.ICityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class MessageFacade {

    private final SplittableRandom random;
    private final String notFoundText = "У нас нет информации о данном городе.\nПожалуйста, введите название другого города";
    private final ICityService cityService;
    @Value("${telegram.api.parse.mode}")
    private String parseMode;

    public MessageFacade(ICityService cityService) {
        this.cityService = cityService;
        this.random = new SplittableRandom();
    }

    @Transactional
    public String getRandomFactMessage(String cityName) {
        StringBuilder builder = new StringBuilder(toBold(StringUtils.capitalize(cityName.toLowerCase())));
        try {
            final City city = cityService.findByName(cityName);
            final List<Place> places = city.getPlaces().stream()
                    .filter(notEmptyPlaces())
                    .collect(Collectors.toList());
            final int placeNumber = getRandom(places.size());
            final Place place = places.get(placeNumber);
            final List<Fact> facts = place.getFacts();
            final int factNumber = getRandom(facts.size());
            final Fact fact = facts.get(factNumber);
            final String NEW_STRING = "\r\n";
            return builder.append(NEW_STRING)
                    .append(place.getName().toUpperCase())
                    .append(NEW_STRING)
                    .append(fact.getText())
                    .toString();

        } catch (Exception e) {
            return notFoundText;
        }
    }

    private int getRandom(int max) {
        if (max < 1) {
            throw new RuntimeException("Empty collection");
        }
        return random.nextInt(0, max);
    }

    public String getNotFoundText() {
        return notFoundText;
    }

    private Predicate<Place> notEmptyPlaces() {
        return place -> !place.getFacts().isEmpty();
    }

    private String toBold(String text) {
        switch (parseMode) {
            case "html":
                return String.format("<b>%s</b>", text);
            case "markdown":
                return String.format("*%s*", text);
        }
        return StringUtils.EMPTY;
    }
}