package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager = new Manager();

    private Film filmOne = new Film(1, "Bloodshot", "thriller");
    private Film filmTwo = new Film(2, "Forward", "cartoon");
    private Film filmThree = new Film(3, "Hotel Belgrade", "comedy");
    private Film filmFour = new Film(4, "Gentlemen", "thriller");
    private Film filmFive = new Film(5, "Invisible Man", "horrors");
    private Film filmSix = new Film(6, "Trolls", "cartoon");
    private Film filmSeven = new Film(7, "Number one", "comedy");


    Film[] expected = {new Film(7, "Number one", "comedy"),
            new Film(6, "Trolls", "cartoon"),
            new Film(5, "Invisible Man", "horrors"),
            new Film(4, "Gentlemen", "thriller"),
            new Film(3, "Hotel Belgrade", "comedy"),
            new Film(2, "Forward", "cartoon"),
            new Film(1, "Bloodshot", "thriller")

    };

    @BeforeEach
    public void setUp() {
        manager.addFilm(filmOne);
        manager.addFilm(filmTwo);
        manager.addFilm(filmThree);
        manager.addFilm(filmFour);
        manager.addFilm(filmFive);
        manager.addFilm(filmSix);
        manager.addFilm(filmSeven);

    }

    @Test
    void shouldShowTenFilms() {
        Manager manager = new Manager(7);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowPositive() {
        Manager manager = new Manager(6);
        manager.films = this.manager.films;
        Film filmToAdd = new Film(20, "Duna", "action");
        manager.addFilm(filmToAdd);

        Film[] actual = manager.getLastAdded();
        Film[] expected = {new Film(20, "Duna", "action"),
                new Film(7, "Number one", "comedy"),
                new Film(6, "Trolls", "cartoon"),
                new Film(5, "Invisible Man", "horrors"),
                new Film(4, "Gentlemen", "thriller"),
                new Film(3, "Hotel Belgrade", "comedy")
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNothing() {
        Manager manager = new Manager(0);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowAboveMax() {
        Manager manager = new Manager(15);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldShowNegative() {
        Manager manager = new Manager(-1);
        manager.films = this.manager.films;
        Film[] actual = manager.getLastAdded();
        assertArrayEquals(expected, actual);
    }
}
